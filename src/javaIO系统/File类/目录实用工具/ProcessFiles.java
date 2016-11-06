package javaIO系统.File类.目录实用工具;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/4.
 * Strategy接口内嵌在ProcessFiles中，使得如果你希望实现它，就必须实现ProcessFiles.Strategy，它为读者提供了更多的上下文信息。ProcessFiles执行了查找具有特定扩展名
 * （传递给构造器的ext参数）的文件所需的全部工作，并且当它找到匹配的文件时，将直接把文件传递给Strategy对象（也是传递给构造器的参数）
 */
public class ProcessFiles {
    public interface Strategy{
        void process(File file);
    }
    private Strategy strategy;
    private String ext;
    public ProcessFiles(Strategy strategy, String ext){
        this.strategy=strategy;
        this.ext=ext;
    }
    public void start(String[] args){
        try {
            if (args.length==0){
                processDirectoryTree(new File("."));
            }else {
                for (String arg:args
                     ) {
                    File fileArg=new File(arg);
                    if (fileArg.isDirectory()){
                        processDirectoryTree(fileArg);
                    }else {
                        if (!arg.endsWith("."+ext)){
                            arg+="."+ext;
                        }
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void processDirectoryTree(File root) throws IOException{
        for (File file: Directory.walk(root.getAbsolutePath(),".*\\."+ext)
             ) {
            strategy.process(file.getCanonicalFile());
        }
    }

    public static void main(String[] args) {
        new ProcessFiles(new ProcessFiles.Strategy(){
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        },"(class|java)").start(args); //可以根据提供的命令来打印相应格式的文件名字。
    }
}
