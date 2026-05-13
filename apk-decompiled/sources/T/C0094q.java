package T;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: T.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0094q extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ C0093p f333a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0094q(C0093p c0093p, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f333a = c0093p;
    }

    private final boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                boolean zMoveToFirst = cursorQuery.moveToFirst();
                cursorQuery.close();
                return zMoveToFirst;
            } catch (SQLiteException e2) {
                this.f333a.o("Error querying for table", str, e2);
                if (cursorQuery == null) {
                    return false;
                }
                cursorQuery.close();
                return false;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    private static Set b(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" LIMIT 0");
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
        try {
            for (String str2 : cursorRawQuery.getColumnNames()) {
                hashSet.add(str2);
            }
            return hashSet;
        } finally {
            cursorRawQuery.close();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        if (!this.f333a.f332e.c(3600000L)) {
            throw new SQLiteException("Database open failed");
        }
        try {
            return super.getWritableDatabase();
        } catch (SQLiteException unused) {
            this.f333a.f332e.b();
            this.f333a.C("Opening the database failed, dropping the table and recreating it");
            C0093p c0093p = this.f333a;
            this.f333a.a().getDatabasePath(C0093p.V()).delete();
            try {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                this.f333a.f332e.a();
                return writableDatabase;
            } catch (SQLiteException e2) {
                this.f333a.x("Failed to open freshly created database", e2);
                throw e2;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        String path = sQLiteDatabase.getPath();
        if (M.a() >= 9) {
            File file = new File(path);
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    @Override // android.database.sqlite.SQLiteOpenHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onOpen(android.database.sqlite.SQLiteDatabase r10) {
        /*
            r9 = this;
            java.lang.String r0 = "hits2"
            boolean r1 = r9.a(r10, r0)
            r2 = 0
            if (r1 != 0) goto L11
            java.lang.String r0 = T.C0093p.W()
        Ld:
            r10.execSQL(r0)
            goto L5f
        L11:
            java.util.Set r0 = b(r10, r0)
            java.lang.String r1 = "hit_time"
            java.lang.String r3 = "hit_url"
            java.lang.String r4 = "hit_id"
            java.lang.String r5 = "hit_string"
            java.lang.String[] r1 = new java.lang.String[]{r4, r5, r1, r3}
            r3 = 0
        L22:
            r4 = 4
            if (r3 >= r4) goto L4c
            r4 = r1[r3]
            boolean r5 = r0.remove(r4)
            if (r5 != 0) goto L49
            android.database.sqlite.SQLiteException r10 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = java.lang.String.valueOf(r4)
            int r1 = r0.length()
            java.lang.String r2 = "Database hits2 is missing required column: "
            if (r1 == 0) goto L40
            java.lang.String r0 = r2.concat(r0)
            goto L45
        L40:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L45:
            r10.<init>(r0)
            throw r10
        L49:
            int r3 = r3 + 1
            goto L22
        L4c:
            java.lang.String r1 = "hit_app_id"
            boolean r1 = r0.remove(r1)
            r1 = r1 ^ 1
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lba
            if (r1 == 0) goto L5f
            java.lang.String r0 = "ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER"
            goto Ld
        L5f:
            java.lang.String r0 = "properties"
            boolean r1 = r9.a(r10, r0)
            if (r1 != 0) goto L6d
            java.lang.String r0 = "CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;"
            r10.execSQL(r0)
            return
        L6d:
            java.util.Set r10 = b(r10, r0)
            java.lang.String r7 = "adid"
            java.lang.String r8 = "hits_count"
            java.lang.String r3 = "app_uid"
            java.lang.String r4 = "cid"
            java.lang.String r5 = "tid"
            java.lang.String r6 = "params"
            java.lang.String[] r0 = new java.lang.String[]{r3, r4, r5, r6, r7, r8}
        L81:
            r1 = 6
            if (r2 >= r1) goto Lab
            r1 = r0[r2]
            boolean r3 = r10.remove(r1)
            if (r3 != 0) goto La8
            android.database.sqlite.SQLiteException r10 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = java.lang.String.valueOf(r1)
            int r1 = r0.length()
            java.lang.String r2 = "Database properties is missing required column: "
            if (r1 == 0) goto L9f
            java.lang.String r0 = r2.concat(r0)
            goto La4
        L9f:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        La4:
            r10.<init>(r0)
            throw r10
        La8:
            int r2 = r2 + 1
            goto L81
        Lab:
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto Lb2
            return
        Lb2:
            android.database.sqlite.SQLiteException r10 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = "Database properties table has extra columns"
            r10.<init>(r0)
            throw r10
        Lba:
            android.database.sqlite.SQLiteException r10 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = "Database hits2 has extra columns"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: T.C0094q.onOpen(android.database.sqlite.SQLiteDatabase):void");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
