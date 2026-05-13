package org.simpleframework.xml.transform;

/* JADX INFO: loaded from: classes.dex */
class ArrayMatcher implements Matcher {
    private final Matcher primary;

    public ArrayMatcher(Matcher matcher) {
        this.primary = matcher;
    }

    private Transform matchArray(Class cls) {
        Transform transformMatch = this.primary.match(cls);
        if (transformMatch == null) {
            return null;
        }
        return new ArrayTransform(transformMatch, cls);
    }

    @Override // org.simpleframework.xml.transform.Matcher
    public Transform match(Class cls) {
        Class<?> componentType = cls.getComponentType();
        if (componentType != Character.TYPE && componentType != Character.class) {
            return componentType == String.class ? new StringArrayTransform() : matchArray(componentType);
        }
        return new CharacterArrayTransform(componentType);
    }
}
