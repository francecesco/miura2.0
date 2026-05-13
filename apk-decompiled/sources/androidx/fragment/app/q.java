package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;
import org.simpleframework.xml.strategy.Name;
import x.C0265c;

/* JADX INFO: loaded from: classes.dex */
class q implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final x f2947a;

    class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ D f2948a;

        a(D d2) {
            this.f2948a = d2;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment fragmentK = this.f2948a.k();
            this.f2948a.m();
            M.n((ViewGroup) fragmentK.f2667I.getParent(), q.this.f2947a).j();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    q(x xVar) {
        this.f2947a = xVar;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        D dV;
        StringBuilder sb;
        String str2;
        if (C0174m.class.getName().equals(str)) {
            return new C0174m(context, attributeSet, this.f2947a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, Name.LABEL);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(R$styleable.Fragment_android_name);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.Fragment_android_id, -1);
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.Fragment_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !AbstractC0176o.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentG0 = resourceId != -1 ? this.f2947a.g0(resourceId) : null;
        if (fragmentG0 == null && string != null) {
            fragmentG0 = this.f2947a.h0(string);
        }
        if (fragmentG0 == null && id != -1) {
            fragmentG0 = this.f2947a.g0(id);
        }
        if (fragmentG0 == null) {
            fragmentG0 = this.f2947a.s0().a(context.getClassLoader(), attributeValue);
            fragmentG0.f2700o = true;
            fragmentG0.f2709x = resourceId != 0 ? resourceId : id;
            fragmentG0.f2710y = id;
            fragmentG0.f2711z = string;
            fragmentG0.f2701p = true;
            x xVar = this.f2947a;
            fragmentG0.f2705t = xVar;
            fragmentG0.f2706u = xVar.u0();
            fragmentG0.y0(this.f2947a.u0().o(), attributeSet, fragmentG0.f2687b);
            dV = this.f2947a.j(fragmentG0);
            if (x.H0(2)) {
                sb = new StringBuilder();
                sb.append("Fragment ");
                sb.append(fragmentG0);
                str2 = " has been inflated via the <fragment> tag: id=0x";
                sb.append(str2);
                sb.append(Integer.toHexString(resourceId));
            }
        } else {
            if (fragmentG0.f2701p) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            fragmentG0.f2701p = true;
            x xVar2 = this.f2947a;
            fragmentG0.f2705t = xVar2;
            fragmentG0.f2706u = xVar2.u0();
            fragmentG0.y0(this.f2947a.u0().o(), attributeSet, fragmentG0.f2687b);
            dV = this.f2947a.v(fragmentG0);
            if (x.H0(2)) {
                sb = new StringBuilder();
                sb.append("Retained Fragment ");
                sb.append(fragmentG0);
                str2 = " has been re-attached via the <fragment> tag: id=0x";
                sb.append(str2);
                sb.append(Integer.toHexString(resourceId));
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        C0265c.g(fragmentG0, viewGroup);
        fragmentG0.f2666H = viewGroup;
        dV.m();
        dV.j();
        View view2 = fragmentG0.f2667I;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (fragmentG0.f2667I.getTag() == null) {
            fragmentG0.f2667I.setTag(string);
        }
        fragmentG0.f2667I.addOnAttachStateChangeListener(new a(dV));
        return fragmentG0.f2667I;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
