package genericity.泛型方法;

/**
 * Created by Administrator on 2016/10/27.
 */
public class P632 {
    public <T> void f(T x){
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        P632 gm=new P632();
        gm.f(" ");
        gm.f(1);         //如果传入基本类型，自动打包机制会介入其中，将基本类型包装秤对应的对象。泛型方法和自动打包避免了许多以前我们不得不自己编写出来的代码
        gm.f(1.0);
        gm.f(1.0f);
        gm.f('c');
        gm.f(gm);
    }
}
/*
output:
java.lang.String
java.lang.Integer
java.lang.Double
java.lang.Float
java.lang.Character
genericity.泛型方法.P632
 */