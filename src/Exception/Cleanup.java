package Exception;

/**
 * Created by Administrator on 2016/10/23.
 */
public class Cleanup {
    public static void main(String[] args) {
        try {
            InputFile in=new InputFile("Cleanup.java");
            try {
                String s;
                int i=1;
                while ((s=in.getLine()) != null);
            } catch (Exception e) {
                System.out.println("Caught Exception in main");
                e.printStackTrace(System.out);
            } finally {
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println("Input file construction failed");;
        }
    }
}
