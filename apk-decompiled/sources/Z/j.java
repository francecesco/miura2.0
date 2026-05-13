package Z;

/* JADX INFO: loaded from: classes.dex */
public class j extends c {
    public j(byte[] bArr) {
        super(bArr);
    }

    @Override // Y.b
    protected void h() {
        if (this.f582b != null) {
            j0.d.a("GroupsActivationStatusMessageResponse: ");
            j0.d.d(this.f583c);
            j0.d.a("- there is something to be parsed here!");
            t();
            j0.d.a("- ActiveGroupsMask: " + this.f622h);
            j0.d.a("- PartiallyActiveGroupsMask: " + this.f623i);
            j0.d.a("- AlarmMemoryGroupsMask: " + this.f624j);
            j0.d.a("- ZoneGroupsMask: " + this.f625k);
            j0.d.a("- ZoneFailureGroupsMask: " + this.f626l);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString() + "\n");
        return stringBuffer.toString();
    }
}
