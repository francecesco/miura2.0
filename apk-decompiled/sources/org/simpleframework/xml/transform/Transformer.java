package org.simpleframework.xml.transform;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* JADX INFO: loaded from: classes.dex */
public class Transformer {
    private final Cache<Transform> cache = new ConcurrentCache();
    private final Cache<Object> error = new ConcurrentCache();
    private final Matcher matcher;

    public Transformer(Matcher matcher) {
        this.matcher = new DefaultMatcher(matcher);
    }

    private Transform lookup(Class cls) {
        if (this.error.contains(cls)) {
            return null;
        }
        Transform transformFetch = this.cache.fetch(cls);
        return transformFetch != null ? transformFetch : match(cls);
    }

    private Transform match(Class cls) {
        Transform transformMatch = this.matcher.match(cls);
        if (transformMatch != null) {
            this.cache.cache(cls, transformMatch);
        } else {
            this.error.cache(cls, this);
        }
        return transformMatch;
    }

    public Object read(String str, Class cls) throws TransformException {
        Transform transformLookup = lookup(cls);
        if (transformLookup != null) {
            return transformLookup.read(str);
        }
        throw new TransformException("Transform of %s not supported", cls);
    }

    public boolean valid(Class cls) {
        return lookup(cls) != null;
    }

    public String write(Object obj, Class cls) throws TransformException {
        Transform transformLookup = lookup(cls);
        if (transformLookup != null) {
            return transformLookup.write(obj);
        }
        throw new TransformException("Transform of %s not supported", cls);
    }
}
