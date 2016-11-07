package javaIO系统;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2016/11/7.
 */
public class FileCreate {
    public static void main(String[] args) throws Exception{
        File file = new File("c:"+File.separator+"a.txt");
        OutputStream os = new FileOutputStream(file,true);
        int i =0;
        while (i< 10){
            os.write(("我是"+i).getBytes());
            i++;
        }
      os.close();
    }
}
