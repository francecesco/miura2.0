package org.simpleframework.xml.core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class LabelMap extends LinkedHashMap<String, Label> implements Iterable<Label> {
    private final Policy policy;

    public LabelMap() {
        this(null);
    }

    private String[] getArray(Set<String> set) {
        return (String[]) set.toArray(new String[0]);
    }

    public String[] getKeys() {
        HashSet hashSet = new HashSet();
        for (Label label : this) {
            if (label != null) {
                String path = label.getPath();
                String name = label.getName();
                hashSet.add(path);
                hashSet.add(name);
            }
        }
        return getArray(hashSet);
    }

    public Label getLabel(String str) {
        return remove(str);
    }

    public LabelMap getLabels() {
        LabelMap labelMap = new LabelMap(this.policy);
        for (Label label : this) {
            if (label != null) {
                labelMap.put(label.getPath(), label);
            }
        }
        return labelMap;
    }

    public String[] getPaths() {
        HashSet hashSet = new HashSet();
        for (Label label : this) {
            if (label != null) {
                hashSet.add(label.getPath());
            }
        }
        return getArray(hashSet);
    }

    public boolean isStrict(Context context) {
        Policy policy = this.policy;
        boolean zIsStrict = context.isStrict();
        return policy == null ? zIsStrict : zIsStrict && this.policy.isStrict();
    }

    @Override // java.lang.Iterable
    public Iterator<Label> iterator() {
        return values().iterator();
    }

    public LabelMap(Policy policy) {
        this.policy = policy;
    }
}
