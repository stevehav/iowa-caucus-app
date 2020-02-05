package com.google.firebase.annotations;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@KeepForSdk
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
/* compiled from: com.google.firebase:firebase-common@@17.1.0 */
public @interface PublicApi {
}
