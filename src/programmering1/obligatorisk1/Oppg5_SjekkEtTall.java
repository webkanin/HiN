package programmering1.obligatorisk1;
import java.util.Scanner;      //importerer klassen som leser input

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 21.08.13
 * Time: 00:08
 */
public class Oppg5_SjekkEtTall {

    static int tall;

    public static void main(String [] args){




    System.out.print("Tast inn ett tall:");


        divideBy3Check();
        divideBy7Check();


    }

    static void divideBy3Check(){

        String info = null;
        Scanner scan = new Scanner(System.in);

        tall=scan.nextInt();
        if(tall%3==0){

            info="Tallet kan deles med 3";
        }

        else{
            info="Tallet kan IKKE deles med 3";
        }

        System.out.println(info);

    }


    static void divideBy7Check(){

        String info2 = null;
        Scanner scan = new Scanner(System.in);

        tall=scan.nextInt();
        if(tall%7==0){

            info2="Tallet kan deles med 7";
        }

        else{
            info2="Tallet kan IKKE deles med 7";
        }

        System.out.println(info2);
    }

}