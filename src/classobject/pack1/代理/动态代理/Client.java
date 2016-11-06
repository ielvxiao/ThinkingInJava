package classobject.pack1.代理.动态代理;

import classobject.pack1.代理.UserManager;
import classobject.pack1.代理.UserManagerImpl;

/**
 * Created by Administrator on 2016/10/27.
 */
public class Client {


    public static void main(String[] args) {
        LogHandler logHandler=new LogHandler();
        UserManager userManager=(UserManager) logHandler.newProxyInstance(new UserManagerImpl());
        userManager.addUser("122","safdas");
        System.out.println(userManager.findUser("122"));
    }
}
/*
可以看到，我们可以通过LogHandler代理不同类型的对象，如果我们把对外的接口都通过动态代理来实现，那么所有的函数调用最终都会经过invoke函数的转发，
因此我们就可以在这里做一些自己想做的操作，比如日志系统、事务、拦截器、权限控制等。这也就是AOP(面向切面编程)的基本原理。

动态代理与静态代理相比较，最大的好处是接口中声明的所有方法都被转移到调用处理器一个集中的方法中处理（InvocationHandler.invoke）。
这样，在接口方法数量比较多的时候，我们可以进行灵活处理，而不需要像静态代理那样每一个方法进行中转。而且动态代理的应用使我们的类职责更加单一，复用性更强
 */