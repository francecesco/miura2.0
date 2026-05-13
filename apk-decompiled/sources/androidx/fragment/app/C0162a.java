package androidx.fragment.app;

import androidx.fragment.app.G;
import androidx.fragment.app.x;
import androidx.lifecycle.AbstractC0183g;
import it.tervis.miura.model.Console;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.fragment.app.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0162a extends G implements x.l {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final x f2830t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f2831u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f2832v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f2833w;

    C0162a(x xVar) {
        super(xVar.s0(), xVar.u0() != null ? xVar.u0().o().getClassLoader() : null);
        this.f2832v = -1;
        this.f2833w = false;
        this.f2830t = xVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.fragment.app.Fragment A(java.util.ArrayList r6, androidx.fragment.app.Fragment r7) {
        /*
            r5 = this;
            java.util.ArrayList r0 = r5.f2745c
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L35
            java.util.ArrayList r2 = r5.f2745c
            java.lang.Object r2 = r2.get(r0)
            androidx.fragment.app.G$a r2 = (androidx.fragment.app.G.a) r2
            int r3 = r2.f2762a
            if (r3 == r1) goto L2d
            r4 = 3
            if (r3 == r4) goto L27
            switch(r3) {
                case 6: goto L27;
                case 7: goto L2d;
                case 8: goto L25;
                case 9: goto L22;
                case 10: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L32
        L1d:
            androidx.lifecycle.g$b r3 = r2.f2769h
            r2.f2770i = r3
            goto L32
        L22:
            androidx.fragment.app.Fragment r7 = r2.f2763b
            goto L32
        L25:
            r7 = 0
            goto L32
        L27:
            androidx.fragment.app.Fragment r2 = r2.f2763b
            r6.add(r2)
            goto L32
        L2d:
            androidx.fragment.app.Fragment r2 = r2.f2763b
            r6.remove(r2)
        L32:
            int r0 = r0 + (-1)
            goto L8
        L35:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0162a.A(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    @Override // androidx.fragment.app.x.l
    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (x.H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Run: ");
            sb.append(this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f2751i) {
            return true;
        }
        this.f2830t.i(this);
        return true;
    }

    @Override // androidx.fragment.app.G
    public int g() {
        return s(false);
    }

    @Override // androidx.fragment.app.G
    public int h() {
        return s(true);
    }

    @Override // androidx.fragment.app.G
    public void i() {
        k();
        this.f2830t.b0(this, false);
    }

    @Override // androidx.fragment.app.G
    public void j() {
        k();
        this.f2830t.b0(this, true);
    }

    @Override // androidx.fragment.app.G
    void l(int i2, Fragment fragment, String str, int i3) {
        super.l(i2, fragment, str, i3);
        fragment.f2705t = this.f2830t;
    }

    @Override // androidx.fragment.app.G
    public G m(Fragment fragment) {
        x xVar = fragment.f2705t;
        if (xVar == null || xVar == this.f2830t) {
            return super.m(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.G
    public G p(Fragment fragment, AbstractC0183g.b bVar) {
        if (fragment.f2705t != this.f2830t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f2830t);
        }
        if (bVar == AbstractC0183g.b.INITIALIZED && fragment.f2685a > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + bVar + " after the Fragment has been created");
        }
        if (bVar != AbstractC0183g.b.DESTROYED) {
            return super.p(fragment, bVar);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + bVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    void r(int i2) {
        if (this.f2751i) {
            if (x.H0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Bump nesting in ");
                sb.append(this);
                sb.append(" by ");
                sb.append(i2);
            }
            int size = this.f2745c.size();
            for (int i3 = 0; i3 < size; i3++) {
                G.a aVar = (G.a) this.f2745c.get(i3);
                Fragment fragment = aVar.f2763b;
                if (fragment != null) {
                    fragment.f2704s += i2;
                    if (x.H0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Bump nesting of ");
                        sb2.append(aVar.f2763b);
                        sb2.append(" to ");
                        sb2.append(aVar.f2763b.f2704s);
                    }
                }
            }
        }
    }

    int s(boolean z2) {
        if (this.f2831u) {
            throw new IllegalStateException("commit already called");
        }
        if (x.H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Commit: ");
            sb.append(this);
            PrintWriter printWriter = new PrintWriter(new L("FragmentManager"));
            t("  ", printWriter);
            printWriter.close();
        }
        this.f2831u = true;
        this.f2832v = this.f2751i ? this.f2830t.l() : -1;
        this.f2830t.Y(this, z2);
        return this.f2832v;
    }

    public void t(String str, PrintWriter printWriter) {
        u(str, printWriter, true);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f2832v >= 0) {
            sb.append(" #");
            sb.append(this.f2832v);
        }
        if (this.f2753k != null) {
            sb.append(" ");
            sb.append(this.f2753k);
        }
        sb.append("}");
        return sb.toString();
    }

    public void u(String str, PrintWriter printWriter, boolean z2) {
        String str2;
        if (z2) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f2753k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f2832v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f2831u);
            if (this.f2750h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f2750h));
            }
            if (this.f2746d != 0 || this.f2747e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2746d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2747e));
            }
            if (this.f2748f != 0 || this.f2749g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2748f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2749g));
            }
            if (this.f2754l != 0 || this.f2755m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2754l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f2755m);
            }
            if (this.f2756n != 0 || this.f2757o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2756n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f2757o);
            }
        }
        if (this.f2745c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f2745c.size();
        for (int i2 = 0; i2 < size; i2++) {
            G.a aVar = (G.a) this.f2745c.get(i2);
            switch (aVar.f2762a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case Console.MAX_CONSOLE /* 7 */:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f2762a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i2);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f2763b);
            if (z2) {
                if (aVar.f2765d != 0 || aVar.f2766e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f2765d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f2766e));
                }
                if (aVar.f2767f != 0 || aVar.f2768g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f2767f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f2768g));
                }
            }
        }
    }

    void v() {
        x xVar;
        int size = this.f2745c.size();
        for (int i2 = 0; i2 < size; i2++) {
            G.a aVar = (G.a) this.f2745c.get(i2);
            Fragment fragment = aVar.f2763b;
            if (fragment != null) {
                fragment.f2699n = this.f2833w;
                fragment.z1(false);
                fragment.y1(this.f2750h);
                fragment.B1(this.f2758p, this.f2759q);
            }
            switch (aVar.f2762a) {
                case 1:
                    fragment.s1(aVar.f2765d, aVar.f2766e, aVar.f2767f, aVar.f2768g);
                    this.f2830t.m1(fragment, false);
                    this.f2830t.j(fragment);
                    continue;
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2762a);
                case 3:
                    fragment.s1(aVar.f2765d, aVar.f2766e, aVar.f2767f, aVar.f2768g);
                    this.f2830t.e1(fragment);
                    continue;
                    break;
                case 4:
                    fragment.s1(aVar.f2765d, aVar.f2766e, aVar.f2767f, aVar.f2768g);
                    this.f2830t.E0(fragment);
                    continue;
                    break;
                case 5:
                    fragment.s1(aVar.f2765d, aVar.f2766e, aVar.f2767f, aVar.f2768g);
                    this.f2830t.m1(fragment, false);
                    this.f2830t.q1(fragment);
                    continue;
                    break;
                case 6:
                    fragment.s1(aVar.f2765d, aVar.f2766e, aVar.f2767f, aVar.f2768g);
                    this.f2830t.w(fragment);
                    continue;
                    break;
                case Console.MAX_CONSOLE /* 7 */:
                    fragment.s1(aVar.f2765d, aVar.f2766e, aVar.f2767f, aVar.f2768g);
                    this.f2830t.m1(fragment, false);
                    this.f2830t.n(fragment);
                    continue;
                    break;
                case 8:
                    xVar = this.f2830t;
                    break;
                case 9:
                    xVar = this.f2830t;
                    fragment = null;
                    break;
                case 10:
                    this.f2830t.n1(fragment, aVar.f2770i);
                    continue;
                    break;
            }
            xVar.o1(fragment);
        }
    }

    void w() {
        x xVar;
        for (int size = this.f2745c.size() - 1; size >= 0; size--) {
            G.a aVar = (G.a) this.f2745c.get(size);
            Fragment fragment = aVar.f2763b;
            if (fragment != null) {
                fragment.f2699n = this.f2833w;
                fragment.z1(true);
                fragment.y1(x.i1(this.f2750h));
                fragment.B1(this.f2759q, this.f2758p);
            }
            switch (aVar.f2762a) {
                case 1:
                    fragment.s1(aVar.f2765d, aVar.f2766e, aVar.f2767f, aVar.f2768g);
                    this.f2830t.m1(fragment, true);
                    this.f2830t.e1(fragment);
                    continue;
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2762a);
                case 3:
                    fragment.s1(aVar.f2765d, aVar.f2766e, aVar.f2767f, aVar.f2768g);
                    this.f2830t.j(fragment);
                    continue;
                    break;
                case 4:
                    fragment.s1(aVar.f2765d, aVar.f2766e, aVar.f2767f, aVar.f2768g);
                    this.f2830t.q1(fragment);
                    continue;
                    break;
                case 5:
                    fragment.s1(aVar.f2765d, aVar.f2766e, aVar.f2767f, aVar.f2768g);
                    this.f2830t.m1(fragment, true);
                    this.f2830t.E0(fragment);
                    continue;
                    break;
                case 6:
                    fragment.s1(aVar.f2765d, aVar.f2766e, aVar.f2767f, aVar.f2768g);
                    this.f2830t.n(fragment);
                    continue;
                    break;
                case Console.MAX_CONSOLE /* 7 */:
                    fragment.s1(aVar.f2765d, aVar.f2766e, aVar.f2767f, aVar.f2768g);
                    this.f2830t.m1(fragment, true);
                    this.f2830t.w(fragment);
                    continue;
                    break;
                case 8:
                    xVar = this.f2830t;
                    fragment = null;
                    break;
                case 9:
                    xVar = this.f2830t;
                    break;
                case 10:
                    this.f2830t.n1(fragment, aVar.f2769h);
                    continue;
                    break;
            }
            xVar.o1(fragment);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.fragment.app.Fragment x(java.util.ArrayList r17, androidx.fragment.app.Fragment r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = 0
        L7:
            java.util.ArrayList r5 = r0.f2745c
            int r5 = r5.size()
            if (r4 >= r5) goto Lbe
            java.util.ArrayList r5 = r0.f2745c
            java.lang.Object r5 = r5.get(r4)
            androidx.fragment.app.G$a r5 = (androidx.fragment.app.G.a) r5
            int r6 = r5.f2762a
            r7 = 1
            if (r6 == r7) goto Lb6
            r8 = 2
            r9 = 0
            r10 = 3
            r11 = 9
            if (r6 == r8) goto L5a
            if (r6 == r10) goto L43
            r8 = 6
            if (r6 == r8) goto L43
            r8 = 7
            if (r6 == r8) goto Lb6
            r8 = 8
            if (r6 == r8) goto L31
            goto Lbb
        L31:
            java.util.ArrayList r6 = r0.f2745c
            androidx.fragment.app.G$a r8 = new androidx.fragment.app.G$a
            r8.<init>(r11, r3, r7)
            r6.add(r4, r8)
            r5.f2764c = r7
            int r4 = r4 + 1
            androidx.fragment.app.Fragment r3 = r5.f2763b
            goto Lbb
        L43:
            androidx.fragment.app.Fragment r6 = r5.f2763b
            r1.remove(r6)
            androidx.fragment.app.Fragment r5 = r5.f2763b
            if (r5 != r3) goto Lbb
            java.util.ArrayList r3 = r0.f2745c
            androidx.fragment.app.G$a r6 = new androidx.fragment.app.G$a
            r6.<init>(r11, r5)
            r3.add(r4, r6)
            int r4 = r4 + 1
            r3 = r9
            goto Lbb
        L5a:
            androidx.fragment.app.Fragment r6 = r5.f2763b
            int r8 = r6.f2710y
            int r12 = r17.size()
            int r12 = r12 - r7
            r13 = 0
        L64:
            if (r12 < 0) goto La4
            java.lang.Object r14 = r1.get(r12)
            androidx.fragment.app.Fragment r14 = (androidx.fragment.app.Fragment) r14
            int r15 = r14.f2710y
            if (r15 != r8) goto La1
            if (r14 != r6) goto L74
            r13 = 1
            goto La1
        L74:
            if (r14 != r3) goto L83
            java.util.ArrayList r3 = r0.f2745c
            androidx.fragment.app.G$a r15 = new androidx.fragment.app.G$a
            r15.<init>(r11, r14, r7)
            r3.add(r4, r15)
            int r4 = r4 + 1
            r3 = r9
        L83:
            androidx.fragment.app.G$a r15 = new androidx.fragment.app.G$a
            r15.<init>(r10, r14, r7)
            int r2 = r5.f2765d
            r15.f2765d = r2
            int r2 = r5.f2767f
            r15.f2767f = r2
            int r2 = r5.f2766e
            r15.f2766e = r2
            int r2 = r5.f2768g
            r15.f2768g = r2
            java.util.ArrayList r2 = r0.f2745c
            r2.add(r4, r15)
            r1.remove(r14)
            int r4 = r4 + r7
        La1:
            int r12 = r12 + (-1)
            goto L64
        La4:
            if (r13 == 0) goto Lae
            java.util.ArrayList r2 = r0.f2745c
            r2.remove(r4)
            int r4 = r4 + (-1)
            goto Lbb
        Lae:
            r5.f2762a = r7
            r5.f2764c = r7
            r1.add(r6)
            goto Lbb
        Lb6:
            androidx.fragment.app.Fragment r2 = r5.f2763b
            r1.add(r2)
        Lbb:
            int r4 = r4 + r7
            goto L7
        Lbe:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0162a.x(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    public String y() {
        return this.f2753k;
    }

    public void z() {
        if (this.f2761s != null) {
            for (int i2 = 0; i2 < this.f2761s.size(); i2++) {
                ((Runnable) this.f2761s.get(i2)).run();
            }
            this.f2761s = null;
        }
    }
}
