package org.simpleframework.xml.stream;

/* JADX INFO: loaded from: classes.dex */
public class Format {
    private final int indent;
    private final String prolog;
    private final Style style;
    private final Verbosity verbosity;

    public Format() {
        this(3);
    }

    public int getIndent() {
        return this.indent;
    }

    public String getProlog() {
        return this.prolog;
    }

    public Style getStyle() {
        return this.style;
    }

    public Verbosity getVerbosity() {
        return this.verbosity;
    }

    public Format(int i2) {
        this(i2, (String) null, new IdentityStyle());
    }

    public Format(int i2, String str) {
        this(i2, str, new IdentityStyle());
    }

    public Format(int i2, String str, Style style) {
        this(i2, str, style, Verbosity.HIGH);
    }

    public Format(int i2, String str, Style style, Verbosity verbosity) {
        this.verbosity = verbosity;
        this.prolog = str;
        this.indent = i2;
        this.style = style;
    }

    public Format(int i2, Style style) {
        this(i2, (String) null, style);
    }

    public Format(int i2, Style style, Verbosity verbosity) {
        this(i2, null, style, verbosity);
    }

    public Format(int i2, Verbosity verbosity) {
        this(i2, new IdentityStyle(), verbosity);
    }

    public Format(String str) {
        this(3, str);
    }

    public Format(Style style) {
        this(3, style);
    }

    public Format(Style style, Verbosity verbosity) {
        this(3, style, verbosity);
    }

    public Format(Verbosity verbosity) {
        this(3, verbosity);
    }
}
