package genericity.反射;

/**
 * @author Administrator
 * @date 2017/3/11
 */
class ClassLoader1 {
    static {
        System.out.println("我是用ClassLoader执行的");
    }
    {
        System.out.println("我是ClassLoader的非静态代码块");
    }
}

class ClassForName1 {
    static {
        System.out.println("我是用ClassForName执行的");
    }

    {
        System.out.println("我是ClassForName的非静态代码块");
    }
}
public class ClassLoaderAndClassForNameTest {
    public static void main(String[] args) {
        testClassForName(); //ClassForName会加载静态代码块内容
        testClassLoader();  //ClassLoader不会加载静态代码块内容
    }

    private static void testClassLoader() {
        try {
            Class<?> line;
            ClassLoader loader = ClassLoader.getSystemClassLoader();
            line = loader.loadClass("genericity.反射.ClassLoader1");
            System.out.println(line.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void testClassForName() {
        try {
            /**
             * - //Class.forName(String className)  这是1.8的源码
             -    public static Class<?> forName(String className) throws ClassNotFoundException {
             -        Class<?> caller = Reflection.getCallerClass();
             -        return forName0(className, true, ClassLoader.getClassLoader(caller), caller);
             -    }
             - //注意第二个参数，是指Class被loading后是不是必须被初始化。 不初始化就是不执行static的代码即静态代码
             */
            Class point = Class.forName("genericity.反射.ClassForName1");
            System.out.println(point.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
