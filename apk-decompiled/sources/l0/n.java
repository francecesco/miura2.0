package l0;

import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class n extends m {
    public static int f(Iterable iterable, int i2) {
        q0.f.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }
}
