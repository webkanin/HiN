package programmering1.kode.oblig5.oppg12_1;
import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 05.11.13
 * Time: 00:03
 */


public class FlowLayout extends JFrame
{
    public FlowLayout()
    {
        setLayout(new java.awt.FlowLayout());

        JPanel p1 = new JPanel();
        p1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 20));

        p1.add(new JButton("Button 1"));
        p1.add(new JButton("Button 2"));
        p1.add(new JButton("Button 3"));

        JPanel p2 = new JPanel(new java.awt.FlowLayout());
        p2.add(new JButton("Button 4"));
        p2.add(new JButton("Button 5"));
        p2.add(new JButton("Button 6"));

        getContentPane().add(p1);
        getContentPane().add(p2);
    }

    public static void main(String[] args)
    {
        FlowLayout frame = new FlowLayout();
        frame.setTitle("Show Flow Layout");
        frame.setSize(600, 100);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}