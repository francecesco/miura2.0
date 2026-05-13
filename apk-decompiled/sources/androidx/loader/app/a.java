package androidx.loader.app;

import androidx.lifecycle.E;
import androidx.lifecycle.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static a b(l lVar) {
        return new b(lVar, ((E) lVar).x());
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c();
}
