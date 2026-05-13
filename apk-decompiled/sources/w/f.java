package w;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import o.AbstractC0236e;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f4059a;

    private static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextView f4060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final C0261d f4061b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f4062c = true;

        a(TextView textView) {
            this.f4060a = textView;
            this.f4061b = new C0261d(textView);
        }

        private InputFilter[] d(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f4061b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f4061b;
            return inputFilterArr2;
        }

        private SparseArray e(InputFilter[] inputFilterArr) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i2 = 0; i2 < inputFilterArr.length; i2++) {
                InputFilter inputFilter = inputFilterArr[i2];
                if (inputFilter instanceof C0261d) {
                    sparseArray.put(i2, inputFilter);
                }
            }
            return sparseArray;
        }

        private InputFilter[] f(InputFilter[] inputFilterArr) {
            SparseArray sparseArrayE = e(inputFilterArr);
            if (sparseArrayE.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArrayE.size()];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (sparseArrayE.indexOfKey(i3) < 0) {
                    inputFilterArr2[i2] = inputFilterArr[i3];
                    i2++;
                }
            }
            return inputFilterArr2;
        }

        private TransformationMethod h(TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? ((h) transformationMethod).a() : transformationMethod;
        }

        private void i() {
            this.f4060a.setFilters(a(this.f4060a.getFilters()));
        }

        private TransformationMethod k(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h(transformationMethod);
        }

        @Override // w.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.f4062c ? f(inputFilterArr) : d(inputFilterArr);
        }

        @Override // w.f.b
        void b(boolean z2) {
            if (z2) {
                j();
            }
        }

        @Override // w.f.b
        void c(boolean z2) {
            this.f4062c = z2;
            j();
            i();
        }

        void g(boolean z2) {
            this.f4062c = z2;
        }

        void j() {
            this.f4060a.setTransformationMethod(l(this.f4060a.getTransformationMethod()));
        }

        TransformationMethod l(TransformationMethod transformationMethod) {
            return this.f4062c ? k(transformationMethod) : h(transformationMethod);
        }
    }

    static class b {
        b() {
        }

        abstract InputFilter[] a(InputFilter[] inputFilterArr);

        abstract void b(boolean z2);

        abstract void c(boolean z2);
    }

    private static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f4063a;

        c(TextView textView) {
            this.f4063a = new a(textView);
        }

        private boolean d() {
            return !androidx.emoji2.text.f.i();
        }

        @Override // w.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return d() ? inputFilterArr : this.f4063a.a(inputFilterArr);
        }

        @Override // w.f.b
        void b(boolean z2) {
            if (d()) {
                return;
            }
            this.f4063a.b(z2);
        }

        @Override // w.f.b
        void c(boolean z2) {
            if (d()) {
                this.f4063a.g(z2);
            } else {
                this.f4063a.c(z2);
            }
        }
    }

    public f(TextView textView, boolean z2) {
        AbstractC0236e.g(textView, "textView cannot be null");
        this.f4059a = !z2 ? new c(textView) : new a(textView);
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f4059a.a(inputFilterArr);
    }

    public void b(boolean z2) {
        this.f4059a.b(z2);
    }

    public void c(boolean z2) {
        this.f4059a.c(z2);
    }
}
