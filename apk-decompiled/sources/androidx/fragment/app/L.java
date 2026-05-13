package androidx.fragment.app;

import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
final class L extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StringBuilder f2800b = new StringBuilder(128);

    L(String str) {
        this.f2799a = str;
    }

    private void a() {
        if (this.f2800b.length() > 0) {
            this.f2800b.toString();
            StringBuilder sb = this.f2800b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == '\n') {
                a();
            } else {
                this.f2800b.append(c2);
            }
        }
    }
}
