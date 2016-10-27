package classobject.pack1.工厂模式;

import java.io.*;
import java.util.*;
/**
 * Created by Administrator on 2016/10/27.
 */
public class OtherFactory {

}


//操作属性文件类
class init{
    public static Properties getPro() throws FileNotFoundException, IOException{
        Properties pro=new Properties();
        File f=new File("fruit.properties");
        if(f.exists()){
            pro.load(new FileInputStream(f));
        }else{
            pro.setProperty("apple", "classobject.pack1.工厂模式.Apple");
            pro.setProperty("orange", "classobject.pack1.工厂模式.Orange");
            pro.store(new FileOutputStream(f), "FRUIT CLASS");
        }
        return pro;
    }
}

class hello1{
    public static void main(String[] a) throws FileNotFoundException, IOException{
        Properties pro=init.getPro();
        fruit f=ReflectFactory.getInstance(pro.getProperty("apple"));
        if(f!=null){
            f.eat();
        }
    }
}