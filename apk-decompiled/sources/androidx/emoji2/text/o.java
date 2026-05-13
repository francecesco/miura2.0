package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import o.AbstractC0236e;

/* JADX INFO: loaded from: classes.dex */
public final class o extends SpannableStringBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f2606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f2607b;

    private static class a implements TextWatcher, SpanWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f2608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f2609b = new AtomicInteger(0);

        a(Object obj) {
            this.f2608a = obj;
        }

        private boolean b(Object obj) {
            return obj instanceof j;
        }

        final void a() {
            this.f2609b.incrementAndGet();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f2608a).afterTextChanged(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ((TextWatcher) this.f2608a).beforeTextChanged(charSequence, i2, i3, i4);
        }

        final void c() {
            this.f2609b.decrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i2, int i3) {
            if (this.f2609b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f2608a).onSpanAdded(spannable, obj, i2, i3);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x001e A[PHI: r11
          0x001e: PHI (r11v1 int) = (r11v0 int), (r11v3 int) binds: [B:8:0x0013, B:12:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // android.text.SpanWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onSpanChanged(android.text.Spannable r9, java.lang.Object r10, int r11, int r12, int r13, int r14) {
            /*
                r8 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r8.f2609b
                int r0 = r0.get()
                if (r0 <= 0) goto Lf
                boolean r0 = r8.b(r10)
                if (r0 == 0) goto Lf
                return
            Lf:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 28
                if (r0 >= r1) goto L1e
                r0 = 0
                if (r11 <= r12) goto L19
                r11 = 0
            L19:
                if (r13 <= r14) goto L1e
                r4 = r11
                r6 = 0
                goto L20
            L1e:
                r4 = r11
                r6 = r13
            L20:
                java.lang.Object r11 = r8.f2608a
                r1 = r11
                android.text.SpanWatcher r1 = (android.text.SpanWatcher) r1
                r2 = r9
                r3 = r10
                r5 = r12
                r7 = r14
                r1.onSpanChanged(r2, r3, r4, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.o.a.onSpanChanged(android.text.Spannable, java.lang.Object, int, int, int, int):void");
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i2, int i3) {
            if (this.f2609b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f2608a).onSpanRemoved(spannable, obj, i2, i3);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ((TextWatcher) this.f2608a).onTextChanged(charSequence, i2, i3, i4);
        }
    }

    o(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f2607b = new ArrayList();
        AbstractC0236e.g(cls, "watcherClass cannot be null");
        this.f2606a = cls;
    }

    private void b() {
        for (int i2 = 0; i2 < this.f2607b.size(); i2++) {
            ((a) this.f2607b.get(i2)).a();
        }
    }

    public static o c(Class cls, CharSequence charSequence) {
        return new o(cls, charSequence);
    }

    private void e() {
        for (int i2 = 0; i2 < this.f2607b.size(); i2++) {
            ((a) this.f2607b.get(i2)).onTextChanged(this, 0, length(), length());
        }
    }

    private a f(Object obj) {
        for (int i2 = 0; i2 < this.f2607b.size(); i2++) {
            a aVar = (a) this.f2607b.get(i2);
            if (aVar.f2608a == obj) {
                return aVar;
            }
        }
        return null;
    }

    private boolean g(Class cls) {
        return this.f2606a == cls;
    }

    private boolean h(Object obj) {
        return obj != null && g(obj.getClass());
    }

    private void i() {
        for (int i2 = 0; i2 < this.f2607b.size(); i2++) {
            ((a) this.f2607b.get(i2)).c();
        }
    }

    public void a() {
        b();
    }

    public void d() {
        i();
        e();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public Object[] getSpans(int i2, int i3, Class cls) {
        if (!g(cls)) {
            return super.getSpans(i2, i3, cls);
        }
        a[] aVarArr = (a[]) super.getSpans(i2, i3, a.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, aVarArr.length);
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            objArr[i4] = aVarArr[i4].f2608a;
        }
        return objArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int i2, int i3, Class cls) {
        if (cls == null || g(cls)) {
            cls = a.class;
        }
        return super.nextSpanTransition(i2, i3, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object obj) {
        a aVarF;
        if (h(obj)) {
            aVarF = f(obj);
            if (aVarF != null) {
                obj = aVarF;
            }
        } else {
            aVarF = null;
        }
        super.removeSpan(obj);
        if (aVarF != null) {
            this.f2607b.remove(aVarF);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i2, int i3, int i4) {
        if (h(obj)) {
            a aVar = new a(obj);
            this.f2607b.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i2, i3, i4);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public CharSequence subSequence(int i2, int i3) {
        return new o(this.f2606a, this, i2, i3);
    }

    o(Class cls, CharSequence charSequence, int i2, int i3) {
        super(charSequence, i2, i3);
        this.f2607b = new ArrayList();
        AbstractC0236e.g(cls, "watcherClass cannot be null");
        this.f2606a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder delete(int i2, int i3) {
        super.delete(i2, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i2, CharSequence charSequence) {
        super.insert(i2, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i2, int i3, CharSequence charSequence) {
        b();
        super.replace(i2, i3, charSequence);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(char c2) {
        super.append(c2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i2, CharSequence charSequence, int i3, int i4) {
        super.insert(i2, charSequence, i3, i4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i2, int i3, CharSequence charSequence, int i4, int i5) {
        b();
        super.replace(i2, i3, charSequence, i4, i5);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence, int i2, int i3) {
        super.append(charSequence, i2, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i2) {
        super.append(charSequence, obj, i2);
        return this;
    }
}
