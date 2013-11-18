package programmering1.kode.oblig6.oppg4_tegnefigurer;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

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
    

	public Figure clone()
	{
		Random rand = new Random();
		int y = 120+rand.nextInt(400);
		int x = 120+rand.nextInt(400);
		return new Circle(filled, color, x, y, radius);
	}

}
