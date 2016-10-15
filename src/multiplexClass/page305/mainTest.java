package multiplexClass.page305;

/**
 * Created by Administrator on 2016/10/15.
 */
public class mainTest {
    public static void main(String[] args) {
        Stage stage=new Stage();
        stage.performPlay();
        stage.change(); // private Actor actor=new SadActor();
        stage.performPlay();//所以这里调用的就是SadActor类里的actor()
    }
}
/*
output:
HappyActor
SadActor


 */