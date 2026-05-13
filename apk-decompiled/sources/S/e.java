package s;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.core.view.C0140d;
import androidx.core.view.L;
import o.AbstractC0234c;
import o.AbstractC0236e;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    class a extends InputConnectionWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f4002a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InputConnection inputConnection, boolean z2, c cVar) {
            super(inputConnection, z2);
            this.f4002a = cVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitContent(InputContentInfo inputContentInfo, int i2, Bundle bundle) {
            if (this.f4002a.a(f.f(inputContentInfo), i2, bundle)) {
                return true;
            }
            return super.commitContent(inputContentInfo, i2, bundle);
        }
    }

    class b extends InputConnectionWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f4003a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InputConnection inputConnection, boolean z2, c cVar) {
            super(inputConnection, z2);
            this.f4003a = cVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean performPrivateCommand(String str, Bundle bundle) {
            if (e.e(str, bundle, this.f4003a)) {
                return true;
            }
            return super.performPrivateCommand(str, bundle);
        }
    }

    public interface c {
        boolean a(f fVar, int i2, Bundle bundle);
    }

    private static c b(final View view) {
        AbstractC0236e.f(view);
        return new c() { // from class: s.d
            @Override // s.e.c
            public final boolean a(f fVar, int i2, Bundle bundle) {
                return e.f(view, fVar, i2, bundle);
            }
        };
    }

    public static InputConnection c(View view, InputConnection inputConnection, EditorInfo editorInfo) {
        return d(inputConnection, editorInfo, b(view));
    }

    public static InputConnection d(InputConnection inputConnection, EditorInfo editorInfo, c cVar) {
        AbstractC0234c.d(inputConnection, "inputConnection must be non-null");
        AbstractC0234c.d(editorInfo, "editorInfo must be non-null");
        AbstractC0234c.d(cVar, "onCommitContentListener must be non-null");
        return Build.VERSION.SDK_INT >= 25 ? new a(inputConnection, false, cVar) : s.c.a(editorInfo).length == 0 ? inputConnection : new b(inputConnection, false, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    static boolean e(String str, Bundle bundle, c cVar) throws Throwable {
        boolean z2;
        ResultReceiver resultReceiver;
        ?? A2 = 0;
        A2 = 0;
        if (bundle == null) {
            return false;
        }
        if (TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
            z2 = false;
        } else {
            if (!TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
                return false;
            }
            z2 = true;
        }
        try {
            ResultReceiver resultReceiver2 = (ResultReceiver) bundle.getParcelable(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER");
            try {
                Uri uri = (Uri) bundle.getParcelable(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI");
                ClipDescription clipDescription = (ClipDescription) bundle.getParcelable(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION");
                Uri uri2 = (Uri) bundle.getParcelable(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI");
                int i2 = bundle.getInt(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS");
                Bundle bundle2 = (Bundle) bundle.getParcelable(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS");
                if (uri != null && clipDescription != null) {
                    A2 = cVar.a(new f(uri, clipDescription, uri2), i2, bundle2);
                }
                if (resultReceiver2 != 0) {
                    resultReceiver2.send(A2, null);
                }
                return A2;
            } catch (Throwable th) {
                th = th;
                resultReceiver = resultReceiver2;
                if (resultReceiver != null) {
                    resultReceiver.send(0, null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            resultReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean f(View view, f fVar, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25 && (i2 & 1) != 0) {
            try {
                fVar.d();
                Parcelable parcelable = (Parcelable) fVar.e();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception unused) {
                return false;
            }
        }
        return L.N(view, new C0140d.a(new ClipData(fVar.b(), new ClipData.Item(fVar.a())), 2).d(fVar.c()).b(bundle).a()) == null;
    }
}
