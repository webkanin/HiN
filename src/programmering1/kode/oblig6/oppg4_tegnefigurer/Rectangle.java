package programmering1.kode.oblig6.oppg4_tegnefigurer;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Rectangle extends Figure {
	int width;
	int height;
	
	Rectangle(boolean f, Color c, int x, int y, int w, int h) {
		super(f,c,x,y);
		width = w;
		height = h;
	}
    @Override
	public void drawMySelf(Graphics g) {
		g.setColor(color);
		if (filled)
			g.fillRect(xPos, yPos, width, height);
		else
			g.drawRect(xPos, yPos, width, height);
	}
    

	public Figure clone()
	{
		Random rand = new Random();
		int y = 120+rand.nextInt(400);
		int x = 120+rand.nextInt(400);
		return new Rectangle(filled, color, x, y, width, height);
	}

}
