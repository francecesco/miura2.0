package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import c.AbstractC0186a;
import it.tervis.miura.model.Peripheral;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Random f801a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f802b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Map f803c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f804d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ArrayList f805e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final transient Map f806f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Map f807g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Bundle f808h = new Bundle();

    class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractC0186a f810b;

        a(String str, AbstractC0186a abstractC0186a) {
            this.f809a = str;
            this.f810b = abstractC0186a;
        }

        @Override // androidx.activity.result.c
        public void b(Object obj, androidx.core.app.c cVar) throws Exception {
            Integer num = (Integer) d.this.f803c.get(this.f809a);
            if (num != null) {
                d.this.f805e.add(this.f809a);
                try {
                    d.this.f(num.intValue(), this.f810b, obj, cVar);
                    return;
                } catch (Exception e2) {
                    d.this.f805e.remove(this.f809a);
                    throw e2;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f810b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.c
        public void c() {
            d.this.k(this.f809a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final androidx.activity.result.b f812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AbstractC0186a f813b;

        b(androidx.activity.result.b bVar, AbstractC0186a abstractC0186a) {
            this.f812a = bVar;
            this.f813b = abstractC0186a;
        }
    }

    private void a(int i2, String str) {
        this.f802b.put(Integer.valueOf(i2), str);
        this.f803c.put(str, Integer.valueOf(i2));
    }

    private void d(String str, int i2, Intent intent, b bVar) {
        if (bVar == null || bVar.f812a == null || !this.f805e.contains(str)) {
            this.f807g.remove(str);
            this.f808h.putParcelable(str, new androidx.activity.result.a(i2, intent));
        } else {
            bVar.f812a.a(bVar.f813b.c(i2, intent));
            this.f805e.remove(str);
        }
    }

    private int e() {
        int iNextInt = this.f801a.nextInt(2147418112);
        while (true) {
            int i2 = iNextInt + Peripheral.EXPANSION_8;
            if (!this.f802b.containsKey(Integer.valueOf(i2))) {
                return i2;
            }
            iNextInt = this.f801a.nextInt(2147418112);
        }
    }

    private void j(String str) {
        if (((Integer) this.f803c.get(str)) != null) {
            return;
        }
        a(e(), str);
    }

    public final boolean b(int i2, int i3, Intent intent) {
        String str = (String) this.f802b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        d(str, i3, intent, (b) this.f806f.get(str));
        return true;
    }

    public final boolean c(int i2, Object obj) {
        androidx.activity.result.b bVar;
        String str = (String) this.f802b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        b bVar2 = (b) this.f806f.get(str);
        if (bVar2 == null || (bVar = bVar2.f812a) == null) {
            this.f808h.remove(str);
            this.f807g.put(str, obj);
            return true;
        }
        if (!this.f805e.remove(str)) {
            return true;
        }
        bVar.a(obj);
        return true;
    }

    public abstract void f(int i2, AbstractC0186a abstractC0186a, Object obj, androidx.core.app.c cVar);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f805e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f801a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
        this.f808h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
            String str = stringArrayList.get(i2);
            if (this.f803c.containsKey(str)) {
                Integer num = (Integer) this.f803c.remove(str);
                if (!this.f808h.containsKey(str)) {
                    this.f802b.remove(num);
                }
            }
            a(integerArrayList.get(i2).intValue(), stringArrayList.get(i2));
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f803c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f803c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f805e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f808h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f801a);
    }

    public final c i(String str, AbstractC0186a abstractC0186a, androidx.activity.result.b bVar) {
        j(str);
        this.f806f.put(str, new b(bVar, abstractC0186a));
        if (this.f807g.containsKey(str)) {
            Object obj = this.f807g.get(str);
            this.f807g.remove(str);
            bVar.a(obj);
        }
        androidx.activity.result.a aVar = (androidx.activity.result.a) this.f808h.getParcelable(str);
        if (aVar != null) {
            this.f808h.remove(str);
            bVar.a(abstractC0186a.c(aVar.b(), aVar.a()));
        }
        return new a(str, abstractC0186a);
    }

    final void k(String str) {
        Integer num;
        if (!this.f805e.contains(str) && (num = (Integer) this.f803c.remove(str)) != null) {
            this.f802b.remove(num);
        }
        this.f806f.remove(str);
        if (this.f807g.containsKey(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Dropping pending result for request ");
            sb.append(str);
            sb.append(": ");
            sb.append(this.f807g.get(str));
            this.f807g.remove(str);
        }
        if (this.f808h.containsKey(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Dropping pending result for request ");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(this.f808h.getParcelable(str));
            this.f808h.remove(str);
        }
        android.support.v4.media.session.b.a(this.f804d.get(str));
    }
}
