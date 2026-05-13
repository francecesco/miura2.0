package T;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: T.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0093p extends AbstractC0083f implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f328f = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f329g = String.format("SELECT MAX(%s) FROM %s WHERE 1;", "hit_time", "hits2");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C0094q f330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final k0 f331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k0 f332e;

    C0093p(C0085h c0085h) {
        super(c0085h);
        this.f331d = new k0(k());
        this.f332e = new k0(k());
        this.f330c = new C0094q(this, c0085h.a(), "google_analytics_v4.db");
    }

    private final long M(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = J().rawQuery(str, null);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j2 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j2;
            } catch (SQLiteException e2) {
                w("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long N(java.lang.String r1, java.lang.String[] r2, long r3) {
        /*
            r0 = this;
            android.database.sqlite.SQLiteDatabase r3 = r0.J()
            r4 = 0
            android.database.Cursor r4 = r3.rawQuery(r1, r2)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteException -> L1a
            boolean r2 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteException -> L1a
            if (r2 == 0) goto L1c
            r2 = 0
            long r1 = r4.getLong(r2)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteException -> L1a
            r4.close()
            return r1
        L18:
            r1 = move-exception
            goto L28
        L1a:
            r2 = move-exception
            goto L22
        L1c:
            r4.close()
            r1 = 0
            return r1
        L22:
            java.lang.String r3 = "Database error"
            r0.w(r3, r1, r2)     // Catch: java.lang.Throwable -> L18
            throw r2     // Catch: java.lang.Throwable -> L18
        L28:
            if (r4 == 0) goto L2d
            r4.close()
        L2d:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: T.C0093p.N(java.lang.String, java.lang.String[], long):long");
    }

    private final long R() {
        F.i.d();
        F();
        return M("SELECT COUNT(*) FROM hits2", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String V() {
        return "google_analytics_v4.db";
    }

    private final Map Y(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                str = str.length() != 0 ? "?".concat(str) : new String("?");
            }
            return O.f.b(new URI(str), "UTF-8");
        } catch (URISyntaxException e2) {
            x("Error parsing hit parameters", e2);
            return new HashMap(0);
        }
    }

    public final void H() {
        F();
        J().beginTransaction();
    }

    public final void I() {
        F();
        J().endTransaction();
    }

    final SQLiteDatabase J() {
        try {
            return this.f330c.getWritableDatabase();
        } catch (SQLiteException e2) {
            v("Error opening database", e2);
            throw e2;
        }
    }

    final boolean K() {
        return R() == 0;
    }

    public final void L() {
        F();
        J().setTransactionSuccessful();
    }

    public final void P(List list) {
        K.e.f(list);
        F.i.d();
        F();
        if (list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("hit_id");
        sb.append(" in (");
        for (int i2 = 0; i2 < list.size(); i2++) {
            Long l2 = (Long) list.get(i2);
            if (l2 == null || l2.longValue() == 0) {
                throw new SQLiteException("Invalid hit id");
            }
            if (i2 > 0) {
                sb.append(",");
            }
            sb.append(l2);
        }
        sb.append(")");
        String string = sb.toString();
        try {
            SQLiteDatabase sQLiteDatabaseJ = J();
            c("Deleting dispatched hits. count", Integer.valueOf(list.size()));
            int iDelete = sQLiteDatabaseJ.delete("hits2", string, null);
            if (iDelete != list.size()) {
                i("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(iDelete), string);
            }
        } catch (SQLiteException e2) {
            x("Error deleting hits", e2);
            throw e2;
        }
    }

    public final List S(long j2) throws Throwable {
        Cursor cursorQuery;
        K.e.a(j2 >= 0);
        F.i.d();
        F();
        Cursor cursor = null;
        try {
            try {
                cursorQuery = J().query("hits2", new String[]{"hit_id", "hit_time", "hit_string", "hit_url", "hit_app_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Long.toString(j2));
            } catch (Throwable th) {
                th = th;
            }
        } catch (SQLiteException e2) {
            e = e2;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (cursorQuery.moveToFirst()) {
                do {
                    arrayList.add(new T(this, Y(cursorQuery.getString(2)), cursorQuery.getLong(1), l0.d(cursorQuery.getString(3)), cursorQuery.getLong(0), cursorQuery.getInt(4)));
                } while (cursorQuery.moveToNext());
            }
            cursorQuery.close();
            return arrayList;
        } catch (SQLiteException e3) {
            e = e3;
            x("Error loading hits from the database", e);
            throw e;
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final int T() {
        F.i.d();
        F();
        if (!this.f331d.c(86400000L)) {
            return 0;
        }
        this.f331d.b();
        y("Deleting stale hits (if any)");
        int iDelete = J().delete("hits2", "hit_time < ?", new String[]{Long.toString(k().a() - 2592000000L)});
        c("Deleted stale hits, count", Integer.valueOf(iDelete));
        return iDelete;
    }

    public final long U() {
        F.i.d();
        F();
        return N(f329g, null, 0L);
    }

    public final void X(long j2) {
        F.i.d();
        F();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j2));
        c("Deleting hit, id", Long.valueOf(j2));
        P(arrayList);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        String str;
        try {
            this.f330c.close();
        } catch (SQLiteException e2) {
            e = e2;
            str = "Sql error closing database";
            x(str, e);
        } catch (IllegalStateException e3) {
            e = e3;
            str = "Error closing database";
            x(str, e);
        }
    }

    @Override // T.AbstractC0083f
    protected final void E() {
    }
}
