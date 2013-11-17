package programmering1.kode.oblig6.oppg4_tegnefigurer;
import java.awt.Color;
import java.awt.Graphics;


public abstract class Figure {
	protected boolean filled = false;
	protected Color color = Color.RED;
	protected int xPos, yPos;
		
	Figure(boolean f, Color c, int x, int y) {
		filled = f;
		color = c;
		xPos = x;
		yPos = y;
	}

	public Figure clone()
	{
		return null;
	}



	public void drawMySelf(Graphics g){};
	


}
