package programmering1.kode.oblig1;
import java.util.Scanner;      //importerer klassen som leser input
import java.math.BigDecimal;  //skal brukes til å runde av desimalene skikkelig.

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 21.08.13
 * Time: 00:05
 */
public class Oppg2_UttrykkOgInnlesning {

    public static void main (String [] args){


        Scanner sc = new Scanner(System.in);

        System.out.println("Du skal naa taste inn 3 tall. Programmet vil deretter finne gjennomsnittverdien:");
        System.out.print("Velg det foerste tallet: ");
        double tall1 = sc.nextDouble();
        System.out.print("Velg det andre tallet: ");
        double tall2 = sc.nextDouble();
        System.out.print("Velg det tredje tallet: ");
        double tall3 = sc.nextDouble();

        double gjsnitt = (tall1 + tall2 + tall3)/3;

        //kodesnuten nedenfor brukes til aa runde av til 2 desimaler. Bedre aa bruke BigDecimal enn aa bruke  "DecimalFormat" f.eks.
        //BigDecimal gir full kontroll på avrundingen.

        BigDecimal a = BigDecimal.valueOf(gjsnitt);
        BigDecimal rundetav = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);   //

        //resultatet maa selvsagt skrives ut etterpaa
        System.out.print("Gjennomsnittet er: " + rundetav);


    }
}
