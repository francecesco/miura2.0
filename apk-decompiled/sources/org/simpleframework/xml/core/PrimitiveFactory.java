package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;

/* JADX INFO: loaded from: classes.dex */
class PrimitiveFactory extends Factory {
    public PrimitiveFactory(Context context, Type type) {
        super(context, type);
    }

    public Object getInstance(String str, Class cls) {
        return this.support.read(str, cls);
    }

    public String getText(Object obj) {
        Class<?> cls = obj.getClass();
        cls.isEnum();
        return this.support.write(obj, cls);
    }

    public PrimitiveFactory(Context context, Type type, Class cls) {
        super(context, type, cls);
    }

    public Instance getInstance(InputNode inputNode) {
        Value override = getOverride(inputNode);
        return override == null ? this.context.getInstance(getType()) : new ObjectInstance(this.context, override);
    }
}
