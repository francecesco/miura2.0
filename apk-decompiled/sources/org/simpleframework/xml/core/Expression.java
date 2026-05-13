package org.simpleframework.xml.core;

/* JADX INFO: loaded from: classes.dex */
interface Expression extends Iterable<String> {
    String getAttribute(String str);

    String getElement(String str);

    String getFirst();

    int getIndex();

    String getLast();

    String getPath();

    Expression getPath(int i2);

    Expression getPath(int i2, int i3);

    String getPrefix();

    boolean isAttribute();

    boolean isEmpty();

    boolean isPath();

    String toString();
}
