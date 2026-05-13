package O;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static boolean a(Object[] objArr, Object obj) {
        int length = objArr != null ? objArr.length : 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (K.d.a(objArr[i2], obj)) {
                break;
            }
            i2++;
        }
        return i2 >= 0;
    }
}
