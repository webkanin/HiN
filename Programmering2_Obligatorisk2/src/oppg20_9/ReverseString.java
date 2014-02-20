package oppg20_9;

/**
 * Created with IntelliJ IDEA.
 * User: Marko Sundic
 * Student nr. 530 614
 */

public class ReverseString
{
    public String reverse(String arg)
    {
        String tmp;
        if (arg.length() == 1)
        {
            return arg;
        }

        else
        {

            String lastChar = arg.substring(arg.length()-1,arg.length());

            String remainingString = arg.substring(0, arg.length() -1);

            tmp = lastChar + reverse(remainingString);
            return tmp;


        }
    }
}
