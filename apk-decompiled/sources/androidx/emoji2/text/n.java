package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import it.tervis.miura.model.Peripheral;
import java.nio.ByteBuffer;
import o.AbstractC0236e;
import v.C0254b;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0254b f2600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char[] f2601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f2602c = new a(Peripheral.EXPANSION_2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Typeface f2603d;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SparseArray f2604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private p f2605b;

        private a() {
            this(1);
        }

        a a(int i2) {
            SparseArray sparseArray = this.f2604a;
            if (sparseArray == null) {
                return null;
            }
            return (a) sparseArray.get(i2);
        }

        final p b() {
            return this.f2605b;
        }

        void c(p pVar, int i2, int i3) {
            a aVarA = a(pVar.b(i2));
            if (aVarA == null) {
                aVarA = new a();
                this.f2604a.put(pVar.b(i2), aVarA);
            }
            if (i3 > i2) {
                aVarA.c(pVar, i2 + 1, i3);
            } else {
                aVarA.f2605b = pVar;
            }
        }

        a(int i2) {
            this.f2604a = new SparseArray(i2);
        }
    }

    private n(Typeface typeface, C0254b c0254b) {
        this.f2603d = typeface;
        this.f2600a = c0254b;
        this.f2601b = new char[c0254b.k() * 2];
        a(c0254b);
    }

    private void a(C0254b c0254b) {
        int iK = c0254b.k();
        for (int i2 = 0; i2 < iK; i2++) {
            p pVar = new p(this, i2);
            Character.toChars(pVar.f(), this.f2601b, i2 * 2);
            h(pVar);
        }
    }

    public static n b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            androidx.core.os.m.a("EmojiCompat.MetadataRepo.create");
            return new n(typeface, m.b(byteBuffer));
        } finally {
            androidx.core.os.m.b();
        }
    }

    public char[] c() {
        return this.f2601b;
    }

    public C0254b d() {
        return this.f2600a;
    }

    int e() {
        return this.f2600a.l();
    }

    a f() {
        return this.f2602c;
    }

    Typeface g() {
        return this.f2603d;
    }

    void h(p pVar) {
        AbstractC0236e.g(pVar, "emoji metadata cannot be null");
        AbstractC0236e.a(pVar.c() > 0, "invalid metadata codepoint length");
        this.f2602c.c(pVar, 0, pVar.c() - 1);
    }
}
