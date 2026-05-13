package j0;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap f3792a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HashMap f3793b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static HashMap f3794c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static HashMap f3795d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static HashMap f3796e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static HashMap f3797f = new HashMap();

    public static void a() {
        f3792a.clear();
        f3793b.clear();
        f3794c.clear();
        f3795d.clear();
        f3797f.clear();
        f3796e.clear();
    }

    public static void b(String str) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(j.j(str)));
            f3792a = (HashMap) objectInputStream.readObject();
            f3793b = (HashMap) objectInputStream.readObject();
            f3794c = (HashMap) objectInputStream.readObject();
            f3796e = (HashMap) objectInputStream.readObject();
            f3797f = (HashMap) objectInputStream.readObject();
        } catch (Exception e2) {
            d.c(e2);
            a();
        }
    }

    public static String c(int i2) {
        return (String) f3792a.get(Integer.valueOf(i2));
    }

    public static String d(int i2) {
        return (String) f3793b.get(Integer.valueOf(i2));
    }

    public static String e(int i2) {
        return (String) f3796e.get(Integer.valueOf(i2));
    }

    public static String f(int i2) {
        return (String) f3797f.get(Integer.valueOf(i2));
    }

    public static String g(int i2) {
        return (String) f3794c.get(Integer.valueOf(i2));
    }

    public static void h(int i2, String str) {
        f3792a.put(Integer.valueOf(i2), str);
    }

    public static void i(int i2, String str) {
        f3795d.put(Integer.valueOf(i2), str);
    }

    public static void j(int i2, String str) {
        f3793b.put(Integer.valueOf(i2), str);
    }

    public static void k(int i2, String str) {
        f3796e.put(Integer.valueOf(i2), str);
    }

    public static void l(int i2, String str) {
        f3797f.put(Integer.valueOf(i2), str);
    }

    public static void m(int i2, String str) {
        f3794c.put(Integer.valueOf(i2), str);
    }

    public static String n() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(f3792a);
            objectOutputStream.writeObject(f3793b);
            objectOutputStream.writeObject(f3794c);
            objectOutputStream.writeObject(f3796e);
            objectOutputStream.writeObject(f3797f);
            return j.a(byteArrayOutputStream.toByteArray());
        } catch (Exception e2) {
            d.c(e2);
            return "";
        }
    }
}
