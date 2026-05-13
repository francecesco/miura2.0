package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.AbstractC0183g;

/* JADX INFO: loaded from: classes.dex */
final class C implements Parcelable {
    public static final Parcelable.Creator<C> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f2626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f2627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f2628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f2629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f2630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final String f2631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f2632g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f2633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f2634i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final Bundle f2635j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f2636k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final int f2637l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Bundle f2638m;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C createFromParcel(Parcel parcel) {
            return new C(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C[] newArray(int i2) {
            return new C[i2];
        }
    }

    C(Parcel parcel) {
        this.f2626a = parcel.readString();
        this.f2627b = parcel.readString();
        this.f2628c = parcel.readInt() != 0;
        this.f2629d = parcel.readInt();
        this.f2630e = parcel.readInt();
        this.f2631f = parcel.readString();
        this.f2632g = parcel.readInt() != 0;
        this.f2633h = parcel.readInt() != 0;
        this.f2634i = parcel.readInt() != 0;
        this.f2635j = parcel.readBundle();
        this.f2636k = parcel.readInt() != 0;
        this.f2638m = parcel.readBundle();
        this.f2637l = parcel.readInt();
    }

    Fragment a(AbstractC0176o abstractC0176o, ClassLoader classLoader) {
        Fragment fragmentA = abstractC0176o.a(classLoader, this.f2626a);
        Bundle bundle = this.f2635j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentA.t1(this.f2635j);
        fragmentA.f2691f = this.f2627b;
        fragmentA.f2700o = this.f2628c;
        fragmentA.f2702q = true;
        fragmentA.f2709x = this.f2629d;
        fragmentA.f2710y = this.f2630e;
        fragmentA.f2711z = this.f2631f;
        fragmentA.f2661C = this.f2632g;
        fragmentA.f2698m = this.f2633h;
        fragmentA.f2660B = this.f2634i;
        fragmentA.f2659A = this.f2636k;
        fragmentA.f2676R = AbstractC0183g.b.values()[this.f2637l];
        Bundle bundle2 = this.f2638m;
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        fragmentA.f2687b = bundle2;
        return fragmentA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f2626a);
        sb.append(" (");
        sb.append(this.f2627b);
        sb.append(")}:");
        if (this.f2628c) {
            sb.append(" fromLayout");
        }
        if (this.f2630e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f2630e));
        }
        String str = this.f2631f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f2631f);
        }
        if (this.f2632g) {
            sb.append(" retainInstance");
        }
        if (this.f2633h) {
            sb.append(" removing");
        }
        if (this.f2634i) {
            sb.append(" detached");
        }
        if (this.f2636k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f2626a);
        parcel.writeString(this.f2627b);
        parcel.writeInt(this.f2628c ? 1 : 0);
        parcel.writeInt(this.f2629d);
        parcel.writeInt(this.f2630e);
        parcel.writeString(this.f2631f);
        parcel.writeInt(this.f2632g ? 1 : 0);
        parcel.writeInt(this.f2633h ? 1 : 0);
        parcel.writeInt(this.f2634i ? 1 : 0);
        parcel.writeBundle(this.f2635j);
        parcel.writeInt(this.f2636k ? 1 : 0);
        parcel.writeBundle(this.f2638m);
        parcel.writeInt(this.f2637l);
    }

    C(Fragment fragment) {
        this.f2626a = fragment.getClass().getName();
        this.f2627b = fragment.f2691f;
        this.f2628c = fragment.f2700o;
        this.f2629d = fragment.f2709x;
        this.f2630e = fragment.f2710y;
        this.f2631f = fragment.f2711z;
        this.f2632g = fragment.f2661C;
        this.f2633h = fragment.f2698m;
        this.f2634i = fragment.f2660B;
        this.f2635j = fragment.f2692g;
        this.f2636k = fragment.f2659A;
        this.f2637l = fragment.f2676R.ordinal();
    }
}
