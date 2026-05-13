package org.simpleframework.xml.transform;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
class ArrayTransform implements Transform {
    private final Transform delegate;
    private final Class entry;
    private final StringArrayTransform split = new StringArrayTransform();

    public ArrayTransform(Transform transform, Class cls) {
        this.delegate = transform;
        this.entry = cls;
    }

    @Override // org.simpleframework.xml.transform.Transform
    public Object read(String str) {
        String[] strArr = this.split.read(str);
        return read(strArr, strArr.length);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Object obj) {
        return write(obj, Array.getLength(obj));
    }

    private Object read(String[] strArr, int i2) {
        Object objNewInstance = Array.newInstance((Class<?>) this.entry, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            Object obj = this.delegate.read(strArr[i3]);
            if (obj != null) {
                Array.set(objNewInstance, i3, obj);
            }
        }
        return objNewInstance;
    }

    private String write(Object obj, int i2) {
        String[] strArr = new String[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            Object obj2 = Array.get(obj, i3);
            if (obj2 != null) {
                strArr[i3] = this.delegate.write(obj2);
            }
        }
        return this.split.write(strArr);
    }
}
