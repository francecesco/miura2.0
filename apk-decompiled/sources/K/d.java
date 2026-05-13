package K;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f104b;

        private a(Object obj) {
            this.f104b = e.f(obj);
            this.f103a = new ArrayList();
        }

        public final a a(String str, Object obj) {
            List list = this.f103a;
            String str2 = (String) e.f(str);
            String strValueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + strValueOf.length());
            sb.append(str2);
            sb.append("=");
            sb.append(strValueOf);
            list.add(sb.toString());
            return this;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f104b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f103a.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append((String) this.f103a.get(i2));
                if (i2 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a c(Object obj) {
        return new a(obj);
    }
}
