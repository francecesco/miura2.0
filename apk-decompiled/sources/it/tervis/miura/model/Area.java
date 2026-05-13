package it.tervis.miura.model;

import j0.d;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Area implements Normalizable {
    public static final int MAX_AREAS = 4;
    private int mAreaIndex;
    private String mName;
    public ArrayList<Group> mGroups = new ArrayList<>();
    public ArrayList<Group> mNormalizedGroups = new ArrayList<>();

    public Area(int i2) {
        this.mAreaIndex = i2;
        for (int i3 = 0; i3 < 4; i3++) {
            this.mGroups.add(new Group((this.mAreaIndex * 4) + i3));
        }
    }

    public int getGroupCount() {
        Iterator<Group> it2 = this.mGroups.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            if (it2.next().hasZoneAssigned()) {
                i2++;
            }
        }
        return i2;
    }

    public int getID() {
        return this.mAreaIndex;
    }

    public String getName() {
        return this.mName;
    }

    public boolean hasActiveGroups() {
        ArrayList<Group> arrayList = this.mNormalizedGroups;
        return arrayList != null && arrayList.size() > 0;
    }

    @Override // it.tervis.miura.model.Normalizable
    public void normalize() {
        d.a("Normalizing area " + this.mAreaIndex + "...");
        this.mNormalizedGroups.clear();
        for (Group group : this.mGroups) {
            if (group.hasZoneAssigned()) {
                this.mNormalizedGroups.add(group);
            }
        }
        d.a("Area " + this.mAreaIndex + " normalized: there are " + this.mNormalizedGroups.size() + " groups with zones.");
    }

    public void setName(String str) {
        this.mName = str;
    }
}
