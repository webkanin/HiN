package programmering1.obligatorisk1;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 21.08.13
 * Time: 00:07
 */
public class Oppg4_MyntEllerKron {


    public static void main(String [] args){

        String valg_tekst = null;   //ønsker å gi teksttilbakemelding til brukeren, måtte dermed ha par nye variabler av typen String for å få det til i IF setningene.
        String tilfeldigtall_tekst = null;

        int brukervalg;
        int tilfeldigtall;
        tilfeldigtall = (int) (Math.random()*2); //denne variablene får en verdi med en gang programmet har startet.

        Scanner sc = new Scanner(System.in);

        System.out.println("Tippeprogram 1.0");
        System.out.println("-----------------");
        System.out.println("For mynt, tast 0");
        System.out.println("For kron, tast 1");
        System.out.print("Ditt valg: ");
        brukervalg = sc.nextInt();

        if (brukervalg==0){
           valg_tekst = "MYNT";
        }
        else if(brukervalg==1){
            valg_tekst = "KRON";
        }
        else {
           valg_tekst = "ingen av delene";
        }
        System.out.print("Du tippet " + valg_tekst);


       //programmet skriver ut resultatene nedenfor:
        System.out.println(" ");
        System.out.println("----------------------------- ");

        if (tilfeldigtall==0){
            tilfeldigtall_tekst = "MYNT";
        }
        else if(tilfeldigtall==1){
            tilfeldigtall_tekst = "KRON";
        }
             System.out.println("Programmet flipper..." + tilfeldigtall_tekst);


        if (tilfeldigtall==brukervalg){
             System.out.println("Du tippet dermed RIKTIG!");
        }
            else {
             System.out.println("Du har dessverre FEIL!");
        }

    }

}
