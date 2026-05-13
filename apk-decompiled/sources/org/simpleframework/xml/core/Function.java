package org.simpleframework.xml.core;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class Function {
    private final boolean contextual;
    private final Method method;

    public Function(Method method) {
        this(method, false);
    }

    public Object call(Context context, Object obj) {
        if (obj != null) {
            return this.contextual ? this.method.invoke(obj, context.getSession().getMap()) : this.method.invoke(obj, null);
        }
        return null;
    }

    public Function(Method method, boolean z2) {
        this.contextual = z2;
        this.method = method;
    }
}
