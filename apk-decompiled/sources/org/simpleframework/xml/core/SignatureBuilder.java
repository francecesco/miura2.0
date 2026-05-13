package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class SignatureBuilder {
    private final Constructor factory;
    private final ParameterTable table = new ParameterTable();

    private static class ParameterList extends ArrayList<Parameter> {
        public ParameterList() {
        }

        public ParameterList(ParameterList parameterList) {
            super(parameterList);
        }
    }

    private static class ParameterTable extends ArrayList<ParameterList> {
        /* JADX INFO: Access modifiers changed from: private */
        public int height() {
            if (width() > 0) {
                return get(0).size();
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int width() {
            return size();
        }

        public void insert(Parameter parameter, int i2) {
            ParameterList parameterList = get(i2);
            if (parameterList != null) {
                parameterList.add(parameter);
            }
        }

        public Parameter get(int i2, int i3) {
            return get(i2).get(i3);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public ParameterList get(int i2) {
            for (int size = size(); size <= i2; size++) {
                add(new ParameterList());
            }
            return (ParameterList) super.get(i2);
        }
    }

    public SignatureBuilder(Constructor constructor) {
        this.factory = constructor;
    }

    private List<Signature> create() {
        ArrayList arrayList = new ArrayList();
        Signature signature = new Signature(this.factory);
        if (isValid()) {
            arrayList.add(signature);
        }
        return arrayList;
    }

    private void populate(ParameterTable parameterTable, ParameterList parameterList, int i2) {
        ParameterList parameterList2 = this.table.get(i2);
        int size = parameterList.size();
        int size2 = parameterList2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            for (int i4 = 0; i4 < size; i4++) {
                parameterTable.get(i4).add(parameterList.get(i4));
            }
            parameterTable.get(i2).add(parameterList2.get(i3));
        }
    }

    public List<Signature> build() {
        return build(new ParameterTable());
    }

    public void insert(Parameter parameter, int i2) {
        this.table.insert(parameter, i2);
    }

    public boolean isValid() {
        return this.factory.getParameterTypes().length == this.table.width();
    }

    private List<Signature> build(ParameterTable parameterTable) {
        if (this.table.isEmpty()) {
            return create();
        }
        build(parameterTable, 0);
        return create(parameterTable);
    }

    private List<Signature> create(ParameterTable parameterTable) throws ConstructorException {
        ArrayList arrayList = new ArrayList();
        int iHeight = parameterTable.height();
        int iWidth = parameterTable.width();
        for (int i2 = 0; i2 < iHeight; i2++) {
            Signature signature = new Signature(this.factory);
            for (int i3 = 0; i3 < iWidth; i3++) {
                Parameter parameter = parameterTable.get(i3, i2);
                String path = parameter.getPath();
                if (signature.contains(parameter.getKey())) {
                    throw new ConstructorException("Parameter '%s' is a duplicate in %s", path, this.factory);
                }
                signature.add(parameter);
            }
            arrayList.add(signature);
        }
        return arrayList;
    }

    private void build(ParameterTable parameterTable, int i2) {
        build(parameterTable, new ParameterList(), i2);
    }

    private void build(ParameterTable parameterTable, ParameterList parameterList, int i2) {
        ParameterList parameterList2 = this.table.get(i2);
        int size = parameterList2.size();
        if (this.table.width() - 1 <= i2) {
            populate(parameterTable, parameterList, i2);
            return;
        }
        for (int i3 = 0; i3 < size; i3++) {
            ParameterList parameterList3 = new ParameterList(parameterList);
            if (parameterList != null) {
                parameterList3.add(parameterList2.get(i3));
                build(parameterTable, parameterList3, i2 + 1);
            }
        }
    }
}
