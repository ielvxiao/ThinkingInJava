# ThinkingInJava
##自学JAVA的一些练习。


###面试常考题
```
package 面试常考题;
 
 /**
  * Created by Clark on 2017/1/20.
  *
  */
 public class StringTest {
     public static void main(String[] args) {
         String str1 = "hello";
         String str2 = "he" + new String("llo");
         String str3 = "hello";
         System.err.println(str1 == str2);
         System.out.println(str1 == str3);
         System.out.println(str1.equals(str2));
     }
 }
 ```
 解析：
 
1.基本数据类型，也称原始数据类型。byte,short,char,int,long,float,double,boolean 
  他们之间的比较，应用双等号（==）,比较的是他们的值。 

2.复合数据类型(类) 
  当他们用（==）进行比较的时候，比较的是他们在内存中的存放地址，所以，除非是同一个new出来的对象，他们的比较后的结果为true，否则比较后结果为false。 JAVA当中所有的类都是继承于Object这个基类的，在Object中的基类中定义了一个equals的方法，这个方法的初始行为是比较对象的内存地 址，但在一些类库当中这个方法被覆盖掉了，如String,Integer,Date在这些类当中equals有其自身的实现，而不再是比较类在堆内存中的存放地址了。
  对于复合数据类型之间进行equals比较，在没有覆写equals方法的情况下，他们之间的比较还是基于他们在内存中的存放位置的地址值的，因为Object的equals方法也是用双等号（==）进行比较的，所以比较后的结果跟双等号（==）的结果相同。

``` 
package 面试常考题;
  
  /**
   * AUTHOR: Administrator
   * DATE: 2017/1/20
   */
  public class Null {
      public static void haha(){
          System.out.println("haha");
      }
      public static void main(String[] args) {
          ((Null)null).haha();
      }
  }
  ```
  解析：输出为haha，因为null值可以强制转换为任何java类类型,(String)null也是合法的。但null强制转换后是无效对象，其返回值还是为null，而static方法的调用是和类名绑定的，不借助对象进行访问所以能正确输出。反过来，没有static修饰就只能用对象进行访问，使用null调用对象肯定会报空指针错了。这里和C++很类似。这里感谢@Florian网友解答。
  
```  
package 面试常考题;
  
  /**
   * AUTHOR: Administrator
   * DATE: 2017/1/20
   */
  class HelloA {
  
      public HelloA() {
          System.out.println("HelloA");
      }
  
      { System.out.println("I'm A class"); }
  
      static { System.out.println("static A"); }
  
  }
  
  public class HelloB extends HelloA {
      public HelloB() {
          System.out.println("HelloB");
      }
  
      { System.out.println("I'm B class"); }
  
      static { System.out.println("static B"); }
  
      public static void main(String[] args) {
  
          System.out.println("-------main start-------");
          new HelloB();
          new HelloB();
          System.out.println("-------main end-------");
      }
  }
  ```
   解析：对象的初始化顺序：（1）类加载之后，按从上到下（从父类到子类）执行被static修饰的语句；（2）当static语句执行完之后,再执行main方法；（3）如果有语句new了自身的对象，将从上到下执行构造代码块、构造器（两者可以说绑定在一起）。
 ```  
   package 面试常考题;
   
   /**
    * AUTHOR: Administrator
    * DATE: 2017/1/20
    */
   public class Foo {
       public static void main(String[] args) {
           String s;
           System.out.println("s = " + s);
       }
   }
   ```
s没有初始化至于初始化才能输出值