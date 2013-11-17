package programmering1.kode.oblig6.oppg15_12;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 17.11.13
 * Time: 22:05
 */
public class Exercise15_12 {

   public static void main (String[] args){
       Rectangle1 obj1 = new Rectangle1();
       Rectangle1 obj2 = new Rectangle1();
       System.out.println(obj1.equals(obj2));
       System.out.println(obj1.compareTo(obj2));
   }

}

class Rectangle1 extends GeometricObject implements Comparable{
    private double width;
    private double height;

    public Rectangle1(){
        this(1.0,1.0);
    }



    public Rectangle1(double width, double height){
        this.width = width;
        this.height = height;
    }

    double getWidth() {
        return width;
    }

    void setWidth(double width) {
        this.width = width;
    }

    double getHeight() {
        return height;
    }

    void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width*height;
    }

    public double getPerimeter(){
        return 2*(width+height);
    }

    public int compareTo(Object obj){
        if (this.getArea() > ((Rectangle1)obj).getArea()){
            return 1;
        }
       else if (this.getArea() < ((Rectangle1)obj).getArea()){
            return -1;
        }
        else
            return 0;

    }

     public boolean equals(Object obj){
         return this.getArea() == ((Rectangle1)obj).getArea();
     }

}
