package 容器深入理解.MAP生成器;

/**
 * Created by Administrator on 2016/11/15.
 */
public class Pair<K, V> {
    public final K key;
    public final V value;
//key和value都是public 和 final的，这是为了使Pair成为制度的数据传输对象（信使）
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
