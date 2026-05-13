package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f1255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Context f1256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected e f1257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected LayoutInflater f1258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected LayoutInflater f1259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private j.a f1260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected k f1263i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f1264j;

    public a(Context context, int i2, int i3) {
        this.f1255a = context;
        this.f1258d = LayoutInflater.from(context);
        this.f1261g = i2;
        this.f1262h = i3;
    }

    @Override // androidx.appcompat.view.menu.j
    public void a(e eVar, boolean z2) {
        j.a aVar = this.f1260f;
        if (aVar != null) {
            aVar.a(eVar, z2);
        }
    }

    protected void b(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1263i).addView(view, i2);
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(Context context, e eVar) {
        this.f1256b = context;
        this.f1259e = LayoutInflater.from(context);
        this.f1257c = eVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e(e eVar, g gVar) {
        return false;
    }

    public abstract void f(g gVar, k.a aVar);

    @Override // androidx.appcompat.view.menu.j
    public boolean g(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f1260f = aVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.appcompat.view.menu.j
    public boolean i(m mVar) {
        j.a aVar = this.f1260f;
        e eVar = mVar;
        if (aVar == null) {
            return false;
        }
        if (mVar == null) {
            eVar = this.f1257c;
        }
        return aVar.b(eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.j
    public void j(boolean z2) {
        ViewGroup viewGroup = (ViewGroup) this.f1263i;
        if (viewGroup == null) {
            return;
        }
        e eVar = this.f1257c;
        int i2 = 0;
        if (eVar != null) {
            eVar.r();
            ArrayList arrayListE = this.f1257c.E();
            int size = arrayListE.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                g gVar = (g) arrayListE.get(i4);
                if (q(i3, gVar)) {
                    View childAt = viewGroup.getChildAt(i3);
                    g itemData = childAt instanceof k.a ? ((k.a) childAt).getItemData() : null;
                    View viewN = n(gVar, childAt, viewGroup);
                    if (gVar != itemData) {
                        viewN.setPressed(false);
                        viewN.jumpDrawablesToCurrentState();
                    }
                    if (viewN != childAt) {
                        b(viewN, i3);
                    }
                    i3++;
                }
            }
            i2 = i3;
        }
        while (i2 < viewGroup.getChildCount()) {
            if (!l(viewGroup, i2)) {
                i2++;
            }
        }
    }

    public k.a k(ViewGroup viewGroup) {
        return (k.a) this.f1258d.inflate(this.f1262h, viewGroup, false);
    }

    protected boolean l(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    public j.a m() {
        return this.f1260f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View n(g gVar, View view, ViewGroup viewGroup) {
        k.a aVarK = view instanceof k.a ? (k.a) view : k(viewGroup);
        f(gVar, aVarK);
        return (View) aVarK;
    }

    public k o(ViewGroup viewGroup) {
        if (this.f1263i == null) {
            k kVar = (k) this.f1258d.inflate(this.f1261g, viewGroup, false);
            this.f1263i = kVar;
            kVar.b(this.f1257c);
            j(true);
        }
        return this.f1263i;
    }

    public void p(int i2) {
        this.f1264j = i2;
    }

    public abstract boolean q(int i2, g gVar);
}
