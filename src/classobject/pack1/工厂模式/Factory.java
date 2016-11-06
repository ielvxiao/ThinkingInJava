package classobject.pack1.工厂模式;

/**
 * Created by Administrator on 2016/10/27.
 * 也就是我们在添加其他实例的时候只需要运行工厂模式即可。。
 * 这个工厂模式是没有利用反射模式的工厂模式
 */
public class Factory {

    public static fruit getInstance(String fruitName){
        fruit f=null;
        if("Apple".equals(fruitName)){
            f=new Apple();
        }
        if("Orange".equals(fruitName)){
            f=new Orange();
        }
        return f;
    }
}
class hello{
    public static void main(String[] a){
        fruit f=Factory.getInstance("Orange");
        f.eat();
    }
}
