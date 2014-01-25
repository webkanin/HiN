package programmering2.Labs;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 25.01.14
 * Time: 22:49
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise17_02 extends JFrame {
    private JRadioButton jrbLine, jrbRectangle, jrbOval;
    private JCheckBox jchkFilled = new JCheckBox("Filled");
    private FigurePanel figurePanel = new FigurePanel();

    public static void main(String[] args) {
        Exercise17_02 frame = new Exercise17_02();
        frame.setSize(400, 300);
        frame.setTitle("Exercise17_02");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    public Exercise17_02() {
        // Panel p to hold radio buttons
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(jrbLine = new JRadioButton("Line"));
        p.add(jrbRectangle = new JRadioButton("Rectangle"));
        p.add(jrbOval = new JRadioButton("Oval"));
        p.add(jchkFilled);

        // Group radio buttons
        ButtonGroup btg = new ButtonGroup();
        btg.add(jrbLine);
        btg.add(jrbRectangle);
        btg.add(jrbOval);

        // Place figure panel and p in the frame
        add(figurePanel, BorderLayout.CENTER);
        add(p, BorderLayout.SOUTH);

        // Register listener
        jrbLine.addItemListener(new MyItemEventListener());
        jrbRectangle.addItemListener(new MyItemEventListener());
        jrbOval.addItemListener(new MyItemEventListener());
        jchkFilled.addItemListener(new MyItemEventListener());
    }

    class MyItemEventListener implements ItemListener {
        // Handle ItemEvent
        public void itemStateChanged(ItemEvent e) {
            if (jrbLine.isSelected()) {
                figurePanel.setType(FigurePanel.LINE);
            } else if (jrbRectangle.isSelected()) {
                figurePanel.setType(FigurePanel.RECTANGLE);
            } else if (jrbOval.isSelected()) {
                figurePanel.setType(FigurePanel.OVAL);
            }

            figurePanel.setFilled(jchkFilled.isSelected());
        }
    }

    class FigurePanel extends JPanel {
        // Define constants
        public static final int LINE = 1;
        public static final int RECTANGLE = 2;
        public static final int ROUND_RECTANGLE = 3;
        public static final int OVAL = 4;
        public static final int ARC = 5;
        public static final int POLYGON = 6;

        private int type = 1;
        private boolean filled;

        /** Construct a default FigurePanel */
        public FigurePanel() {
        }

        /** Construct a FigurePanel with the specified type */
        public FigurePanel(int type) {
            this.type = type;
        }

        /** Construct a FigurePanel with the specified type and filled */
        public FigurePanel(int type, boolean filled) {
            this.type = type;
            this.filled = filled;
        }

        @Override /** Draw a figure on the panel */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Get the appropriate size for the figure
            int width = getSize().width;
            int height = getSize().height;

            switch (type) {
                case LINE: // Display two cross lines
                    g.setColor(Color.BLACK);
                    g.drawLine(10, 10, width - 10, height - 10);
                    g.drawLine(width - 10, 10, 10, height - 10);
                    break;
                case RECTANGLE: // Display a rectangle
                    g.setColor(Color.BLUE);
                    if (filled)
                        g.fillRect((int)(0.1 * width), (int)(0.1 * height),
                                (int)(0.8 * width), (int)(0.8 * height));
                    else
                        g.drawRect((int)(0.1 * width), (int)(0.1 * height),
                                (int)(0.8 * width), (int)(0.8 * height));
                    break;
                case ROUND_RECTANGLE: // Display a round-cornered rectangle
                    g.setColor(Color.RED);
                    if (filled)
                        g.fillRoundRect((int)(0.1 * width), (int)(0.1 * height),
                                (int)(0.8 * width), (int)(0.8 * height), 20, 20);
                    else
                        g.drawRoundRect((int)(0.1 * width), (int)(0.1 * height),
                                (int)(0.8 * width), (int)(0.8 * height), 20, 20);
                    break;
                case OVAL: // Display an oval
                    g.setColor(Color.BLACK);
                    if (filled)
                        g.fillOval((int)(0.1 * width), (int)(0.1 * height),
                                (int)(0.8 * width), (int)(0.8 * height));
                    else
                        g.drawOval((int)(0.1 * width), (int)(0.1 * height),
                                (int)(0.8 * width), (int)(0.8 * height));
                    break;
                case ARC: // Display an arc
                    g.setColor(Color.BLACK);
                    if (filled) {
                        int xCenter = getWidth() / 2;
                        int yCenter = getHeight() / 2;
                        int radius =
                                (int)(Math.min(getWidth(), getHeight()) * 0.4);

                        int x = xCenter - radius;
                        int y = yCenter - radius;

                        g.fillArc(x, y, 2 * radius, 2 * radius, 0, 30);
                        g.fillArc(x, y, 2 * radius, 2 * radius, 90, 30);
                        g.fillArc(x, y, 2 * radius, 2 * radius, 180, 30);
                        g.fillArc(x, y, 2 * radius, 2 * radius, 270, 30);
                    }
                    else {
                        int xCenter = getWidth() / 2;
                        int yCenter = getHeight() / 2;
                        int radius =
                                (int)(Math.min(getWidth(), getHeight()) * 0.4);

                        int x = xCenter - radius;
                        int y = yCenter - radius;

                        g.drawArc(x, y, 2 * radius, 2 * radius, 0, 30);
                        g.drawArc(x, y, 2 * radius, 2 * radius, 90, 30);
                        g.drawArc(x, y, 2 * radius, 2 * radius, 180, 30);
                        g.drawArc(x, y, 2 * radius, 2 * radius, 270, 30);
                    };
                    break;
                case POLYGON: // Display a polygon
                    g.setColor(Color.BLACK);
                    int xCenter = getWidth() / 2;
                    int yCenter = getHeight() / 2;
                    int radius =
                            (int)(Math.min(getWidth(), getHeight()) * 0.4);

                    // Create a Polygon object
                    Polygon polygon = new Polygon();

                    // Add points to the polygon
                    polygon.addPoint(xCenter + radius, yCenter);
                    polygon.addPoint((int)(xCenter + radius *
                            Math.cos(2 * Math.PI / 6)), (int)(yCenter - radius *
                            Math.sin(2 * Math.PI / 6)));
                    polygon.addPoint((int)(xCenter + radius *
                            Math.cos(2 * 2 * Math.PI / 6)), (int)(yCenter - radius *
                            Math.sin(2 * 2 * Math.PI / 6)));
                    polygon.addPoint((int)(xCenter + radius *
                            Math.cos(3 * 2 * Math.PI / 6)), (int)(yCenter - radius *
                            Math.sin(3 * 2 * Math.PI / 6)));
                    polygon.addPoint((int)(xCenter + radius *
                            Math.cos(4 * 2 * Math.PI / 6)), (int)(yCenter - radius *
                            Math.sin(4 * 2 * Math.PI / 6)));
                    polygon.addPoint((int)(xCenter + radius *
                            Math.cos(5 * 2 * Math.PI / 6)), (int)(yCenter - radius *
                            Math.sin(5 * 2 * Math.PI / 6)));

                    // Draw the polygon
                    if (filled)
                        g.fillPolygon(polygon);
                    else
                        g.drawPolygon(polygon);
            }
        }

        /** Set a new figure type */
        public void setType(int type) {
            this.type = type;
            repaint();
        }

        /** Return figure type */
        public int getType() {
            return type;
        }

        /** Set a new filled property */
        public void setFilled(boolean filled) {
            this.filled = filled;
            repaint();
        }

        /** Check if the figure is filled */
        public boolean isFilled() {
            return filled;
        }

        /** Specify preferred size */
        public Dimension getPreferredSize() {
            return new Dimension(80, 80);
        }
    }

}