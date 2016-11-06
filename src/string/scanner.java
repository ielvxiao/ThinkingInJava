package string;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/10/24.
 */
public class scanner {
    public static void main(String[] args) {
        Scanner stdin=new Scanner(System.in);
        System.out.println("whar is your name");
        String name=stdin.nextLine();
        System.out.println(name);
        System.out.println("How old are you?");
        System.out.println("(input: <age> <double>)");
        int age=stdin.nextInt();
        double favorite=stdin.nextDouble();
        System.out.println(age);
        System.out.println(favorite);
        System.out.format("Hi %s.\n",name);
        System.out.format("In 5 years you will be %d.\n",age+5);
        System.out.format("My favorite double is %f.",favorite/2);
    }
}
