package org.simpleframework.xml.stream;

/* JADX INFO: loaded from: classes.dex */
class Indenter {
    private Cache cache;
    private int count;
    private int indent;
    private int index;

    private static class Cache {
        private int count;
        private String[] list;

        public Cache(int i2) {
            this.list = new String[i2];
        }

        private void resize(int i2) {
            String[] strArr = new String[i2];
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.list;
                if (i3 >= strArr2.length) {
                    this.list = strArr;
                    return;
                } else {
                    strArr[i3] = strArr2[i3];
                    i3++;
                }
            }
        }

        public String get(int i2) {
            String[] strArr = this.list;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
            return null;
        }

        public void set(int i2, String str) {
            if (i2 >= this.list.length) {
                resize(i2 * 2);
            }
            if (i2 > this.count) {
                this.count = i2;
            }
            this.list[i2] = str;
        }

        public int size() {
            return this.count;
        }
    }

    public Indenter() {
        this(new Format());
    }

    private String create() {
        int i2 = this.count;
        char[] cArr = new char[i2 + 1];
        if (i2 <= 0) {
            return "\n";
        }
        cArr[0] = '\n';
        for (int i3 = 1; i3 <= this.count; i3++) {
            cArr[i3] = ' ';
        }
        return new String(cArr);
    }

    private String indent(int i2) {
        if (this.indent <= 0) {
            return "";
        }
        String strCreate = this.cache.get(i2);
        if (strCreate == null) {
            strCreate = create();
            this.cache.set(i2, strCreate);
        }
        return this.cache.size() > 0 ? strCreate : "";
    }

    public String pop() {
        int i2 = this.index - 1;
        this.index = i2;
        String strIndent = indent(i2);
        int i3 = this.indent;
        if (i3 > 0) {
            this.count -= i3;
        }
        return strIndent;
    }

    public String push() {
        int i2 = this.index;
        this.index = i2 + 1;
        String strIndent = indent(i2);
        int i3 = this.indent;
        if (i3 > 0) {
            this.count += i3;
        }
        return strIndent;
    }

    public String top() {
        return indent(this.index);
    }

    public Indenter(Format format) {
        this(format, 16);
    }

    private Indenter(Format format, int i2) {
        this.indent = format.getIndent();
        this.cache = new Cache(i2);
    }
}
