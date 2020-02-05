package com.google.firebase.firestore;

import com.google.firebase.annotations.PublicApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@PublicApi
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public @interface Exclude {
}
