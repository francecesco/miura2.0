package org.simpleframework.xml.core;

/* JADX INFO: loaded from: classes.dex */
class Template {
    protected char[] buf;
    protected String cache;
    protected int count;

    public Template() {
        this(16);
    }

    public void append(char c2) {
        ensureCapacity(this.count + 1);
        char[] cArr = this.buf;
        int i2 = this.count;
        this.count = i2 + 1;
        cArr[i2] = c2;
    }

    public void clear() {
        this.cache = null;
        this.count = 0;
    }

    protected void ensureCapacity(int i2) {
        char[] cArr = this.buf;
        if (cArr.length < i2) {
            char[] cArr2 = new char[Math.max(i2, cArr.length * 2)];
            System.arraycopy(this.buf, 0, cArr2, 0, this.count);
            this.buf = cArr2;
        }
    }

    public int length() {
        return this.count;
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    public Template(int i2) {
        this.buf = new char[i2];
    }

    public void append(String str) {
        ensureCapacity(this.count + str.length());
        str.getChars(0, str.length(), this.buf, this.count);
        this.count += str.length();
    }

    public void append(String str, int i2, int i3) {
        ensureCapacity(this.count + i3);
        str.getChars(i2, i3, this.buf, this.count);
        this.count += i3;
    }

    public void append(Template template) {
        append(template.buf, 0, template.count);
    }

    public void append(Template template, int i2, int i3) {
        append(template.buf, i2, i3);
    }

    public void append(char[] cArr, int i2, int i3) {
        ensureCapacity(this.count + i3);
        System.arraycopy(cArr, i2, this.buf, this.count, i3);
        this.count += i3;
    }
}
