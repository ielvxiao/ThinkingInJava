package learning;

/**
 * Created by Administrator on 2016/11/24.
 */
public class TestValueReference {
    void foo(int a) {
        a = 100;
    }

    void foo(String s) {
        s = "window";
    }
    void foo(StringBuilder sb){
        sb.append("4");
    }
    void foo1(StringBuilder stringBuilder) {
        stringBuilder = new StringBuilder("ipad");
    }
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("iphone");
        StringBuilder s1 = s;
        s1.append("4");
        System.out.println(s);
        String str = "hello";
        String str1 = str;
        str1 += "11";
        System.out.println(str);
    }
}
