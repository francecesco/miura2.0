package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R$style;

/* JADX INFO: loaded from: classes.dex */
public class d extends ContextWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Configuration f1153f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Resources.Theme f1155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LayoutInflater f1156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Configuration f1157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Resources f1158e;

    public d(Context context, int i2) {
        super(context);
        this.f1154a = i2;
    }

    private Resources b() {
        if (this.f1158e == null) {
            Configuration configuration = this.f1157d;
            this.f1158e = (configuration == null || (Build.VERSION.SDK_INT >= 26 && e(configuration))) ? super.getResources() : createConfigurationContext(this.f1157d).getResources();
        }
        return this.f1158e;
    }

    private void d() {
        boolean z2 = this.f1155b == null;
        if (z2) {
            this.f1155b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1155b.setTo(theme);
            }
        }
        f(this.f1155b, this.f1154a, z2);
    }

    private static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f1153f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f1153f = configuration2;
        }
        return configuration.equals(f1153f);
    }

    public void a(Configuration configuration) {
        if (this.f1158e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f1157d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f1157d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f1154a;
    }

    protected void f(Resources.Theme theme, int i2, boolean z2) {
        theme.applyStyle(i2, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1156c == null) {
            this.f1156c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1156c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1155b;
        if (theme != null) {
            return theme;
        }
        if (this.f1154a == 0) {
            this.f1154a = R$style.Theme_AppCompat_Light;
        }
        d();
        return this.f1155b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        if (this.f1154a != i2) {
            this.f1154a = i2;
            d();
        }
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f1155b = theme;
    }
}
