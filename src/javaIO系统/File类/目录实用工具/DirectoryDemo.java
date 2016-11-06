package javaIO系统.File类.目录实用工具;

import java.io.File;

/**
 * Created by Administrator on 2016/11/4.
 * 目录实用工具的使用技巧
 */
public class DirectoryDemo {
    public static void main(String[] args) {
        System.out.println("------打印所有的目录--------");
        PPrint.pprint(Directory.walk(".").dirs);
        System.out.println("------所有以T开头的文件--------");
        for (File file: Directory.local(".","T.*")
             ) {
            System.out.println(file);
        }
        System.out.println("------所有以T开头的java文件--------");
        for (File file:Directory.walk(".","T.*\\.java")
             ) {
            System.out.println(file);
        }
        System.out.println("---------所有包含Z或者z的class文件---------");
        for (File file:Directory.walk(".",".*[Zz].*\\.class")
             ) {
            System.out.println(file);
        }
    }
}
