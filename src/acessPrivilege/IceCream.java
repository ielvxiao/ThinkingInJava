package acessPrivilege;

/**
 * Created by Administrator on 2016/10/14.
 */
public class IceCream {
    public static void main(String[] args){
        Sundae sundae=Sundae.makeASudae();  //不能通过构造器来创建Sundae对象。而必须调用makeAsundae()方法来达到目的
        publicTest publicTest=new publicTest();
        publicTest.bite();
    }
}
