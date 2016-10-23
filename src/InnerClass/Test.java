package InnerClass;

/**
 * Created by Administrator on 2016/10/20.
 */
public class Test {
//     void pr(){
//        Parcel2 p=new Parcel2();
//      //  Parcel2.Contents pc=p.new Contents();
//         Parcel2.Contents pc =new Parcel2.Contents();
//    }
    public static void main(String[] args) {
        Parcel2 p =new Parcel2();
        p.ship("asdf");
        Parcel2.Contents pc=p.new Contents();  //很奇怪啊。。。。。
        System.out.println(pc.value());
    }
}
