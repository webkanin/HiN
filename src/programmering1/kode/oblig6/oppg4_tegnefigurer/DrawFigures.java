package programmering1.kode.oblig6.oppg4_tegnefigurer;
import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;

public class DrawFigures extends JFrame {
	private JButton jbtCircle;
	private JButton jbtRectangle;
	private JButton jbtTriangle;
	private JButton jbtFilledCircle;
	private JButton jbtFilledRectangle;
	private JButton jbtFilledTriangle;
	private JButton jbtClone;
	private JButton jbtRemove;
	private JPanel buttonPanel;
	private DrawPanel drawPanel;
	private JPanel colorPanel;

	private JButton jbtRed;
	private JButton jbtGreen;
	private JButton jbtBlue;

	Random rand = new Random();

	private ArrayList<Figure> theFigures = new ArrayList<Figure>(); // holds the figures that are being created
	Color currentColor = Color.BLUE; // holds current color

	public DrawFigures() {
		buttonPanel = new JPanel(); // panel that holds the buttons in the bottom of the window
		colorPanel = new JPanel();


		// TODO: create a panel that holds color pick buttons

		drawPanel = new DrawPanel(); // in this panel figures are drawn
		jbtCircle = new JButton("Circle");
		jbtRectangle = new JButton("Rectangle");
		jbtTriangle = new JButton("Triangle");
		jbtFilledCircle = new JButton("Filled Circle");
		jbtFilledRectangle = new JButton("Filled Rectangle");
		jbtFilledTriangle = new JButton("Filled Triangle");
		jbtClone = new JButton("Copy Last");
		jbtRemove = new JButton("Remove one");

		jbtGreen= new JButton("Green");
		jbtBlue = new JButton("Blue");
		jbtRed = new JButton("Red");

		jbtGreen.setOpaque(true);
		jbtGreen.setBackground(Color.GREEN);
		jbtBlue.setOpaque(true);
		jbtBlue.setBackground(Color.BLUE);
		jbtRed.setOpaque(true);
		jbtRed.setBackground(Color.RED);


		buttonPanel.add(jbtCircle);
		buttonPanel.add(jbtRectangle);
		buttonPanel.add(jbtTriangle);
		buttonPanel.add(jbtFilledCircle);
		buttonPanel.add(jbtFilledRectangle);
		buttonPanel.add(jbtFilledTriangle);
		buttonPanel.add(jbtClone);
		buttonPanel.add(jbtRemove);

		colorPanel.add(jbtGreen);
		colorPanel.add(jbtBlue);
		colorPanel.add(jbtRed);

		add(colorPanel, BorderLayout.NORTH);

		add(drawPanel, BorderLayout.CENTER); // add drawing panel to the center of the frame

		add(buttonPanel, BorderLayout.SOUTH); // adds button to the bottom of the frame

		// actionlisteners
		ButtonsListener bl = new ButtonsListener();
		jbtCircle.addActionListener(bl);
		jbtRectangle.addActionListener(bl);
		jbtTriangle.addActionListener(bl);
		jbtFilledCircle.addActionListener(bl);
		jbtFilledRectangle.addActionListener(bl);
		jbtFilledTriangle.addActionListener(bl);

		jbtClone.addActionListener(bl);
		jbtRemove.addActionListener(bl);
		// connects rest of the buttons to the action listener


		ColorButtonsListener cbl = new ColorButtonsListener();

		jbtGreen.addActionListener(cbl);
		jbtBlue.addActionListener(cbl);
		jbtRed.addActionListener(cbl);

	       //TODO: add color pick buttons, place them to the north of the frame,  add actionlistener that is already implemented bellow

	}

	/** Main method */
	public static void main(String[] args) {
		JFrame frame = new DrawFigures();
		frame.setTitle("Program that creates figures");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 600);
		frame.setVisible(true);
	}

    //Class that includes a method to listen for input on the buttons in the lower side of the panel.

	class ButtonsListener implements ActionListener {


		@Override
		public void actionPerformed(ActionEvent e) {
			String kommando = e.getActionCommand();

			int width = drawPanel.getWidth();
			int heigth = drawPanel.getHeight();

			//System.out.println(kommando);

			if (kommando.equals("Circle")) {
				theFigures.add(new Circle(false, currentColor, 20, 20, 50));
			} else if (kommando.equals("Filled Circle")) {
				theFigures.add(new Circle(true, currentColor, 80, 20, 50));
			} else if (kommando.equals("Rectangle")) {
				theFigures.add(new Rectangle(false, currentColor, 30, 30, 95, 95));
			} else if (kommando.equals("Filled Rectangle")) {
				theFigures.add(new Rectangle(true, currentColor, 101, 30, 90, 90));
			} else if (kommando.equals("Triangle")) {
				theFigures.add(new Triangle(false, currentColor, 50, 150, 80, 70));
			} else if (kommando.equals("Filled Triangle")) {
				theFigures.add(new Triangle(true, currentColor, 66, 166, 95, 83));
			} else if (kommando.equals("Copy Last")) {
				if (theFigures.size()>0)
				{

					theFigures.add(theFigures.get(theFigures.size()-1).clone());
				}
			} else if (kommando.equals("Remove one")) {
				if (theFigures.size()>0)
				{
			                int index = rand.nextInt(theFigures.size());
					theFigures.remove(index);					
				}				
			}

			drawPanel.repaint(); 
		}
	}


	class ColorButtonsListener implements ActionListener {


		@Override
		public void actionPerformed(ActionEvent e) {
			String kommando = e.getActionCommand();
			if (kommando.equals("Red"))
				currentColor = Color.RED;
			else if (kommando.equals("Green"))
				currentColor = Color.GREEN;
			else if (kommando.equals("Blue"))
				currentColor = Color.BLUE;
		}
	}

	class DrawPanel extends JPanel {

		@Override
		// don't call this method directly (repaint will call it indirectly..)
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (Figure f : theFigures)
				f.drawMySelf(g);

			g.setColor(Color.BLACK);
			g.drawString("Figures Count = "+theFigures.size(), 20, 450);
		}
	}
}
