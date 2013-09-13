package programmering1.obligatorisk1.uke2_lab;
import java.util.Scanner;


/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 13.09.13
 * Time: 23:55
 */

/**
 * Compute the area and perimeter of a rectangle.

 */
public class Exercise2_2 {



    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);




        System.out.print("Enter length of the rectangle: ");
        int a = sc.nextInt();
        System.out.print("Enter breadth of the rectangle: ");
        int b = sc.nextInt();

        int area = a * b;
        int volume = 2 * (a + b);

        System.out.println("The area of the rectangle is: " + area );
        System.out.println("The volume of the rectangle is " + volume);


    }

}
