package programmering1.kode.oblig4.oppg1_11_1;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 26.10.13
 * Time: 00:34
 */
public class GeometricObject
{
    private String color = "Yellow";
    private Boolean filled = true;

    public String getColor( )
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public boolean isFilled( )
    {
        return filled;
    }

    public void setFilled(boolean filled)
    {
        this.filled = filled;
    }


    public String toStrings( )
    {
        return  " Color: " + color + " and filled: " + filled;
    }

}

