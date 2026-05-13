package X;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import it.tervis.miura.R;

/* JADX INFO: loaded from: classes.dex */
public class c extends X.b {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private ImageView f470i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private Bitmap f471j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private ProgressBar f472k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private b f473l0;

    private class b extends AsyncTask {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f473l0 = new b();
                c.this.f473l0.execute("");
            }
        }

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(String... strArr) {
            try {
                return j0.j.h("");
            } catch (Exception e2) {
                j0.d.c(e2);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            c.this.f472k0.setIndeterminate(false);
            if (bitmap != null) {
                c.this.f470i0.setImageBitmap(bitmap);
                if (c.this.f471j0 != null && !c.this.f471j0.isRecycled()) {
                    c.this.f471j0.recycle();
                    c.this.f471j0 = bitmap;
                }
            }
            c.this.f466f0.postDelayed(new a(), 5000L);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            c.this.f472k0.setIndeterminate(true);
        }
    }

    public static c S1() {
        return new c();
    }

    private void U1() {
        b bVar = new b();
        this.f473l0 = bVar;
        bVar.execute("");
    }

    @Override // X.b, androidx.fragment.app.Fragment
    public void J0() {
        super.J0();
        U1();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0() {
        super.K0();
    }

    public void T1() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", new byte[15]);
        intent.setType("image/jpeg");
        D1(intent);
    }

    @Override // androidx.fragment.app.Fragment
    public View q0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_camera, viewGroup, false);
        this.f465e0 = viewGroup2;
        this.f470i0 = (ImageView) viewGroup2.findViewById(R.id.image_camera);
        this.f472k0 = (ProgressBar) this.f465e0.findViewById(R.id.progress_camera);
        return this.f465e0;
    }
}
