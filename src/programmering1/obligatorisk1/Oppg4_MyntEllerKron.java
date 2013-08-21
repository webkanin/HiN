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
        int mynt = 0;
        int kron = 1;
        String valg = null;

        int brukervalg;
        int tilfeldigtall = (int) (Math.random()*2);

        Scanner sc = new Scanner(System.in);

        System.out.println("Tippeprogram 1.0");
        System.out.println("-----------------");
        System.out.println("For mynt, tast 0");
        System.out.println("For kron, tast 1");
        System.out.print("Ditt valg: ");
        brukervalg = sc.nextInt();

        if (brukervalg==0){
           valg = "MYNT";
        }
        else if(brukervalg==1){
            valg = "KRON";
        }



         System.out.println(" ");
        System.out.println("----------------------------- ");
         System.out.println("Programmet flipper mynten...");
         System.out.println("Det ble " + tilfeldigtall);

        if (tilfeldigtall==brukervalg){
          System.out.println("Du tippet dermed RIKTIG!");
        }
            else {
           System.out.println("Du har dessverre FEIL!");
        }

    }

}
