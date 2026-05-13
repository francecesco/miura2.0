package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: classes.dex */
interface Extractor<T extends Annotation> {
    T[] getAnnotations();

    Label getLabel(T t2);

    Class getType(T t2);
}
