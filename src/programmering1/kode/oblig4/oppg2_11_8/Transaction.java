package programmering1.kode.oblig4.oppg2_11_8;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 26.10.13
 * Time: 00:44
 */


public class Transaction {

    private Date date;

    private char type;

    private double amount;

    private double balance;

    private String description;



    public Transaction( char type, double amount, double balance, String description){
        this.date = new Date();

        this.type = type;

        this.amount = amount;

        this.balance = balance;

        this.description = description;
    }

    public Date getDate(){
        return this.date;
    }

    public char getType(){
        return this.type;
    }

    public double getAmount(){
        return this.amount;
    }

    public double getBalance(){
        return this.balance;
    }

    public String getDescription(){
        return this.description;
    }

}