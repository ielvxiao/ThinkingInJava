package Exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/23.
 */
public class InputFile {
    private BufferedReader in;
    public InputFile(String fname) throws Exception{
        try {
            in=new BufferedReader(new FileReader(fname));
        } catch (FileNotFoundException e) {
            System.out.println("Cold not open"+fname);
            throw e;
        }catch (Exception e){
            try {
                in.close();
            } catch (IOException e1) {
                System.out.println("in.close() unsuccessful");
            }
            throw e;}
            finally {
                //Don't close here
            }
        }
    public String getLine(){
        String s;
        try {
            s=in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("rendLine() failed");
        }
        return s;
    }
    public void dispose(){
        try {
            in.close();
            System.out.println("dispsoe() successful");
        } catch (IOException e) {
            throw new RuntimeException("in.close() failed");
        }
    }
}
