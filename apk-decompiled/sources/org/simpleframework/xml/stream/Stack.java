package org.simpleframework.xml.stream;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class Stack<T> extends ArrayList<T> {
    public Stack(int i2) {
        super(i2);
    }

    public T bottom() {
        if (size() <= 0) {
            return null;
        }
        return get(0);
    }

    public T pop() {
        int size = size();
        if (size <= 0) {
            return null;
        }
        return remove(size - 1);
    }

    public T push(T t2) {
        add(t2);
        return t2;
    }

    public T top() {
        int size = size();
        if (size <= 0) {
            return null;
        }
        return get(size - 1);
    }
}
