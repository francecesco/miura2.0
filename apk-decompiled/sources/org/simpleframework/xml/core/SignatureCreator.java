package org.simpleframework.xml.core;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class SignatureCreator implements Creator {
    private final List<Parameter> list;
    private final Signature signature;
    private final Class type;

    public SignatureCreator(Signature signature) {
        this.type = signature.getType();
        this.list = signature.getAll();
        this.signature = signature;
    }

    private double getAdjustment(double d2) {
        return d2 > 0.0d ? (((double) this.list.size()) / 1000.0d) + (d2 / ((double) this.list.size())) : d2 / ((double) this.list.size());
    }

    private double getPercentage(Criteria criteria) {
        double d2 = 0.0d;
        for (Parameter parameter : this.list) {
            if (criteria.get(parameter.getKey()) != null) {
                d2 += 1.0d;
            } else if (parameter.isRequired() || parameter.isPrimitive()) {
                return -1.0d;
            }
        }
        return getAdjustment(d2);
    }

    private Object getVariable(Criteria criteria, int i2) {
        Variable variableRemove = criteria.remove(this.list.get(i2).getKey());
        if (variableRemove != null) {
            return variableRemove.getValue();
        }
        return null;
    }

    @Override // org.simpleframework.xml.core.Creator
    public Object getInstance() {
        return this.signature.create();
    }

    @Override // org.simpleframework.xml.core.Creator
    public double getScore(Criteria criteria) {
        Signature signatureCopy = this.signature.copy();
        for (Object obj : criteria) {
            Parameter parameter = signatureCopy.get(obj);
            Variable variable = criteria.get(obj);
            Contact contact = variable.getContact();
            if (parameter != null && !Support.isAssignable(variable.getValue().getClass(), parameter.getType())) {
                return -1.0d;
            }
            if (contact.isReadOnly() && parameter == null) {
                return -1.0d;
            }
        }
        return getPercentage(criteria);
    }

    @Override // org.simpleframework.xml.core.Creator
    public Signature getSignature() {
        return this.signature;
    }

    @Override // org.simpleframework.xml.core.Creator
    public Class getType() {
        return this.type;
    }

    public String toString() {
        return this.signature.toString();
    }

    @Override // org.simpleframework.xml.core.Creator
    public Object getInstance(Criteria criteria) {
        Object[] array = this.list.toArray();
        for (int i2 = 0; i2 < this.list.size(); i2++) {
            array[i2] = getVariable(criteria, i2);
        }
        return this.signature.create(array);
    }
}
