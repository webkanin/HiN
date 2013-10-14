package programmering1.kode.oblig3;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 12.10.13
 * Time: 18:34
 */
public class Oppg3_Main {


    public static void main (String[] args){
         Oppg3_Circle2D sirkel_test = new Oppg3_Circle2D(2,2,5.5);     //oppretter objektet gjennom kontruk0ren og spesifiserer en sirkel med x=2, y=2 og radius paa 5.5

        System.out.println("Area is " + sirkel_test.getArea()); //kaller paa get.Area gjennom det nye objektet for aa returnere Areal.
        System.out.println("Perimeter is: " + sirkel_test.getPerimiter());     //samme som overnevnte, bare naa for omkrets.
        System.out.println(sirkel_test.containsPoint(1, 2));   //her kan vi definere et nytt punkt, som saa skal sjekkes for belligenhet innforbi sirkelen.
        System.out.println(sirkel_test.containsInside(new Oppg3_Circle2D(34, 34, 2)));    //samme for overnevnte. Men her definerer vi en sirkel med koordinater x=34, y=34, rad=2 (som ligger utforbi)
        System.out.println(sirkel_test.circleOverlaps(new Oppg3_Circle2D(14, 14, 65)));  //Her defineres ny sirkel. x=14, y=14, radius 65 (stor radius for aa overlappe. Skal returnere true.
    }



}
