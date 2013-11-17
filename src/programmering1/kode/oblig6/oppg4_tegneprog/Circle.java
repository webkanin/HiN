package programmering1.kode.oblig6.oppg4_tegneprog;
import java.awt.Color;
import java.awt.Graphics;


public class Circle extends Figure {
	int radius;
	
	Circle(boolean f, Color c, int x, int y, int r) {
		super(f,c,x,y);
		radius = r;
	}
    @Override
	public void drawMySelf(Graphics g) {
		g.setColor(color);
		if (filled)
			g.fillOval(xPos, yPos, 2*radius, 2*radius);
		else
			g.drawOval(xPos, yPos, 2*radius, 2*radius);
	}
    
    // add set/get methods if nessecery

}
