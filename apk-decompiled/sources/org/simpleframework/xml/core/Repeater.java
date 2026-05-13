package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.InputNode;

/* JADX INFO: loaded from: classes.dex */
interface Repeater extends Converter {
    @Override // org.simpleframework.xml.core.Converter
    Object read(InputNode inputNode, Object obj);
}
