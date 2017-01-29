package 容器深入理解.MAP生成器;

import classobject.pack1.类字面常量.Initable;
import 数组.Arrays实用功能.Generator;

import java.util.Iterator;

/**
 * Created by Administrator on 2016/11/15.
 */
class Letters implements Generator<Pair<Integer, String>>,
        Iterable<Integer>{
    private int size = 9;
    private int number = 1;
    private char letter = 'A';
    public Pair<Integer, String> next(){
        return new Pair<Integer, String>(number++, "" + letter++);
    }
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };

    }
}

public class MapDataTest {
    public static void main(String[] args) {
        System.out.println(MapData.map(new Letters(), 11));
        System.out.println(MapData.map(new Letters(), "Pop"));
    }
}
