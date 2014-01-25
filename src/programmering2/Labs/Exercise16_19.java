package programmering2.Labs;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 25.01.14
 * Time: 22:49
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.border.*;

public class Exercise16_19 extends JFrame {
    private PaintPanel paintPanel = new PaintPanel();

    public Exercise16_19() {
        add(paintPanel);
    }

    static class PaintPanel extends JPanel {
        private int centerX = 100;
        private int centerY = 60;
        private boolean isInside = false;
        private Point mousePoint = new Point(0, 0);
        public static int RADIUS = 50;

        public PaintPanel() {
            this.addMouseMotionListener(new MouseAdapter() {
                public void mouseMoved(MouseEvent e) {
                    isInside = isInsideCircle(e.getX(), e.getY());

                    mousePoint.x = e.getX();
                    mousePoint.y = e.getY();

                    repaint();
                }
            });
        }

        public boolean isInsideCircle(int px, int py) {
            return distance(px, py, centerX, centerY) < RADIUS;
        }

        public static double distance(
                double x1, double y1, double x2, double y2) {
            return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawOval(centerX - RADIUS, centerY - RADIUS, 2 * RADIUS, 2 * RADIUS);

            if (isInside) {
                // g.setColor(Color.BLACK);
                g.drawString("Mouse point is in the circle",
                        mousePoint.x, mousePoint.y);
            }
            else {
                g.setColor(Color.RED);
                g.drawString("Mouse point is not in the circle",
                        mousePoint.x, mousePoint.y);
                g.setColor(Color.BLACK);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new Exercise16_19();
        frame.setTitle("Exercise16_19");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}