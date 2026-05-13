package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class ModelList extends ArrayList<Model> {
    public ModelList build() {
        ModelList modelList = new ModelList();
        Iterator<Model> it2 = iterator();
        while (it2.hasNext()) {
            modelList.register(it2.next());
        }
        return modelList;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        for (Model model : this) {
            if (model != null && !model.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public Model lookup(int i2) {
        if (i2 <= size()) {
            return get(i2 - 1);
        }
        return null;
    }

    public void register(Model model) {
        int index = model.getIndex();
        int size = size();
        for (int i2 = 0; i2 < index; i2++) {
            if (i2 >= size) {
                add(null);
            }
            int i3 = index - 1;
            if (i2 == i3) {
                set(i3, model);
            }
        }
    }

    public Model take() {
        while (!isEmpty()) {
            Model modelRemove = remove(0);
            if (!modelRemove.isEmpty()) {
                return modelRemove;
            }
        }
        return null;
    }
}
