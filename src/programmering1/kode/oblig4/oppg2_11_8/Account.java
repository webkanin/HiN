package programmering1.kode.oblig4.oppg2_11_8;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 26.10.13
 * Time: 00:43
 */
import java.util.ArrayList;
import java.util.Date;

public class Account {


    //attributes
    private int id;

    private String name;

    private double balance;

    private static double annualInterestRate;

    private Date dateCreated;

    //Recall that the ArrayList is a data structure that allows the storage of data in a relatively efficient manner.
    private ArrayList transactions = new ArrayList();

    public Account(){
        this.dateCreated = new Date();
    }

    public Account(String name, int id, double balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    public int getId(){
        return this.id;

    }

    public double getBalance(){
        return this.balance;
    }

    public ArrayList < Transaction >  getTransaction(){
        return this.transactions;

    }

    public String getName(){
        return this.name;

    }

    public static double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public void setId( int id){
        this.id = id;
    }

    public void setBalance( double balance){
        this.balance = balance;

    }
    public static void setAnnualInterestRate( double annualInterestRate){
        annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest(){
        return this.balance * (annualInterestRate /1200.0D);
    }

    public Date getDateCreated(){
        return this.dateCreated;
    }

    public void withdraw( double amount){
        this.balance -= amount;
        this.transactions.add(new Transaction('W', amount, this.balance, ""));
    }

    public void deposit( double amount){
        this.balance += amount;
        this.transactions.add(new Transaction('D', amount, this.balance, ""));
    }


}
