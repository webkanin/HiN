package programmering1.kode.oblig4.oppg1_11_1;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 26.10.13
 * Time: 00:35
 */
public class TestTriangle
{
    public static void main (String [ ] args)
    {
        Triangle Triangle = new Triangle(1,1.5,1);
        System.out.println("The Triangle Sides are "  + Triangle.toString());
        System.out.println("The Triangle’s Area is "  + Triangle.getArea());
        System.out.println("The Triangle’s Perimeter is " +  Triangle.getPerimeter());
        System.out.println("The Triangle's Color is " + Triangle.getColor());
        System.out.println("The Triangle is " + Triangle.isFilled());
    }
}

