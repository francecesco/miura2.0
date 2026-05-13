package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.C0115d;
import androidx.appcompat.widget.C0117f;
import androidx.appcompat.widget.C0118g;
import androidx.appcompat.widget.C0119h;
import androidx.appcompat.widget.C0123l;
import androidx.appcompat.widget.C0127p;
import androidx.appcompat.widget.C0129s;
import androidx.appcompat.widget.C0132v;
import androidx.appcompat.widget.C0133w;
import androidx.appcompat.widget.C0135y;
import androidx.appcompat.widget.K;
import androidx.appcompat.widget.b0;
import androidx.core.view.L;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import k.C0213g;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: loaded from: classes.dex */
public class z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class[] f1138b = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f1139c = {R.attr.onClick};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f1140d = {R.attr.accessibilityHeading};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f1141e = {R.attr.accessibilityPaneTitle};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f1142f = {R.attr.screenReaderFocusable};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f1143g = {"android.widget.", "android.view.", "android.webkit."};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final C0213g f1144h = new C0213g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f1145a = new Object[2];

    private static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f1146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f1147b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Method f1148c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Context f1149d;

        public a(View view, String str) {
            this.f1146a = view;
            this.f1147b = str;
        }

        private void a(Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f1147b, View.class)) != null) {
                        this.f1148c = method;
                        this.f1149d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f1146a.getId();
            if (id == -1) {
                str = "";
            } else {
                str = " with id '" + this.f1146a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f1147b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f1146a.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f1148c == null) {
                a(this.f1146a.getContext());
            }
            try {
                this.f1148c.invoke(this.f1149d, view);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }
    }

    private void a(Context context, View view, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1140d);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            L.V(view, typedArrayObtainStyledAttributes.getBoolean(0, false));
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f1141e);
        if (typedArrayObtainStyledAttributes2.hasValue(0)) {
            L.W(view, typedArrayObtainStyledAttributes2.getString(0));
        }
        typedArrayObtainStyledAttributes2.recycle();
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f1142f);
        if (typedArrayObtainStyledAttributes3.hasValue(0)) {
            L.d0(view, typedArrayObtainStyledAttributes3.getBoolean(0, false));
        }
        typedArrayObtainStyledAttributes3.recycle();
    }

    private void b(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && view.hasOnClickListeners()) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1139c);
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private View s(Context context, String str, String str2) {
        String str3;
        C0213g c0213g = f1144h;
        Constructor constructor = (Constructor) c0213g.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f1138b);
            c0213g.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f1145a);
    }

    private View t(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, Name.LABEL);
        }
        try {
            Object[] objArr = this.f1145a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return s(context, str, null);
            }
            int i2 = 0;
            while (true) {
                String[] strArr = f1143g;
                if (i2 >= strArr.length) {
                    return null;
                }
                View viewS = s(context, str, strArr[i2]);
                if (viewS != null) {
                    return viewS;
                }
                i2++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.f1145a;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    private static Context u(Context context, AttributeSet attributeSet, boolean z2, boolean z3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.View, 0, 0);
        int resourceId = z2 ? typedArrayObtainStyledAttributes.getResourceId(R$styleable.View_android_theme, 0) : 0;
        if (z3 && resourceId == 0) {
            resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.View_theme, 0);
        }
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof androidx.appcompat.view.d) && ((androidx.appcompat.view.d) context).c() == resourceId) ? context : new androidx.appcompat.view.d(context, resourceId) : context;
    }

    private void v(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    protected C0115d c(Context context, AttributeSet attributeSet) {
        return new C0115d(context, attributeSet);
    }

    protected C0117f d(Context context, AttributeSet attributeSet) {
        return new C0117f(context, attributeSet);
    }

    protected C0118g e(Context context, AttributeSet attributeSet) {
        return new C0118g(context, attributeSet);
    }

    protected C0119h f(Context context, AttributeSet attributeSet) {
        return new C0119h(context, attributeSet);
    }

    protected C0123l g(Context context, AttributeSet attributeSet) {
        return new C0123l(context, attributeSet);
    }

    protected C0127p h(Context context, AttributeSet attributeSet) {
        return new C0127p(context, attributeSet);
    }

    protected androidx.appcompat.widget.r i(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.r(context, attributeSet);
    }

    protected C0129s j(Context context, AttributeSet attributeSet) {
        return new C0129s(context, attributeSet);
    }

    protected C0132v k(Context context, AttributeSet attributeSet) {
        return new C0132v(context, attributeSet);
    }

    protected C0133w l(Context context, AttributeSet attributeSet) {
        return new C0133w(context, attributeSet);
    }

    protected C0135y m(Context context, AttributeSet attributeSet) {
        return new C0135y(context, attributeSet);
    }

    protected androidx.appcompat.widget.A n(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.A(context, attributeSet);
    }

    protected androidx.appcompat.widget.F o(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.F(context, attributeSet);
    }

    protected K p(Context context, AttributeSet attributeSet) {
        return new K(context, attributeSet);
    }

    protected View q(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    public final View r(View view, String str, Context context, AttributeSet attributeSet, boolean z2, boolean z3, boolean z4, boolean z5) {
        Context context2;
        View viewL;
        context2 = (!z2 || view == null) ? context : view.getContext();
        if (z3 || z4) {
            context2 = u(context2, attributeSet, z3, z4);
        }
        if (z5) {
            context2 = b0.b(context2);
        }
        str.hashCode();
        switch (str) {
            case "RatingBar":
                viewL = l(context2, attributeSet);
                v(viewL, str);
                break;
            case "CheckedTextView":
                viewL = f(context2, attributeSet);
                v(viewL, str);
                break;
            case "MultiAutoCompleteTextView":
                viewL = j(context2, attributeSet);
                v(viewL, str);
                break;
            case "TextView":
                viewL = o(context2, attributeSet);
                v(viewL, str);
                break;
            case "ImageButton":
                viewL = h(context2, attributeSet);
                v(viewL, str);
                break;
            case "SeekBar":
                viewL = m(context2, attributeSet);
                v(viewL, str);
                break;
            case "Spinner":
                viewL = n(context2, attributeSet);
                v(viewL, str);
                break;
            case "RadioButton":
                viewL = k(context2, attributeSet);
                v(viewL, str);
                break;
            case "ToggleButton":
                viewL = p(context2, attributeSet);
                v(viewL, str);
                break;
            case "ImageView":
                viewL = i(context2, attributeSet);
                v(viewL, str);
                break;
            case "AutoCompleteTextView":
                viewL = c(context2, attributeSet);
                v(viewL, str);
                break;
            case "CheckBox":
                viewL = e(context2, attributeSet);
                v(viewL, str);
                break;
            case "EditText":
                viewL = g(context2, attributeSet);
                v(viewL, str);
                break;
            case "Button":
                viewL = d(context2, attributeSet);
                v(viewL, str);
                break;
            default:
                viewL = q(context2, str, attributeSet);
                break;
        }
        if (viewL == null && context != context2) {
            viewL = t(context2, str, attributeSet);
        }
        if (viewL != null) {
            b(viewL, attributeSet);
            a(context2, viewL, attributeSet);
        }
        return viewL;
    }
}
