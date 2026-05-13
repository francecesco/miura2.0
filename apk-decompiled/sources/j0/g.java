package j0;

import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes.dex */
public class g extends LinkedBlockingDeque {
    @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
    public boolean offer(Object obj) {
        if (!(obj instanceof h) || !((h) obj).b()) {
            return super.offer(obj);
        }
        addFirst(obj);
        return true;
    }
}
