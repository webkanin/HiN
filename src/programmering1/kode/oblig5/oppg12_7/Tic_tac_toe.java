package programmering1.kode.oblig5.oppg12_7;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 31.10.13
 * Time: 01:05
 */
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tic_tac_toe extends JFrame
{
    private ImageIcon kryss = new ImageIcon("C:\\Users\\Webkanin\\IdeaProjects\\HiN\\src\\programmering1\\kode\\oblig5\\oppg12_7\\x.gif");
    private ImageIcon runding = new ImageIcon("C:\\Users\\Webkanin\\IdeaProjects\\HiN\\src\\programmering1\\kode\\oblig5\\oppg12_7\\o.gif");

    public Tic_tac_toe() {
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            int mode = (int)(Math.random() * 3.0D);
            if (mode == 0)
                add(new JLabel(this.kryss));
            else if (mode == 1)
                add(new JLabel(this.runding));
            else
                add(new JLabel());
        }
    }

    public static void main(String[] args) {
        Tic_tac_toe frame = new Tic_tac_toe();
        frame.setTitle("TicTacToe");
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}