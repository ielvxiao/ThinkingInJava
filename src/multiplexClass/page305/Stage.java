package multiplexClass.page305;

/**
 * Created by Administrator on 2016/10/15.
 */
public class Stage {
    private Actor actor=new HappyActor();
    public void change(){actor=new SadActor();}
    public void performPlay(){actor.act();}
}
