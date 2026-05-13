package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class AnnotationHandler implements InvocationHandler {
    private static final String ATTRIBUTE = "attribute";
    private static final String CLASS = "annotationType";
    private static final String EQUAL = "equals";
    private static final String REQUIRED = "required";
    private static final String STRING = "toString";
    private final boolean attribute;
    private final Comparer comparer;
    private final boolean required;
    private final Class type;

    public AnnotationHandler(Class cls) {
        this(cls, true);
    }

    private void attributes(StringBuilder sb) {
        Method[] declaredMethods = this.type.getDeclaredMethods();
        for (int i2 = 0; i2 < declaredMethods.length; i2++) {
            String name = declaredMethods[i2].getName();
            Object objValue = value(declaredMethods[i2]);
            if (i2 > 0) {
                sb.append(',');
                sb.append(' ');
            }
            sb.append(name);
            sb.append('=');
            sb.append(objValue);
        }
        sb.append(')');
    }

    private boolean equals(Object obj, Object[] objArr) throws PersistenceException {
        Annotation annotation = (Annotation) obj;
        Annotation annotation2 = (Annotation) objArr[0];
        if (annotation.annotationType() == annotation2.annotationType()) {
            return this.comparer.equals(annotation, annotation2);
        }
        throw new PersistenceException("Annotation %s is not the same as %s", annotation, annotation2);
    }

    private void name(StringBuilder sb) {
        String name = this.type.getName();
        sb.append('@');
        sb.append(name);
        sb.append('(');
    }

    private Object value(Method method) {
        boolean z2;
        String name = method.getName();
        if (name.equals(REQUIRED)) {
            z2 = this.required;
        } else {
            if (!name.equals(ATTRIBUTE)) {
                return method.getDefaultValue();
            }
            z2 = this.attribute;
        }
        return Boolean.valueOf(z2);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws PersistenceException {
        boolean zEquals;
        String name = method.getName();
        if (name.equals(STRING)) {
            return toString();
        }
        if (name.equals(EQUAL)) {
            zEquals = equals(obj, objArr);
        } else {
            if (name.equals(CLASS)) {
                return this.type;
            }
            if (name.equals(REQUIRED)) {
                zEquals = this.required;
            } else {
                if (!name.equals(ATTRIBUTE)) {
                    return method.getDefaultValue();
                }
                zEquals = this.attribute;
            }
        }
        return Boolean.valueOf(zEquals);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.type != null) {
            name(sb);
            attributes(sb);
        }
        return sb.toString();
    }

    public AnnotationHandler(Class cls, boolean z2) {
        this(cls, z2, false);
    }

    public AnnotationHandler(Class cls, boolean z2, boolean z3) {
        this.comparer = new Comparer();
        this.attribute = z3;
        this.required = z2;
        this.type = cls;
    }
}
