package l0;

import java.util.List;

/* JADX INFO: renamed from: l0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0218b extends AbstractC0217a implements List {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3862a = new a(null);

    /* JADX INFO: renamed from: l0.b$a */
    public static final class a {
        private a() {
        }

        public final void a(int i2, int i3) {
            if (i2 < 0 || i2 >= i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public final void b(int i2, int i3) {
            if (i2 < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public /* synthetic */ a(q0.d dVar) {
            this();
        }
    }
}
