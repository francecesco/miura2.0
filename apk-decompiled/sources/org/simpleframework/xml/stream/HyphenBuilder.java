package org.simpleframework.xml.stream;

/* JADX INFO: loaded from: classes.dex */
class HyphenBuilder implements Style {

    private class Parser extends Splitter {
        private Parser(String str) {
            super(str);
        }

        @Override // org.simpleframework.xml.stream.Splitter
        protected void commit(char[] cArr, int i2, int i3) {
            this.builder.append(cArr, i2, i3);
            if (i2 + i3 < this.count) {
                this.builder.append('-');
            }
        }

        @Override // org.simpleframework.xml.stream.Splitter
        protected void parse(char[] cArr, int i2, int i3) {
            cArr[i2] = toLower(cArr[i2]);
        }
    }

    HyphenBuilder() {
    }

    @Override // org.simpleframework.xml.stream.Style
    public String getAttribute(String str) {
        if (str != null) {
            return new Parser(str).process();
        }
        return null;
    }

    @Override // org.simpleframework.xml.stream.Style
    public String getElement(String str) {
        if (str != null) {
            return new Parser(str).process();
        }
        return null;
    }
}
