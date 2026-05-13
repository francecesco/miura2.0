package org.simpleframework.xml.core;

/* JADX INFO: loaded from: classes.dex */
class Revision {
    private boolean equal = true;

    public boolean compare(Object obj, Object obj2) {
        boolean zEquals;
        if (obj2 == null) {
            if (obj != null) {
                zEquals = obj.equals(Double.valueOf(1.0d));
            }
            return this.equal;
        }
        zEquals = obj2.equals(obj);
        this.equal = zEquals;
        return this.equal;
    }

    public double getDefault() {
        return 1.0d;
    }

    public boolean isEqual() {
        return this.equal;
    }
}
