package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import o.AbstractC0236e;

/* JADX INFO: loaded from: classes.dex */
final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f1543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextClassifier f1544b;

    private static final class a {
        static TextClassifier a(TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    D(TextView textView) {
        this.f1543a = (TextView) AbstractC0236e.f(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f1544b;
        return textClassifier == null ? a.a(this.f1543a) : textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f1544b = textClassifier;
    }
}
