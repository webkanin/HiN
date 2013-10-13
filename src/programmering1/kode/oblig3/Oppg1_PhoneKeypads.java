package programmering1.kode.oblig3;
import java.util.*;

public class Oppg1_PhoneKeypads {

    public static void main(String[] args){

        System.out.print("Enter a string: ");

        Scanner input = new Scanner(System.in);

        String phNumber = input.next();

        String output = "";

        for(int i = 0 ; i < phNumber.length() ; i++){

            char ch = Character.toUpperCase(phNumber.charAt(i));

            if(Character.isLetter(ch)){

                int digit = getNumber(ch);

                output = output + digit;

            }

            else{

                output = output + ch;

            }

        }

        System.out.println(output);

    }

    public static int getNumber(char upperCaseLetter){

        if(upperCaseLetter == 'A' || upperCaseLetter == 'B'   || upperCaseLetter == 'C')

        return 2;

        else if(upperCaseLetter == 'D' || upperCaseLetter == 'E'    || upperCaseLetter == 'F')

        return 3;

        else if(upperCaseLetter == 'G' || upperCaseLetter == 'H'

                || upperCaseLetter == 'I')

        return 4;

        else if(upperCaseLetter == 'J' || upperCaseLetter == 'K'

                || upperCaseLetter == 'L')

        return 5;

        else if(upperCaseLetter == 'M' || upperCaseLetter == 'N'

                || upperCaseLetter == 'O')

        return 6;

        else if(upperCaseLetter == 'P' || upperCaseLetter == 'Q'

                || upperCaseLetter == 'R')

        return 7;

        else if(upperCaseLetter == 'S' || upperCaseLetter == 'T'

                || upperCaseLetter == 'U')

        return 8;

        else if(upperCaseLetter == 'V' || upperCaseLetter == 'W'

                || upperCaseLetter == 'Y' || upperCaseLetter == 'Z')

        return 9;

        else

        return 0;

    }

}