package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;

/* JADX INFO: loaded from: classes.dex */
class SignatureScanner {
    private final SignatureBuilder builder;
    private final Constructor constructor;
    private final ParameterFactory factory;
    private final ParameterMap registry;
    private final Class type;

    public SignatureScanner(Constructor constructor, ParameterMap parameterMap, Support support) {
        this.builder = new SignatureBuilder(constructor);
        this.factory = new ParameterFactory(support);
        Class declaringClass = constructor.getDeclaringClass();
        this.type = declaringClass;
        this.constructor = constructor;
        this.registry = parameterMap;
        scan(declaringClass);
    }

    private List<Parameter> create(Annotation annotation, int i2) throws ConstructorException {
        Parameter parameterFactory = this.factory.getInstance(this.constructor, annotation, i2);
        if (parameterFactory != null) {
            register(parameterFactory);
        }
        return Collections.singletonList(parameterFactory);
    }

    private Annotation[] extract(Annotation annotation) throws UnionException {
        Method[] declaredMethods = annotation.annotationType().getDeclaredMethods();
        if (declaredMethods.length == 1) {
            return (Annotation[]) declaredMethods[0].invoke(annotation, null);
        }
        throw new UnionException("Annotation '%s' is not a valid union for %s", annotation, this.type);
    }

    private List<Parameter> process(Annotation annotation, int i2) {
        if (!(annotation instanceof Attribute) && !(annotation instanceof Element) && !(annotation instanceof ElementList) && !(annotation instanceof ElementArray) && !(annotation instanceof ElementMap)) {
            if (!(annotation instanceof ElementListUnion) && !(annotation instanceof ElementMapUnion) && !(annotation instanceof ElementUnion)) {
                return annotation instanceof Text ? create(annotation, i2) : Collections.emptyList();
            }
            return union(annotation, i2);
        }
        return create(annotation, i2);
    }

    private void register(Parameter parameter) throws ConstructorException {
        String path = parameter.getPath();
        Object key = parameter.getKey();
        if (this.registry.containsKey(key)) {
            validate(parameter, key);
        }
        if (this.registry.containsKey(path)) {
            validate(parameter, path);
        }
        this.registry.put(path, parameter);
        this.registry.put(key, parameter);
    }

    private void scan(Class cls) {
        Class<?>[] parameterTypes = this.constructor.getParameterTypes();
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            scan(parameterTypes[i2], i2);
        }
    }

    private List<Parameter> union(Annotation annotation, int i2) throws UnionException, ConstructorException {
        Signature signature = new Signature(this.constructor);
        for (Annotation annotation2 : extract(annotation)) {
            Parameter parameterFactory = this.factory.getInstance(this.constructor, annotation, annotation2, i2);
            String path = parameterFactory.getPath();
            if (signature.contains(path)) {
                throw new UnionException("Annotation name '%s' used more than once in %s for %s", path, annotation, this.type);
            }
            signature.set(path, parameterFactory);
            register(parameterFactory);
        }
        return signature.getAll();
    }

    private void validate(Parameter parameter, Object obj) throws ConstructorException {
        Parameter parameter2 = this.registry.get(obj);
        if (parameter.isText() != parameter2.isText()) {
            Annotation annotation = parameter.getAnnotation();
            Annotation annotation2 = parameter2.getAnnotation();
            String path = parameter.getPath();
            if (!annotation.equals(annotation2)) {
                throw new ConstructorException("Annotations do not match for '%s' in %s", path, this.type);
            }
            if (parameter2.getType() != parameter.getType()) {
                throw new ConstructorException("Parameter types do not match for '%s' in %s", path, this.type);
            }
        }
    }

    public List<Signature> getSignatures() {
        return this.builder.build();
    }

    public boolean isValid() {
        return this.builder.isValid();
    }

    private void scan(Class cls, int i2) {
        Annotation[][] parameterAnnotations = this.constructor.getParameterAnnotations();
        int i3 = 0;
        while (true) {
            Annotation[] annotationArr = parameterAnnotations[i2];
            if (i3 >= annotationArr.length) {
                return;
            }
            Iterator<Parameter> it2 = process(annotationArr[i3], i2).iterator();
            while (it2.hasNext()) {
                this.builder.insert(it2.next(), i2);
            }
            i3++;
        }
    }
}
