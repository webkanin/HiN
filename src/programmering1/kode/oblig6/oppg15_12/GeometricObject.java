package programmering1.kode.oblig6.oppg15_12;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 26.10.13
 * Time: 00:17
 */

public abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    /** Construct a default geometric object */
    protected GeometricObject(){
        dateCreated = new Date();
    }

    /** Construct a geoemtric object with color and filled value */
    protected GeometricObject(String color, boolean filled){
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }

    /** Return color */
    public String getColor(){
        return color;
    }

    /** Set a new color */
    public void setColor(String color){
        this.color = color;
    }

    /** Return filled. Since filled is boolean the get method is named isFilled */
    public boolean isFilled(){
        return filled;
    }

    /** Set a new filled */
    public void setFilled(boolean filled){
        this.filled = filled;
    }

    /** Get dateCreated*/
    public Date getDateCreated(){
        return dateCreated;
    }

    /** Return a string representation of this object */
    public String toString(){
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }

    /** Abstract method getArea */
    public abstract double getArea();

    /** Abstract method getPerimeter */
    public abstract double getPerimeter();

}

