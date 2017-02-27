package thread;

/**
 * Created by tiptop on 17-2-27.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel() {canceled = true;}
    public boolean isCanceled() {return canceled;}
}
