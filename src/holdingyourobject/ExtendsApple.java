package holdingyourobject;


/**
 * Created by Administrator on 2016/10/22.
 */
public class ExtendsApple extends Apple {
    @Override
    public long id() {
        return super.id()+1;
    }
}
