package programmering1.kode.oblig5.oppg13_12;
import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 05.11.13
 * Time: 19:53
 */

public class SineCosineFrame extends JFrame {

    private static final int WIDTH = 510;
    private static final int HEIGHT = 310;
    private GraphPanel panel;

    /**
     * Konstrukt0r som setter opp frame og innhold
     */
    public SineCosineFrame()
    {
        //Frame
        this.setTitle("Exercise: 13_12");
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 300);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        this.setVisible(true);
        this.setResizable(false);

        //lager aa legger til Panel
        panel = new GraphPanel(WIDTH, HEIGHT);
        this.add(panel);

        this.pack();
    }

    //main
    public static void main(String [] args)
    {
        new SineCosineFrame();
    }
}

class GraphPanel extends JPanel
{
    int WIDTH = 500;
    int HEIGHT = 300;


    private int RADIUS = 30;

    /**
     * Konstrukt0r som setter opp panelet med gitt bredde og h0yde.
     */
    public GraphPanel(int w, int h)
    {
        WIDTH = w;
        HEIGHT = h;
        this.setPreferredSize(new Dimension(WIDTH-RADIUS, HEIGHT-RADIUS));
    }


    public void paintComponent(Graphics g)
    {
        //Tegner aksen
        drawAxis(g);

        //Tegner Sin og setter farge

        g.setColor(Color.red);
        drawSineGraph(g);

        //tegner cos og setter farge
        g.setColor(Color.blue);
        drawCosineGraph(g);
    }

    private void drawAxis(Graphics g)
    {
        //den horisontale linjen
        g.drawLine(20, 100, 400, 100);

        //akse label
        g.drawString("X", 380, 90);

        //pilspissen
        g.drawLine(400,100, 385, 95);
        g.drawLine(400,100, 385, 105);

        //den verticale linjen
        g.drawLine(200, 10, 200, 190);

        //akse label
        g.drawString("Y", 210, 20);

        //pilspissen
        g.drawLine(200, 10, 205, 25);
        g.drawLine(200, 10, 195, 25);


        //tegner aksen  for -2PI, -PI, 0, PI, 2PI
        g.drawString("-2\u03c0", 100, 110);
        g.drawString("0", 200, 110);
        g.drawString("2\u03c0", 300, 110);
        g.drawString("-\u03c0", 150, 110);
        g.drawString("\u03c0", 250, 110);
    }

     //metode for sinus grafen
    private void drawSineGraph(Graphics g)
    {
        Polygon p = new Polygon();


        for(int x = -170; x<=170; x++)
        {
            p.addPoint( (x + 200), (100-(int)(50 * Math.sin( (x/100.0) * 2 * Math.PI))));
        }


        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }

    //metode for cosinus grafen
    private void drawCosineGraph(Graphics g)
    {
        Polygon p = new Polygon();


        for(int x = -175; x<=175; x++)
        {
            p.addPoint( (x + 200), (100-(int)(50 * Math.cos( (x/100.0) * 2 * Math.PI))));
        }


        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }
}
 