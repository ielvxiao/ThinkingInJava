package 数组.数组与泛型;

/**
 * Created by Administrator on 2016/11/2.
 */
public class ParameterizedArrayType {
    public static void main(String[] args) {
        Integer[] ints={1,2,3,4,5};
        Double[] doubles={1.1,2.2,3.3,4.4,5.5};
        Integer[] ints2=new ClassParameter<Integer>().f(ints);
        Double[] doubles2=new ClassParameter<Double>().f(doubles);
        ints2=MethodParameter.f(ints);
        doubles2=MethodParameter.f(doubles);
    }
}