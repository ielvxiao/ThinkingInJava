package Exception;

/**
 * Created by Administrator on 2016/10/23.
 */
public class Switch {
    private boolean state=false;

    public boolean read() {
        return state;
    }
    public void on(){
        state=true;
        System.out.println(this);
    }
    public void off(){
        state=false;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return state ? "no" : "off";

    }

    public static void main(String[] args) {
        Switch sw=new Switch();
        try {
            sw.on();
        } catch (Exception e) {
            e.printStackTrace();
           // sw.off(); 没必要在这里写，因为finally总会被执行。不管catch有几个。。但是如果没有finally那么每个catch里边都要写一个。sw.off()
        } finally {
            sw.off(); //finally  无论try块是否有抛出，finally总会执行。所以它用来清理资源。
        }
    }
}
