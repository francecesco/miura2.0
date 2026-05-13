package V;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import it.tervis.miura.model.Installation;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected LayoutInflater f383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Handler f384c = new Handler();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakReference f385d;

    public a(Context context, Installation installation) {
        this.f382a = context;
        this.f383b = LayoutInflater.from(context);
        this.f385d = new WeakReference(installation);
    }

    protected Installation a() {
        return (Installation) this.f385d.get();
    }

    protected String b(int i2) {
        return this.f382a.getString(i2);
    }
}
