package genericity;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2016/10/27.
 */
public class RandomList<T> {
    private ArrayList<T> storage=new ArrayList<T>();
    private Random rand=new Random(47);
    public void add(T item){storage.add(item);}
    public T select(){
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs=new RandomList<String>();
        for (String s:"the quick sfds sdfxx 2s23 14sdx".split(" ")
             ) {
            rs.add(s);
        }
        for (int i = 0; i <11 ; i++) {
            System.out.println(rs.select()+" ");
        }
    }
}
