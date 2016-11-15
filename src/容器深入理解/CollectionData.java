package 容器深入理解;


import 数组.Arrays实用功能.Generator;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/9.
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity){
        for (int i = 0; i < quantity ; i++) {
            add(gen.next());
        }
    }
    public static <T> CollectionData<T> list(Generator<T> gen, int quantity){
        return new CollectionData<T>(gen,quantity);
    }
}
