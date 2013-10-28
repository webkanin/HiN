package programmering1.kode.oblig4.oppg2_11_8;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 26.10.13
 * Time: 00:42
 */
import java.util.ArrayList;

public class TestAccount {
    public static void main( String[] args ){

        //create a new account object from an existing class
        Account account = new Account( "George", 1122, 1000.0D);

        account.deposit(30.0D);

        account.deposit(40.0D);

        account.deposit(50.0D);

        account.withdraw(5.0D);

        account.withdraw(4.0D);

        account.withdraw(2.0D);


        //output the information to the user

        System.out.println( "Name:  " + account.getName() );

        System.out.println( "Annual interest rate: " + Account.getAnnualInterestRate());

        System.out.println("Balance " + account.getBalance());

        ArrayList list = account.getTransaction();

        System.out.printf("%-35s%-15s%-15s%-15s\n", new Object[] {"Date", "Type", "Amount", "Balance"} );

        for (int i = 0; i < list.size(); i++){

            Transaction transaction = (Transaction)list.get(i);

            System.out.printf("%-35s%-15s%-15s%-15s\n", new Object[] { transaction.getDate(),

                    Character.valueOf(transaction.getType()),

                    Double.valueOf(transaction.getAmount()),

                    Double.valueOf(transaction.getBalance()) });

        }
    }
}



