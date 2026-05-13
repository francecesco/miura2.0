package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataSetObservable f3426a = new DataSetObservable();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DataSetObserver f3427b;

    public abstract void a(ViewGroup viewGroup, int i2, Object obj);

    public abstract void b(ViewGroup viewGroup);

    public abstract int c();

    public int d(Object obj) {
        return -1;
    }

    public abstract CharSequence e(int i2);

    public float f(int i2) {
        return 1.0f;
    }

    public abstract Object g(ViewGroup viewGroup, int i2);

    public abstract boolean h(View view, Object obj);

    public void i(DataSetObserver dataSetObserver) {
        this.f3426a.registerObserver(dataSetObserver);
    }

    public abstract void j(Parcelable parcelable, ClassLoader classLoader);

    public abstract Parcelable k();

    public abstract void l(ViewGroup viewGroup, int i2, Object obj);

    void m(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f3427b = dataSetObserver;
        }
    }

    public abstract void n(ViewGroup viewGroup);

    public void o(DataSetObserver dataSetObserver) {
        this.f3426a.unregisterObserver(dataSetObserver);
    }
}
