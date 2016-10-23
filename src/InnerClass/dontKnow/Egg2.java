package InnerClass.dontKnow;

/**
 * Created by Administrator on 2016/10/20.
 */
public class Egg2 {
    protected class  York{
        public York(){
            System.out.println("Egg2.yolk()");
        }
        public void f(){
            System.out.println("Egg2.yolk().f()");
        }
    }
    protected class base{
        public base(){
            System.out.println("asdfsafsdsadadddddddddddddddddd");
        }
    }
    private base b=new base();
    private York y =new York();
    public Egg2(){
        System.out.println("new Egg2");
    }
    public void inserYork(York yy){y=yy;}
    public void g(){y.f();}

}
