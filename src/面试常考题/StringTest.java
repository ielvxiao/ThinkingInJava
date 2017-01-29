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
