package org.simpleframework.xml.transform;

/* JADX INFO: loaded from: classes.dex */
class StringTransform implements Transform<String> {
    StringTransform() {
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String read(String str) {
        return str;
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(String str) {
        return str;
    }
}
