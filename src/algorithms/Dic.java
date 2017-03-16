package algorithms;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2017/3/15
 */
public class Dic {
    static List<String> isDir(File file,List<String> resultFileName) {
        File[] files = file.listFiles();
        if (files == null) return resultFileName;
        for (File f: files
             ) {
            if (f.isDirectory()){
                resultFileName.add(f.getPath());
                isDir(f, resultFileName);
            } else {
                resultFileName.add(f.getPath());
            }
        }
        return resultFileName;
    }

    public static void main(String[] args) {
        List<String> list = isDir(new File("G:/"), new ArrayList<>());
        for (String s: list
             ) {
            System.out.println(s);
        }
    }
}
