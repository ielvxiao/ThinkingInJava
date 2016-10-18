package multiplexClass.abstractAndInterface;

/**
 * Created by Administrator on 2016/10/18.
 */
public interface interfacedemo {  //如果接口没有public修饰，则它只具有包访问权限
    //private void asdf(); 系统报错。因为在接口中所有的方法都必须是public的，没有修饰的默认为public
    int value=5; //static and final 这是编译时常量
    void play(); //虽然没有public 但是它也是public的，接口中所有方法都是public 的
   // public addmehodbody(){}    系统提示错误，接口中的方法不能包含方法体
 }
