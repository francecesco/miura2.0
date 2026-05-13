package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.e0;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements k.a, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f1238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f1239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RadioButton f1240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f1241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CheckBox f1242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f1243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f1244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f1245h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LinearLayout f1246i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Drawable f1247j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1248k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Context f1249l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f1250m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Drawable f1251n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f1252o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private LayoutInflater f1253p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f1254q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listMenuViewStyle);
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i2) {
        LinearLayout linearLayout = this.f1246i;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    private void e() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R$layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f1242e = checkBox;
        a(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(R$layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.f1239b = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R$layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f1240c = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f1253p == null) {
            this.f1253p = LayoutInflater.from(getContext());
        }
        return this.f1253p;
    }

    private void setSubMenuArrowVisible(boolean z2) {
        ImageView imageView = this.f1244g;
        if (imageView != null) {
            imageView.setVisibility(z2 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f1245h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1245h.getLayoutParams();
        rect.top += this.f1245h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void d(g gVar, int i2) {
        this.f1238a = gVar;
        setVisibility(gVar.isVisible() ? 0 : 8);
        setTitle(gVar.i(this));
        setCheckable(gVar.isCheckable());
        h(gVar.A(), gVar.g());
        setIcon(gVar.getIcon());
        setEnabled(gVar.isEnabled());
        setSubMenuArrowVisible(gVar.hasSubMenu());
        setContentDescription(gVar.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.f1238a;
    }

    public void h(boolean z2, char c2) {
        int i2 = (z2 && this.f1238a.A()) ? 0 : 8;
        if (i2 == 0) {
            this.f1243f.setText(this.f1238a.h());
        }
        if (this.f1243f.getVisibility() != i2) {
            this.f1243f.setVisibility(i2);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f1247j);
        TextView textView = (TextView) findViewById(R$id.title);
        this.f1241d = textView;
        int i2 = this.f1248k;
        if (i2 != -1) {
            textView.setTextAppearance(this.f1249l, i2);
        }
        this.f1243f = (TextView) findViewById(R$id.shortcut);
        ImageView imageView = (ImageView) findViewById(R$id.submenuarrow);
        this.f1244g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f1251n);
        }
        this.f1245h = (ImageView) findViewById(R$id.group_divider);
        this.f1246i = (LinearLayout) findViewById(R$id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.f1239b != null && this.f1250m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1239b.getLayoutParams();
            int i4 = layoutParams.height;
            if (i4 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i4;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCheckable(boolean z2) {
        CompoundButton compoundButton;
        View view;
        if (!z2 && this.f1240c == null && this.f1242e == null) {
            return;
        }
        if (this.f1238a.m()) {
            if (this.f1240c == null) {
                g();
            }
            compoundButton = this.f1240c;
            view = this.f1242e;
        } else {
            if (this.f1242e == null) {
                e();
            }
            compoundButton = this.f1242e;
            view = this.f1240c;
        }
        if (z2) {
            compoundButton.setChecked(this.f1238a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f1242e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f1240c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z2) {
        CompoundButton compoundButton;
        if (this.f1238a.m()) {
            if (this.f1240c == null) {
                g();
            }
            compoundButton = this.f1240c;
        } else {
            if (this.f1242e == null) {
                e();
            }
            compoundButton = this.f1242e;
        }
        compoundButton.setChecked(z2);
    }

    public void setForceShowIcon(boolean z2) {
        this.f1254q = z2;
        this.f1250m = z2;
    }

    public void setGroupDividerEnabled(boolean z2) {
        ImageView imageView = this.f1245h;
        if (imageView != null) {
            imageView.setVisibility((this.f1252o || !z2) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z2 = this.f1238a.z() || this.f1254q;
        if (z2 || this.f1250m) {
            ImageView imageView = this.f1239b;
            if (imageView == null && drawable == null && !this.f1250m) {
                return;
            }
            if (imageView == null) {
                f();
            }
            if (drawable == null && !this.f1250m) {
                this.f1239b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f1239b;
            if (!z2) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f1239b.getVisibility() != 0) {
                this.f1239b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        int i2;
        TextView textView;
        if (charSequence != null) {
            this.f1241d.setText(charSequence);
            if (this.f1241d.getVisibility() == 0) {
                return;
            }
            textView = this.f1241d;
            i2 = 0;
        } else {
            i2 = 8;
            if (this.f1241d.getVisibility() == 8) {
                return;
            } else {
                textView = this.f1241d;
            }
        }
        textView.setVisibility(i2);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        e0 e0VarU = e0.u(getContext(), attributeSet, R$styleable.MenuView, i2, 0);
        this.f1247j = e0VarU.f(R$styleable.MenuView_android_itemBackground);
        this.f1248k = e0VarU.m(R$styleable.MenuView_android_itemTextAppearance, -1);
        this.f1250m = e0VarU.a(R$styleable.MenuView_preserveIconSpacing, false);
        this.f1249l = context;
        this.f1251n = e0VarU.f(R$styleable.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, R$attr.dropDownListViewStyle, 0);
        this.f1252o = typedArrayObtainStyledAttributes.hasValue(0);
        e0VarU.w();
        typedArrayObtainStyledAttributes.recycle();
    }
}
