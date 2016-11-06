package holdingyourobject;

/**
 * Created by Administrator on 2016/10/22.
 */
public class Apple {
    private static long counter;
    private final long id=counter++;
    public long id(){return id;}
}
