package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;
import androidx.appcompat.widget.W;
import e.AbstractC0190a;

/* JADX INFO: renamed from: androidx.appcompat.widget.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0122k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PorterDuff.Mode f1894b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static C0122k f1895c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private W f1896a;

    /* JADX INFO: renamed from: androidx.appcompat.widget.k$a */
    class a implements W.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f1897a = {R$drawable.abc_textfield_search_default_mtrl_alpha, R$drawable.abc_textfield_default_mtrl_alpha, R$drawable.abc_ab_share_pack_mtrl_alpha};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f1898b = {R$drawable.abc_ic_commit_search_api_mtrl_alpha, R$drawable.abc_seekbar_tick_mark_material, R$drawable.abc_ic_menu_share_mtrl_alpha, R$drawable.abc_ic_menu_copy_mtrl_am_alpha, R$drawable.abc_ic_menu_cut_mtrl_alpha, R$drawable.abc_ic_menu_selectall_mtrl_alpha, R$drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f1899c = {R$drawable.abc_textfield_activated_mtrl_alpha, R$drawable.abc_textfield_search_activated_mtrl_alpha, R$drawable.abc_cab_background_top_mtrl_alpha, R$drawable.abc_text_cursor_material, R$drawable.abc_text_select_handle_left_mtrl, R$drawable.abc_text_select_handle_middle_mtrl, R$drawable.abc_text_select_handle_right_mtrl};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f1900d = {R$drawable.abc_popup_background_mtrl_mult, R$drawable.abc_cab_background_internal_bg, R$drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f1901e = {R$drawable.abc_tab_indicator_material, R$drawable.abc_textfield_search_material};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int[] f1902f = {R$drawable.abc_btn_check_material, R$drawable.abc_btn_radio_material, R$drawable.abc_btn_check_material_anim, R$drawable.abc_btn_radio_material_anim};

        a() {
        }

        private boolean f(int[] iArr, int i2) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i2) {
            int iC = a0.c(context, R$attr.colorControlHighlight);
            return new ColorStateList(new int[][]{a0.f1785b, a0.f1788e, a0.f1786c, a0.f1792i}, new int[]{a0.b(context, R$attr.colorButtonNormal), androidx.core.graphics.a.c(iC, i2), androidx.core.graphics.a.c(iC, i2), i2});
        }

        private ColorStateList i(Context context) {
            return h(context, a0.c(context, R$attr.colorAccent));
        }

        private ColorStateList j(Context context) {
            return h(context, a0.c(context, R$attr.colorButtonNormal));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList colorStateListE = a0.e(context, R$attr.colorSwitchThumbNormal);
            if (colorStateListE == null || !colorStateListE.isStateful()) {
                iArr[0] = a0.f1785b;
                iArr2[0] = a0.b(context, R$attr.colorSwitchThumbNormal);
                iArr[1] = a0.f1789f;
                iArr2[1] = a0.c(context, R$attr.colorControlActivated);
                iArr[2] = a0.f1792i;
                iArr2[2] = a0.c(context, R$attr.colorSwitchThumbNormal);
            } else {
                int[] iArr3 = a0.f1785b;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListE.getColorForState(iArr3, 0);
                iArr[1] = a0.f1789f;
                iArr2[1] = a0.c(context, R$attr.colorControlActivated);
                iArr[2] = a0.f1792i;
                iArr2[2] = colorStateListE.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private LayerDrawable l(W w2, Context context, int i2) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i2);
            Drawable drawableJ = w2.j(context, R$drawable.abc_star_black_48dp);
            Drawable drawableJ2 = w2.j(context, R$drawable.abc_star_half_black_48dp);
            if ((drawableJ instanceof BitmapDrawable) && drawableJ.getIntrinsicWidth() == dimensionPixelSize && drawableJ.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableJ;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableJ.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableJ.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableJ2 instanceof BitmapDrawable) && drawableJ2.getIntrinsicWidth() == dimensionPixelSize && drawableJ2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableJ2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableJ2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableJ2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            return layerDrawable;
        }

        private void m(Drawable drawable, int i2, PorterDuff.Mode mode) {
            Drawable drawableMutate = drawable.mutate();
            if (mode == null) {
                mode = C0122k.f1894b;
            }
            drawableMutate.setColorFilter(C0122k.e(i2, mode));
        }

        @Override // androidx.appcompat.widget.W.f
        public Drawable a(W w2, Context context, int i2) {
            int i3;
            if (i2 == R$drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{w2.j(context, R$drawable.abc_cab_background_internal_bg), w2.j(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (i2 == R$drawable.abc_ratingbar_material) {
                i3 = R$dimen.abc_star_big;
            } else if (i2 == R$drawable.abc_ratingbar_indicator_material) {
                i3 = R$dimen.abc_star_medium;
            } else {
                if (i2 != R$drawable.abc_ratingbar_small_material) {
                    return null;
                }
                i3 = R$dimen.abc_star_small;
            }
            return l(w2, context, i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0067 A[RETURN] */
        @Override // androidx.appcompat.widget.W.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean b(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.C0122k.a()
                int[] r1 = r6.f1897a
                boolean r1 = r6.f(r1, r8)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L15
                int r8 = androidx.appcompat.R$attr.colorControlNormal
            L11:
                r1 = r0
            L12:
                r0 = -1
                r5 = 1
                goto L50
            L15:
                int[] r1 = r6.f1899c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L20
                int r8 = androidx.appcompat.R$attr.colorControlActivated
                goto L11
            L20:
                int[] r1 = r6.f1900d
                boolean r1 = r6.f(r1, r8)
                r5 = 16842801(0x1010031, float:2.3693695E-38)
                if (r1 == 0) goto L32
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            L2d:
                r1 = r0
                r8 = 16842801(0x1010031, float:2.3693695E-38)
                goto L12
            L32:
                int r1 = androidx.appcompat.R$drawable.abc_list_divider_mtrl_alpha
                if (r8 != r1) goto L47
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                r1 = 16842800(0x1010030, float:2.3693693E-38)
                r1 = r0
                r5 = 1
                r0 = r8
                r8 = 16842800(0x1010030, float:2.3693693E-38)
                goto L50
            L47:
                int r1 = androidx.appcompat.R$drawable.abc_dialog_material_background
                if (r8 != r1) goto L4c
                goto L2d
            L4c:
                r1 = r0
                r8 = 0
                r0 = -1
                r5 = 0
            L50:
                if (r5 == 0) goto L67
                android.graphics.drawable.Drawable r9 = r9.mutate()
                int r7 = androidx.appcompat.widget.a0.c(r7, r8)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.C0122k.e(r7, r1)
                r9.setColorFilter(r7)
                if (r0 == r4) goto L66
                r9.setAlpha(r0)
            L66:
                return r2
            L67:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0122k.a.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // androidx.appcompat.widget.W.f
        public ColorStateList c(Context context, int i2) {
            if (i2 == R$drawable.abc_edit_text_material) {
                return AbstractC0190a.a(context, R$color.abc_tint_edittext);
            }
            if (i2 == R$drawable.abc_switch_track_mtrl_alpha) {
                return AbstractC0190a.a(context, R$color.abc_tint_switch_track);
            }
            if (i2 == R$drawable.abc_switch_thumb_material) {
                return k(context);
            }
            if (i2 == R$drawable.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i2 == R$drawable.abc_btn_borderless_material) {
                return g(context);
            }
            if (i2 == R$drawable.abc_btn_colored_material) {
                return i(context);
            }
            if (i2 == R$drawable.abc_spinner_mtrl_am_alpha || i2 == R$drawable.abc_spinner_textfield_background_material) {
                return AbstractC0190a.a(context, R$color.abc_tint_spinner);
            }
            if (f(this.f1898b, i2)) {
                return a0.e(context, R$attr.colorControlNormal);
            }
            if (f(this.f1901e, i2)) {
                return AbstractC0190a.a(context, R$color.abc_tint_default);
            }
            if (f(this.f1902f, i2)) {
                return AbstractC0190a.a(context, R$color.abc_tint_btn_checkable);
            }
            if (i2 == R$drawable.abc_seekbar_thumb_material) {
                return AbstractC0190a.a(context, R$color.abc_tint_seek_thumb);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.W.f
        public boolean d(Context context, int i2, Drawable drawable) {
            LayerDrawable layerDrawable;
            Drawable drawableFindDrawableByLayerId;
            int i3;
            if (i2 == R$drawable.abc_seekbar_track_material) {
                layerDrawable = (LayerDrawable) drawable;
                m(layerDrawable.findDrawableByLayerId(R.id.background), a0.c(context, R$attr.colorControlNormal), C0122k.f1894b);
                drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.secondaryProgress);
                i3 = R$attr.colorControlNormal;
            } else {
                if (i2 != R$drawable.abc_ratingbar_material && i2 != R$drawable.abc_ratingbar_indicator_material && i2 != R$drawable.abc_ratingbar_small_material) {
                    return false;
                }
                layerDrawable = (LayerDrawable) drawable;
                m(layerDrawable.findDrawableByLayerId(R.id.background), a0.b(context, R$attr.colorControlNormal), C0122k.f1894b);
                drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.secondaryProgress);
                i3 = R$attr.colorControlActivated;
            }
            m(drawableFindDrawableByLayerId, a0.c(context, i3), C0122k.f1894b);
            m(layerDrawable.findDrawableByLayerId(R.id.progress), a0.c(context, R$attr.colorControlActivated), C0122k.f1894b);
            return true;
        }

        @Override // androidx.appcompat.widget.W.f
        public PorterDuff.Mode e(int i2) {
            if (i2 == R$drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }
    }

    public static synchronized C0122k b() {
        try {
            if (f1895c == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f1895c;
    }

    public static synchronized PorterDuffColorFilter e(int i2, PorterDuff.Mode mode) {
        return W.l(i2, mode);
    }

    public static synchronized void h() {
        if (f1895c == null) {
            C0122k c0122k = new C0122k();
            f1895c = c0122k;
            c0122k.f1896a = W.h();
            f1895c.f1896a.u(new a());
        }
    }

    static void i(Drawable drawable, c0 c0Var, int[] iArr) {
        W.w(drawable, c0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i2) {
        return this.f1896a.j(context, i2);
    }

    synchronized Drawable d(Context context, int i2, boolean z2) {
        return this.f1896a.k(context, i2, z2);
    }

    synchronized ColorStateList f(Context context, int i2) {
        return this.f1896a.m(context, i2);
    }

    public synchronized void g(Context context) {
        this.f1896a.s(context);
    }
}
