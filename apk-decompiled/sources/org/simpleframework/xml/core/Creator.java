package org.simpleframework.xml.core;

/* JADX INFO: loaded from: classes.dex */
interface Creator {
    Object getInstance();

    Object getInstance(Criteria criteria);

    double getScore(Criteria criteria);

    Signature getSignature();

    Class getType();
}
