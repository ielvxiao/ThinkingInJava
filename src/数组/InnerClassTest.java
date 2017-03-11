package 数组;

/**
 * @author Administrator
 * @date 2017/3/11
 */
public class InnerClassTest {
    private String s1 = "我是非静态类属性";
    private static String s2 = "我是静态类属性";
    static class test{
        private String s3 = s2;
       // private String s4 = s1;
        private static  String s5 = s2;
        //静态内部类不能访问外部类的非静态属性值
    }
    class test1 {
        private String s3 = s2;
        private String s4 = s1;
    }
}
