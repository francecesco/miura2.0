package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IntentSender f815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Intent f816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f814e = new c(null);
    public static final Parcelable.Creator<f> CREATOR = new b();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IntentSender f819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Intent f820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f821c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f822d;

        public a(IntentSender intentSender) {
            q0.f.e(intentSender, "intentSender");
            this.f819a = intentSender;
        }

        public final f a() {
            return new f(this.f819a, this.f820b, this.f821c, this.f822d);
        }

        public final a b(Intent intent) {
            this.f820b = intent;
            return this;
        }

        public final a c(int i2, int i3) {
            this.f822d = i2;
            this.f821c = i3;
            return this;
        }
    }

    public static final class b implements Parcelable.Creator {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            q0.f.e(parcel, "inParcel");
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i2) {
            return new f[i2];
        }
    }

    public static final class c {
        private c() {
        }

        public /* synthetic */ c(q0.d dVar) {
            this();
        }
    }

    public f(IntentSender intentSender, Intent intent, int i2, int i3) {
        q0.f.e(intentSender, "intentSender");
        this.f815a = intentSender;
        this.f816b = intent;
        this.f817c = i2;
        this.f818d = i3;
    }

    public final Intent a() {
        return this.f816b;
    }

    public final int b() {
        return this.f817c;
    }

    public final int c() {
        return this.f818d;
    }

    public final IntentSender d() {
        return this.f815a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        q0.f.e(parcel, "dest");
        parcel.writeParcelable(this.f815a, i2);
        parcel.writeParcelable(this.f816b, i2);
        parcel.writeInt(this.f817c);
        parcel.writeInt(this.f818d);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f(Parcel parcel) {
        q0.f.e(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        q0.f.b(parcelable);
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }
}
