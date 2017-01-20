package 容器深入理解.list的功能与方法;

import java.util.*;

/**
 * Created by Administrator on 2016/11/23.
 */
public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;
    public static void basicTest(List<String> a){
        a.add(1,"x");
        a.add("x");
        a.add("y");
        a.contains("x");
        s = a.get(1);
        i = a.indexOf("x");
        b = a.isEmpty();
        it = a.iterator();
        lit = a.listIterator();
        lit = a.listIterator(3);
        a.remove(1);
        a.remove("y");
        i = a.size();
        a.clear();
    }

    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        Iterator<String> it = c.iterator();
        c.add("object");
        try {
            String s = it.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
