package InnerClass;


/**
 * Created by Administrator on 2016/10/20.
 */
public class ThisAndNewTest {
    public static void main(String[] args) {
        ThisAndNew t=new ThisAndNew();
        ThisAndNew.In in=t.new In(); //要想直接创建内部类，你不嗯给你按照你想象的方式，去引用外部类名字。而必须使用外部类的对象来创建内部类对象。这也解决了作用域的问题
        in.print();
        ThisAndNew.abc a=new ThisAndNew.abc(); //对比一下，如果你创建的是嵌套类（静态内部类），那么它就不需要对外部类对象的引用。非静态内部类则需要对外部类对象进行引用。如上所示
        a.print();
    }
}
