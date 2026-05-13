package it.tervis.miura.model;

import Z.b;
import Z.e;
import Z.f;
import Z.h;
import Z.j;
import Z.o;
import g0.k;
import h0.c;
import h0.g;
import j0.d;
import j0.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class Installation {
    private String address;
    private long clock;
    private e mAllZonesPeripheralsActivationStatusMessageData;
    private b mLastKnownActivationStatus;
    private boolean mNormalized;
    private ArrayList<Integer> mRemoteControllerEnableStatus;
    private k mTimerSummary;
    private ArrayList<Timer> mTimers;
    private HashMap<Integer, Timer> mTimersByID;
    private c mUserInfoData;
    private UserSessionListener mUserSessionListener;
    private String name;
    public ArrayList<Area> mAreas = new ArrayList<>();
    public ArrayList<Zone> mZones = new ArrayList<>();
    public ArrayList<Area> mNormalizedAreas = new ArrayList<>();
    public ArrayList<Group> mGroups = new ArrayList<>();
    public ArrayList<Group> mNormalizedGroups = new ArrayList<>();
    private ArrayList<TextListener> mTextListeners = new ArrayList<>();
    public ArrayList<Console> mConsoles = new ArrayList<>();
    private SessionState mSessionState = SessionState.NOT_CONNECTED;
    private ArrayList<RemoteController> mRemoteControllers = new ArrayList<>();
    private HashMap<Integer, RemoteController> mRemoteControllersByID = new HashMap<>();
    private HashSet<Integer> mAuthorizedZones = new HashSet<>();
    private int mNormalizedZoneCount = 0;

    public enum ReadyForActivation {
        READY,
        NOT_READY,
        UNKNOWN
    }

    public enum SessionState {
        NOT_CONNECTED,
        CONNECTED,
        EXPIRED
    }

    public interface TextListener {
        void onTextChanged(int i2);
    }

    public interface UserSessionListener {
        void onSessionClosed();

        void onUserInfoDataChanged(c cVar);
    }

    public Installation() {
        init();
    }

    private void dispatchTextChanged(int i2) {
        for (TextListener textListener : this.mTextListeners) {
            if (textListener != null) {
                textListener.onTextChanged(i2);
            }
        }
    }

    private Group getGroup(int i2) {
        return this.mAreas.get(i2 / 4).mGroups.get(i2 % 4);
    }

    private void handleGenericMessage(Y.b bVar) {
        d.d(bVar.n());
        d.a("- generic message, nothing to do...");
    }

    private void init() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.mAreas.add(new Area(i2));
        }
        for (int i3 = 0; i3 < 255; i3++) {
            this.mZones.add(new Zone(i3));
        }
        for (int i4 = 0; i4 < 7; i4++) {
            this.mConsoles.add(new Console(i4));
        }
    }

    public void addTextListener(TextListener textListener) {
        this.mTextListeners.add(textListener);
    }

    public boolean canAccessLog() {
        return this.mUserInfoData.s();
    }

    public boolean canActivateGroups(int i2) {
        return this.mUserInfoData.t(i2);
    }

    public boolean canDeactivateGroups(int i2) {
        return this.mUserInfoData.u(i2);
    }

    public boolean canDeactivateZones() {
        return this.mUserInfoData.v();
    }

    public boolean canUseRemoteControllers() {
        return this.mUserInfoData.w();
    }

    public boolean canUseSecuritySection() {
        return this.mUserInfoData.x();
    }

    public boolean canUseTimers() {
        return this.mUserInfoData.y();
    }

    public String getAddress() {
        return this.address;
    }

    public String getName() {
        return this.name;
    }

    public int getNormalizedZonesCount() {
        return this.mNormalizedZoneCount;
    }

    public ArrayList<RemoteController> getRemoteControllers() {
        return this.mRemoteControllers;
    }

    public int getRemoteControllersCount() {
        return this.mRemoteControllers.size();
    }

    public Timer getTimer(int i2) {
        return this.mTimersByID.get(Integer.valueOf(i2));
    }

    public ArrayList<Timer> getTimers() {
        return this.mTimers;
    }

    public String getUserName() {
        c cVar = this.mUserInfoData;
        if (cVar != null) {
            return cVar.r();
        }
        return null;
    }

    public void handleMessage(Y.b bVar) {
        try {
            Installation.class.getDeclaredMethod("handleMessage", bVar.getClass()).invoke(this, bVar);
        } catch (Exception unused) {
            handleGenericMessage(bVar);
        }
    }

    public boolean hasTimers() {
        return this.mTimers != null;
    }

    public boolean isEnabled(RemoteController remoteController) {
        ArrayList<Integer> arrayList = this.mRemoteControllerEnableStatus;
        if (arrayList != null) {
            return arrayList.get(remoteController.getID()).intValue() == 1;
        }
        d.a("Installation: mRemoteControllerEnableStatus is null!");
        return false;
    }

    public ReadyForActivation isReadyForActivation() {
        e eVar = this.mAllZonesPeripheralsActivationStatusMessageData;
        return eVar != null ? eVar.A() ? ReadyForActivation.READY : ReadyForActivation.NOT_READY : ReadyForActivation.UNKNOWN;
    }

    public boolean isUserAuthorizedForZone(int i2) {
        return this.mAuthorizedZones.contains(Integer.valueOf(i2));
    }

    public boolean isValid() {
        return this.mNormalized;
    }

    public void normalize() {
        if (this.mNormalized) {
            throw new RuntimeException("Installation already normalized! Please, load a new Installation from scratch!");
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.mAreas.get(i2).normalize();
        }
        d.a("Normalizing installation for purging empty areas...");
        this.mNormalizedAreas.clear();
        for (Area area : this.mAreas) {
            if (area.hasActiveGroups()) {
                this.mNormalizedAreas.add(area);
            }
        }
        this.mNormalized = true;
        d.a("Normalized: there are " + this.mNormalizedAreas.size() + " areas with active groups");
        Iterator<Area> it2 = this.mNormalizedAreas.iterator();
        while (it2.hasNext()) {
            Iterator<Group> it3 = it2.next().mNormalizedGroups.iterator();
            while (it3.hasNext()) {
                this.mNormalizedZoneCount += it3.next().getZonesList().size();
            }
        }
    }

    public void removeTextListener(TextListener textListener) {
        this.mTextListeners.remove(textListener);
    }

    void reset() {
        try {
            this.name = null;
            this.address = null;
            this.mAreas.clear();
            this.mZones.clear();
            this.mNormalizedAreas.clear();
            this.mGroups.clear();
            this.mNormalizedGroups.clear();
            this.mAllZonesPeripheralsActivationStatusMessageData = null;
            this.mUserInfoData = null;
            this.mLastKnownActivationStatus = null;
            this.mUserSessionListener = null;
            this.mTextListeners.clear();
            this.mNormalized = false;
            this.mConsoles.clear();
            this.mSessionState = SessionState.NOT_CONNECTED;
            this.mRemoteControllers.clear();
            HashMap<Integer, RemoteController> map = this.mRemoteControllersByID;
            if (map != null) {
                map.clear();
            }
            ArrayList<Integer> arrayList = this.mRemoteControllerEnableStatus;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList<Timer> arrayList2 = this.mTimers;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            HashMap<Integer, Timer> map2 = this.mTimersByID;
            if (map2 != null) {
                map2.clear();
            }
            HashSet<Integer> hashSet = this.mAuthorizedZones;
            if (hashSet != null) {
                hashSet.clear();
            }
            this.mNormalizedZoneCount = 0;
            this.mTimerSummary = null;
            this.clock = 0L;
        } catch (Exception e2) {
            d.c(e2);
        }
    }

    public void setUserSessionListener(UserSessionListener userSessionListener) {
        this.mUserSessionListener = userSessionListener;
    }

    public Installation(String str, String str2) {
        this.name = str;
        this.address = str2;
        init();
    }

    private void handleMessage(b bVar) {
        d.a("- ActivateResponse arrived.");
        this.mLastKnownActivationStatus = bVar;
        Iterator<Area> it2 = this.mAreas.iterator();
        while (it2.hasNext()) {
            for (Group group : it2.next().mNormalizedGroups) {
                if (group != null) {
                    d.a("Message mask: " + Integer.toBinaryString(bVar.q()) + " and group mask " + Integer.toBinaryString(group.asMask()));
                    group.setActivated((bVar.q() & group.asMask()) != 0);
                    group.setPartiallyActivatedWithTemporaryExcludedZones((bVar.r() & group.asMask()) != 0);
                    group.setZonePermanentlyExcludedGroupsMask((bVar.s() & group.asMask()) != 0);
                }
            }
        }
    }

    private void handleMessage(e eVar) {
        d.a("- AllZonesResponse arrived. Ready: " + eVar.A());
    }

    private void handleMessage(f fVar) {
        d.a("- BoardcastActivateDeactivateMessage arrived.");
        Iterator<Area> it2 = this.mAreas.iterator();
        while (it2.hasNext()) {
            for (Group group : it2.next().mNormalizedGroups) {
                if (group != null) {
                    d.a("Message mask: " + Integer.toBinaryString(fVar.q()) + " and group mask " + Integer.toBinaryString(group.asMask()));
                    group.setActivated((fVar.q() & group.asMask()) != 0);
                    group.setPartiallyActivatedWithTemporaryExcludedZones((fVar.r() & group.asMask()) != 0);
                    group.setZonePermanentlyExcludedGroupsMask((fVar.s() & group.asMask()) != 0);
                }
            }
        }
    }

    private void handleMessage(h hVar) {
        d.a("- DeactivateResponse arrived.");
        Iterator<Area> it2 = this.mAreas.iterator();
        while (it2.hasNext()) {
            for (Group group : it2.next().mNormalizedGroups) {
                if (group != null) {
                    d.a("Message mask: " + Integer.toBinaryString(hVar.q()) + " and group mask " + Integer.toBinaryString(group.asMask()));
                    group.setActivated((hVar.q() & group.asMask()) != 0);
                }
            }
        }
    }

    private void handleMessage(j jVar) {
        d.a("- message type*: " + jVar.getClass());
        d.d(jVar.n());
        Iterator<Area> it2 = this.mAreas.iterator();
        while (it2.hasNext()) {
            for (Group group : it2.next().mNormalizedGroups) {
                if (group != null) {
                    d.a("Message mask: " + Integer.toBinaryString(jVar.q()) + " and group mask " + Integer.toBinaryString(group.asMask()));
                    group.setActivated((jVar.q() & group.asMask()) != 0);
                    group.setPartiallyActivatedWithTemporaryExcludedZones((jVar.r() & group.asMask()) != 0);
                    group.setZonePermanentlyExcludedGroupsMask((jVar.s() & group.asMask()) != 0);
                }
            }
        }
    }

    private void handleMessage(o oVar) {
        d.a("- ZonesPeripheralsActivationStatusMessageData arrived");
    }

    private void handleMessage(a0.c cVar) {
    }

    private void handleMessage(b0.b bVar) {
        int iQ = bVar.q() / 4;
        Group group = this.mAreas.get(iQ).mGroups.get(bVar.q() % 4);
        for (int i2 = 0; i2 < bVar.r().size(); i2++) {
            group.setZone((Zone) bVar.r().get(i2));
        }
    }

    private void handleMessage(b0.d dVar) {
        d.a("- message type: " + dVar.getClass().getName());
        d.a("- group: " + dVar.q());
        if (dVar.t()) {
            getGroup(dVar.q()).setZones(dVar.s(), dVar.r());
        }
        dVar.q();
    }

    private void handleMessage(d0.d dVar) {
        d.a("- RemoteControllerEnabledListResponse arrived");
        this.mRemoteControllerEnableStatus = dVar.r();
    }

    private void handleMessage(d0.f fVar) {
        d.a("- RemoteControllerListResponse arrived.");
        for (RemoteController remoteController : fVar.r()) {
            if (remoteController.isAccessibleViaApp()) {
                this.mRemoteControllers.add(remoteController);
                this.mRemoteControllersByID.put(Integer.valueOf(remoteController.getID()), remoteController);
            }
        }
    }

    private void handleMessage(d0.h hVar) {
        d.a("- OutletStateChangedBroadcastData arrived");
        for (RemoteController remoteController : this.mRemoteControllers) {
            if (remoteController.getID() == hVar.r().getID()) {
                remoteController.update(hVar.r());
            }
        }
    }

    private void handleMessage(f0.c cVar) {
        RemoteController remoteController;
        d.a("- text: " + cVar.s());
        if (cVar.q() == 2) {
            i.j(cVar.r(), cVar.s());
            this.mAreas.get(cVar.r() / 4).mGroups.get(cVar.r() % 4).setName(cVar.s());
        } else if (cVar.q() == 1) {
            i.h(cVar.r(), cVar.s());
            this.mAreas.get(cVar.r()).setName(cVar.s());
        } else if (cVar.q() == 3) {
            i.m(cVar.r(), cVar.s());
            this.mZones.get(cVar.r()).setName(cVar.s());
        } else {
            if (cVar.q() == 6) {
                i.i(cVar.r(), cVar.s());
                remoteController = this.mConsoles.get(cVar.r());
            } else if (cVar.q() == 4) {
                i.k(cVar.r(), cVar.s());
                remoteController = this.mRemoteControllersByID.get(Integer.valueOf(cVar.r()));
            } else if (cVar.q() == 8) {
                i.l(cVar.r() + 1, cVar.s());
            }
            remoteController.setName(cVar.s());
        }
        dispatchTextChanged(cVar.q());
    }

    private void handleMessage(g0.d dVar) {
        d.a("- TimerDetailsResponse arrived.");
        this.mTimersByID.get(Integer.valueOf(dVar.q())).setTransitions(dVar.r());
    }

    private void handleMessage(g0.f fVar) {
        d.a("- TimerGroupsResponse arrived.");
        this.mTimersByID.get(Integer.valueOf(fVar.s())).setGroups(fVar.q(), fVar.r());
    }

    private void handleMessage(g0.h hVar) {
        d.a("- TimerStateChangedBroadcast arrived.");
        for (Timer timer : this.mTimers) {
            boolean z2 = true;
            if ((hVar.r() & (1 << (timer.getID() - 1))) == 0) {
                z2 = false;
            }
            timer.setEnabled(z2);
        }
    }

    private void handleMessage(k kVar) {
        d.a("- TimerSummaryResponse arrived.");
        this.mTimers = new ArrayList<>();
        this.mTimersByID = new HashMap<>();
        this.mTimerSummary = kVar;
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = 1 << i2;
            if ((kVar.q() & i3) != 0) {
                d.a("Timer " + i2 + " has been programmed");
                Timer timer = new Timer(i2 + 1);
                timer.setEnabled((i3 & kVar.r()) != 0);
                this.mTimers.add(timer);
                this.mTimersByID.put(Integer.valueOf(timer.getID()), timer);
            }
        }
    }

    private void handleMessage(c cVar) {
        d.a("- UserInfoData arrived: " + cVar.toString());
        d.a("USER - canUseSecuritySection? " + cVar.x());
        this.mUserInfoData = cVar;
        UserSessionListener userSessionListener = this.mUserSessionListener;
        if (userSessionListener != null) {
            try {
                userSessionListener.onUserInfoDataChanged(cVar);
            } catch (Exception unused) {
            }
        }
    }

    private void handleMessage(h0.e eVar) {
        d.a("- UserSessionChangedBroadcast arrived. [still to be managed]");
        if (eVar.q() == 255) {
            this.mUserSessionListener.onSessionClosed();
        }
    }

    private void handleMessage(g gVar) {
        d.a("- UserSessionResponse arrived. [still to be managed]");
    }

    private void handleMessage(i0.d dVar) {
        d.a("- handling message type: " + dVar.getClass());
        for (int i2 = 0; i2 < dVar.s(); i2++) {
            d.a("Adding ZoneInfo authorization for zone " + dVar.r(i2).f3652a);
            this.mAuthorizedZones.add(Integer.valueOf(dVar.r(i2).f3652a));
        }
    }

    private void handleMessage(i0.g gVar) {
        d.a("- ZoneStatusResponse arrived");
    }
}
