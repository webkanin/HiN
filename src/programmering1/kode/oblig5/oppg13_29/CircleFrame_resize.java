package programmering1.kode.oblig5.oppg13_29;

/* * File CircleFrame_resize.java
 *
 * @author Expertz
 *         Date: 11/4/13
 *         Time: 5:42 PM
 */
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class CircleFrame_resize extends JFrame {
    private static final int WIDTH = 510;
    private static final int HEIGHT = 310;
    private DrawPanel panel;

    //set frame features
    public CircleFrame_resize()
    {
        this.setTitle("Exercise: 13_29");
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 300);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        this.setVisible(true);
        //this.setResizable(false);

        //create and add draw Panel
        panel = new DrawPanel(WIDTH, HEIGHT);
        this.add(panel);

        this.addWindowListener( new WindowAdapter() {
            @Override
            public void windowStateChanged(WindowEvent windowEvent) {
                //panel.setDimension(getWidth(), getHeight());
                removeAll();
                repaint();
                invalidate();
                panel = new DrawPanel(getWidth()-30, getHeight()-30);
                add(panel);
                repaint();
                invalidate();
            }
        });

        this.pack();
    }

    //main method
    public static void main(String [] args)
    {
        new CircleFrame_resize();
    }


}

class DrawPanel extends JPanel
{
    int WIDTH = 500;
    int HEIGHT = 300;

    private Color colors [] = {Color.black, Color.BLUE,
            Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.green,
            Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.pink,
            Color.RED, Color.YELLOW};
    private int RADIUS = 30;

    /**
     * constructor to setup the Panel
     */
    public DrawPanel(int w, int h)
    {
        WIDTH = w;
        HEIGHT = h;
        this.setPreferredSize(new Dimension(WIDTH-RADIUS, HEIGHT-RADIUS));
    }

    public void setDimension(int w, int h)
    {
        WIDTH = w;
        HEIGHT = h;
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    /**
     * function to draw the DrawPanel with Circles and line
     * of distance
     * @param g
     */
    public void paintComponent(Graphics g)
    {
        //Circle Centers
        int x1 = (int)(Math.random() * (WIDTH-(RADIUS*2)));
        int y1 = (int)(Math.random() * (HEIGHT-(RADIUS*2)));
        int x2 = (int)(Math.random() * (WIDTH-(RADIUS)*2));
        int y2 = (int)(Math.random() * (HEIGHT-(RADIUS*2)));

        //Distance using distance formula
        double distance = Math.sqrt(((x1 - x2) * (x1 - x2))+
                ( (y1 - y2) * (y1 - y2)));

        //random color
        int index = (int) (Math.random() * colors.length);

        //set color of first circle
        g.setColor(colors[index]);

        //Draw first circle
        g.fillOval(x1, y1, RADIUS, RADIUS);

        //random color
        index = (int) (Math.random() * colors.length);

        //set color of first circle
        g.setColor(colors[index]);

        //Draw first circle
        g.fillOval(x2, y2, RADIUS, RADIUS);

        //Draw Line
        g.setColor(Color.black);
        g.drawLine(x1+15, y1+15, x2+15, y2+15);

        //Draw distance
        g.drawString(String.format("%.2f", distance), (x1+x2)/2, (y1+y2)/2);
    }
}