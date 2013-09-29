package programmering1.kode.oblig1;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 21.08.13
 * Time: 00:05
 */
public class Oppg3_UttrykkOgInnlesning {

    static double x1, y1, x2, y2; //koordinatene til to punkt
    static double distance;       //distansen mellom punktene

    public static void main (String [] args){



        Scanner scan = new Scanner(System.in);

        // Lese inn de to punktene

        System.out.print ("Tast inn koordinatene til foerste punkt: " + "(bruk mellomrom mellom dem): ");
        x1 = scan.nextDouble();
        y1 = scan.nextDouble();

        System.out.print ("Tast inn koordinatene til andre punkt: ");
        x2 = scan.nextDouble();
        y2 = scan.nextDouble();

        //Beregningn av avstanden

        distance = Math.sqrt((Math.pow((x1-x2),2))+(Math.pow((y1-y2),2)));


        //Utskriving av svar
        System.out.println(distance);

    }


}
