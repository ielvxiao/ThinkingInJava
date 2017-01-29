package 容器深入理解.填充容器;

import 容器深入理解.CollectionData;
import 数组.Arrays实用功能.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/11/15.
 */
public class Government implements Generator<String> {
    String[] foundation = ("strange women lying in ponds " +
    "distributing swords is no basis for a system of "+
    "government").split(" ");
    private int index;
    @Override
    public String next() {
        return foundation[index++];
    }

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(new CollectionData<>(new Government(), 15));
        set.addAll(CollectionData.list(new Government(), 15));
        System.out.println(set);
    }
}
