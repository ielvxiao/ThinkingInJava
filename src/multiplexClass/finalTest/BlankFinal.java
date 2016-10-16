package multiplexClass.finalTest;

/**
 * Created by Administrator on 2016/10/15.
 *  应用空白final可以让一个勒种的final域根据对象不同而不同，而又保持其恒定不变的特性
 */
public class BlankFinal {
    private final int i=0;
    private final int j;
    private final Poppet p;
    public BlankFinal(){
        j=1;   //如果这里和下边不为J赋值，则就会报错，因为final在使用前必须被初始化。
        System.out.println(j);
        p=new Poppet(1);
    }
    public BlankFinal(int x){
        j=x;
        System.out.println(j);
        p=new Poppet(x);
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
        final StringBuffer sb=new StringBuffer();
        sb.append("asdfsa");
        System.out.println(sb);
        sb.append("添加");
        System.out.println(sb);
    }
}
