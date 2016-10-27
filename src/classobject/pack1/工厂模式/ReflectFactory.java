package classobject.pack1.工厂模式;

/**
 * Created by Administrator on 2016/10/27.
 * 这个工厂模式用到了反射现在就算我们添加任意多个子类，工厂类也不需要更改
 * 但是虽然可以通过反射获得接口的实例，但是需要传入完整的包和类名。而且用户也无法知道一个接口有多少个可以使用的子类，所以我们通过属性文件的形式配置所需要的子类。
 */
public class ReflectFactory {
    public static fruit getInstance(String ClassName){
        fruit f=null;
        try {
            f=(fruit)Class.forName(ClassName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return f;
    }

}
class test{
    public static void main(String[] args) {
          fruit f=ReflectFactory.getInstance("classobject.pack1.工厂模式.Apple");
        if(f!=null){
            f.eat();
        }
    }
}
