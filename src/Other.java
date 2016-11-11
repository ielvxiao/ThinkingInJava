import java.io.*;
import java.net.URLDecoder;
import java.util.Properties;

/**
 * Created by Administrator on 2016/11/11.
 */
public class Other {
    public static String readValue(String proper){
        Properties properties = new Properties();
        File f = new File(Other.class.getResource("ok.properties").getFile());
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(f),"GBK"); //草。。这个编码要和properties一样。。。
            BufferedReader bf = new BufferedReader(reader);
            properties.load(bf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties.getProperty(proper);
    }

    public static void main(String[] args) throws Exception{
        File file = new File("D:\\test.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write("我是中国人！");
        fileWriter.close();
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));   //因为idea默认编码为utf-8所以写入的时候是utf-8读的时候也是
//        String s = null;
//        while ((s=br.readLine()) != null)
//            System.out.println(s);
//        br.close();
        InputStream inputStream = new FileInputStream(file);
        int i;
        byte[] bytes = new byte[1024];
        while ((i=inputStream.read(bytes)) != -1)
            System.out.write(bytes, 0, i);  //直接输出读取的内容
    }
}
