package InnerClass;

/**
 * Created by Administrator on 2016/10/20.
 */
public class ThisAndNew {
    private String string="我是外部变量";
    class In{
         String string="我是内部变量";
        void print(){
            String string="我是局部变量";
            System.out.println("局部变量"+string); //如果没有局部变量会自动访问同名的内部变量，如果没有内部变量，则会访问外部变量
          System.out.println("内部变量"+this.string); //this. 就代表访问内部变量
            System.out.println("外部变量"+ThisAndNew.this.string); //访问外部变量
        }
    }
    static class abc{
        void print(){
            System.out.println("我是静态内部类");
        }
    }

}
