package programmering1.kode.oblig3;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 10.10.13
 * Time: 11:56
 */

public class Oppg2_GuessTheCapitals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);     //Scanner klassen for brukerinput
        String[][] stateCapital = {                //Her opprettes en multidimensional array som inneholder de respektive statene og hovedstadene.
                { "Alabama", "Montgomery" },
                { "Alaska", "Juneau" },
                { "Arizona", "Phoenix" },
                { "Arkansas", "Little Rock" },
                { "California", "Sacramento" },
                { "Colorado", "Denver" },
                { "Connecticut", "Hartford" },
                { "Delaware", "Dover" },
                { "Florida", "Tallahassee" },
                { "Georgia", "Atlanta" },
                { "Hawaii", "Honolulu" },
                { "Idaho", "Boise" },
                { "Illinois", "Springfield" },
                { "Indiana", "Indianapolis" },
                { "Iowa", "Des Moines" },
                { "Kansas", "Topeka" },
                { "Kentucky", "Frankfort" },
                { "Louisiana", "Baton Rouge" },
                { "Maine", "Augusta" },
                { "Maryland", "Annapolis" },
                { "Massachusettes", "Boston" },
                { "Michigan", "Lansing" },
                { "Minnesota", "Saint Paul" },
                { "Mississippi", "Jackson" },
                { "Missouri", "Jefferson City" },
                { "Montana", "Helena" },
                { "Nebraska", "Lincoln" },
                { "Nevada", "Carson City" },
                { "New Hampshire", "Concord" },
                { "New Jersey", "Trenton" },
                { "New York", "Albany" },
                { "New Mexico", "Santa Fe" },
                { "North Carolina", "Raleigh" },
                { "North Dakota", "Bismark" },
                { "Ohio", "Columbus" },
                { "Oklahoma", "Oklahoma City" },
                { "Oregon", "Salem" },
                { "Pennslyvania", "Harrisburg" },
                { "Rhode Island", "Providence" },
                { "South Carolina", "Columbia" },
                { "South Dakota", "Pierre" },
                { "Tennessee", "Nashville" },
                { "Texas", "Austin" },
                { "Utah", "Salt Lake City" },
                { "Vermont", "Montpelier" },
                { "Virginia", "Richmond" },
                { "Washington", "Olympia" },
                { "West Virginia", "Charleston" },
                { "Wisconsin", "Madison" },
                { "Wyoming", "Cheyenne" } };

        int correctCount = 0;   //egen variabel for aa holde tellingen. For hvert rett svar inkrementeres denne i++.

        for (int i = 0; i < stateCapital.length; i++){   //traverserer gjennom arrayet
            System.out.println("What is the capital of " + stateCapital[i][0] + "?");    //plukker ut stateCapital i rekkef0lge
            String capital =  scan.next();          //scanner brukerinput

            if (capital.toLowerCase().equals(stateCapital[i][1].toLowerCase())) {   //sammenligner brukerinput (capital) mot stateCapital fra arrayet. Begge blir gjort om til lowercase for sammenligning.
               System.out.println("Your answer is correct!");    //gir tilbakemelding ved riktig svar
                correctCount++;                            //0ker tellevariabelen med 1
            }
            else {
                System.out.println("Correct answer should be " + stateCapital[i][1]);      //forteller om hva riktig svar er. Her blir det naturligvis ingen 0kning av tellevariabelen.
            }
        }
        System.out.println("The ammount of correct answers is " + correctCount);       //utskrift av tellevariabelen for aa vise score.
    }
}