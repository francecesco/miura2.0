package q0;

/* JADX INFO: loaded from: classes.dex */
public class i {
    public s0.a a(Class cls) {
        return new b(cls);
    }

    public String b(e eVar) {
        String string = eVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String c(g gVar) {
        return b(gVar);
    }
}
