package javaIO系统.File类;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/11/2.
 */
public class DirFilter implements FilenameFilter {
    private Pattern pattern;
    public DirFilter(String regex){
        pattern=Pattern.compile(regex);
    }
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
