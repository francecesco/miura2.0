package org.simpleframework.xml.stream;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
class OutputBuffer {
    private StringBuilder text = new StringBuilder();

    public void append(char c2) {
        this.text.append(c2);
    }

    public void clear() {
        this.text.setLength(0);
    }

    public void write(Writer writer) throws IOException {
        writer.append((CharSequence) this.text);
    }

    public void append(String str) {
        this.text.append(str);
    }

    public void append(String str, int i2, int i3) {
        this.text.append((CharSequence) str, i2, i3);
    }

    public void append(char[] cArr) {
        this.text.append(cArr, 0, cArr.length);
    }

    public void append(char[] cArr, int i2, int i3) {
        this.text.append(cArr, i2, i3);
    }
}
