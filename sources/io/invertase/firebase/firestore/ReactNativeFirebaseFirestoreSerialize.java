package io.invertase.firebase.firestore;

import android.util.Base64;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.common.collect.Iterables;
import com.google.firebase.Timestamp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.firestore.Blob;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SnapshotMetadata;
import io.invertase.firebase.common.RCTConvertFirebase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

class ReactNativeFirebaseFirestoreSerialize {
    private static final String CHANGE_ADDED = "a";
    private static final String CHANGE_MODIFIED = "m";
    private static final String CHANGE_REMOVED = "r";
    private static final int INT_ARRAY = 10;
    private static final int INT_BLOB = 14;
    private static final int INT_BOOLEAN_FALSE = 6;
    private static final int INT_BOOLEAN_TRUE = 5;
    private static final int INT_DOCUMENTID = 4;
    private static final int INT_FIELDVALUE = 15;
    private static final int INT_GEOPOINT = 12;
    private static final int INT_NAN = 0;
    private static final int INT_NEGATIVE_INFINITY = 1;
    private static final int INT_NULL = 3;
    private static final int INT_NUMBER = 7;
    private static final int INT_OBJECT = 16;
    private static final int INT_POSITIVE_INFINITY = 2;
    private static final int INT_REFERENCE = 11;
    private static final int INT_STRING = 8;
    private static final int INT_STRING_EMPTY = 9;
    private static final int INT_TIMESTAMP = 13;
    private static final int INT_UNKNOWN = -999;
    private static final String KEY_CHANGES = "changes";
    private static final String KEY_DATA = "data";
    private static final String KEY_DOCUMENTS = "documents";
    private static final String KEY_DOC_CHANGE_DOCUMENT = "doc";
    private static final String KEY_DOC_CHANGE_NEW_INDEX = "ni";
    private static final String KEY_DOC_CHANGE_OLD_INDEX = "oi";
    private static final String KEY_DOC_CHANGE_TYPE = "type";
    private static final String KEY_EXISTS = "exists";
    private static final String KEY_META = "metadata";
    private static final String KEY_OPTIONS = "options";
    private static final String KEY_PATH = "path";
    private static final String TAG = "FirestoreSerialize";
    private static final String TYPE = "type";

    ReactNativeFirebaseFirestoreSerialize() {
    }

    /* access modifiers changed from: package-private */
    public static WritableMap snapshotToWritableMap(DocumentSnapshot documentSnapshot) {
        WritableArray createArray = Arguments.createArray();
        WritableMap createMap = Arguments.createMap();
        SnapshotMetadata metadata = documentSnapshot.getMetadata();
        createArray.pushBoolean(metadata.isFromCache());
        createArray.pushBoolean(metadata.hasPendingWrites());
        createMap.putArray(KEY_META, createArray);
        createMap.putString(KEY_PATH, documentSnapshot.getReference().getPath());
        createMap.putBoolean(KEY_EXISTS, documentSnapshot.exists());
        if (documentSnapshot.exists() && documentSnapshot.getData() != null) {
            createMap.putMap("data", objectMapToWritable(documentSnapshot.getData()));
        }
        return createMap;
    }

    /* access modifiers changed from: package-private */
    public static WritableMap snapshotToWritableMap(String str, QuerySnapshot querySnapshot, @Nullable MetadataChanges metadataChanges) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(FirebaseAnalytics.Param.SOURCE, str);
        WritableArray createArray = Arguments.createArray();
        WritableArray createArray2 = Arguments.createArray();
        List<DocumentChange> documentChanges = querySnapshot.getDocumentChanges();
        if (metadataChanges == null || metadataChanges == MetadataChanges.EXCLUDE) {
            createMap.putBoolean("excludesMetadataChanges", true);
            createMap.putArray(KEY_CHANGES, documentChangesToWritableArray(documentChanges, (List<DocumentChange>) null));
        } else {
            createMap.putBoolean("excludesMetadataChanges", false);
            createMap.putArray(KEY_CHANGES, documentChangesToWritableArray(querySnapshot.getDocumentChanges(MetadataChanges.INCLUDE), documentChanges));
        }
        SnapshotMetadata metadata = querySnapshot.getMetadata();
        for (DocumentSnapshot snapshotToWritableMap : querySnapshot.getDocuments()) {
            createArray2.pushMap(snapshotToWritableMap(snapshotToWritableMap));
        }
        createMap.putArray(KEY_DOCUMENTS, createArray2);
        createArray.pushBoolean(metadata.isFromCache());
        createArray.pushBoolean(metadata.hasPendingWrites());
        createMap.putArray(KEY_META, createArray);
        return createMap;
    }

    private static WritableArray documentChangesToWritableArray(List<DocumentChange> list, @Nullable List<DocumentChange> list2) {
        WritableArray createArray = Arguments.createArray();
        boolean z = list2 != null;
        for (DocumentChange next : list) {
            createArray.pushMap(documentChangeToWritableMap(next, z && ((DocumentChange) Iterables.tryFind(list2, 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0039: INVOKE  
                  (r0v0 'createArray' com.facebook.react.bridge.WritableArray)
                  (wrap: com.facebook.react.bridge.WritableMap : 0x0035: INVOKE  (r4v3 com.facebook.react.bridge.WritableMap) = 
                  (r4v2 'next' com.google.firebase.firestore.DocumentChange)
                  (wrap: boolean : ?: TERNARY(r5v0 boolean) = (((r3v0 'z' boolean) == true && (wrap: com.google.firebase.firestore.DocumentChange : 0x002e: CHECK_CAST  (r5v5 com.google.firebase.firestore.DocumentChange) = (com.google.firebase.firestore.DocumentChange) (wrap: T : 0x002a: INVOKE  (r5v4 T) = 
                  (wrap: com.google.common.base.Optional<T> : 0x0026: INVOKE  (r5v3 com.google.common.base.Optional<T>) = 
                  (r8v0 'list2' java.util.List<com.google.firebase.firestore.DocumentChange>)
                  (wrap: io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw : 0x0023: CONSTRUCTOR  (r6v0 io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw) = 
                  (wrap: int : 0x001d: INVOKE  (r5v2 int) = (r4v2 'next' com.google.firebase.firestore.DocumentChange) com.google.firebase.firestore.DocumentChange.hashCode():int type: VIRTUAL)
                 call: io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw.<init>(int):void type: CONSTRUCTOR)
                 com.google.common.collect.Iterables.tryFind(java.lang.Iterable, com.google.common.base.Predicate):com.google.common.base.Optional type: STATIC)
                 com.google.common.base.Optional.orNull():java.lang.Object type: VIRTUAL)) == (null com.google.firebase.firestore.DocumentChange))) ? true : false)
                 io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreSerialize.documentChangeToWritableMap(com.google.firebase.firestore.DocumentChange, boolean):com.facebook.react.bridge.WritableMap type: STATIC)
                 com.facebook.react.bridge.WritableArray.pushMap(com.facebook.react.bridge.ReadableMap):void type: INTERFACE in method: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreSerialize.documentChangesToWritableArray(java.util.List, java.util.List):com.facebook.react.bridge.WritableArray, dex: classes2.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:232)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0035: INVOKE  (r4v3 com.facebook.react.bridge.WritableMap) = 
                  (r4v2 'next' com.google.firebase.firestore.DocumentChange)
                  (wrap: boolean : ?: TERNARY(r5v0 boolean) = (((r3v0 'z' boolean) == true && (wrap: com.google.firebase.firestore.DocumentChange : 0x002e: CHECK_CAST  (r5v5 com.google.firebase.firestore.DocumentChange) = (com.google.firebase.firestore.DocumentChange) (wrap: T : 0x002a: INVOKE  (r5v4 T) = 
                  (wrap: com.google.common.base.Optional<T> : 0x0026: INVOKE  (r5v3 com.google.common.base.Optional<T>) = 
                  (r8v0 'list2' java.util.List<com.google.firebase.firestore.DocumentChange>)
                  (wrap: io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw : 0x0023: CONSTRUCTOR  (r6v0 io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw) = 
                  (wrap: int : 0x001d: INVOKE  (r5v2 int) = (r4v2 'next' com.google.firebase.firestore.DocumentChange) com.google.firebase.firestore.DocumentChange.hashCode():int type: VIRTUAL)
                 call: io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw.<init>(int):void type: CONSTRUCTOR)
                 com.google.common.collect.Iterables.tryFind(java.lang.Iterable, com.google.common.base.Predicate):com.google.common.base.Optional type: STATIC)
                 com.google.common.base.Optional.orNull():java.lang.Object type: VIRTUAL)) == (null com.google.firebase.firestore.DocumentChange))) ? true : false)
                 io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreSerialize.documentChangeToWritableMap(com.google.firebase.firestore.DocumentChange, boolean):com.facebook.react.bridge.WritableMap type: STATIC in method: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreSerialize.documentChangesToWritableArray(java.util.List, java.util.List):com.facebook.react.bridge.WritableArray, dex: classes2.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	... 34 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: TERNARY(r5v0 boolean) = (((r3v0 'z' boolean) == true && (wrap: com.google.firebase.firestore.DocumentChange : 0x002e: CHECK_CAST  (r5v5 com.google.firebase.firestore.DocumentChange) = (com.google.firebase.firestore.DocumentChange) (wrap: T : 0x002a: INVOKE  (r5v4 T) = 
                  (wrap: com.google.common.base.Optional<T> : 0x0026: INVOKE  (r5v3 com.google.common.base.Optional<T>) = 
                  (r8v0 'list2' java.util.List<com.google.firebase.firestore.DocumentChange>)
                  (wrap: io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw : 0x0023: CONSTRUCTOR  (r6v0 io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw) = 
                  (wrap: int : 0x001d: INVOKE  (r5v2 int) = (r4v2 'next' com.google.firebase.firestore.DocumentChange) com.google.firebase.firestore.DocumentChange.hashCode():int type: VIRTUAL)
                 call: io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw.<init>(int):void type: CONSTRUCTOR)
                 com.google.common.collect.Iterables.tryFind(java.lang.Iterable, com.google.common.base.Predicate):com.google.common.base.Optional type: STATIC)
                 com.google.common.base.Optional.orNull():java.lang.Object type: VIRTUAL)) == (null com.google.firebase.firestore.DocumentChange))) ? true : false in method: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreSerialize.documentChangesToWritableArray(java.util.List, java.util.List):com.facebook.react.bridge.WritableArray, dex: classes2.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	... 40 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002e: CHECK_CAST  (r5v5 com.google.firebase.firestore.DocumentChange) = (com.google.firebase.firestore.DocumentChange) (wrap: T : 0x002a: INVOKE  (r5v4 T) = 
                  (wrap: com.google.common.base.Optional<T> : 0x0026: INVOKE  (r5v3 com.google.common.base.Optional<T>) = 
                  (r8v0 'list2' java.util.List<com.google.firebase.firestore.DocumentChange>)
                  (wrap: io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw : 0x0023: CONSTRUCTOR  (r6v0 io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw) = 
                  (wrap: int : 0x001d: INVOKE  (r5v2 int) = (r4v2 'next' com.google.firebase.firestore.DocumentChange) com.google.firebase.firestore.DocumentChange.hashCode():int type: VIRTUAL)
                 call: io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw.<init>(int):void type: CONSTRUCTOR)
                 com.google.common.collect.Iterables.tryFind(java.lang.Iterable, com.google.common.base.Predicate):com.google.common.base.Optional type: STATIC)
                 com.google.common.base.Optional.orNull():java.lang.Object type: VIRTUAL) in method: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreSerialize.documentChangesToWritableArray(java.util.List, java.util.List):com.facebook.react.bridge.WritableArray, dex: classes2.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:129)
                	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
                	at jadx.core.codegen.ConditionGen.wrap(ConditionGen.java:84)
                	at jadx.core.codegen.ConditionGen.addAndOr(ConditionGen.java:151)
                	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:70)
                	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
                	at jadx.core.codegen.InsnGen.makeTernary(InsnGen.java:948)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:476)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	... 46 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002a: INVOKE  (r5v4 T) = 
                  (wrap: com.google.common.base.Optional<T> : 0x0026: INVOKE  (r5v3 com.google.common.base.Optional<T>) = 
                  (r8v0 'list2' java.util.List<com.google.firebase.firestore.DocumentChange>)
                  (wrap: io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw : 0x0023: CONSTRUCTOR  (r6v0 io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw) = 
                  (wrap: int : 0x001d: INVOKE  (r5v2 int) = (r4v2 'next' com.google.firebase.firestore.DocumentChange) com.google.firebase.firestore.DocumentChange.hashCode():int type: VIRTUAL)
                 call: io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw.<init>(int):void type: CONSTRUCTOR)
                 com.google.common.collect.Iterables.tryFind(java.lang.Iterable, com.google.common.base.Predicate):com.google.common.base.Optional type: STATIC)
                 com.google.common.base.Optional.orNull():java.lang.Object type: VIRTUAL in method: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreSerialize.documentChangesToWritableArray(java.util.List, java.util.List):com.facebook.react.bridge.WritableArray, dex: classes2.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:291)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	... 57 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0026: INVOKE  (r5v3 com.google.common.base.Optional<T>) = 
                  (r8v0 'list2' java.util.List<com.google.firebase.firestore.DocumentChange>)
                  (wrap: io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw : 0x0023: CONSTRUCTOR  (r6v0 io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw) = 
                  (wrap: int : 0x001d: INVOKE  (r5v2 int) = (r4v2 'next' com.google.firebase.firestore.DocumentChange) com.google.firebase.firestore.DocumentChange.hashCode():int type: VIRTUAL)
                 call: io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw.<init>(int):void type: CONSTRUCTOR)
                 com.google.common.collect.Iterables.tryFind(java.lang.Iterable, com.google.common.base.Predicate):com.google.common.base.Optional type: STATIC in method: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreSerialize.documentChangesToWritableArray(java.util.List, java.util.List):com.facebook.react.bridge.WritableArray, dex: classes2.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	... 61 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0023: CONSTRUCTOR  (r6v0 io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw) = 
                  (wrap: int : 0x001d: INVOKE  (r5v2 int) = (r4v2 'next' com.google.firebase.firestore.DocumentChange) com.google.firebase.firestore.DocumentChange.hashCode():int type: VIRTUAL)
                 call: io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw.<init>(int):void type: CONSTRUCTOR in method: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreSerialize.documentChangesToWritableArray(java.util.List, java.util.List):com.facebook.react.bridge.WritableArray, dex: classes2.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	... 67 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	... 73 more
                */
            /*
                com.facebook.react.bridge.WritableArray r0 = com.facebook.react.bridge.Arguments.createArray()
                r1 = 1
                r2 = 0
                if (r8 == 0) goto L_0x000a
                r3 = 1
                goto L_0x000b
            L_0x000a:
                r3 = 0
            L_0x000b:
                java.util.Iterator r7 = r7.iterator()
            L_0x000f:
                boolean r4 = r7.hasNext()
                if (r4 == 0) goto L_0x003d
                java.lang.Object r4 = r7.next()
                com.google.firebase.firestore.DocumentChange r4 = (com.google.firebase.firestore.DocumentChange) r4
                if (r3 == 0) goto L_0x0034
                int r5 = r4.hashCode()
                io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw r6 = new io.invertase.firebase.firestore.-$$Lambda$ReactNativeFirebaseFirestoreSerialize$SJLEVITK9bBq-kePk0M2CePhXXw
                r6.<init>(r5)
                com.google.common.base.Optional r5 = com.google.common.collect.Iterables.tryFind(r8, r6)
                java.lang.Object r5 = r5.orNull()
                com.google.firebase.firestore.DocumentChange r5 = (com.google.firebase.firestore.DocumentChange) r5
                if (r5 != 0) goto L_0x0034
                r5 = 1
                goto L_0x0035
            L_0x0034:
                r5 = 0
            L_0x0035:
                com.facebook.react.bridge.WritableMap r4 = documentChangeToWritableMap(r4, r5)
                r0.pushMap(r4)
                goto L_0x000f
            L_0x003d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreSerialize.documentChangesToWritableArray(java.util.List, java.util.List):com.facebook.react.bridge.WritableArray");
        }

        static /* synthetic */ boolean lambda$documentChangesToWritableArray$0(int i, DocumentChange documentChange) {
            return documentChange.hashCode() == i;
        }

        private static WritableMap documentChangeToWritableMap(DocumentChange documentChange, boolean z) {
            WritableMap createMap = Arguments.createMap();
            createMap.putBoolean("isMetadataChange", z);
            int i = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$DocumentChange$Type[documentChange.getType().ordinal()];
            if (i == 1) {
                createMap.putString("type", CHANGE_ADDED);
            } else if (i == 2) {
                createMap.putString("type", CHANGE_MODIFIED);
            } else if (i == 3) {
                createMap.putString("type", CHANGE_REMOVED);
            }
            createMap.putMap(KEY_DOC_CHANGE_DOCUMENT, snapshotToWritableMap(documentChange.getDocument()));
            createMap.putInt(KEY_DOC_CHANGE_NEW_INDEX, documentChange.getNewIndex());
            createMap.putInt(KEY_DOC_CHANGE_OLD_INDEX, documentChange.getOldIndex());
            return createMap;
        }

        /* renamed from: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreSerialize$1  reason: invalid class name */
        static /* synthetic */ class AnonymousClass1 {
            static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$DocumentChange$Type = new int[DocumentChange.Type.values().length];

            /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
            static {
                /*
                    com.google.firebase.firestore.DocumentChange$Type[] r0 = com.google.firebase.firestore.DocumentChange.Type.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    $SwitchMap$com$google$firebase$firestore$DocumentChange$Type = r0
                    int[] r0 = $SwitchMap$com$google$firebase$firestore$DocumentChange$Type     // Catch:{ NoSuchFieldError -> 0x0014 }
                    com.google.firebase.firestore.DocumentChange$Type r1 = com.google.firebase.firestore.DocumentChange.Type.ADDED     // Catch:{ NoSuchFieldError -> 0x0014 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
                L_0x0014:
                    int[] r0 = $SwitchMap$com$google$firebase$firestore$DocumentChange$Type     // Catch:{ NoSuchFieldError -> 0x001f }
                    com.google.firebase.firestore.DocumentChange$Type r1 = com.google.firebase.firestore.DocumentChange.Type.MODIFIED     // Catch:{ NoSuchFieldError -> 0x001f }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
                L_0x001f:
                    int[] r0 = $SwitchMap$com$google$firebase$firestore$DocumentChange$Type     // Catch:{ NoSuchFieldError -> 0x002a }
                    com.google.firebase.firestore.DocumentChange$Type r1 = com.google.firebase.firestore.DocumentChange.Type.REMOVED     // Catch:{ NoSuchFieldError -> 0x002a }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
                L_0x002a:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreSerialize.AnonymousClass1.<clinit>():void");
            }
        }

        private static WritableMap objectMapToWritable(Map<String, Object> map) {
            WritableMap createMap = Arguments.createMap();
            for (Map.Entry next : map.entrySet()) {
                createMap.putArray((String) next.getKey(), buildTypeMap(next.getValue()));
            }
            return createMap;
        }

        private static WritableArray objectArrayToWritable(Object[] objArr) {
            WritableArray createArray = Arguments.createArray();
            for (Object buildTypeMap : objArr) {
                createArray.pushArray(buildTypeMap(buildTypeMap));
            }
            return createArray;
        }

        private static WritableArray buildTypeMap(Object obj) {
            WritableArray createArray = Arguments.createArray();
            if (obj == null) {
                createArray.pushInt(3);
                return createArray;
            } else if (obj instanceof Boolean) {
                if (((Boolean) obj).booleanValue()) {
                    createArray.pushInt(5);
                } else {
                    createArray.pushInt(6);
                }
                return createArray;
            } else if (obj instanceof Integer) {
                createArray.pushInt(7);
                createArray.pushDouble(((Integer) obj).doubleValue());
                return createArray;
            } else if (obj instanceof Double) {
                Double d = (Double) obj;
                if (Double.isInfinite(d.doubleValue())) {
                    if (d.equals(Double.valueOf(Double.NEGATIVE_INFINITY))) {
                        createArray.pushInt(1);
                        return createArray;
                    } else if (d.equals(Double.valueOf(Double.POSITIVE_INFINITY))) {
                        createArray.pushInt(2);
                        return createArray;
                    }
                }
                if (Double.isNaN(d.doubleValue())) {
                    createArray.pushInt(0);
                    return createArray;
                }
                createArray.pushInt(7);
                createArray.pushDouble(d.doubleValue());
                return createArray;
            } else if (obj instanceof Float) {
                createArray.pushInt(7);
                createArray.pushDouble(((Float) obj).doubleValue());
                return createArray;
            } else if (obj instanceof Long) {
                createArray.pushInt(7);
                createArray.pushDouble(((Long) obj).doubleValue());
                return createArray;
            } else if (obj instanceof String) {
                if (obj == "") {
                    createArray.pushInt(9);
                } else {
                    createArray.pushInt(8);
                    createArray.pushString((String) obj);
                }
                return createArray;
            } else if (Map.class.isAssignableFrom(obj.getClass())) {
                createArray.pushInt(16);
                createArray.pushMap(objectMapToWritable((Map) obj));
                return createArray;
            } else if (List.class.isAssignableFrom(obj.getClass())) {
                createArray.pushInt(10);
                List list = (List) obj;
                createArray.pushArray(objectArrayToWritable(list.toArray(new Object[list.size()])));
                return createArray;
            } else if (obj instanceof DocumentReference) {
                createArray.pushInt(11);
                createArray.pushString(((DocumentReference) obj).getPath());
                return createArray;
            } else if (obj instanceof Timestamp) {
                createArray.pushInt(13);
                WritableArray createArray2 = Arguments.createArray();
                Timestamp timestamp = (Timestamp) obj;
                createArray2.pushDouble((double) timestamp.getSeconds());
                createArray2.pushInt(timestamp.getNanoseconds());
                createArray.pushArray(createArray2);
                return createArray;
            } else if (obj instanceof GeoPoint) {
                createArray.pushInt(12);
                WritableArray createArray3 = Arguments.createArray();
                GeoPoint geoPoint = (GeoPoint) obj;
                createArray3.pushDouble(geoPoint.getLatitude());
                createArray3.pushDouble(geoPoint.getLongitude());
                createArray.pushArray(createArray3);
                return createArray;
            } else if (obj instanceof Blob) {
                createArray.pushInt(14);
                createArray.pushString(Base64.encodeToString(((Blob) obj).toBytes(), 2));
                return createArray;
            } else {
                Log.w(TAG, "Unknown object of type " + obj.getClass());
                createArray.pushInt(INT_UNKNOWN);
                return createArray;
            }
        }

        /* access modifiers changed from: package-private */
        public static Map<String, Object> parseReadableMap(FirebaseFirestore firebaseFirestore, @Nullable ReadableMap readableMap) {
            HashMap hashMap = new HashMap();
            if (readableMap == null) {
                return hashMap;
            }
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                hashMap.put(nextKey, parseTypeMap(firebaseFirestore, readableMap.getArray(nextKey)));
            }
            return hashMap;
        }

        static List<Object> parseReadableArray(FirebaseFirestore firebaseFirestore, @Nullable ReadableArray readableArray) {
            ArrayList arrayList = new ArrayList();
            if (readableArray == null) {
                return arrayList;
            }
            for (int i = 0; i < readableArray.size(); i++) {
                arrayList.add(parseTypeMap(firebaseFirestore, readableArray.getArray(i)));
            }
            return arrayList;
        }

        static Object parseTypeMap(FirebaseFirestore firebaseFirestore, ReadableArray readableArray) {
            switch (readableArray.getInt(0)) {
                case 0:
                    return Double.valueOf(Double.NaN);
                case 1:
                    return Double.valueOf(Double.NEGATIVE_INFINITY);
                case 2:
                    return Double.valueOf(Double.POSITIVE_INFINITY);
                case 3:
                    return null;
                case 4:
                    return FieldPath.documentId();
                case 5:
                    return true;
                case 6:
                    return false;
                case 7:
                    return Double.valueOf(readableArray.getDouble(1));
                case 8:
                    return readableArray.getString(1);
                case 9:
                    return "";
                case 10:
                    return parseReadableArray(firebaseFirestore, readableArray.getArray(1));
                case 11:
                    String string = readableArray.getString(1);
                    string.getClass();
                    return firebaseFirestore.document(string);
                case 12:
                    ReadableArray array = readableArray.getArray(1);
                    array.getClass();
                    return new GeoPoint(array.getDouble(0), array.getDouble(1));
                case 13:
                    ReadableArray array2 = readableArray.getArray(1);
                    array2.getClass();
                    return new Timestamp((long) array2.getDouble(0), array2.getInt(1));
                case 14:
                    return Blob.fromBytes(Base64.decode(readableArray.getString(1), 2));
                case 15:
                    ReadableArray array3 = readableArray.getArray(1);
                    array3.getClass();
                    String string2 = array3.getString(0);
                    string2.getClass();
                    String str = string2;
                    if (str.equals("timestamp")) {
                        return FieldValue.serverTimestamp();
                    }
                    string2.getClass();
                    if (str.equals("increment")) {
                        return FieldValue.increment(array3.getDouble(1));
                    }
                    string2.getClass();
                    if (str.equals("delete")) {
                        return FieldValue.delete();
                    }
                    string2.getClass();
                    if (str.equals("array_union")) {
                        return FieldValue.arrayUnion(parseReadableArray(firebaseFirestore, array3.getArray(1)).toArray());
                    }
                    string2.getClass();
                    if (str.equals("array_remove")) {
                        return FieldValue.arrayRemove(parseReadableArray(firebaseFirestore, array3.getArray(1)).toArray());
                    }
                    break;
                case 16:
                    break;
                default:
                    return null;
            }
            return parseReadableMap(firebaseFirestore, readableArray.getMap(1));
        }

        /* access modifiers changed from: package-private */
        public static List<Object> parseDocumentBatches(FirebaseFirestore firebaseFirestore, ReadableArray readableArray) {
            ArrayList arrayList = new ArrayList(readableArray.size());
            for (int i = 0; i < readableArray.size(); i++) {
                HashMap hashMap = new HashMap();
                ReadableMap map = readableArray.getMap(i);
                hashMap.put("type", map.getString("type"));
                hashMap.put(KEY_PATH, map.getString(KEY_PATH));
                if (map.hasKey("data")) {
                    hashMap.put("data", parseReadableMap(firebaseFirestore, map.getMap("data")));
                }
                if (map.hasKey(KEY_OPTIONS)) {
                    hashMap.put(KEY_OPTIONS, RCTConvertFirebase.toHashMap(map.getMap(KEY_OPTIONS)));
                }
                arrayList.add(hashMap);
            }
            return arrayList;
        }
    }
