package programmering1.kode.oblig6.oppg4_tegnefigurer;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Triangle extends Figure {
	int width;
	int height;
	
	Triangle(boolean f, Color c, int x, int y, int w, int h) {
		super(f,c,x,y);
		width = w;
		height = h;
	}
    @Override
	public void drawMySelf(Graphics g) {
		int[] xx = new int[3];
		int[] yy = new int[3];

		xx[0] = xPos;
		yy[0] = yPos;
		xx[1] = xPos+width;
		yy[1] = yPos;
		xx[2] = xPos+width/2;
		yy[2] = yPos-height;


		g.setColor(color);
		if (filled)
			g.fillPolygon(xx, yy, 3);
		else
			g.drawPolygon(xx, yy, 3);
	}
    

	public Figure clone()
	{
		Random rand = new Random();
		int y = 120+rand.nextInt(400);
		int x = 120+rand.nextInt(400);
		return new Triangle(filled, color, x, y, width, height);
	}

}
