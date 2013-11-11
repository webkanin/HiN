package programmering1.kode.oblig5.oppg12_2;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 11.11.13
 * Time: 19:53
 */
public class VisBorderLayout extends JFrame
{
    public VisBorderLayout()
    {

        JPanel p1 = new JPanel();
        p1.add(new JButton("Center"));
        p1.add(new JButton("Center"));
        p1.add(new JButton("Center"));
        p1.setBorder(new LineBorder(Color.BLACK, 1));   //la inn borders for at det skal vise bedre hva som er hvor.

        JPanel p2 = new JPanel();
        p2.add(new JButton("South"));
        p2.add(new JButton("South"));
        p2.add(new JButton("South"));
        p2.setBorder(new LineBorder(Color.BLACK, 1));

        //La til en tredje panel bare for aa synligj0re plasseringene litt mer.

        JPanel p3 = new JPanel();
        p3.add(new JButton("North"));
        p3.add(new JButton("North"));
        p3.add(new JButton("North"));
        p3.setBorder(new LineBorder(Color.BLACK, 1));

        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().add(p2,BorderLayout.SOUTH);
        getContentPane().add(p1,BorderLayout.CENTER);
        getContentPane().add(p3,BorderLayout.NORTH);

    }

    public static void main(String[] args)
    {
        VisBorderLayout frame = new VisBorderLayout();
        frame.setTitle("Show Border Layout");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}