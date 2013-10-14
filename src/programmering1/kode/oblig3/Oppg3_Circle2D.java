package programmering1.kode.oblig3;

public class Oppg3_Circle2D {

    public static void main(String[] args) {
//center point of the circle
        private double X,Y;
//radius
        private double rad;
        private double c;
/*double dist=0.0;*/
        public Circle2D()
        {
            X=0;
            Y=0;
            rad=1.0;
        }
        public Circle2D(double CenterX,double CenterY,double radius)
        {
            X = CenterX;
            Y = CenterY;
            rad = radius;
        }
    public double getRadius()
    {
        return rad;
    }
    public double getArea()
    {
        return Math.PI*rad*rad;
    }
    public double getPerimiter()
    {
        return 2*Math.PI*rad;
    }
    public boolean isContain(double x,double y)
    {
        double dist = Math.sqrt((x-X)*(x-X)-(y-Y)*(y-Y));
        if(dist>rad) {
            return false;
        }
        else {
            return true;
        }
    }
    public boolean isCircleContains(Oppg3_Circle2D circle, double dist)
    {
        dist = Math.sqrt((X-circle.X)*(X-circle.X)-(Y-c…
        if(dist+circle.rad<=rad) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isCircleOverlaps(Oppg3_Circle2D circle, double dist)
    {
        dist = Math.sqrt((X-circle.X)*(X-circle.X)-(Y-c…
        if(dist<(rad+circle.rad)) {
            return true;
        }
        else {
            return false;
        }
    }
}