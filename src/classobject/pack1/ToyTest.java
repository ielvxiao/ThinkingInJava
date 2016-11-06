package classobject.pack1;


/**
 * Created by Administrator on 2016/10/25.
 */
public class ToyTest {
    static void printInfo(Class cc){
        System.out.println("Class name: "+cc.getName()+
        " is interface? ["+cc.isInterface()+"]");
        System.out.println("Simple name : "+cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
        System.out.println();
    }

    public static void main(String[] args) {
        Class c=null;
        try {
            c=Class.forName("classobject.pack1.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Con't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face: c.getInterfaces()
             )
              printInfo(face);
            Class up=c.getSuperclass();
            Object obj=null;
        try {
            obj=up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Canot instantice");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("canot access");
            System.exit(1);
        }
       printInfo(obj.getClass());
    }
}
