package org.simpleframework.xml.core;

import org.simpleframework.xml.transform.Matcher;
import org.simpleframework.xml.transform.Transform;

/* JADX INFO: loaded from: classes.dex */
class EmptyMatcher implements Matcher {
    EmptyMatcher() {
    }

    @Override // org.simpleframework.xml.transform.Matcher
    public Transform match(Class cls) {
        return null;
    }
}
