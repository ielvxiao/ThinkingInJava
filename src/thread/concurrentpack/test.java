package thread.concurrentpack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2017/3/11
 */
public class test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        System.out.println(map.get("a"));
    }
}
