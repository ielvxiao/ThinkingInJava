package InnerClass.dontKnow;

/**
 * Created by Administrator on 2016/10/20.
 */
public class BigEgg2 extends Egg2 {
    public class York extends Egg2.York{
        @Override
        public void f() {
            System.out.println("BigEgg2.f()");;
        }
        public York(){
            System.out.println("BiggEgg2.york()");
        }
    }
    public BigEgg2(){inserYork(new York());}

    public static void main(String[] args) {
        Egg2 E2=new BigEgg2();
       // Egg2 e=new Egg2();
        E2.g();
    }
}
