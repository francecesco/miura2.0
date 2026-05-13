package y;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: renamed from: y.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0272a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f4094a = new LinkedHashMap();

    /* JADX INFO: renamed from: y.a$a, reason: collision with other inner class name */
    public static final class C0076a extends AbstractC0272a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0076a f4095b = new C0076a();

        private C0076a() {
        }
    }

    /* JADX INFO: renamed from: y.a$b */
    public interface b {
    }

    public final Map a() {
        return this.f4094a;
    }
}
