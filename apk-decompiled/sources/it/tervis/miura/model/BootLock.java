package it.tervis.miura.model;

import Y.b;
import b0.d;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class BootLock {
    private static boolean _locked;
    private static final HashMap<Class<? extends b>, Integer> _locks = new HashMap<>();

    private BootLock() {
    }

    public static void init() {
        HashMap<Class<? extends b>, Integer> map = _locks;
        map.put(d.class, 16);
        _locked = true;
        j0.d.a("Initializing BootLock with " + map.size() + " elements");
    }

    public static boolean isLocked() {
        return _locked;
    }

    public static void setUnlocked() {
        _locked = false;
    }

    public static boolean unlock(b bVar) {
        j0.d.a("BootLock unlock");
        Class<?> cls = bVar.getClass();
        HashMap<Class<? extends b>, Integer> map = _locks;
        if (map.containsKey(cls)) {
            int iIntValue = map.get(cls).intValue() - 1;
            j0.d.a("Lock count: " + iIntValue);
            if (iIntValue == 0) {
                map.remove(cls);
            } else {
                map.put((Class<? extends b>) cls, Integer.valueOf(iIntValue));
            }
        } else {
            j0.d.a("This message does not unlock: " + bVar);
        }
        return map.isEmpty();
    }
}
