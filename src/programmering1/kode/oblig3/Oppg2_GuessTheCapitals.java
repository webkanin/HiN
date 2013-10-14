package programmering1.kode.oblig3;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Oppg2_GuessTheCapitals
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String[][] stateCapital = {
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

        int correctCount = 0;

        for (int i = 0; i < stateCapital.length; i++)
        {
            System.out.println("What is the capital of " + stateCapital[i][0] + "?");
            String capital =  scan.next();

            if (capital.toLowerCase().equals(stateCapital[i][1].toLowerCase())) {
               System.out.println("Your answer is correct!");
                correctCount++;
            }
            else {
                System.out.println("Correct answer should be " + stateCapital[i][1]);
            }
        }
        System.out.println("The ammount of correct answers is " + correctCount);
    }
}