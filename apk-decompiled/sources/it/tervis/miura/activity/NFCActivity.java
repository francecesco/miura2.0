package it.tervis.miura.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.os.Bundle;
import j0.d;
import j0.f;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class NFCActivity extends a {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private NfcAdapter f3742D;

    private NdefMessage D0() {
        return new NdefMessage(new NdefRecord[]{new NdefRecord((short) 1, NdefRecord.RTD_TEXT, new byte[0], E0(f.g()))});
    }

    private byte[] E0(String str) throws UnsupportedEncodingException {
        byte[] bytes = Locale.getDefault().getLanguage().getBytes(Charset.forName("US_ASCII"));
        byte length = (byte) (bytes.length & 63);
        byte[] bytes2 = str.getBytes("UTF-8");
        byte[] bArr = new byte[bytes.length + 1 + bytes2.length];
        bArr[0] = length;
        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        System.arraycopy(bytes2, 0, bArr, bytes.length + 1, bytes2.length);
        return bArr;
    }

    private void F0(Ndef ndef) {
        try {
            ndef.connect();
            ndef.writeNdefMessage(D0());
            ndef.close();
            p("tag written");
        } catch (Exception e2) {
            d.c(e2);
            p("error");
        }
    }

    @Override // it.tervis.miura.activity.a, androidx.fragment.app.AbstractActivityC0171j, androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3742D = NfcAdapter.getDefaultAdapter(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Tag tag = (Tag) intent.getExtras().getParcelable("android.nfc.extra.TAG");
        if (intent.getAction().equals("android.nfc.action.NDEF_DISCOVERED")) {
            Ndef ndef = Ndef.get(tag);
            if (ndef != null) {
                if (ndef.isWritable()) {
                    F0(ndef);
                    return;
                }
                p("readonly tag");
                return;
            }
            p("tag not supported");
        }
        if (intent.getAction().equals("android.nfc.action.TECH_DISCOVERED")) {
            Ndef ndef2 = Ndef.get(tag);
            if (ndef2 != null) {
                if (ndef2.isWritable()) {
                    F0(ndef2);
                    return;
                }
                p("readonly tag");
                return;
            }
            if (NdefFormatable.get(tag) != null) {
                setIntent(intent);
                return;
            }
            p("tag not supported");
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f3742D.disableForegroundDispatch(this);
    }

    @Override // androidx.fragment.app.AbstractActivityC0171j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f3742D.enableForegroundDispatch(this, PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(536870912), 0), new IntentFilter[]{new IntentFilter("android.nfc.action.NDEF_DISCOVERED"), new IntentFilter("android.nfc.action.TECH_DISCOVERED")}, new String[][]{new String[]{NdefFormatable.class.getName()}, new String[]{Ndef.class.getName()}});
    }
}
