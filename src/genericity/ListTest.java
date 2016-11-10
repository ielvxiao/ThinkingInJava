package genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/9.
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("a");
        s.add("b");
        List<String> a = new ArrayList<String>();
        a.add("a");
        a.add("b");
        System.out.println(s.get(0).getClass());
        System.out.println(s.toString());
        System.out.println(a.toString());
    }
}
