package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class l implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocaleList f2249a;

    l(Object obj) {
        this.f2249a = k.a(obj);
    }

    @Override // androidx.core.os.e
    public Object a() {
        return this.f2249a;
    }

    @Override // androidx.core.os.e
    public String b() {
        return this.f2249a.toLanguageTags();
    }

    public boolean equals(Object obj) {
        return this.f2249a.equals(((e) obj).a());
    }

    @Override // androidx.core.os.e
    public Locale get(int i2) {
        return this.f2249a.get(i2);
    }

    public int hashCode() {
        return this.f2249a.hashCode();
    }

    @Override // androidx.core.os.e
    public boolean isEmpty() {
        return this.f2249a.isEmpty();
    }

    @Override // androidx.core.os.e
    public int size() {
        return this.f2249a.size();
    }

    public String toString() {
        return this.f2249a.toString();
    }
}
