package InnerClass;

import multiplexClass.page305.SadActor;

/**
 * Created by Administrator on 2016/10/20.
 */
public class AnonymousInnerClass {
   public static Base getBase(int i){
       return new Base(i) {
           {
               System.out.println("Inside instance initializer");
           }
           @Override
           public void f() {
               System.out.println("In anonymous f()");
           }
       };
   }

    public static void main(String[] args) {
        Base base=getBase(47);
        base.f();
    }
}
