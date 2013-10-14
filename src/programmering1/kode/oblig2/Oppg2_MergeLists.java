package programmering1.kode.oblig2;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 23.09.13
 * Time: 21:07
 */

public class Oppg2_MergeLists {


    public static void main(String []args){

        int[] output;
        int[] liste1;
        int[] liste2;


        int antallTall = 0;

     Scanner sc = new Scanner(System.in);

        System.out.println("Oppgave 2");
        //populering av f0rste array
        System.out.print("Tast inn antall elementer F0rste listen skal inneholde og trykk ENTER: ");
        antallTall = sc.nextInt();

        System.out.print("Tast inn " + antallTall + " tall, separer de med MELLOMROM og trykk ENTER: ");
        liste1 = new int[antallTall];

        for (int i = 0; i < antallTall; i++)
        {

            liste1[i] = sc.nextInt();
        }

        //populering av andre array
        System.out.print("Tast inn antall elementer ANDRE listen skal inneholde og trykk ENTER: ");
        antallTall = sc.nextInt();

        System.out.print("Tast inn " + antallTall + " tall, separer de med MELLOMROM og trykk ENTER: ");
        liste2 = new int[antallTall];


        for (int i = 0; i < antallTall; i++)
        {

            liste2[i] = sc.nextInt();
        }


        output = merge(liste1, liste2);
        System.out.println("Listene blandes og det ser slik ut: ");
        for (int i = 0; i < output.length; i++)
        {
            System.out.print(output[i] + " ");
        }

    }

    public static int[] merge(int[] liste1, int[] liste2) {

        int[] listenBlandet;   //for aa blande to arrays, saa maa det opprettes et nytt array som skal inneholde begge.

        listenBlandet = new int[liste1.length + liste2.length];

        int j, k;
        j = 0;
        k = 0;

        for (int i = 0; i < listenBlandet.length; i++)
        {
            if ( (j < liste1.length) && (k < liste2.length)  )
            {
                if (liste1[j] > liste2[k])
                {
                    listenBlandet[i] = liste2[k];
                    k++;
                }
                else if (liste1[j] <= liste2[k])
                {
                    listenBlandet[i] = liste1[j];
                    j++;
                }


            } else if (j >= liste1.length)
            {
                listenBlandet[i] = liste2[k];
                k++;

            } else if (k >= liste2.length)
            {
                listenBlandet[i] = liste1[j];
                j++;
            }

        }
        return listenBlandet;
    }
}