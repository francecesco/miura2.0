package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.OutputNode;

/* JADX INFO: loaded from: classes.dex */
interface Decorator {
    void decorate(OutputNode outputNode);

    void decorate(OutputNode outputNode, Decorator decorator);
}
