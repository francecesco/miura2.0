package org.simpleframework.xml.stream;

/* JADX INFO: loaded from: classes.dex */
abstract class Splitter {
    protected StringBuilder builder = new StringBuilder();
    protected int count;
    protected int off;
    protected char[] text;

    public Splitter(String str) {
        char[] charArray = str.toCharArray();
        this.text = charArray;
        this.count = charArray.length;
    }

    private boolean acronym() {
        int i2 = this.off;
        int i3 = 0;
        while (i2 < this.count && isUpper(this.text[i2])) {
            i3++;
            i2++;
        }
        if (i3 > 1) {
            if (i2 < this.count && isUpper(this.text[i2 - 1])) {
                i2--;
            }
            char[] cArr = this.text;
            int i4 = this.off;
            commit(cArr, i4, i2 - i4);
            this.off = i2;
        }
        return i3 > 1;
    }

    private boolean isDigit(char c2) {
        return Character.isDigit(c2);
    }

    private boolean isLetter(char c2) {
        return Character.isLetter(c2);
    }

    private boolean isSpecial(char c2) {
        return !Character.isLetterOrDigit(c2);
    }

    private boolean isUpper(char c2) {
        return Character.isUpperCase(c2);
    }

    private boolean number() {
        int i2 = this.off;
        int i3 = 0;
        while (i2 < this.count && isDigit(this.text[i2])) {
            i3++;
            i2++;
        }
        if (i3 > 0) {
            char[] cArr = this.text;
            int i4 = this.off;
            commit(cArr, i4, i2 - i4);
        }
        this.off = i2;
        return i3 > 0;
    }

    private void token() {
        int i2 = this.off;
        while (i2 < this.count) {
            char c2 = this.text[i2];
            if (!isLetter(c2) || (i2 > this.off && isUpper(c2))) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = this.off;
        if (i2 > i3) {
            parse(this.text, i3, i2 - i3);
            char[] cArr = this.text;
            int i4 = this.off;
            commit(cArr, i4, i2 - i4);
        }
        this.off = i2;
    }

    protected abstract void commit(char[] cArr, int i2, int i3);

    protected abstract void parse(char[] cArr, int i2, int i3);

    public String process() {
        while (this.off < this.count) {
            while (true) {
                int i2 = this.off;
                if (i2 >= this.count || !isSpecial(this.text[i2])) {
                    break;
                }
                this.off++;
            }
            if (!acronym()) {
                token();
                number();
            }
        }
        return this.builder.toString();
    }

    protected char toLower(char c2) {
        return Character.toLowerCase(c2);
    }

    protected char toUpper(char c2) {
        return Character.toUpperCase(c2);
    }
}
