package it.tervis.miura.model;

/* JADX INFO: loaded from: classes.dex */
public class RemoteController extends Component {
    private boolean mAccessibleViaApp;
    private State mState;

    public enum State {
        ON,
        OFF,
        UNKNOWN
    }

    public RemoteController(int i2, State state, boolean z2) {
        super(i2);
        State state2 = State.ON;
        this.mState = state;
        this.mAccessibleViaApp = z2;
    }

    public State getState() {
        return this.mState;
    }

    public boolean isAccessibleViaApp() {
        return this.mAccessibleViaApp;
    }

    public void update(RemoteController remoteController) {
        this.mState = remoteController.getState();
    }
}
