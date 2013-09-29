package programmering1.kode.oblig2;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 26.08.13
 * Time: 20:03
 */


public class Oppg1_isSorted {


    public static void main(String[] args) {

     int antallTall = 0;

        int[] array;    //oppretter liste

        Scanner sc = new Scanner(System.in);

        System.out.println("Oppgave 1");
        System.out.print("Tast inn antall elementer listen skal inneholde og trykk ENTER: ");
        antallTall = sc.nextInt();     //setter st0rrelse paa array-et

        System.out.print("Tast inn " + antallTall + " tall, separer de med MELLOMROM og trykk ENTER: ");
        array = new int[antallTall];    //oppretter nytt array med st0rrelsen gitt i forrige punkt.

        for (int i=0; i<antallTall; i++){    //populerer arrayet ved bruk av for-l0kke
            array[i] = sc.nextInt();
        }

        boolean output = isSorted(array);    //variabelen er laget kun for aa kunne presentere resultatet paa en finere maate. Ellers kunne en printet ut metoden isSorted(array) direkte for en enkel true/false

        if (output==true){
            System.out.println("Listen er sortert");
        }
        else {
            System.out.println("Listen er IKKE sortert");
        }


    }

    public static boolean isSorted(int[] list) {

        boolean sorted = true;

        for (int i = 0; i < list.length - 1; i++)
        {
            if (list[i+1] < list[i])
            {
                sorted = false;
                break;
            }
        }
        return sorted;
    }

}
