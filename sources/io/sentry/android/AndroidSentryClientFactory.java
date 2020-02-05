package io.sentry.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.facebook.common.util.UriUtil;
import io.sentry.DefaultSentryClientFactory;
import io.sentry.SentryClient;
import io.sentry.android.event.helper.AndroidEventBuilderHelper;
import io.sentry.buffer.Buffer;
import io.sentry.buffer.DiskBuffer;
import io.sentry.config.Lookup;
import io.sentry.context.ContextManager;
import io.sentry.context.SingletonContextManager;
import io.sentry.dsn.Dsn;
import io.sentry.util.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class AndroidSentryClientFactory extends DefaultSentryClientFactory {
    private static final String DEFAULT_BUFFER_DIR = "sentry-buffered-events";
    public static final String TAG = "io.sentry.android.AndroidSentryClientFactory";
    private Context ctx;

    public AndroidSentryClientFactory(Context context) {
        Log.d(TAG, "Construction of Android Sentry.");
        this.ctx = context.getApplicationContext();
    }

    public SentryClient createSentryClient(Dsn dsn) {
        if (!checkPermission("android.permission.INTERNET")) {
            Log.e(TAG, "android.permission.INTERNET is required to connect to the Sentry server, please add it to your AndroidManifest.xml");
        }
        String str = TAG;
        Log.d(str, "Sentry init with ctx='" + this.ctx.toString() + "'");
        String protocol = dsn.getProtocol();
        if (protocol.equalsIgnoreCase("noop")) {
            Log.w(TAG, "*** Couldn't find a suitable DSN, Sentry operations will do nothing! See documentation: https://docs.sentry.io/clients/java/modules/android/ ***");
        } else if (!protocol.equalsIgnoreCase(UriUtil.HTTP_SCHEME) && !protocol.equalsIgnoreCase(UriUtil.HTTPS_SCHEME)) {
            String lookup = Lookup.lookup("async", dsn);
            if (lookup == null || !lookup.equalsIgnoreCase("false")) {
                throw new IllegalArgumentException("Only 'http' or 'https' connections are supported in Sentry Android, but received: " + protocol);
            }
            throw new IllegalArgumentException("Sentry Android cannot use synchronous connections, remove 'async=false' from your options.");
        }
        SentryClient createSentryClient = super.createSentryClient(dsn);
        createSentryClient.addBuilderHelper(new AndroidEventBuilderHelper(this.ctx));
        return createSentryClient;
    }

    /* access modifiers changed from: protected */
    public Collection<String> getInAppFrames(Dsn dsn) {
        Collection<String> inAppFrames = super.getInAppFrames(dsn);
        if (!inAppFrames.isEmpty()) {
            return inAppFrames;
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.ctx.getPackageManager().getPackageInfo(this.ctx.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Error getting package information.", e);
        }
        if (packageInfo == null || Util.isNullOrEmpty(packageInfo.packageName)) {
            return inAppFrames;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(packageInfo.packageName);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public Buffer getBuffer(Dsn dsn) {
        File file;
        String lookup = Lookup.lookup(DefaultSentryClientFactory.BUFFER_DIR_OPTION, dsn);
        if (lookup != null) {
            file = new File(lookup);
        } else {
            file = new File(this.ctx.getCacheDir().getAbsolutePath(), DEFAULT_BUFFER_DIR);
        }
        String str = TAG;
        Log.d(str, "Using buffer dir: " + file.getAbsolutePath());
        return new DiskBuffer(file, getBufferSize(dsn));
    }

    /* access modifiers changed from: protected */
    public ContextManager getContextManager(Dsn dsn) {
        return new SingletonContextManager();
    }

    private boolean checkPermission(String str) {
        return this.ctx.checkCallingOrSelfPermission(str) == 0;
    }
}
