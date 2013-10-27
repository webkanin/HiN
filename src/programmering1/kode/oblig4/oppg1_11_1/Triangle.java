package programmering1.kode.oblig4.oppg1_11_1;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 26.10.13
 * Time: 00:27
 */


public class Triangle extends GeometricObject
{
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;


    public Triangle (double side1, double side2, double side3)
    {this.side1=side1; this.side2=side2; this.side3=side3;}

    public double getSide1( )  {return side1;}
    public double setSide2( )  {return side2;}
    public double setSide3( )  {return side3;}
    public void setSide1 (double side1)  {this.side1=side1;}
    public void setSide2 (double side2)  {this.side2=side2;}
    public double getArea( ) { return (side1+side2+side3)/2;}
    public double getPerimeter( ) { return side1+side2+side3;}
    public String toString( ) { return "Side 1 = " + side1 + " Side 2 = " + side2 + " Side 3 = " + side3;  }



}

