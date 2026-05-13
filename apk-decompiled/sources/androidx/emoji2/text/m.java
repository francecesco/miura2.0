package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import v.C0254b;

/* JADX INFO: loaded from: classes.dex */
abstract class m {

    private static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f2597a;

        a(ByteBuffer byteBuffer) {
            this.f2597a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.m.c
        public long a() {
            return m.c(this.f2597a.getInt());
        }

        @Override // androidx.emoji2.text.m.c
        public void b(int i2) {
            ByteBuffer byteBuffer = this.f2597a;
            byteBuffer.position(byteBuffer.position() + i2);
        }

        @Override // androidx.emoji2.text.m.c
        public int c() {
            return m.d(this.f2597a.getShort());
        }

        @Override // androidx.emoji2.text.m.c
        public int d() {
            return this.f2597a.getInt();
        }

        @Override // androidx.emoji2.text.m.c
        public long getPosition() {
            return this.f2597a.position();
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f2598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f2599b;

        b(long j2, long j3) {
            this.f2598a = j2;
            this.f2599b = j3;
        }

        long a() {
            return this.f2598a;
        }
    }

    private interface c {
        long a();

        void b(int i2);

        int c();

        int d();

        long getPosition();
    }

    private static b a(c cVar) throws IOException {
        long jA;
        cVar.b(4);
        int iC = cVar.c();
        if (iC > 100) {
            throw new IOException("Cannot read metadata.");
        }
        cVar.b(6);
        int i2 = 0;
        while (true) {
            if (i2 >= iC) {
                jA = -1;
                break;
            }
            int iD = cVar.d();
            cVar.b(4);
            jA = cVar.a();
            cVar.b(4);
            if (1835365473 == iD) {
                break;
            }
            i2++;
        }
        if (jA != -1) {
            cVar.b((int) (jA - cVar.getPosition()));
            cVar.b(12);
            long jA2 = cVar.a();
            for (int i3 = 0; i3 < jA2; i3++) {
                int iD2 = cVar.d();
                long jA3 = cVar.a();
                long jA4 = cVar.a();
                if (1164798569 == iD2 || 1701669481 == iD2) {
                    return new b(jA3 + jA, jA4);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    static C0254b b(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position((int) a(new a(byteBufferDuplicate)).a());
        return C0254b.h(byteBufferDuplicate);
    }

    static long c(int i2) {
        return ((long) i2) & 4294967295L;
    }

    static int d(short s2) {
        return s2 & 65535;
    }
}
