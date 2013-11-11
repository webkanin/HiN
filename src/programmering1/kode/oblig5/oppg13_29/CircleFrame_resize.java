package programmering1.kode.oblig5.oppg13_29;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 06.11.13
 * Time: 15:45
 */


public class CircleFrame_resize extends JFrame {
    private static final int WIDTH = 510;
    private static final int HEIGHT = 310;
    private DrawPanel panel;

    //setter opp Frame
    public CircleFrame_resize()
    {
        this.setTitle("Exercise: 13_29");
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 300);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        this.setVisible(true);

        //oppretter DrawPanel
        panel = new DrawPanel(WIDTH, HEIGHT);
        this.add(panel);

        this.addWindowListener( new WindowAdapter() {

            public void windowStateChanged(WindowEvent windowEvent) {

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

    //main
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
     * Konstrukt0r for panelet
     */
    public DrawPanel(int w, int h)
    {
        WIDTH = w;
        HEIGHT = h;
        this.setPreferredSize(new Dimension(WIDTH-RADIUS, HEIGHT-RADIUS));
    }




    public void paintComponent(Graphics g)
    {
        //Sentrum av sirklene
        int x1 = (int)(Math.random() * (WIDTH-(RADIUS*2)));
        int y1 = (int)(Math.random() * (HEIGHT-(RADIUS*2)));
        int x2 = (int)(Math.random() * (WIDTH-(RADIUS)*2));
        int y2 = (int)(Math.random() * (HEIGHT-(RADIUS*2)));

        //Formel for distanse
        double distance = Math.sqrt(((x1 - x2) * (x1 - x2))+
                ( (y1 - y2) * (y1 - y2)));

        //tilfeldige farger for morsom effekt.
        int index = (int) (Math.random() * colors.length);

        //f0rste sirkel faar en farge
        g.setColor(colors[index]);

        //tegning av f0rste sirkel
        g.fillOval(x1, y1, RADIUS, RADIUS);

        //tilfeldig farge
        index = (int) (Math.random() * colors.length);

        //setter farge paa den andre sirkelen
        g.setColor(colors[index]);

        //tegning av andre sirkel
        g.fillOval(x2, y2, RADIUS, RADIUS);

        //tegner linjen
        g.setColor(Color.black);
        g.drawLine(x1+15, y1+15, x2+15, y2+15);

        //tegner distansen paa linjen
        g.drawString(String.format("%.2f", distance), (x1+x2)/2, (y1+y2)/2);
    }
}