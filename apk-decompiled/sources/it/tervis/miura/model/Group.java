package it.tervis.miura.model;

import android.util.SparseArray;
import j0.d;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class Group {
    public static final int MAX_GROUPS = 16;
    public static final int MAX_GROUPS_PER_AREA = 4;
    private boolean mActivated;
    private int mGroupID;
    private boolean mHasZonesOut;
    private int mMask;
    private String mName;
    private boolean mPartiallyActivated;
    private boolean mStatusKnown;
    private SparseArray<Zone> mZones = new SparseArray<>();
    private HashSet<Integer> mZonesHash;
    private ArrayList<Integer> mZonesList;

    public Group(int i2) {
        this.mGroupID = i2;
        this.mMask = (int) Math.pow(2.0d, i2);
    }

    public static int groupNumberFromMask(int i2) {
        for (int i3 = 0; i3 < 16; i3++) {
            if (((int) Math.pow(2.0d, i3)) == i2) {
                return i3;
            }
        }
        return 0;
    }

    public int asMask() {
        return this.mMask;
    }

    public String getDefaultName() {
        int i2 = this.mGroupID;
        return Integer.toString((i2 / 4) + 1) + " " + ((char) ((i2 % 4) + 65));
    }

    public int getID() {
        return this.mGroupID;
    }

    public String getName() {
        return this.mName;
    }

    public SparseArray<Zone> getZones() {
        return this.mZones;
    }

    public ArrayList<Integer> getZonesList() {
        return this.mZonesList;
    }

    public boolean hasZoneAssigned() {
        ArrayList<Integer> arrayList = this.mZonesList;
        return arrayList != null && arrayList.size() > 0;
    }

    public boolean hasZonePermanentlyExcludedGroupsMask() {
        return this.mHasZonesOut;
    }

    public boolean isActivated() {
        return this.mActivated;
    }

    public boolean isPartiallyActivatedWithTemporaryExcludedZones() {
        return this.mPartiallyActivated;
    }

    public boolean isStatusKnown() {
        return this.mStatusKnown;
    }

    public void setActivated(boolean z2) {
        d.a("Setting activation to " + z2 + " for group " + this.mGroupID + " " + Integer.toBinaryString(this.mMask));
        this.mActivated = z2;
        this.mStatusKnown = true;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setPartiallyActivatedWithTemporaryExcludedZones(boolean z2) {
        d.a("Setting partial activation to " + z2 + " for group " + this.mGroupID + " " + Integer.toBinaryString(this.mMask));
        this.mPartiallyActivated = z2;
        this.mStatusKnown = true;
    }

    public void setZone(Zone zone) {
        if (zone.getID() < 96 || ((zone.getID() >= 100 && zone.getID() < 196) || (zone.getID() >= 200 && zone.getID() < 254))) {
            Zone zone2 = this.mZones.get(zone.getID());
            if (zone2 == null) {
                this.mZones.put(zone.getID(), zone);
                return;
            }
            if (zone.getName() != null) {
                zone2.setName(zone.getName());
            } else if (zone.isActive() != null) {
                zone2.setActive(zone.isActive().booleanValue());
            } else if (zone.getStatus() != null) {
                zone2.setStatus(zone.getStatus());
            }
        }
    }

    public void setZonePermanentlyExcludedGroupsMask(boolean z2) {
        this.mHasZonesOut = z2;
        this.mStatusKnown = true;
    }

    public void setZones(HashSet<Integer> hashSet, ArrayList<Integer> arrayList) {
        this.mZonesHash = hashSet;
        this.mZonesList = arrayList;
    }
}
