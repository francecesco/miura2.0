package it.tervis.miura.model;

import j0.d;
import j0.j;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class LogEvent implements Serializable {
    private static SimpleDateFormat _DateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    private static SimpleDateFormat _HourFormat = new SimpleDateFormat("HH:mm");
    private int[] mBuffer;
    private int mCategory;
    private Date mDate;
    private int mDay;
    private int mHour;
    private int mMinute;
    private int mMonth;
    private boolean mRead;
    private String mText;
    private int mYear;

    public LogEvent(int i2, int i3, int i4, int i5, int i6, int i7, boolean z2, int[] iArr, String str) {
        this.mCategory = i2;
        this.mDay = i3;
        this.mMonth = i4;
        this.mYear = i5;
        this.mHour = i6;
        this.mMinute = i7;
        this.mRead = z2;
        this.mBuffer = iArr;
        this.mText = str;
        parseDate();
    }

    private void parseDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.mYear + 2000, this.mMonth - 1, this.mDay, this.mHour, this.mMinute);
        Date time = calendar.getTime();
        this.mDate = time;
        d.a(time.toString());
    }

    public int getCategory() {
        return this.mCategory;
    }

    public Date getDate() {
        return this.mDate;
    }

    public int getDay() {
        return this.mDay;
    }

    public int getHour() {
        return this.mHour;
    }

    public String getHumanizedDateText() {
        if (j.f(this.mDate)) {
            return "Oggi alle " + _HourFormat.format(this.mDate);
        }
        if (!j.g(this.mDate)) {
            return _DateFormat.format(this.mDate);
        }
        return "Ieri alle " + _HourFormat.format(this.mDate);
    }

    public int getMinute() {
        return this.mMinute;
    }

    public int getMonth() {
        return this.mMonth;
    }

    public String getText() {
        return this.mText;
    }

    public int getYear() {
        return this.mYear;
    }

    public boolean hasBeenRead() {
        return this.mRead;
    }

    public void setText(String str) {
        this.mText = str;
    }
}
