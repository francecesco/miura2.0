package j0;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Cipher f3787a;

    static {
        try {
            f3787a = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (Exception e2) {
            d.c(e2);
        }
    }

    public static final String a(byte[] bArr, String str) {
        return new String(b(bArr, str.getBytes()));
    }

    public static final byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            d.a("Key lenght: " + bArr2.length);
            d.a("Data lenght: " + bArr.length);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(bArr2, 0, bArr2.length, "AES"));
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(cipher.doFinal(bArr)));
            int i2 = dataInputStream.readInt();
            byte[] bArr3 = new byte[i2];
            dataInputStream.read(bArr3, 0, i2);
            return bArr3;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static final byte[] c(String str, String str2) {
        return (str == null || str2 == null) ? new byte[0] : d(str.getBytes(), str2.getBytes());
    }

    public static final byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            d.a("Key lenght: " + bArr2.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, 0, bArr2.length, "AES");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
            f3787a.init(1, secretKeySpec);
            byte[] bArrDoFinal = f3787a.doFinal(byteArrayOutputStream.toByteArray());
            d.a("Data lenght: " + bArrDoFinal.length);
            return bArrDoFinal;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String e(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : bArrDigest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
