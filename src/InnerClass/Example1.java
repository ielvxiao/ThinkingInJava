package InnerClass;

/**
 * Created by Administrator on 2016/10/20.
 */
public class Example1 {
    private int age = 12;

    public void Print(int x) {
        class In {
            public void inPrint() {
                System.out.println(x);
                System.out.println(age);
            }
        }
        new In().inPrint();
    }
}
