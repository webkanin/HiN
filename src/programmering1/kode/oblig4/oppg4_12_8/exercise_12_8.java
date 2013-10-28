package programmering1.kode.oblig4.oppg4_12_8;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 28.10.13
 * Time: 20:04
 */
public class exercise_12_8 extends JFrame {

    public static void main(String[] args){
        JFrame frame= new JFrame("Exercise12_8");
        frame.setSize(300,200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel p1 = new JPanel(new BorderLayout());
        p1.setLayout(new GridLayout(2,3,1,1));

        Border lineborder = new LineBorder(Color.black, 1);
        frame.add(p1);

        JLabel label1 = new JLabel("Black");
        p1.add(label1);
        label1.setForeground(Color.BLACK);
        Font font1 = new Font("Times New Roman", Font.BOLD, 20);
        label1.setFont(font1);
        label1.setBorder(lineborder);

        JLabel label2 = new JLabel("Blue");
        p1.add(label2);
        label2.setForeground(Color.BLUE);
        Font font2 = new Font("Times New Roman", Font.BOLD, 20);
        label2.setFont(font2);
        label2.setBorder(lineborder);

        JLabel label3 = new JLabel("Cyan");
        p1.add(label3);
        label3.setForeground(Color.CYAN);
        Font font3 = new Font("Times New Roman", Font.BOLD, 20);
        label3.setFont(font3);
        label3.setBorder(lineborder);

        JLabel label4 = new JLabel("Green");
        p1.add(label4);
        label4.setForeground(Color.GREEN);
        Font font4 = new Font("Times New Roman", Font.BOLD, 20);
        label4.setFont(font4);
        label4.setBorder(lineborder);

        JLabel label5 = new JLabel("Magenta");
        p1.add(label5);
        label5.setForeground(Color.MAGENTA);
        Font font5 = new Font("Times New Roman", Font.BOLD, 20);
        label5.setFont(font5);
        label5.setBorder(lineborder);

        JLabel label6 = new JLabel("Orange");
        p1.add(label6);
        label6.setForeground(Color.ORANGE);
        Font font6 = new Font("Times New Roman", Font.BOLD, 20);
        label6.setFont(font6);
        label6.setBorder(lineborder);



    }

}
