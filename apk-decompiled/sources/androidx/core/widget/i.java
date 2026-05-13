package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.core.text.m;
import it.tervis.miura.model.Console;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import o.AbstractC0236e;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    static class a {
        static int a(TextView textView) {
            return textView.getBreakStrategy();
        }

        static ColorStateList b(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        static PorterDuff.Mode c(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }

        static int d(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        static void e(TextView textView, int i2) {
            textView.setBreakStrategy(i2);
        }

        static void f(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        static void g(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        static void h(TextView textView, int i2) {
            textView.setHyphenationFrequency(i2);
        }
    }

    static class b {
        static DecimalFormatSymbols a(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    }

    static class c {
        static CharSequence a(PrecomputedText precomputedText) {
            return precomputedText;
        }

        static String[] b(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        static PrecomputedText.Params c(TextView textView) {
            return textView.getTextMetricsParams();
        }

        static void d(TextView textView, int i2) {
            textView.setFirstBaselineToTopHeight(i2);
        }
    }

    static class d {
        public static void a(TextView textView, int i2, float f2) {
            textView.setLineHeight(i2, f2);
        }
    }

    private static class e implements ActionMode.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ActionMode.Callback f2453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextView f2454b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Class f2455c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Method f2456d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f2457e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f2458f = false;

        e(ActionMode.Callback callback, TextView textView) {
            this.f2453a = callback;
            this.f2454b = textView;
        }

        private Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent b(ResolveInfo resolveInfo, TextView textView) {
            Intent intentPutExtra = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !e(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return intentPutExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        private List c(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(a(), 0)) {
                if (f(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        private boolean e(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        private boolean f(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            return str == null || context.checkSelfPermission(str) == 0;
        }

        private void g(Menu menu) {
            Context context = this.f2454b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f2458f) {
                this.f2458f = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f2455c = cls;
                    this.f2456d = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.f2457e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f2455c = null;
                    this.f2456d = null;
                    this.f2457e = false;
                }
            }
            try {
                Method declaredMethod = (this.f2457e && this.f2455c.isInstance(menu)) ? this.f2456d : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List listC = c(context, packageManager);
                for (int i2 = 0; i2 < listC.size(); i2++) {
                    ResolveInfo resolveInfo = (ResolveInfo) listC.get(i2);
                    menu.add(0, 0, i2 + 100, resolveInfo.loadLabel(packageManager)).setIntent(b(resolveInfo, this.f2454b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        ActionMode.Callback d() {
            return this.f2453a;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f2453a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f2453a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f2453a.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            g(menu);
            return this.f2453a.onPrepareActionMode(actionMode, menu);
        }
    }

    public static int a(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int b(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    private static int c(TextDirectionHeuristic textDirectionHeuristic) {
        TextDirectionHeuristic textDirectionHeuristic2;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        if (textDirectionHeuristic == textDirectionHeuristic3 || textDirectionHeuristic == (textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return 6;
        }
        return textDirectionHeuristic == textDirectionHeuristic3 ? 7 : 1;
    }

    private static TextDirectionHeuristic d(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            byte directionality = Character.getDirectionality(c.b(b.a(textView.getTextLocale()))[0].codePointAt(0));
            return (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        boolean z2 = textView.getLayoutDirection() == 1;
        switch (textView.getTextDirection()) {
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case Console.MAX_CONSOLE /* 7 */:
                break;
            default:
                if (!z2) {
                }
                break;
        }
        return TextDirectionHeuristics.LTR;
    }

    public static m.a e(TextView textView) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return new m.a(c.c(textView));
        }
        m.a.C0036a c0036a = new m.a.C0036a(new TextPaint(textView.getPaint()));
        if (i2 >= 23) {
            c0036a.b(a.a(textView));
            c0036a.c(a.d(textView));
        }
        c0036a.d(d(textView));
        return c0036a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void f(TextView textView, ColorStateList colorStateList) {
        AbstractC0236e.f(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            a.f(textView, colorStateList);
        } else if (textView instanceof l) {
            ((l) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(TextView textView, PorterDuff.Mode mode) {
        AbstractC0236e.f(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            a.g(textView, mode);
        } else if (textView instanceof l) {
            ((l) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void h(TextView textView, int i2) {
        AbstractC0236e.c(i2);
        if (Build.VERSION.SDK_INT >= 28) {
            c.d(textView, i2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i2 + i3, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void i(TextView textView, int i2) {
        AbstractC0236e.c(i2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static void j(TextView textView, int i2) {
        AbstractC0236e.c(i2);
        if (i2 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i2 - r0, 1.0f);
        }
    }

    public static void k(TextView textView, int i2, float f2) {
        if (Build.VERSION.SDK_INT >= 34) {
            d.a(textView, i2, f2);
        } else {
            j(textView, Math.round(TypedValue.applyDimension(i2, f2, textView.getResources().getDisplayMetrics())));
        }
    }

    public static void l(TextView textView, m mVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        e(textView);
        throw null;
    }

    public static void m(TextView textView, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i2);
        } else {
            textView.setTextAppearance(textView.getContext(), i2);
        }
    }

    public static void n(TextView textView, m.a aVar) {
        textView.setTextDirection(c(aVar.d()));
        if (Build.VERSION.SDK_INT >= 23) {
            textView.getPaint().set(aVar.e());
            a.e(textView, aVar.b());
            a.h(textView, aVar.c());
        } else {
            float textScaleX = aVar.e().getTextScaleX();
            textView.getPaint().set(aVar.e());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
        }
    }

    public static ActionMode.Callback o(ActionMode.Callback callback) {
        return (!(callback instanceof e) || Build.VERSION.SDK_INT < 26) ? callback : ((e) callback).d();
    }

    public static ActionMode.Callback p(TextView textView, ActionMode.Callback callback) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 26 || i2 > 27 || (callback instanceof e) || callback == null) ? callback : new e(callback, textView);
    }
}
