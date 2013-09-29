package programmering1.kode.uke2_lab;
import java.util.Scanner;


/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 13.09.13
 * Time: 23:56
 */
public class Exercise2_4 {


    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);


      System.out.print("Enter the number of bits ");

        double a = sc.nextDouble();
        double bytes = a / 8;

        System.out.print(a + " bits is " + bytes + " bytes ");

    }


}
