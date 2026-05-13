package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Map;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Verbosity;

/* JADX INFO: loaded from: classes.dex */
class AnnotationFactory {
    private final Format format;
    private final boolean required;

    public AnnotationFactory(Detail detail, Support support) {
        this.required = detail.isRequired();
        this.format = support.getFormat();
    }

    private ClassLoader getClassLoader() {
        return AnnotationFactory.class.getClassLoader();
    }

    private Annotation getInstance(Class cls) {
        Class cls2;
        ClassLoader classLoader = getClassLoader();
        Class<?> componentType = cls.getComponentType();
        if (cls.isArray()) {
            if (isPrimitive(componentType)) {
                return getInstance(classLoader, Element.class);
            }
            cls2 = ElementArray.class;
        } else {
            if (!isPrimitive(cls) || !isAttribute()) {
                return getInstance(classLoader, Element.class);
            }
            cls2 = Attribute.class;
        }
        return getInstance(classLoader, cls2);
    }

    private boolean isAttribute() {
        Verbosity verbosity = this.format.getVerbosity();
        return verbosity != null && verbosity == Verbosity.LOW;
    }

    private boolean isPrimitive(Class cls) {
        if (Number.class.isAssignableFrom(cls) || cls == Boolean.class || cls == Character.class) {
            return true;
        }
        return cls.isPrimitive();
    }

    private boolean isPrimitiveKey(Class[] clsArr) {
        if (clsArr == null || clsArr.length <= 0) {
            return false;
        }
        Class superclass = clsArr[0].getSuperclass();
        Class cls = clsArr[0];
        if (superclass == null || !(superclass.isEnum() || cls.isEnum())) {
            return isPrimitive(cls);
        }
        return true;
    }

    public Annotation getInstance(Class cls, Class[] clsArr) {
        ClassLoader classLoader = getClassLoader();
        return Map.class.isAssignableFrom(cls) ? (isPrimitiveKey(clsArr) && isAttribute()) ? getInstance(classLoader, ElementMap.class, true) : getInstance(classLoader, ElementMap.class) : Collection.class.isAssignableFrom(cls) ? getInstance(classLoader, ElementList.class) : getInstance(cls);
    }

    private Annotation getInstance(ClassLoader classLoader, Class cls) {
        return getInstance(classLoader, cls, false);
    }

    private Annotation getInstance(ClassLoader classLoader, Class cls, boolean z2) {
        return (Annotation) Proxy.newProxyInstance(classLoader, new Class[]{cls}, new AnnotationHandler(cls, this.required, z2));
    }
}
