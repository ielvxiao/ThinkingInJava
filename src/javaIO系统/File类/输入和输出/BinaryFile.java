package javaIO系统.File类.输入和输出;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/6.
 */
public class BinaryFile {
    public static byte[] read(File bFile) throws IOException{
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));
        try {
            byte[] data = new byte[bf.available()];  //available（）产生恰当的数组尺寸。
            bf.read(data);
            return data;
        } finally {
            bf.close();
        }
    }
    public static byte[] read(String bFile) throws IOException{
        return read(new File(bFile).getAbsoluteFile());
    }

}
