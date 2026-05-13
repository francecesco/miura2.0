package org.simpleframework.xml.stream;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
class PullReader implements EventReader {
    private XmlPullParser parser;
    private EventNode peek;

    private static class End extends EventToken {
        private End() {
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public boolean isEnd() {
            return true;
        }
    }

    private static class Entry extends EventAttribute {
        private final String name;
        private final String prefix;
        private final String reference;
        private final XmlPullParser source;
        private final String value;

        public Entry(XmlPullParser xmlPullParser, int i2) {
            this.reference = xmlPullParser.getAttributeNamespace(i2);
            this.prefix = xmlPullParser.getAttributePrefix(i2);
            this.value = xmlPullParser.getAttributeValue(i2);
            this.name = xmlPullParser.getAttributeName(i2);
            this.source = xmlPullParser;
        }

        @Override // org.simpleframework.xml.stream.Attribute
        public String getName() {
            return this.name;
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public String getPrefix() {
            return this.prefix;
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public String getReference() {
            return this.reference;
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public Object getSource() {
            return this.source;
        }

        @Override // org.simpleframework.xml.stream.Attribute
        public String getValue() {
            return this.value;
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public boolean isReserved() {
            return false;
        }
    }

    private static class Start extends EventElement {
        private final int line;
        private final String name;
        private final String prefix;
        private final String reference;
        private final XmlPullParser source;

        public Start(XmlPullParser xmlPullParser) {
            this.reference = xmlPullParser.getNamespace();
            this.line = xmlPullParser.getLineNumber();
            this.prefix = xmlPullParser.getPrefix();
            this.name = xmlPullParser.getName();
            this.source = xmlPullParser;
        }

        @Override // org.simpleframework.xml.stream.EventElement, org.simpleframework.xml.stream.EventNode
        public int getLine() {
            return this.line;
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public String getName() {
            return this.name;
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public String getPrefix() {
            return this.prefix;
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public String getReference() {
            return this.reference;
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public Object getSource() {
            return this.source;
        }
    }

    private static class Text extends EventToken {
        private final XmlPullParser source;
        private final String text;

        public Text(XmlPullParser xmlPullParser) {
            this.text = xmlPullParser.getText();
            this.source = xmlPullParser;
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public Object getSource() {
            return this.source;
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public String getValue() {
            return this.text;
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public boolean isText() {
            return true;
        }
    }

    public PullReader(XmlPullParser xmlPullParser) {
        this.parser = xmlPullParser;
    }

    private Entry attribute(int i2) {
        return new Entry(this.parser, i2);
    }

    private Start build(Start start) {
        int attributeCount = this.parser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            Entry entryAttribute = attribute(i2);
            if (!entryAttribute.isReserved()) {
                start.add(entryAttribute);
            }
        }
        return start;
    }

    private End end() {
        return new End();
    }

    private EventNode read() throws XmlPullParserException, IOException {
        int next = this.parser.next();
        if (next != 1) {
            return next == 2 ? start() : next == 4 ? text() : next == 3 ? end() : read();
        }
        return null;
    }

    private Start start() {
        Start start = new Start(this.parser);
        return start.isEmpty() ? build(start) : start;
    }

    private Text text() {
        return new Text(this.parser);
    }

    @Override // org.simpleframework.xml.stream.EventReader
    public EventNode next() {
        EventNode eventNode = this.peek;
        if (eventNode == null) {
            return read();
        }
        this.peek = null;
        return eventNode;
    }

    @Override // org.simpleframework.xml.stream.EventReader
    public EventNode peek() {
        if (this.peek == null) {
            this.peek = next();
        }
        return this.peek;
    }
}
