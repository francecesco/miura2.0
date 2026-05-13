package org.simpleframework.xml.strategy;

/* JADX INFO: loaded from: classes.dex */
class ArrayValue implements Value {
    private int size;
    private Class type;
    private Object value;

    public ArrayValue(Class cls, int i2) {
        this.type = cls;
        this.size = i2;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public int getLength() {
        return this.size;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public Class getType() {
        return this.type;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public Object getValue() {
        return this.value;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public boolean isReference() {
        return false;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public void setValue(Object obj) {
        this.value = obj;
    }
}
