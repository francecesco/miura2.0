package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;

/* JADX INFO: loaded from: classes.dex */
class DocumentProvider implements Provider {
    private final DocumentBuilderFactory factory;

    public DocumentProvider() {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        this.factory = documentBuilderFactoryNewInstance;
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
    }

    @Override // org.simpleframework.xml.stream.Provider
    public EventReader provide(InputStream inputStream) {
        return provide(new InputSource(inputStream));
    }

    @Override // org.simpleframework.xml.stream.Provider
    public EventReader provide(Reader reader) {
        return provide(new InputSource(reader));
    }

    private EventReader provide(InputSource inputSource) {
        return new DocumentReader(this.factory.newDocumentBuilder().parse(inputSource));
    }
}
