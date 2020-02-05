package com.facebook.react.devsupport;

import android.util.JsonReader;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.NativeDeltaClient;
import io.sentry.marshaller.json.JsonMarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import okhttp3.Headers;
import okio.BufferedSource;

public abstract class BundleDeltaClient {
    private static final String METRO_DELTA_ID_HEADER = "X-Metro-Delta-ID";
    @Nullable
    private String mRevisionId;

    public enum ClientType {
        NONE,
        DEV_SUPPORT,
        NATIVE
    }

    public abstract boolean canHandle(ClientType clientType);

    /* access modifiers changed from: protected */
    public abstract Pair<Boolean, NativeDeltaClient> processDelta(BufferedSource bufferedSource, File file) throws IOException;

    static boolean isDeltaUrl(String str) {
        return str.indexOf(".delta?") != -1;
    }

    /* renamed from: com.facebook.react.devsupport.BundleDeltaClient$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$devsupport$BundleDeltaClient$ClientType = new int[ClientType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.facebook.react.devsupport.BundleDeltaClient$ClientType[] r0 = com.facebook.react.devsupport.BundleDeltaClient.ClientType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$devsupport$BundleDeltaClient$ClientType = r0
                int[] r0 = $SwitchMap$com$facebook$react$devsupport$BundleDeltaClient$ClientType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.facebook.react.devsupport.BundleDeltaClient$ClientType r1 = com.facebook.react.devsupport.BundleDeltaClient.ClientType.DEV_SUPPORT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$facebook$react$devsupport$BundleDeltaClient$ClientType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.facebook.react.devsupport.BundleDeltaClient$ClientType r1 = com.facebook.react.devsupport.BundleDeltaClient.ClientType.NATIVE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.BundleDeltaClient.AnonymousClass1.<clinit>():void");
        }
    }

    @Nullable
    static BundleDeltaClient create(ClientType clientType) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$devsupport$BundleDeltaClient$ClientType[clientType.ordinal()];
        if (i == 1) {
            return new BundleDeltaJavaClient((AnonymousClass1) null);
        }
        if (i != 2) {
            return null;
        }
        return new BundleDeltaNativeClient((AnonymousClass1) null);
    }

    public final synchronized String extendUrlForDelta(String str) {
        if (this.mRevisionId != null) {
            str = str + "&revisionId=" + this.mRevisionId;
        }
        return str;
    }

    public synchronized void reset() {
        this.mRevisionId = null;
    }

    public synchronized Pair<Boolean, NativeDeltaClient> processDelta(Headers headers, BufferedSource bufferedSource, File file) throws IOException {
        this.mRevisionId = headers.get(METRO_DELTA_ID_HEADER);
        return processDelta(bufferedSource, file);
    }

    private static class BundleDeltaJavaClient extends BundleDeltaClient {
        final TreeMap<Number, byte[]> mModules;
        byte[] mPostCode;
        byte[] mPreCode;

        private BundleDeltaJavaClient() {
            this.mModules = new TreeMap<>();
        }

        /* synthetic */ BundleDeltaJavaClient(AnonymousClass1 r1) {
            this();
        }

        public boolean canHandle(ClientType clientType) {
            return clientType == ClientType.DEV_SUPPORT;
        }

        public synchronized void reset() {
            BundleDeltaClient.super.reset();
            this.mPreCode = null;
            this.mPostCode = null;
            this.mModules.clear();
        }

        /* JADX INFO: finally extract failed */
        public synchronized Pair<Boolean, NativeDeltaClient> processDelta(BufferedSource bufferedSource, File file) throws IOException {
            int removeModules;
            JsonReader jsonReader = new JsonReader(new InputStreamReader(bufferedSource.inputStream()));
            jsonReader.beginObject();
            int i = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (nextName.equals("pre")) {
                    this.mPreCode = jsonReader.nextString().getBytes();
                } else if (nextName.equals("post")) {
                    this.mPostCode = jsonReader.nextString().getBytes();
                } else {
                    if (nextName.equals(JsonMarshaller.MODULES)) {
                        removeModules = setModules(jsonReader, this.mModules);
                    } else if (nextName.equals("added")) {
                        removeModules = setModules(jsonReader, this.mModules);
                    } else if (nextName.equals("modified")) {
                        removeModules = setModules(jsonReader, this.mModules);
                    } else if (nextName.equals("deleted")) {
                        removeModules = removeModules(jsonReader, this.mModules);
                    } else {
                        jsonReader.skipValue();
                    }
                    i += removeModules;
                }
            }
            jsonReader.endObject();
            jsonReader.close();
            if (i == 0) {
                return Pair.create(Boolean.FALSE, (Object) null);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(this.mPreCode);
                fileOutputStream.write(10);
                for (byte[] write : this.mModules.values()) {
                    fileOutputStream.write(write);
                    fileOutputStream.write(10);
                }
                fileOutputStream.write(this.mPostCode);
                fileOutputStream.write(10);
                fileOutputStream.flush();
                fileOutputStream.close();
                return Pair.create(Boolean.TRUE, (Object) null);
            } catch (Throwable th) {
                fileOutputStream.flush();
                fileOutputStream.close();
                throw th;
            }
        }

        private static int setModules(JsonReader jsonReader, TreeMap<Number, byte[]> treeMap) throws IOException {
            jsonReader.beginArray();
            int i = 0;
            while (jsonReader.hasNext()) {
                jsonReader.beginArray();
                treeMap.put(Integer.valueOf(jsonReader.nextInt()), jsonReader.nextString().getBytes());
                jsonReader.endArray();
                i++;
            }
            jsonReader.endArray();
            return i;
        }

        private static int removeModules(JsonReader jsonReader, TreeMap<Number, byte[]> treeMap) throws IOException {
            jsonReader.beginArray();
            int i = 0;
            while (jsonReader.hasNext()) {
                treeMap.remove(Integer.valueOf(jsonReader.nextInt()));
                i++;
            }
            jsonReader.endArray();
            return i;
        }
    }

    private static class BundleDeltaNativeClient extends BundleDeltaClient {
        private final NativeDeltaClient nativeClient;

        private BundleDeltaNativeClient() {
            this.nativeClient = new NativeDeltaClient();
        }

        /* synthetic */ BundleDeltaNativeClient(AnonymousClass1 r1) {
            this();
        }

        public boolean canHandle(ClientType clientType) {
            return clientType == ClientType.NATIVE;
        }

        /* access modifiers changed from: protected */
        public Pair<Boolean, NativeDeltaClient> processDelta(BufferedSource bufferedSource, File file) throws IOException {
            this.nativeClient.processDelta(bufferedSource);
            return Pair.create(Boolean.FALSE, this.nativeClient);
        }

        public void reset() {
            BundleDeltaClient.super.reset();
            this.nativeClient.reset();
        }
    }
}
