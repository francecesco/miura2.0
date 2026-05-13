package it.tervis.miura.model;

import j0.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Timer extends Component {
    public static final int MAX_TRANSITIONS = 56;
    public static final int NOT_PROGRAMMED = 63;
    private int mActivationGroups;
    private int mDeactivationGroups;
    private boolean mEnabled;
    private ArrayList<TimerTransition> mTransitions;

    public enum TimerState {
        ON,
        OFF
    }

    public static class TimerTransition {
        private int mHour;
        private int mMinute;
        private TimerState mTimerState;

        public TimerTransition(int i2, int i3, TimerState timerState) {
            this.mHour = i2;
            this.mMinute = i3;
            this.mTimerState = timerState;
        }

        public int getHour() {
            return this.mHour;
        }

        public int getMinute() {
            return this.mMinute;
        }

        public TimerState getState() {
            return this.mTimerState;
        }

        public String getTime() {
            return Integer.toString(this.mHour) + ":" + String.format("%02d", Integer.valueOf(this.mMinute));
        }

        public boolean isProgrammed() {
            return (this.mHour == 63 || this.mMinute == 63) ? false : true;
        }

        public String toString() {
            if (!isProgrammed()) {
                return "Transition not programmed";
            }
            return "Transition: " + this.mHour + ":" + this.mMinute + " to state " + this.mTimerState;
        }
    }

    public Timer(int i2) {
        super(i2);
        this.mEnabled = false;
        d.a("Creating timer " + i2);
    }

    public void add(TimerTransition timerTransition) {
        if (this.mTransitions.size() == 56) {
            throw new RuntimeException("Too many transitions");
        }
        d.a("Adding transition: " + timerTransition.toString());
        this.mTransitions.add(timerTransition);
        d.a("There are now " + this.mTransitions.size() + " transitions stored.");
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    public ArrayList<TimerTransition> getTransitions() {
        return this.mTransitions;
    }

    public boolean hasGroupForActivation(Group group) {
        d.a("Checking timer activation on group: ");
        d.a("Timer: " + Integer.toBinaryString(this.mActivationGroups));
        d.a("Group: " + Integer.toBinaryString(group.asMask()));
        boolean z2 = (group.asMask() & this.mActivationGroups) != 0;
        d.a("Group managed by timer? " + z2);
        return z2;
    }

    public boolean hasGroupForDeactivation(Group group) {
        return (group.asMask() & this.mDeactivationGroups) != 0;
    }

    public boolean hasTransitions() {
        return this.mTransitions != null;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean z2) {
        this.mEnabled = z2;
    }

    public void setGroups(int i2, int i3) {
        this.mActivationGroups = i2;
        this.mDeactivationGroups = i3;
    }

    public void setTransitions(ArrayList<TimerTransition> arrayList) {
        this.mTransitions = arrayList;
    }
}
