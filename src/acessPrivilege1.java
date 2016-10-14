import acessPrivilege.*;

/**
 * Created by Administrator on 2016/10/14.
 */
public class acessPrivilege1 extends publicTest{
    public static void main(String[] args){
        publicTest publicTest=new publicTest();
      //  publicTest.bite(); //在acesspivilege中可以访问bite()方法，因为它只有包访问权限
        acessPrivilege1 acessPrivilege1=new acessPrivilege1();
     //   acessPrivilege1.bite(); 将bite方法改为protect则可以访问
    }
    public acessPrivilege1(){System.out.println("protect继承之后可以使用bite()");}
}
