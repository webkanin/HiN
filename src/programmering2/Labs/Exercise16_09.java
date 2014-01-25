package programmering2.Labs;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 25.01.14
 * Time: 22:46
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise16_09 extends JFrame {
    private DrawMaze mazePanel = new DrawMaze();

    public Exercise16_09() {
        // Add the keyboard panel to accept and display user input
        add(mazePanel);

        // Set focus
        mazePanel.setFocusable(true);
    }

    public static void main(String[] args) {
        Exercise16_09 frame = new Exercise16_09();
        frame.setTitle("Exercise16_09");
        frame.setSize(350, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}

class DrawMaze extends JPanel {
    private int x, y, previousX, previousY;
    private boolean firstTime = true;

    public DrawMaze() {
        addKeyListener(new Listener()); // Register listener
    }

    @Override /** Draw the character */
    protected void paintComponent(Graphics g) {
        if (firstTime) {
            x = previousX = getWidth() / 2;
            y = previousY = getHeight() / 2;
            firstTime = false;
        }

        g.drawLine(previousX, previousY, x, y);
    }

    class Listener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                    previousY = y;
                    previousX = x;
                    y += 10;
                    break;
                case KeyEvent.VK_UP:
                    previousY = y;
                    previousX = x;
                    y -= 10;
                    break;
                case KeyEvent.VK_LEFT:
                    previousX = x;
                    previousY = y;
                    x -= 10;
                    break;
                case KeyEvent.VK_RIGHT:
                    previousX = x;
                    previousY = y;
                    x += 10;
            }

            repaint();
        }
    }
}