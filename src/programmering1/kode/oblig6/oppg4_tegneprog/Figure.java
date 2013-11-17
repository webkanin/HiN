package programmering1.kode.oblig6.oppg4_tegneprog;
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

    //metode that should be implemented into child classes

	public void drawMySelf(Graphics g){};
	
	///set/get methods if nessecery

}
