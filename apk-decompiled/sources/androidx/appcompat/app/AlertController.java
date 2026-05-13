package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.S;
import androidx.core.view.L;
import androidx.core.widget.NestedScrollView;
import it.tervis.miura.model.Peripheral;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class AlertController {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    NestedScrollView f823A;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private Drawable f825C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private ImageView f826D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private TextView f827E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private TextView f828F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private View f829G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    ListAdapter f830H;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f832J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private int f833K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    int f834L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    int f835M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    int f836N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    int f837O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private boolean f838P;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    Handler f840R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final y f843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Window f844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CharSequence f847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ListView f848g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f849h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f850i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f851j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f852k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f853l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f854m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Button f856o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f857p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    Message f858q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Drawable f859r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Button f860s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private CharSequence f861t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    Message f862u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Drawable f863v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    Button f864w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private CharSequence f865x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Message f866y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Drawable f867z;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f855n = false;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private int f824B = 0;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    int f831I = -1;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private int f839Q = 0;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private final View.OnClickListener f841S = new a();

    public static class RecycleListView extends ListView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f869b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecycleListView);
            this.f869b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f868a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z2, boolean z3) {
            if (z3 && z2) {
                return;
            }
            setPadding(getPaddingLeft(), z2 ? getPaddingTop() : this.f868a, getPaddingRight(), z3 ? getPaddingBottom() : this.f869b);
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            AlertController alertController = AlertController.this;
            Message messageObtain = ((view != alertController.f856o || (message2 = alertController.f858q) == null) && (view != alertController.f860s || (message2 = alertController.f862u) == null)) ? (view != alertController.f864w || (message = alertController.f866y) == null) ? null : Message.obtain(message) : Message.obtain(message2);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.f840R.obtainMessage(1, alertController2.f843b).sendToTarget();
        }
    }

    class b implements NestedScrollView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f872b;

        b(View view, View view2) {
            this.f871a = view;
            this.f872b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.d
        public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            AlertController.f(nestedScrollView, this.f871a, this.f872b);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f875b;

        c(View view, View view2) {
            this.f874a = view;
            this.f875b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(AlertController.this.f823A, this.f874a, this.f875b);
        }
    }

    class d implements AbsListView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f878b;

        d(View view, View view2) {
            this.f877a = view;
            this.f878b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            AlertController.f(absListView, this.f877a, this.f878b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f881b;

        e(View view, View view2) {
            this.f880a = view;
            this.f881b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(AlertController.this.f848g, this.f880a, this.f881b);
        }
    }

    public static class f {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public int f883A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public int f884B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public int f885C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public int f886D;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public boolean[] f888F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public boolean f889G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public boolean f890H;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public DialogInterface.OnMultiChoiceClickListener f892J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public Cursor f893K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public String f894L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public String f895M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public AdapterView.OnItemSelectedListener f896N;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LayoutInflater f899b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f901d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f903f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View f904g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f905h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public CharSequence f906i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Drawable f907j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f908k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f909l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Drawable f910m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f911n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public CharSequence f912o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Drawable f913p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f914q;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f916s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f917t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f918u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public CharSequence[] f919v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public ListAdapter f920w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f921x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f922y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public View f923z;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f900c = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f902e = 0;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public boolean f887E = false;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public int f891I = -1;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        public boolean f897O = true;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f915r = true;

        class a extends ArrayAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecycleListView f924a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, int i2, int i3, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i2, i3, charSequenceArr);
                this.f924a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i2, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i2, view, viewGroup);
                boolean[] zArr = f.this.f888F;
                if (zArr != null && zArr[i2]) {
                    this.f924a.setItemChecked(i2, true);
                }
                return view2;
            }
        }

        class b extends CursorAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f926a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f927b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ RecycleListView f928c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ AlertController f929d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Context context, Cursor cursor, boolean z2, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z2);
                this.f928c = recycleListView;
                this.f929d = alertController;
                Cursor cursor2 = getCursor();
                this.f926a = cursor2.getColumnIndexOrThrow(f.this.f894L);
                this.f927b = cursor2.getColumnIndexOrThrow(f.this.f895M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f926a));
                this.f928c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f927b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f899b.inflate(this.f929d.f835M, viewGroup, false);
            }
        }

        class c implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AlertController f931a;

            c(AlertController alertController) {
                this.f931a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                f.this.f921x.onClick(this.f931a.f843b, i2);
                if (f.this.f890H) {
                    return;
                }
                this.f931a.f843b.dismiss();
            }
        }

        class d implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecycleListView f933a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AlertController f934b;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f933a = recycleListView;
                this.f934b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                boolean[] zArr = f.this.f888F;
                if (zArr != null) {
                    zArr[i2] = this.f933a.isItemChecked(i2);
                }
                f.this.f892J.onClick(this.f934b.f843b, i2, this.f933a.isItemChecked(i2));
            }
        }

        public f(Context context) {
            this.f898a = context;
            this.f899b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void b(androidx.appcompat.app.AlertController r10) {
            /*
                r9 = this;
                android.view.LayoutInflater r0 = r9.f899b
                int r1 = r10.f834L
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r9.f889G
                if (r1 == 0) goto L34
                android.database.Cursor r1 = r9.f893K
                if (r1 != 0) goto L25
                androidx.appcompat.app.AlertController$f$a r8 = new androidx.appcompat.app.AlertController$f$a
                android.content.Context r3 = r9.f898a
                int r4 = r10.f835M
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r9.f919v
                r1 = r8
                r2 = r9
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L69
            L25:
                androidx.appcompat.app.AlertController$f$b r8 = new androidx.appcompat.app.AlertController$f$b
                android.content.Context r3 = r9.f898a
                android.database.Cursor r4 = r9.f893K
                r5 = 0
                r1 = r8
                r2 = r9
                r6 = r0
                r7 = r10
                r1.<init>(r3, r4, r5, r6, r7)
                goto L69
            L34:
                boolean r1 = r9.f890H
                if (r1 == 0) goto L3c
                int r1 = r10.f836N
            L3a:
                r4 = r1
                goto L3f
            L3c:
                int r1 = r10.f837O
                goto L3a
            L3f:
                android.database.Cursor r1 = r9.f893K
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L5b
                android.widget.SimpleCursorAdapter r8 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r9.f898a
                android.database.Cursor r5 = r9.f893K
                java.lang.String r1 = r9.f894L
                java.lang.String[] r6 = new java.lang.String[]{r1}
                int[] r7 = new int[]{r2}
                r2 = r8
                r2.<init>(r3, r4, r5, r6, r7)
                goto L69
            L5b:
                android.widget.ListAdapter r8 = r9.f920w
                if (r8 == 0) goto L60
                goto L69
            L60:
                androidx.appcompat.app.AlertController$h r8 = new androidx.appcompat.app.AlertController$h
                android.content.Context r1 = r9.f898a
                java.lang.CharSequence[] r3 = r9.f919v
                r8.<init>(r1, r4, r2, r3)
            L69:
                r10.f830H = r8
                int r1 = r9.f891I
                r10.f831I = r1
                android.content.DialogInterface$OnClickListener r1 = r9.f921x
                if (r1 == 0) goto L7c
                androidx.appcompat.app.AlertController$f$c r1 = new androidx.appcompat.app.AlertController$f$c
                r1.<init>(r10)
            L78:
                r0.setOnItemClickListener(r1)
                goto L86
            L7c:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r9.f892J
                if (r1 == 0) goto L86
                androidx.appcompat.app.AlertController$f$d r1 = new androidx.appcompat.app.AlertController$f$d
                r1.<init>(r0, r10)
                goto L78
            L86:
                android.widget.AdapterView$OnItemSelectedListener r1 = r9.f896N
                if (r1 == 0) goto L8d
                r0.setOnItemSelectedListener(r1)
            L8d:
                boolean r1 = r9.f890H
                if (r1 == 0) goto L96
                r1 = 1
            L92:
                r0.setChoiceMode(r1)
                goto L9c
            L96:
                boolean r1 = r9.f889G
                if (r1 == 0) goto L9c
                r1 = 2
                goto L92
            L9c:
                r10.f848g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.f.b(androidx.appcompat.app.AlertController):void");
        }

        public void a(AlertController alertController) {
            View view = this.f904g;
            if (view != null) {
                alertController.l(view);
            } else {
                CharSequence charSequence = this.f903f;
                if (charSequence != null) {
                    alertController.q(charSequence);
                }
                Drawable drawable = this.f901d;
                if (drawable != null) {
                    alertController.n(drawable);
                }
                int i2 = this.f900c;
                if (i2 != 0) {
                    alertController.m(i2);
                }
                int i3 = this.f902e;
                if (i3 != 0) {
                    alertController.m(alertController.c(i3));
                }
            }
            CharSequence charSequence2 = this.f905h;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            CharSequence charSequence3 = this.f906i;
            if (charSequence3 != null || this.f907j != null) {
                alertController.k(-1, charSequence3, this.f908k, null, this.f907j);
            }
            CharSequence charSequence4 = this.f909l;
            if (charSequence4 != null || this.f910m != null) {
                alertController.k(-2, charSequence4, this.f911n, null, this.f910m);
            }
            CharSequence charSequence5 = this.f912o;
            if (charSequence5 != null || this.f913p != null) {
                alertController.k(-3, charSequence5, this.f914q, null, this.f913p);
            }
            if (this.f919v != null || this.f893K != null || this.f920w != null) {
                b(alertController);
            }
            View view2 = this.f923z;
            if (view2 != null) {
                if (this.f887E) {
                    alertController.t(view2, this.f883A, this.f884B, this.f885C, this.f886D);
                    return;
                } else {
                    alertController.s(view2);
                    return;
                }
            }
            int i4 = this.f922y;
            if (i4 != 0) {
                alertController.r(i4);
            }
        }
    }

    private static final class g extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference f936a;

        public g(DialogInterface dialogInterface) {
            this.f936a = new WeakReference(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == -3 || i2 == -2 || i2 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f936a.get(), message.what);
            } else {
                if (i2 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class h extends ArrayAdapter {
        public h(Context context, int i2, int i3, CharSequence[] charSequenceArr) {
            super(context, i2, i3, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, y yVar, Window window) {
        this.f842a = context;
        this.f843b = yVar;
        this.f844c = window;
        this.f840R = new g(yVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.AlertDialog, R$attr.alertDialogStyle, 0);
        this.f832J = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_android_layout, 0);
        this.f833K = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f834L = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listLayout, 0);
        this.f835M = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f836N = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f837O = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listItemLayout, 0);
        this.f838P = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AlertDialog_showTitle, true);
        this.f845d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        yVar.j(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void f(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private ViewGroup i(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int j() {
        int i2 = this.f833K;
        return (i2 != 0 && this.f839Q == 1) ? i2 : this.f832J;
    }

    private void p(ViewGroup viewGroup, View view, int i2, int i3) {
        View view2;
        Runnable eVar;
        View viewFindViewById = this.f844c.findViewById(R$id.scrollIndicatorUp);
        View viewFindViewById2 = this.f844c.findViewById(R$id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT < 23) {
            if (viewFindViewById != null && (i2 & 1) == 0) {
                viewGroup.removeView(viewFindViewById);
                viewFindViewById = null;
            }
            if (viewFindViewById2 != null && (i2 & 2) == 0) {
                viewGroup.removeView(viewFindViewById2);
                viewFindViewById2 = null;
            }
            if (viewFindViewById == null && viewFindViewById2 == null) {
                return;
            }
            if (this.f847f != null) {
                this.f823A.setOnScrollChangeListener(new b(viewFindViewById, viewFindViewById2));
                view2 = this.f823A;
                eVar = new c(viewFindViewById, viewFindViewById2);
            } else {
                ListView listView = this.f848g;
                if (listView != null) {
                    listView.setOnScrollListener(new d(viewFindViewById, viewFindViewById2));
                    view2 = this.f848g;
                    eVar = new e(viewFindViewById, viewFindViewById2);
                } else {
                    if (viewFindViewById != null) {
                        viewGroup.removeView(viewFindViewById);
                    }
                    if (viewFindViewById2 == null) {
                        return;
                    }
                }
            }
            view2.post(eVar);
            return;
        }
        L.e0(view, i2, i3);
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 == null) {
            return;
        }
        viewGroup.removeView(viewFindViewById2);
    }

    private void u(ViewGroup viewGroup) {
        int i2;
        Button button;
        Button button2 = (Button) viewGroup.findViewById(R.id.button1);
        this.f856o = button2;
        button2.setOnClickListener(this.f841S);
        if (TextUtils.isEmpty(this.f857p) && this.f859r == null) {
            this.f856o.setVisibility(8);
            i2 = 0;
        } else {
            this.f856o.setText(this.f857p);
            Drawable drawable = this.f859r;
            if (drawable != null) {
                int i3 = this.f845d;
                drawable.setBounds(0, 0, i3, i3);
                this.f856o.setCompoundDrawables(this.f859r, null, null, null);
            }
            this.f856o.setVisibility(0);
            i2 = 1;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button2);
        this.f860s = button3;
        button3.setOnClickListener(this.f841S);
        if (TextUtils.isEmpty(this.f861t) && this.f863v == null) {
            this.f860s.setVisibility(8);
        } else {
            this.f860s.setText(this.f861t);
            Drawable drawable2 = this.f863v;
            if (drawable2 != null) {
                int i4 = this.f845d;
                drawable2.setBounds(0, 0, i4, i4);
                this.f860s.setCompoundDrawables(this.f863v, null, null, null);
            }
            this.f860s.setVisibility(0);
            i2 |= 2;
        }
        Button button4 = (Button) viewGroup.findViewById(R.id.button3);
        this.f864w = button4;
        button4.setOnClickListener(this.f841S);
        if (TextUtils.isEmpty(this.f865x) && this.f867z == null) {
            this.f864w.setVisibility(8);
        } else {
            this.f864w.setText(this.f865x);
            Drawable drawable3 = this.f867z;
            if (drawable3 != null) {
                int i5 = this.f845d;
                drawable3.setBounds(0, 0, i5, i5);
                this.f864w.setCompoundDrawables(this.f867z, null, null, null);
            }
            this.f864w.setVisibility(0);
            i2 |= 4;
        }
        if (z(this.f842a)) {
            if (i2 == 1) {
                button = this.f856o;
            } else if (i2 == 2) {
                button = this.f860s;
            } else if (i2 == 4) {
                button = this.f864w;
            }
            b(button);
        }
        if (i2 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f844c.findViewById(R$id.scrollView);
        this.f823A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f823A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.f828F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f847f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.f823A.removeView(this.f828F);
        if (this.f848g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f823A.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.f823A);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f848g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void w(ViewGroup viewGroup) {
        View viewInflate = this.f849h;
        if (viewInflate == null) {
            viewInflate = this.f850i != 0 ? LayoutInflater.from(this.f842a).inflate(this.f850i, viewGroup, false) : null;
        }
        boolean z2 = viewInflate != null;
        if (!z2 || !a(viewInflate)) {
            this.f844c.setFlags(Peripheral.EXPANSION_9, Peripheral.EXPANSION_9);
        }
        if (!z2) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f844c.findViewById(R$id.custom);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f855n) {
            frameLayout.setPadding(this.f851j, this.f852k, this.f853l, this.f854m);
        }
        if (this.f848g != null) {
            ((LinearLayout.LayoutParams) ((S.a) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    private void x(ViewGroup viewGroup) {
        View viewFindViewById;
        if (this.f829G != null) {
            viewGroup.addView(this.f829G, 0, new ViewGroup.LayoutParams(-1, -2));
            viewFindViewById = this.f844c.findViewById(R$id.title_template);
        } else {
            this.f826D = (ImageView) this.f844c.findViewById(R.id.icon);
            if ((!TextUtils.isEmpty(this.f846e)) && this.f838P) {
                TextView textView = (TextView) this.f844c.findViewById(R$id.alertTitle);
                this.f827E = textView;
                textView.setText(this.f846e);
                int i2 = this.f824B;
                if (i2 != 0) {
                    this.f826D.setImageResource(i2);
                    return;
                }
                Drawable drawable = this.f825C;
                if (drawable != null) {
                    this.f826D.setImageDrawable(drawable);
                    return;
                } else {
                    this.f827E.setPadding(this.f826D.getPaddingLeft(), this.f826D.getPaddingTop(), this.f826D.getPaddingRight(), this.f826D.getPaddingBottom());
                    this.f826D.setVisibility(8);
                    return;
                }
            }
            this.f844c.findViewById(R$id.title_template).setVisibility(8);
            this.f826D.setVisibility(8);
            viewFindViewById = viewGroup;
        }
        viewFindViewById.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a5 A[PHI: r1
      0x00a5: PHI (r1v6 android.view.View) = (r1v5 android.view.View), (r1v13 android.view.View) binds: [B:36:0x00a3, B:32:0x0098] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void y() {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.y():void");
    }

    private static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public int c(int i2) {
        TypedValue typedValue = new TypedValue();
        this.f842a.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.f848g;
    }

    public void e() {
        this.f843b.setContentView(j());
        y();
    }

    public boolean g(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f823A;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    public boolean h(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f823A;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    public void k(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f840R.obtainMessage(i2, onClickListener);
        }
        if (i2 == -3) {
            this.f865x = charSequence;
            this.f866y = message;
            this.f867z = drawable;
        } else if (i2 == -2) {
            this.f861t = charSequence;
            this.f862u = message;
            this.f863v = drawable;
        } else {
            if (i2 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f857p = charSequence;
            this.f858q = message;
            this.f859r = drawable;
        }
    }

    public void l(View view) {
        this.f829G = view;
    }

    public void m(int i2) {
        this.f825C = null;
        this.f824B = i2;
        ImageView imageView = this.f826D;
        if (imageView != null) {
            if (i2 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f826D.setImageResource(this.f824B);
            }
        }
    }

    public void n(Drawable drawable) {
        this.f825C = drawable;
        this.f824B = 0;
        ImageView imageView = this.f826D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f826D.setImageDrawable(drawable);
            }
        }
    }

    public void o(CharSequence charSequence) {
        this.f847f = charSequence;
        TextView textView = this.f828F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(CharSequence charSequence) {
        this.f846e = charSequence;
        TextView textView = this.f827E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i2) {
        this.f849h = null;
        this.f850i = i2;
        this.f855n = false;
    }

    public void s(View view) {
        this.f849h = view;
        this.f850i = 0;
        this.f855n = false;
    }

    public void t(View view, int i2, int i3, int i4, int i5) {
        this.f849h = view;
        this.f850i = 0;
        this.f855n = true;
        this.f851j = i2;
        this.f852k = i3;
        this.f853l = i4;
        this.f854m = i5;
    }
}
