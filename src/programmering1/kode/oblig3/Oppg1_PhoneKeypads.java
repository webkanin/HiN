package programmering1.kode.oblig3;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 09.10.13
 * Time: 11:03
 */

public class Oppg1_PhoneKeypads {

    public static void main(String[] args){

        System.out.print("Enter a string: ");                //bruker input ved hjelp av Scanner
        Scanner input = new Scanner(System.in);
        String phNumber = input.next();

        String output = "";  //initialiserer en tom variabel av typen String

        for(int i = 0 ; i < phNumber.length() ; i++){    //gjennomgar hver karakter frem til alle er traversert gjennom

            char ch = Character.toUpperCase(phNumber.charAt(i));    //initialiserer variable av typen char, gj0r alle om til Uppercase for lettere sammenligning etterpaa

            if(Character.isLetter(ch)){        //dersom tegnet er av typen bokstav, saa skal getNumber() metoden kj0res for aa gj0re denne om til tall.
                int digit = getNumber(ch);
                output = output + digit;
            }

            else{

                output = output + ch;
            }
        }

        System.out.println(output);
    }

    public static int getNumber(char upperCaseLetter){     //denne er ganske selvforklarende, her sammenlignes de forskjellige tegn, naar en match finnes saa returneres bestemt tallverdi

        if(upperCaseLetter == 'A' || upperCaseLetter == 'B'   || upperCaseLetter == 'C')
        return 2;

        else if(upperCaseLetter == 'D' || upperCaseLetter == 'E'    || upperCaseLetter == 'F')
        return 3;

        else if(upperCaseLetter == 'G' || upperCaseLetter == 'H' || upperCaseLetter == 'I')
        return 4;

        else if(upperCaseLetter == 'J' || upperCaseLetter == 'K'  || upperCaseLetter == 'L')
        return 5;

        else if(upperCaseLetter == 'M' || upperCaseLetter == 'N' || upperCaseLetter == 'O')
        return 6;

        else if(upperCaseLetter == 'P' || upperCaseLetter == 'Q' || upperCaseLetter == 'R')
        return 7;

        else if(upperCaseLetter == 'S' || upperCaseLetter == 'T' || upperCaseLetter == 'U')
        return 8;

        else if(upperCaseLetter == 'V' || upperCaseLetter == 'W' || upperCaseLetter == 'Y' || upperCaseLetter == 'Z')
        return 9;

        else
        return 0;

    }

}