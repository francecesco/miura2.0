package org.simpleframework.xml.util;

/* JADX INFO: loaded from: classes.dex */
public interface Cache<T> {
    void cache(Object obj, T t2);

    boolean contains(Object obj);

    T fetch(Object obj);

    boolean isEmpty();

    T take(Object obj);
}
