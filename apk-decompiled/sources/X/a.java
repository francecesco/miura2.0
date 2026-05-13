package X;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import it.tervis.miura.Miura;
import it.tervis.miura.MiuraService;
import it.tervis.miura.R;
import it.tervis.miura.activity.GroupActivity;
import it.tervis.miura.model.Group;
import it.tervis.miura.model.NPI;
import it.tervis.miura.model.Peripheral;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a extends X.b {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private ListView f420i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private V.c f421j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private i f422k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private j f423l0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f427p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private boolean f428q0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private HashMap f424m0 = new HashMap();

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private HashMap f425n0 = new HashMap();

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private HashMap f426o0 = new HashMap();

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private MiuraService.n f429r0 = new C0006a();

    /* JADX INFO: renamed from: X.a$a, reason: collision with other inner class name */
    class C0006a extends MiuraService.n {

        /* JADX INFO: renamed from: X.a$a$a, reason: collision with other inner class name */
        class RunnableC0007a implements Runnable {
            RunnableC0007a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f421j0.notifyDataSetChanged();
            }
        }

        C0006a() {
        }

        @Override // it.tervis.miura.MiuraService.n
        public void c(Y.b bVar) {
            if ((bVar instanceof Z.j) || (bVar instanceof Z.f)) {
                a.this.f466f0.post(new RunnableC0007a());
            }
        }
    }

    class b extends Y.f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Group f432c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f433d;

        /* JADX INFO: renamed from: X.a$b$a, reason: collision with other inner class name */
        class RunnableC0008a implements Runnable {
            RunnableC0008a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f464d0.D();
                a.this.f464d0.p("Timeout...!");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i2, int i3, Group group, int i4) {
            super(i2, i3);
            this.f432c = group;
            this.f433d = i4;
        }

        @Override // Y.f
        public void d() {
            j0.d.a("Timeout for AllZonesRequest");
            a.this.f466f0.post(new RunnableC0008a());
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(Z.e eVar) {
            this.f432c.asMask();
            if (eVar.A()) {
                j0.d.a("Group " + this.f433d + " is ready for activation");
                a.this.Y1(this.f433d);
            } else {
                a.this.f428q0 = eVar.z();
                a.this.i2(this.f433d, eVar);
            }
            j0.d.a("Response for AllZonesRequest");
            return true;
        }
    }

    class c extends Y.f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Group f436c;

        /* JADX INFO: renamed from: X.a$c$a, reason: collision with other inner class name */
        class RunnableC0009a implements Runnable {
            RunnableC0009a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                X.g gVar;
                String str;
                a.this.f421j0.notifyDataSetChanged();
                a.this.f464d0.D();
                if (c.this.f436c.isActivated() || c.this.f436c.isPartiallyActivatedWithTemporaryExcludedZones()) {
                    gVar = a.this.f464d0;
                    str = "Gruppo attivato!";
                } else {
                    gVar = a.this.f464d0;
                    str = "Attivazione gruppo non eseguita.";
                }
                gVar.p(str);
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f464d0.D();
                a.this.f464d0.p("Timeout...!");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i2, int i3, Group group) {
            super(i2, i3);
            this.f436c = group;
        }

        @Override // Y.f
        public void d() {
            a.this.f466f0.post(new b());
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(Z.b bVar) {
            a.this.f466f0.post(new RunnableC0009a());
            return true;
        }
    }

    class d extends Y.f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f440c;

        /* JADX INFO: renamed from: X.a$d$a, reason: collision with other inner class name */
        class RunnableC0010a implements Runnable {
            RunnableC0010a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f421j0.notifyDataSetChanged();
                a.this.f464d0.D();
                a.this.f464d0.p("Disattivato!");
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f464d0.D();
                if (d.this.f440c) {
                    return;
                }
                a.this.f464d0.p("Timeout...!");
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f464d0.D();
            }
        }

        d(int i2, int i3) {
            super(i2, i3);
            this.f440c = false;
        }

        @Override // Y.f
        public void b(Y.b bVar) {
            j0.d.a("Generic messaage arrived: " + bVar);
            if (bVar instanceof h0.g) {
                this.f440c = true;
                j0.d.a("Gestiremo questo messaggio! Forse c'e' un errore....");
                a.this.f466f0.post(new c());
                synchronized (this) {
                    notify();
                }
            }
        }

        @Override // Y.f
        public void d() {
            a.this.f466f0.post(new b());
        }

        @Override // Y.f
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean c(Z.h hVar) {
            a.this.f466f0.post(new RunnableC0010a());
            return true;
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f464d0.D();
            a.this.f464d0.E("Attenzione", "Zone non programmate, il gruppo non può essere attivato.");
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f447b;

        /* JADX INFO: renamed from: X.a$f$a, reason: collision with other inner class name */
        class DialogInterfaceOnClickListenerC0011a implements DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC0011a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                f fVar = f.this;
                a.this.Y1(fVar.f447b);
            }
        }

        f(String str, int i2) {
            this.f446a = str;
            this.f447b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f464d0.D();
            a.this.f464d0.j("Attenzione", this.f446a, new DialogInterfaceOnClickListenerC0011a());
        }
    }

    class g extends Y.f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f450c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f451d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f452e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f453f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Z.e f454g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i2, int i3, int i4, int i5, int i6, Z.e eVar) {
            super(i2, i3);
            this.f451d = i4;
            this.f452e = i5;
            this.f453f = i6;
            this.f454g = eVar;
            this.f450c = 0;
        }

        @Override // Y.f
        public void d() {
            j0.d.a("manageZonesInAlarm timeout");
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(Z.o oVar) {
            j0.d.a("manageZonesInAlarm response for zone " + oVar.y());
            HashMap map = (HashMap) a.this.f424m0.get(Integer.valueOf(this.f451d));
            int[] iArr = NPI.NPI_ZONES_CAUSES;
            ((HashSet) map.get(Integer.valueOf(iArr[this.f452e]))).add(Integer.valueOf(oVar.y()));
            int iW = oVar.w();
            this.f450c = iW;
            if (iW < oVar.x() - 1) {
                j0.d.a("manageZonesInAlarm response: querying next frame " + (this.f450c + 1));
                a.this.K1(new Z.n(this.f453f, iArr[this.f452e], this.f450c + 1), this);
            } else {
                j0.d.a("Ended check for type " + Integer.toString(iArr[this.f452e]));
                int i2 = this.f452e;
                if (i2 < iArr.length - 1) {
                    a.this.m2(this.f451d, this.f454g, i2 + 1);
                } else {
                    a.this.i2(this.f451d, this.f454g);
                }
            }
            return true;
        }
    }

    class h extends Y.f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f456c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f457d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f458e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Z.e f459f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(int i2, int i3, int i4, int i5, Z.e eVar) {
            super(i2, i3);
            this.f457d = i4;
            this.f458e = i5;
            this.f459f = eVar;
            this.f456c = 0;
        }

        @Override // Y.f
        public void d() {
            j0.d.a("manageZonesInAlarm timeout");
        }

        @Override // Y.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(Z.l lVar) {
            j0.d.a("managePeripheralsNPI response for type " + lVar.u());
            HashMap map = (HashMap) a.this.f425n0.get(Integer.valueOf(this.f457d));
            int[] iArr = NPI.NPI_PERIPHERALS_CAUSES;
            map.put(Integer.valueOf(iArr[this.f458e]), Integer.valueOf(lVar.y()));
            if (lVar.x() != 0) {
                ((HashMap) a.this.f426o0.get(Integer.valueOf(this.f457d))).put(Integer.valueOf(iArr[this.f458e]), Integer.valueOf(lVar.x()));
            }
            if (lVar.u() == 9) {
                a.this.f427p0 = lVar.w();
            }
            int i2 = this.f458e;
            if (i2 < iArr.length - 1) {
                a.this.k2(this.f457d, this.f459f, i2 + 1);
            } else {
                a.this.i2(this.f457d, this.f459f);
            }
            return true;
        }
    }

    private class i implements View.OnClickListener {
        private i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iIntValue;
            if (!a.this.I1().canUseSecuritySection() || (iIntValue = ((Integer) view.getTag()).intValue()) >= 100) {
                return;
            }
            a.this.d2(iIntValue);
        }

        /* synthetic */ i(a aVar, C0006a c0006a) {
            this();
        }
    }

    private class j implements View.OnClickListener {
        private j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.I1().canUseSecuritySection()) {
                int iIntValue = ((Integer) view.getTag()).intValue();
                Intent intent = new Intent(a.this.i(), (Class<?>) GroupActivity.class);
                intent.putExtra(".area", a.this.g2());
                intent.putExtra(".group", iIntValue);
                a.this.D1(intent);
            }
        }

        /* synthetic */ j(a aVar, C0006a c0006a) {
            this();
        }
    }

    public a() {
        C0006a c0006a = null;
        this.f422k0 = new i(this, c0006a);
        this.f423l0 = new j(this, c0006a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y1(int i2) {
        j0.d.a("Group " + i2 + " is being activated");
        Group item = this.f421j0.getItem(i2);
        K1(new Z.a(item.asMask(), true), new c(6, 129, item));
    }

    private String Z1() {
        StringBuffer stringBuffer = new StringBuffer();
        if ((this.f427p0 & 1) != 0) {
            stringBuffer.append(Q(R.string.label_error_central_power));
        }
        if ((this.f427p0 & 2) != 0) {
            stringBuffer.append(Q(R.string.label_error_central_battery));
        }
        if ((this.f427p0 & 4) != 0) {
            stringBuffer.append(Q(R.string.label_error_sim_credit));
        }
        if ((this.f427p0 & 8) != 0) {
            stringBuffer.append(Q(R.string.label_error_sim_expired));
        }
        if ((this.f427p0 & 16) != 0) {
            stringBuffer.append(Q(R.string.label_error_gsm_signal));
        }
        if ((this.f427p0 & 32) != 0) {
            stringBuffer.append(Q(R.string.label_error_sim_pin_puk));
        }
        if ((this.f427p0 & 64) != 0) {
            stringBuffer.append(Q(R.string.label_error_no_sim));
        }
        return stringBuffer.toString();
    }

    private String a2(int i2) {
        StringBuilder sb;
        String str;
        String str2;
        String str3;
        String str4;
        StringBuilder sb2;
        StringBuilder sb3;
        String str5;
        StringBuffer stringBuffer = new StringBuffer();
        j0.b bVarC2 = c2(i2, 2);
        if (bVarC2 != null && bVarC2.a() > 0) {
            if (bVarC2.a() > 1) {
                sb3 = new StringBuilder();
                sb3.append("Le zone ");
                sb3.append(bVarC2);
                str5 = " sono in allarme. ";
            } else {
                sb3 = new StringBuilder();
                sb3.append("La zona ");
                sb3.append(bVarC2);
                str5 = " e' in allarme. ";
            }
            sb3.append(str5);
            stringBuffer.append(sb3.toString());
        }
        j0.b bVarC22 = c2(i2, 3);
        if (bVarC22 != null && bVarC22.a() > 0) {
            if (bVarC22.a() > 1) {
                sb2 = new StringBuilder();
                sb2.append("Le zone ");
                sb2.append(bVarC22);
                sb2.append(" sono state manomesse. ");
            } else {
                sb2 = new StringBuilder();
                sb2.append("La zona ");
                sb2.append(bVarC22);
                sb2.append(" e' stata manomessa. ");
            }
            stringBuffer.append(sb2.toString());
        }
        j0.b bVarC23 = c2(i2, 4);
        if (bVarC23 != null && bVarC23.a() > 0) {
            if (bVarC23.a() > 1) {
                str4 = "Le zone " + bVarC23 + " presentano un malfunzionamento. ";
            } else {
                str4 = "La zona " + bVarC23 + " presenta un malfunzionamento. ";
            }
            stringBuffer.append(str4);
        }
        j0.b bVarB2 = b2(i2, 9);
        if (bVarB2 != null && bVarB2.a() > 0) {
            if (bVarB2.a() > 1) {
                str3 = "Le periferiche " + bVarB2 + " presentano un malfunzionamento. ";
            } else {
                str3 = "La periferica " + bVarB2 + " presenta un malfunzionamento. ";
            }
            stringBuffer.append(str3);
        }
        j0.b bVarB22 = b2(i2, 8);
        if (bVarB22 != null && bVarB22.a() > 0) {
            if (bVarB22.a() > 1) {
                str2 = "Le periferiche " + bVarB22 + " sono state manomesse. ";
            } else {
                str2 = "La periferica " + bVarB22 + " e' stata manomessa. ";
            }
            stringBuffer.append(str2);
        }
        j0.b bVarB23 = b2(i2, 10);
        if (bVarB23 != null && bVarB23.a() > 0) {
            if (bVarB23.a() > 1) {
                sb = new StringBuilder();
                sb.append("Le periferiche ");
                sb.append(bVarB23);
                str = " hanno il contenitore sabotato. ";
            } else {
                sb = new StringBuilder();
                sb.append("La periferica ");
                sb.append(bVarB23);
                str = " ha il contenitore sabotato. ";
            }
            sb.append(str);
            stringBuffer.append(sb.toString());
        }
        if (this.f428q0) {
            j0.d.a("Has generic board failure. Detailed: " + Integer.toBinaryString(this.f427p0));
            int i3 = this.f427p0;
            stringBuffer.append((i3 == 0 || i3 == 128) ? "Chiamare l'assistenza tecnica. " : Z1());
        }
        return stringBuffer.toString();
    }

    private j0.b b2(int i2, int i3) {
        int i4;
        StringBuffer stringBuffer = new StringBuffer();
        int i5 = 0;
        if (h2(this.f425n0, i2, i3) || h2(this.f426o0, i2, i3)) {
            stringBuffer.append("[");
            if (h2(this.f425n0, i2, i3)) {
                int iIntValue = ((Integer) ((HashMap) this.f425n0.get(Integer.valueOf(i2))).get(Integer.valueOf(i3))).intValue();
                if ((iIntValue & 1) != 0) {
                    stringBuffer.append("Centrale, ");
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                int i6 = 0;
                while (true) {
                    int[] iArr = Peripheral.CONSOLES;
                    if (i6 >= iArr.length) {
                        break;
                    }
                    if ((iArr[i6] & iIntValue) != 0) {
                        stringBuffer.append("Console " + (i6 + 1) + ", ");
                        i4++;
                    }
                    i6++;
                }
                int i7 = 0;
                while (true) {
                    int[] iArr2 = Peripheral.EXPANSIONS;
                    if (i7 >= iArr2.length) {
                        break;
                    }
                    if ((iArr2[i7] & iIntValue) != 0) {
                        stringBuffer.append("Espansione " + (i7 + 1) + ", ");
                        i4++;
                    }
                    i7++;
                }
            } else {
                i4 = 0;
            }
            if (h2(this.f426o0, i2, i3)) {
                int iIntValue2 = ((Integer) ((HashMap) this.f426o0.get(Integer.valueOf(i2))).get(Integer.valueOf(i3))).intValue();
                while (true) {
                    int[] iArr3 = Peripheral.RADIO;
                    if (i5 >= iArr3.length) {
                        break;
                    }
                    if ((iArr3[i5] & iIntValue2) != 0) {
                        stringBuffer.append("Modulo radio " + (i5 + 1) + ", ");
                        i4++;
                    }
                    i5++;
                }
            }
            i5 = i4;
            if (stringBuffer.toString().endsWith(", ")) {
                stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
            }
            stringBuffer.append("]");
        }
        return new j0.b(stringBuffer.toString(), i5);
    }

    private j0.b c2(int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        int i4 = 0;
        if (this.f424m0.get(Integer.valueOf(i2)) != null && ((HashMap) this.f424m0.get(Integer.valueOf(i2))).get(Integer.valueOf(i3)) != null && !((HashSet) ((HashMap) this.f424m0.get(Integer.valueOf(i2))).get(Integer.valueOf(i3))).isEmpty()) {
            stringBuffer.append("[");
            Iterator it2 = ((HashSet) ((HashMap) this.f424m0.get(Integer.valueOf(i2))).get(Integer.valueOf(i3))).iterator();
            while (it2.hasNext()) {
                int iIntValue = ((Integer) it2.next()).intValue();
                i4++;
                String name = I1().mZones.get(iIntValue).getName();
                if (name == null) {
                    name = Integer.toString(I1().mZones.get(iIntValue).getID() + 1);
                }
                stringBuffer.append(name);
                stringBuffer.append(", ");
            }
            stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
            stringBuffer.append("]");
        }
        return new j0.b(stringBuffer.toString(), i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d2(int i2) {
        X.g gVar;
        String str;
        e2();
        Group item = this.f421j0.getItem(i2);
        if (!item.isActivated()) {
            j0.d.a("Checking " + i2 + " group for NPI zones");
            if (I1().canActivateGroups(item.asMask())) {
                K1(new Z.d(item.asMask()), new b(6, 131, item, i2));
                return;
            } else {
                gVar = this.f464d0;
                str = "Non è consentito attivare questo gruppo.";
            }
        } else if (I1().canDeactivateGroups(item.asMask())) {
            f2(i2);
            return;
        } else {
            gVar = this.f464d0;
            str = "Non è consentito disattivare questo gruppo.";
        }
        gVar.p(str);
    }

    private void e2() {
        this.f424m0.clear();
        this.f425n0.clear();
        this.f426o0.clear();
    }

    private void f2(int i2) {
        j0.d.a("Group " + i2 + " is being activated");
        K1(new Z.g(this.f421j0.getItem(i2).asMask()), new d(6, 128));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g2() {
        return m().getInt("area");
    }

    private boolean h2(HashMap map, int i2, int i3) {
        return (map.get(Integer.valueOf(i2)) == null || ((HashMap) map.get(Integer.valueOf(i2))).get(Integer.valueOf(i3)) == null || ((Integer) ((HashMap) map.get(Integer.valueOf(i2))).get(Integer.valueOf(i3))).intValue() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i2(int i2, Z.e eVar) {
        j0.d.a("Group " + eVar.q() + " is NOT ready for activation");
        if (this.f424m0.get(Integer.valueOf(i2)) == null) {
            this.f424m0.put(Integer.valueOf(i2), new HashMap());
        }
        if (this.f425n0.get(Integer.valueOf(i2)) == null) {
            this.f425n0.put(Integer.valueOf(i2), new HashMap());
        }
        if (this.f426o0.get(Integer.valueOf(i2)) == null) {
            this.f426o0.put(Integer.valueOf(i2), new HashMap());
        }
        if (!eVar.x()) {
            this.f466f0.post(new e());
            j0.d.a("Zones are not programmed, group cannot be activated");
        } else if (((HashMap) this.f424m0.get(Integer.valueOf(i2))).isEmpty()) {
            l2(i2, eVar);
        } else if (((HashMap) this.f425n0.get(Integer.valueOf(i2))).isEmpty()) {
            j2(i2, eVar);
        } else {
            this.f466f0.post(new f(a2(i2) + " Si desidera proseguire con l'attivazione?", i2));
        }
        j0.d.a("manageActivationError RETURN ");
    }

    private void j2(int i2, Z.e eVar) {
        j0.d.a("Getting details on group " + eVar.q() + " peripherals: " + eVar.w());
        k2(i2, eVar, 0);
        j0.d.a("managePeripheralsNPI RETURN ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2(int i2, Z.e eVar, int i3) {
        HashMap map = (HashMap) this.f425n0.get(Integer.valueOf(i2));
        int[] iArr = NPI.NPI_PERIPHERALS_CAUSES;
        map.put(Integer.valueOf(iArr[i3]), 0);
        ((HashMap) this.f426o0.get(Integer.valueOf(i2))).put(Integer.valueOf(iArr[i3]), 0);
        j0.d.a("Querying peripheral status for type " + iArr[i3]);
        K1(new Z.k(eVar.q(), iArr[i3]), new h(6, 131, i2, i3, eVar));
    }

    private void l2(int i2, Z.e eVar) {
        j0.d.a("Getting details on group " + eVar.q() + " zones");
        m2(i2, eVar, 0);
        j0.d.a("manageZonesNPI RETURN ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2(int i2, Z.e eVar, int i3) {
        HashMap map = (HashMap) this.f424m0.get(Integer.valueOf(i2));
        int[] iArr = NPI.NPI_ZONES_CAUSES;
        map.put(Integer.valueOf(iArr[i3]), new HashSet());
        if (NPI.hasZoneCause(eVar.y(), iArr[i3])) {
            j0.d.a("Group " + eVar.q() + " has zones in " + Integer.toString(iArr[i3]) + " (b10). Querying zones.");
            int iQ = eVar.q();
            K1(new Z.n(iQ, iArr[i3], 0), new g(6, 131, i2, i3, iQ, eVar));
            return;
        }
        if (i3 >= iArr.length - 1) {
            i2(i2, eVar);
            return;
        }
        j0.d.a("Group " + eVar.q() + " has NOT zones in " + Integer.toString(iArr[i3]) + " (b10): checking the next type");
        m2(i2, eVar, i3 + 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void H0() {
        super.H0();
        this.f421j0.notifyDataSetChanged();
    }

    @Override // X.b, androidx.fragment.app.Fragment
    public void J0() {
        j0.d.a("*********************** AREA FRAGMENT STARTED!");
        ((it.tervis.miura.a) i()).o(this.f429r0);
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0() {
        ((it.tervis.miura.a) i()).A(this.f429r0);
        super.K0();
    }

    @Override // androidx.fragment.app.Fragment
    public View q0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_area_details, viewGroup, false);
        this.f465e0 = viewGroup2;
        ListView listView = (ListView) viewGroup2.findViewById(R.id.list_groups);
        this.f420i0 = listView;
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.f421j0 = new V.c(i(), I1(), g2(), this.f422k0, this.f423l0);
        if (I1() == null || !I1().isValid()) {
            ((Miura) i()).J();
        } else {
            this.f420i0.setAdapter((ListAdapter) this.f421j0);
        }
        return this.f465e0;
    }
}
