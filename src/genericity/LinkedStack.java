package genericity;

/**
 * Created by Administrator on 2016/10/27.
 */
public class LinkedStack<T> {
    private static class Node<U>{
        U item;
        Node<U> next;
        Node(){item=null;next=null;}
        Node(U item,Node<U> next){
            this.item=item;
            this.next=next;
        }
         boolean end(){return item==null&&next==null;}
    }
    private Node<T> top=new Node<T>(); //end entinel末端哨兵，來判斷堆棧何時為空
    public void push(T item){
        top=new Node<T>(item,top);
    }
    public T pop(){
        T result=top.item;
        if (!top.end()){
            top=top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss=new LinkedStack<String>();
        for (String s: "PHasers on stun!".split(" ")
             ) {
            lss.push(s);
        }
        String s;  //这个s和for循环里的s不同。可以把这个s换掉。在for循环中，是往lss里添加s。。下边的 s是从s中pop()
        while ((s=lss.pop()) !=null){
            System.out.println(s);
        }
    }
}
