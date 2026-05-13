package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* JADX INFO: loaded from: classes.dex */
class PathParser implements Expression {
    protected boolean attribute;
    protected String cache;
    protected int count;
    protected char[] data;
    protected String location;
    protected int off;
    protected String path;
    protected int start;
    protected Style style;
    protected Type type;
    protected Cache<String> attributes = new ConcurrentCache();
    protected Cache<String> elements = new ConcurrentCache();
    protected List<Integer> indexes = new ArrayList();
    protected List<String> prefixes = new ArrayList();
    protected List<String> names = new ArrayList();
    protected StringBuilder builder = new StringBuilder();

    private class PathSection implements Expression {
        private int begin;
        private List<String> cache = new ArrayList();
        private int end;
        private String path;
        private String section;

        public PathSection(int i2, int i3) {
            this.begin = i2;
            this.end = i3;
        }

        private String getCanonicalPath() {
            int i2 = 0;
            int iIndexOf = 0;
            while (i2 < this.begin) {
                iIndexOf = PathParser.this.location.indexOf(47, iIndexOf + 1);
                i2++;
            }
            int iIndexOf2 = iIndexOf;
            while (i2 <= this.end) {
                iIndexOf2 = PathParser.this.location.indexOf(47, iIndexOf2 + 1);
                if (iIndexOf2 == -1) {
                    iIndexOf2 = PathParser.this.location.length();
                }
                i2++;
            }
            return PathParser.this.location.substring(iIndexOf + 1, iIndexOf2);
        }

        private String getFragment() {
            int i2 = PathParser.this.start;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 > this.end) {
                    break;
                }
                PathParser pathParser = PathParser.this;
                if (i2 >= pathParser.count) {
                    i2++;
                    break;
                }
                int i5 = i2 + 1;
                if (pathParser.data[i2] == '/' && (i3 = i3 + 1) == this.begin) {
                    i2 = i5;
                    i4 = i2;
                } else {
                    i2 = i5;
                }
            }
            return new String(PathParser.this.data, i4, (i2 - 1) - i4);
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getAttribute(String str) {
            String path = getPath();
            return path != null ? PathParser.this.getAttributePath(path, str) : str;
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getElement(String str) {
            String path = getPath();
            return path != null ? PathParser.this.getElementPath(path, str) : str;
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getFirst() {
            return PathParser.this.names.get(this.begin);
        }

        @Override // org.simpleframework.xml.core.Expression
        public int getIndex() {
            return PathParser.this.indexes.get(this.begin).intValue();
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getLast() {
            return PathParser.this.names.get(this.end);
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getPath() {
            if (this.section == null) {
                this.section = getCanonicalPath();
            }
            return this.section;
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getPrefix() {
            return PathParser.this.prefixes.get(this.begin);
        }

        @Override // org.simpleframework.xml.core.Expression
        public boolean isAttribute() {
            PathParser pathParser = PathParser.this;
            return pathParser.attribute && this.end >= pathParser.names.size() - 1;
        }

        @Override // org.simpleframework.xml.core.Expression
        public boolean isEmpty() {
            return this.begin == this.end;
        }

        @Override // org.simpleframework.xml.core.Expression
        public boolean isPath() {
            return this.end - this.begin >= 1;
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            if (this.cache.isEmpty()) {
                for (int i2 = this.begin; i2 <= this.end; i2++) {
                    String str = PathParser.this.names.get(i2);
                    if (str != null) {
                        this.cache.add(str);
                    }
                }
            }
            return this.cache.iterator();
        }

        @Override // org.simpleframework.xml.core.Expression
        public String toString() {
            if (this.path == null) {
                this.path = getFragment();
            }
            return this.path;
        }

        @Override // org.simpleframework.xml.core.Expression
        public Expression getPath(int i2) {
            return getPath(i2, 0);
        }

        @Override // org.simpleframework.xml.core.Expression
        public Expression getPath(int i2, int i3) {
            return PathParser.this.new PathSection(this.begin + i2, this.end - i3);
        }
    }

    public PathParser(String str, Type type, Format format) throws PathException {
        this.style = format.getStyle();
        this.type = type;
        this.path = str;
        parse(str);
    }

    private void align() {
        if (this.names.size() > this.indexes.size()) {
            this.indexes.add(1);
        }
    }

    private void attribute() throws PathException {
        char c2;
        int i2 = this.off + 1;
        this.off = i2;
        do {
            int i3 = this.off;
            if (i3 >= this.count) {
                if (i3 <= i2) {
                    throw new PathException("Attribute reference in '%s' for %s is empty", this.path, this.type);
                }
                this.attribute = true;
                attribute(i2, i3 - i2);
                return;
            }
            char[] cArr = this.data;
            this.off = i3 + 1;
            c2 = cArr[i3];
        } while (isValid(c2));
        throw new PathException("Illegal character '%s' in attribute for '%s' in %s", Character.valueOf(c2), this.path, this.type);
    }

    private void build() {
        int size = this.names.size();
        int i2 = size - 1;
        for (int i3 = 0; i3 < size; i3++) {
            String str = this.prefixes.get(i3);
            String str2 = this.names.get(i3);
            int iIntValue = this.indexes.get(i3).intValue();
            if (i3 > 0) {
                this.builder.append('/');
            }
            if (this.attribute && i3 == i2) {
                this.builder.append('@');
                this.builder.append(str2);
            } else {
                if (str != null) {
                    this.builder.append(str);
                    this.builder.append(':');
                }
                this.builder.append(str2);
                this.builder.append('[');
                this.builder.append(iIntValue);
                this.builder.append(']');
            }
        }
        this.location = this.builder.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
    
        element(r1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void element() throws org.simpleframework.xml.core.PathException {
        /*
            r7 = this;
            r0 = 1
            int r1 = r7.off
            r2 = 0
            r3 = 0
        L5:
            int r4 = r7.off
            int r5 = r7.count
            if (r4 >= r5) goto L4c
            char[] r5 = r7.data
            int r6 = r4 + 1
            r7.off = r6
            char r4 = r5[r4]
            boolean r5 = r7.isValid(r4)
            if (r5 != 0) goto L4a
            r5 = 64
            if (r4 != r5) goto L23
            int r2 = r7.off
            int r2 = r2 - r0
            r7.off = r2
            goto L4c
        L23:
            r5 = 91
            if (r4 != r5) goto L2b
            r7.index()
            goto L4c
        L2b:
            r5 = 47
            if (r4 != r5) goto L30
            goto L4c
        L30:
            org.simpleframework.xml.core.PathException r1 = new org.simpleframework.xml.core.PathException
            java.lang.Character r3 = java.lang.Character.valueOf(r4)
            java.lang.String r4 = r7.path
            org.simpleframework.xml.strategy.Type r5 = r7.type
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r2] = r3
            r6[r0] = r4
            r0 = 2
            r6[r0] = r5
            java.lang.String r0 = "Illegal character '%s' in element for '%s' in %s"
            r1.<init>(r0, r6)
            throw r1
        L4a:
            int r3 = r3 + r0
            goto L5
        L4c:
            r7.element(r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.simpleframework.xml.core.PathParser.element():void");
    }

    private void index() throws PathException {
        int i2;
        if (this.data[this.off - 1] == '[') {
            i2 = 0;
            while (true) {
                int i3 = this.off;
                if (i3 >= this.count) {
                    break;
                }
                char[] cArr = this.data;
                this.off = i3 + 1;
                char c2 = cArr[i3];
                if (!isDigit(c2)) {
                    break;
                } else {
                    i2 = ((i2 * 10) + c2) - 48;
                }
            }
        } else {
            i2 = 0;
        }
        char[] cArr2 = this.data;
        int i4 = this.off;
        this.off = i4 + 1;
        if (cArr2[i4 - 1] != ']') {
            throw new PathException("Invalid index for path '%s' in %s", this.path, this.type);
        }
        this.indexes.add(Integer.valueOf(i2));
    }

    private boolean isDigit(char c2) {
        return Character.isDigit(c2);
    }

    private boolean isLetter(char c2) {
        return Character.isLetterOrDigit(c2);
    }

    private boolean isSpecial(char c2) {
        return c2 == '_' || c2 == '-' || c2 == ':';
    }

    private boolean isValid(char c2) {
        return isLetter(c2) || isSpecial(c2);
    }

    private void parse(String str) throws PathException {
        if (str != null) {
            int length = str.length();
            this.count = length;
            char[] cArr = new char[length];
            this.data = cArr;
            str.getChars(0, length, cArr, 0);
        }
        path();
    }

    private void path() throws PathException {
        char c2 = this.data[this.off];
        if (c2 == '/') {
            throw new PathException("Path '%s' in %s references document root", this.path, this.type);
        }
        if (c2 == '.') {
            skip();
        }
        while (this.off < this.count) {
            if (this.attribute) {
                throw new PathException("Path '%s' in %s references an invalid attribute", this.path, this.type);
            }
            segment();
        }
        truncate();
        build();
    }

    private void segment() throws PathException {
        char c2 = this.data[this.off];
        if (c2 == '/') {
            throw new PathException("Invalid path expression '%s' in %s", this.path, this.type);
        }
        if (c2 == '@') {
            attribute();
        } else {
            element();
        }
        align();
    }

    private void skip() throws PathException {
        char[] cArr = this.data;
        if (cArr.length > 1) {
            int i2 = this.off;
            if (cArr[i2 + 1] != '/') {
                throw new PathException("Path '%s' in %s has an illegal syntax", this.path, this.type);
            }
            this.off = i2 + 1;
        }
        int i3 = this.off + 1;
        this.off = i3;
        this.start = i3;
    }

    private void truncate() {
        int i2 = this.off;
        int i3 = i2 - 1;
        char[] cArr = this.data;
        if (i3 < cArr.length && cArr[i2 - 1] != '/') {
            return;
        }
        this.off = i2 - 1;
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getAttribute(String str) {
        if (isEmpty(this.location)) {
            return this.style.getAttribute(str);
        }
        String strFetch = this.attributes.fetch(str);
        if (strFetch == null && (strFetch = getAttributePath(this.location, str)) != null) {
            this.attributes.cache(str, strFetch);
        }
        return strFetch;
    }

    protected String getAttributePath(String str, String str2) {
        String attribute = this.style.getAttribute(str2);
        if (isEmpty(str)) {
            return attribute;
        }
        return str + "/@" + attribute;
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getElement(String str) {
        if (isEmpty(this.location)) {
            return this.style.getElement(str);
        }
        String strFetch = this.elements.fetch(str);
        if (strFetch == null && (strFetch = getElementPath(this.location, str)) != null) {
            this.elements.cache(str, strFetch);
        }
        return strFetch;
    }

    protected String getElementPath(String str, String str2) {
        String element = this.style.getElement(str2);
        if (isEmpty(element)) {
            return str;
        }
        if (isEmpty(str)) {
            return element;
        }
        return str + "/" + element + "[1]";
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getFirst() {
        return this.names.get(0);
    }

    @Override // org.simpleframework.xml.core.Expression
    public int getIndex() {
        return this.indexes.get(0).intValue();
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getLast() {
        return this.names.get(this.names.size() - 1);
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getPath() {
        return this.location;
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getPrefix() {
        return this.prefixes.get(0);
    }

    @Override // org.simpleframework.xml.core.Expression
    public boolean isAttribute() {
        return this.attribute;
    }

    @Override // org.simpleframework.xml.core.Expression
    public boolean isEmpty() {
        return isEmpty(this.location);
    }

    @Override // org.simpleframework.xml.core.Expression
    public boolean isPath() {
        return this.names.size() > 1;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.names.iterator();
    }

    @Override // org.simpleframework.xml.core.Expression
    public String toString() {
        int i2 = this.off;
        int i3 = this.start;
        int i4 = i2 - i3;
        if (this.cache == null) {
            this.cache = new String(this.data, i3, i4);
        }
        return this.cache;
    }

    private void attribute(int i2, int i3) {
        String str = new String(this.data, i2, i3);
        if (i3 > 0) {
            attribute(str);
        }
    }

    private void element(int i2, int i3) {
        String str = new String(this.data, i2, i3);
        if (i3 > 0) {
            element(str);
        }
    }

    private boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    @Override // org.simpleframework.xml.core.Expression
    public Expression getPath(int i2) {
        return getPath(i2, 0);
    }

    private void attribute(String str) {
        String attribute = this.style.getAttribute(str);
        this.prefixes.add(null);
        this.names.add(attribute);
    }

    private void element(String str) {
        String strSubstring;
        int iIndexOf = str.indexOf(58);
        if (iIndexOf > 0) {
            strSubstring = str.substring(0, iIndexOf);
            str = str.substring(iIndexOf + 1);
        } else {
            strSubstring = null;
        }
        String element = this.style.getElement(str);
        this.prefixes.add(strSubstring);
        this.names.add(element);
    }

    @Override // org.simpleframework.xml.core.Expression
    public Expression getPath(int i2, int i3) {
        int size = (this.names.size() - 1) - i3;
        return size >= i2 ? new PathSection(i2, size) : new PathSection(i2, i2);
    }
}
