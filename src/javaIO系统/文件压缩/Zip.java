package javaIO系统.文件压缩;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Administrator on 2016/11/4.
 */
public class Zip {
    public static void main(String[] args) throws IOException{
        File[] files = new File[2];
        files[0]=new File("E:\\新建文件夹\\2016-11-03 17-35-08.xls");
        files[1]=new File("E:\\新建文件夹\\2016-11-03 18-18-05.xls");
        File file=new File("E:\\新建文件夹\\test.zip");
        if (!file.exists()){
            file.createNewFile();
        }
        ZipOutputStream zipOutputStream=new ZipOutputStream(new FileOutputStream(file));
        for (int i = 0; i <files.length ; i++) {
            FileInputStream fileInputStream=new FileInputStream(files[i]);
            zipOutputStream.putNextEntry(new ZipEntry(files[i].getName()));
            int len;
            byte[] buffer = new byte[1024];
            while ((len=fileInputStream.read(buffer))>0){
                zipOutputStream.write(buffer,0,len);
            }
            zipOutputStream.closeEntry();
            fileInputStream.close();
        }
        zipOutputStream.close();
    }
}
