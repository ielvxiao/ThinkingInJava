package holdingyourobject;

import java.util.*;

/**
 * Created by Administrator on 2016/10/22.
 */
public class PrintingContainers {
    static Collection fill(Collection<String> collection){
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }
    static Map fill(Map<String,String> map){
        map.put("rat","Fuzzy");
        map.put("cat","Rags");
        map.put("dog","Bosco");
        map.put("dog","Spot");
        return map;
    }

    public static void main(String[] args) {
        System.out.println(fill(new ArrayList<String>())); //插入的内容和顺序都会打印
        System.out.println(fill(new LinkedList<String>())); //同AraayList，但是性能不同。
        System.out.println(fill(new HashSet<String>())); //相同的元素只保存一次
        System.out.println(fill(new TreeSet<String>()));//相同元素保存一次，而且元素按照升序排列
        System.out.println(fill(new LinkedHashSet<String>()));//只保存一次。按照插入顺序，和HashSet相同，但是性能不同。
        System.out.println(fill(new HashMap<String,String>())); //{rat=Fuzzy, cat=Rags, dog=Spot} 保存顺序并不是插入顺序，因为HashMap实现使用的是一种非常快的算法控制排序
        System.out.println(fill(new TreeMap<String,String>())); //是按照升序保存键
        System.out.println(fill(new LinkedHashMap<String, String>())); //输入与输出顺序相同，查询速度与HshMap相同。
    }
}
