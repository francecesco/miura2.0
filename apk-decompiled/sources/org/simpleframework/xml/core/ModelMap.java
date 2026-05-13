package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class ModelMap extends LinkedHashMap<String, ModelList> implements Iterable<ModelList> {
    private final Detail detail;

    public ModelMap(Detail detail) {
        this.detail = detail;
    }

    public ModelMap getModels() throws PathException {
        ModelMap modelMap = new ModelMap(this.detail);
        for (String str : keySet()) {
            ModelList modelListBuild = get(str);
            if (modelListBuild != null) {
                modelListBuild = modelListBuild.build();
            }
            if (modelMap.containsKey(str)) {
                throw new PathException("Path with name '%s' is a duplicate in %s ", str, this.detail);
            }
            modelMap.put(str, modelListBuild);
        }
        return modelMap;
    }

    @Override // java.lang.Iterable
    public Iterator<ModelList> iterator() {
        return values().iterator();
    }

    public Model lookup(String str, int i2) {
        ModelList modelList = get(str);
        if (modelList != null) {
            return modelList.lookup(i2);
        }
        return null;
    }

    public void register(String str, Model model) {
        ModelList modelList = get(str);
        if (modelList == null) {
            modelList = new ModelList();
            put(str, modelList);
        }
        modelList.register(model);
    }
}
