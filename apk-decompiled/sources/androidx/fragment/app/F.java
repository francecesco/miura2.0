package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f2654a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap f2655b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap f2656c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private A f2657d;

    F() {
    }

    void A(A a2) {
        this.f2657d = a2;
    }

    C B(String str, C c2) {
        return (C) (c2 != null ? this.f2656c.put(str, c2) : this.f2656c.remove(str));
    }

    void a(Fragment fragment) {
        if (this.f2654a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f2654a) {
            this.f2654a.add(fragment);
        }
        fragment.f2697l = true;
    }

    void b() {
        this.f2655b.values().removeAll(Collections.singleton(null));
    }

    boolean c(String str) {
        return this.f2655b.get(str) != null;
    }

    void d(int i2) {
        for (D d2 : this.f2655b.values()) {
            if (d2 != null) {
                d2.u(i2);
            }
        }
    }

    void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f2655b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (D d2 : this.f2655b.values()) {
                printWriter.print(str);
                if (d2 != null) {
                    Fragment fragmentK = d2.k();
                    printWriter.println(fragmentK);
                    fragmentK.f(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f2654a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = (Fragment) this.f2654a.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    Fragment f(String str) {
        D d2 = (D) this.f2655b.get(str);
        if (d2 != null) {
            return d2.k();
        }
        return null;
    }

    Fragment g(int i2) {
        for (int size = this.f2654a.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f2654a.get(size);
            if (fragment != null && fragment.f2709x == i2) {
                return fragment;
            }
        }
        for (D d2 : this.f2655b.values()) {
            if (d2 != null) {
                Fragment fragmentK = d2.k();
                if (fragmentK.f2709x == i2) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    Fragment h(String str) {
        if (str != null) {
            for (int size = this.f2654a.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f2654a.get(size);
                if (fragment != null && str.equals(fragment.f2711z)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (D d2 : this.f2655b.values()) {
            if (d2 != null) {
                Fragment fragmentK = d2.k();
                if (str.equals(fragmentK.f2711z)) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    Fragment i(String str) {
        Fragment fragmentH;
        for (D d2 : this.f2655b.values()) {
            if (d2 != null && (fragmentH = d2.k().h(str)) != null) {
                return fragmentH;
            }
        }
        return null;
    }

    int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.f2666H;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f2654a.indexOf(fragment);
        for (int i2 = iIndexOf - 1; i2 >= 0; i2--) {
            Fragment fragment2 = (Fragment) this.f2654a.get(i2);
            if (fragment2.f2666H == viewGroup && (view2 = fragment2.f2667I) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f2654a.size()) {
                return -1;
            }
            Fragment fragment3 = (Fragment) this.f2654a.get(iIndexOf);
            if (fragment3.f2666H == viewGroup && (view = fragment3.f2667I) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    List k() {
        ArrayList arrayList = new ArrayList();
        for (D d2 : this.f2655b.values()) {
            if (d2 != null) {
                arrayList.add(d2);
            }
        }
        return arrayList;
    }

    List l() {
        ArrayList arrayList = new ArrayList();
        for (D d2 : this.f2655b.values()) {
            arrayList.add(d2 != null ? d2.k() : null);
        }
        return arrayList;
    }

    ArrayList m() {
        return new ArrayList(this.f2656c.values());
    }

    D n(String str) {
        return (D) this.f2655b.get(str);
    }

    List o() {
        ArrayList arrayList;
        if (this.f2654a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f2654a) {
            arrayList = new ArrayList(this.f2654a);
        }
        return arrayList;
    }

    A p() {
        return this.f2657d;
    }

    C q(String str) {
        return (C) this.f2656c.get(str);
    }

    void r(D d2) {
        Fragment fragmentK = d2.k();
        if (c(fragmentK.f2691f)) {
            return;
        }
        this.f2655b.put(fragmentK.f2691f, d2);
        if (fragmentK.f2662D) {
            if (fragmentK.f2661C) {
                this.f2657d.e(fragmentK);
            } else {
                this.f2657d.o(fragmentK);
            }
            fragmentK.f2662D = false;
        }
        if (x.H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Added fragment to active set ");
            sb.append(fragmentK);
        }
    }

    void s(D d2) {
        Fragment fragmentK = d2.k();
        if (fragmentK.f2661C) {
            this.f2657d.o(fragmentK);
        }
        if (((D) this.f2655b.put(fragmentK.f2691f, null)) != null && x.H0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Removed fragment from active set ");
            sb.append(fragmentK);
        }
    }

    void t() {
        Iterator it2 = this.f2654a.iterator();
        while (it2.hasNext()) {
            D d2 = (D) this.f2655b.get(((Fragment) it2.next()).f2691f);
            if (d2 != null) {
                d2.m();
            }
        }
        for (D d3 : this.f2655b.values()) {
            if (d3 != null) {
                d3.m();
                Fragment fragmentK = d3.k();
                if (fragmentK.f2698m && !fragmentK.Z()) {
                    if (fragmentK.f2699n && !this.f2656c.containsKey(fragmentK.f2691f)) {
                        d3.s();
                    }
                    s(d3);
                }
            }
        }
    }

    void u(Fragment fragment) {
        synchronized (this.f2654a) {
            this.f2654a.remove(fragment);
        }
        fragment.f2697l = false;
    }

    void v() {
        this.f2655b.clear();
    }

    void w(List list) {
        this.f2654a.clear();
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                Fragment fragmentF = f(str);
                if (fragmentF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (x.H0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("restoreSaveState: added (");
                    sb.append(str);
                    sb.append("): ");
                    sb.append(fragmentF);
                }
                a(fragmentF);
            }
        }
    }

    void x(ArrayList arrayList) {
        this.f2656c.clear();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            C c2 = (C) it2.next();
            this.f2656c.put(c2.f2627b, c2);
        }
    }

    ArrayList y() {
        ArrayList arrayList = new ArrayList(this.f2655b.size());
        for (D d2 : this.f2655b.values()) {
            if (d2 != null) {
                Fragment fragmentK = d2.k();
                d2.s();
                arrayList.add(fragmentK.f2691f);
                if (x.H0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Saved state of ");
                    sb.append(fragmentK);
                    sb.append(": ");
                    sb.append(fragmentK.f2687b);
                }
            }
        }
        return arrayList;
    }

    ArrayList z() {
        synchronized (this.f2654a) {
            try {
                if (this.f2654a.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(this.f2654a.size());
                for (Fragment fragment : this.f2654a) {
                    arrayList.add(fragment.f2691f);
                    if (x.H0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("saveAllState: adding fragment (");
                        sb.append(fragment.f2691f);
                        sb.append("): ");
                        sb.append(fragment);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
