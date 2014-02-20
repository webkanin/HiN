package oppg20_9;

/**
 * Created with IntelliJ IDEA.
 * User: Marko Sundic
 * Student nr. 530 614
 */
import java.io.*;


public class TestReverse
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Enter a set of characters to be reversed");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inData;
        inData = br.readLine();
        ReverseString rs = new ReverseString();
        System.out.println("Reversed: " + rs.reverse(inData));
    }
}
