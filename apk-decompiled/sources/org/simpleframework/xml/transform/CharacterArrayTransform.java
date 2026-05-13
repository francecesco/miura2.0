package org.simpleframework.xml.transform;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
class CharacterArrayTransform implements Transform {
    private final Class entry;

    public CharacterArrayTransform(Class cls) {
        this.entry = cls;
    }

    @Override // org.simpleframework.xml.transform.Transform
    public Object read(String str) {
        char[] charArray = str.toCharArray();
        return this.entry == Character.TYPE ? charArray : read(charArray, charArray.length);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Object obj) {
        return this.entry == Character.TYPE ? new String((char[]) obj) : write(obj, Array.getLength(obj));
    }

    private Object read(char[] cArr, int i2) {
        Object objNewInstance = Array.newInstance((Class<?>) this.entry, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            Array.set(objNewInstance, i3, Character.valueOf(cArr[i3]));
        }
        return objNewInstance;
    }

    private String write(Object obj, int i2) {
        StringBuilder sb = new StringBuilder(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            Object obj2 = Array.get(obj, i3);
            if (obj2 != null) {
                sb.append(obj2);
            }
        }
        return sb.toString();
    }
}
