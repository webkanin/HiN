package programmering1.kode.oblig5.oppg13_12;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.lang.Math;
import java.awt.geom.*;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 04.11.13
 * Time: 21:59
 */


class PlotGraph extends JFrame{


    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g.drawLine(50, 300, 550, 300); //x axis
        g.drawLine(300, 550, 300, 50); //y axis
        //Orignin x = 300 y = 300

        double xmin, xmax;
        double y;
        xmin =(0);
        xmax = 100;
        double x = xmin;

        double form = Math.cos(x);

        double last_y = 300-(form);

        for (x = xmin+1; x<=xmax; x++){
            double newForm = Math.cos(x);
            y = 300-(newForm);
            g2.draw(new Line2D.Double(x-1+(300), last_y, x+300, y));
            last_y = y;

        }




    }

    public static void main(String [] args) {

        PlotGraph graph = new PlotGraph();
        graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graph.setSize(600, 600);
        graph.setVisible(true);
        graph.setTitle("PlotGraph");

    }
}
