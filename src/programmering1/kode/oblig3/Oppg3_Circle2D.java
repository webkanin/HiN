package programmering1.kode.oblig3;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 10.10.13
 * Time: 17:16
 */

public class Oppg3_Circle2D {

    //variablene X og Y definerer senteren av sirkelen
    private double X,Y;
    //variable for aa lagre radius
    private double rad;   //

    double dist=0.0;

    public Oppg3_Circle2D(double CenterX, double CenterY, double radius) {        //konstrukt0r for klassen

        X = CenterX;
        Y = CenterY;
        rad = radius;
    }

    public double getArea(){   //metode for aa returnere arealet til sirkelen

        return Math.PI*rad*rad;  //den matematiske formelen til areal av en sirkel
    }
    public double getPerimiter() {  //metode for aa returnere omkretsen av sirkelen

        return 2*Math.PI*rad;   //den matematiske formelen til omkrets av en sirkel
    }
    public boolean containsPoint(double x, double y){   //sjekker om punktet x,y befinner seg paa innsiden av sirkelen. Punktene spesifiseres ved aa kalle paa metoden via objektet. Dette gj0res i Main klassen.

        dist = Math.sqrt((x-X)*(x-X)-(y-Y)*(y-Y));
        if(dist>rad)
            return false;
        else return true;
    }
    public boolean containsInside(Oppg3_Circle2D circle){   //sjekker om en sirkel befinner seg paa innsiden av den opprinnelige .

        dist = Math.sqrt((X-circle.X)*(X-circle.X)-(Y-circle.Y));

        if(dist+circle.rad<=rad)
            return true;
        else
            return false;
    }
    public boolean circleOverlaps(Oppg3_Circle2D circle){  //sjekker om den nydefinerte sirkelen overlapper den opprinnelige.

        dist = Math.sqrt((X-circle.X)*(X-circle.X)-(Y-circle.Y));
        if(dist<(rad+circle.rad))
            return true;
        else
            return false;
    }
}