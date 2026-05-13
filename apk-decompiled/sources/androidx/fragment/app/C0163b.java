package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.G;
import androidx.lifecycle.AbstractC0183g;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.fragment.app.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0163b implements Parcelable {
    public static final Parcelable.Creator<C0163b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int[] f2834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList f2835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int[] f2836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int[] f2837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f2838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final String f2839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f2840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f2841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final CharSequence f2842i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final int f2843j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final CharSequence f2844k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final ArrayList f2845l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final ArrayList f2846m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final boolean f2847n;

    /* JADX INFO: renamed from: androidx.fragment.app.b$a */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0163b createFromParcel(Parcel parcel) {
            return new C0163b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0163b[] newArray(int i2) {
            return new C0163b[i2];
        }
    }

    C0163b(Parcel parcel) {
        this.f2834a = parcel.createIntArray();
        this.f2835b = parcel.createStringArrayList();
        this.f2836c = parcel.createIntArray();
        this.f2837d = parcel.createIntArray();
        this.f2838e = parcel.readInt();
        this.f2839f = parcel.readString();
        this.f2840g = parcel.readInt();
        this.f2841h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f2842i = (CharSequence) creator.createFromParcel(parcel);
        this.f2843j = parcel.readInt();
        this.f2844k = (CharSequence) creator.createFromParcel(parcel);
        this.f2845l = parcel.createStringArrayList();
        this.f2846m = parcel.createStringArrayList();
        this.f2847n = parcel.readInt() != 0;
    }

    private void a(C0162a c0162a) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= this.f2834a.length) {
                c0162a.f2750h = this.f2838e;
                c0162a.f2753k = this.f2839f;
                c0162a.f2751i = true;
                c0162a.f2754l = this.f2841h;
                c0162a.f2755m = this.f2842i;
                c0162a.f2756n = this.f2843j;
                c0162a.f2757o = this.f2844k;
                c0162a.f2758p = this.f2845l;
                c0162a.f2759q = this.f2846m;
                c0162a.f2760r = this.f2847n;
                return;
            }
            G.a aVar = new G.a();
            int i4 = i2 + 1;
            aVar.f2762a = this.f2834a[i2];
            if (x.H0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Instantiate ");
                sb.append(c0162a);
                sb.append(" op #");
                sb.append(i3);
                sb.append(" base fragment #");
                sb.append(this.f2834a[i4]);
            }
            aVar.f2769h = AbstractC0183g.b.values()[this.f2836c[i3]];
            aVar.f2770i = AbstractC0183g.b.values()[this.f2837d[i3]];
            int[] iArr = this.f2834a;
            int i5 = i2 + 2;
            if (iArr[i4] == 0) {
                z2 = false;
            }
            aVar.f2764c = z2;
            int i6 = iArr[i5];
            aVar.f2765d = i6;
            int i7 = iArr[i2 + 3];
            aVar.f2766e = i7;
            int i8 = i2 + 5;
            int i9 = iArr[i2 + 4];
            aVar.f2767f = i9;
            i2 += 6;
            int i10 = iArr[i8];
            aVar.f2768g = i10;
            c0162a.f2746d = i6;
            c0162a.f2747e = i7;
            c0162a.f2748f = i9;
            c0162a.f2749g = i10;
            c0162a.f(aVar);
            i3++;
        }
    }

    public C0162a b(x xVar) {
        C0162a c0162a = new C0162a(xVar);
        a(c0162a);
        c0162a.f2832v = this.f2840g;
        for (int i2 = 0; i2 < this.f2835b.size(); i2++) {
            String str = (String) this.f2835b.get(i2);
            if (str != null) {
                ((G.a) c0162a.f2745c.get(i2)).f2763b = xVar.e0(str);
            }
        }
        c0162a.r(1);
        return c0162a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f2834a);
        parcel.writeStringList(this.f2835b);
        parcel.writeIntArray(this.f2836c);
        parcel.writeIntArray(this.f2837d);
        parcel.writeInt(this.f2838e);
        parcel.writeString(this.f2839f);
        parcel.writeInt(this.f2840g);
        parcel.writeInt(this.f2841h);
        TextUtils.writeToParcel(this.f2842i, parcel, 0);
        parcel.writeInt(this.f2843j);
        TextUtils.writeToParcel(this.f2844k, parcel, 0);
        parcel.writeStringList(this.f2845l);
        parcel.writeStringList(this.f2846m);
        parcel.writeInt(this.f2847n ? 1 : 0);
    }

    C0163b(C0162a c0162a) {
        int size = c0162a.f2745c.size();
        this.f2834a = new int[size * 6];
        if (!c0162a.f2751i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f2835b = new ArrayList(size);
        this.f2836c = new int[size];
        this.f2837d = new int[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            G.a aVar = (G.a) c0162a.f2745c.get(i3);
            int i4 = i2 + 1;
            this.f2834a[i2] = aVar.f2762a;
            ArrayList arrayList = this.f2835b;
            Fragment fragment = aVar.f2763b;
            arrayList.add(fragment != null ? fragment.f2691f : null);
            int[] iArr = this.f2834a;
            iArr[i4] = aVar.f2764c ? 1 : 0;
            iArr[i2 + 2] = aVar.f2765d;
            iArr[i2 + 3] = aVar.f2766e;
            int i5 = i2 + 5;
            iArr[i2 + 4] = aVar.f2767f;
            i2 += 6;
            iArr[i5] = aVar.f2768g;
            this.f2836c[i3] = aVar.f2769h.ordinal();
            this.f2837d[i3] = aVar.f2770i.ordinal();
        }
        this.f2838e = c0162a.f2750h;
        this.f2839f = c0162a.f2753k;
        this.f2840g = c0162a.f2832v;
        this.f2841h = c0162a.f2754l;
        this.f2842i = c0162a.f2755m;
        this.f2843j = c0162a.f2756n;
        this.f2844k = c0162a.f2757o;
        this.f2845l = c0162a.f2758p;
        this.f2846m = c0162a.f2759q;
        this.f2847n = c0162a.f2760r;
    }
}
