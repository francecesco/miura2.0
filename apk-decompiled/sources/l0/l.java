package l0;

import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static List a(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        q0.f.d(listSingletonList, "singletonList(element)");
        return listSingletonList;
    }
}
