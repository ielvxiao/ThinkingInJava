package multiplexClass.onlineExample;

/**
 * Created by Administrator on 2016/10/15.
 */
public class main {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println(a1.show(b));
        System.out.println(a1.show(c));
        System.out.println(a1.show(d));
        System.out.println(a2.show(b)); //实例对象为A。参数为B。应该执行A的show(A),但是B重写了show(A)
        System.out.println(a2.show(c)); //同上
        System.out.println(a2.show(d)); //执行A的show(D)
        System.out.println(b.show(b)); //实例对象为B
        System.out.println(b.show(c));
        System.out.println(b.show(d));
    }
}
