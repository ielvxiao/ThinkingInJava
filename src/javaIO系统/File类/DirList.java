package javaIO系统.File类;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/11/2.
 */
public class DirList {
    public static void main(String[] args) {
        File path=new File("D:\\ideaworkplace\\ThinkingInJava\\src\\javaIO系统\\File类");
        String[] list;
        if (args.length==0)
            list=path.list(); //不带参数的lit()方法，获得此File对象包含的全部列表。如果我们想获得一个受限列表，则用目录过滤器
        else
         //   list=path.list(new DirFilter(args[0]));
        //或者使用匿名内部类一次性解决问题。此方法的一个优点就是将解决特点问题的代码隔离、聚拢于一点，但是不易阅读需要谨慎使用。
        list=path.list(new FilenameFilter() {
            private Pattern pattern=Pattern.compile(args[0]);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem:list
             ) {
            System.out.println(dirItem);
        }
    }
}
