package programmering1.kode.oblig6.oppg4_tegneprog;
import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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



	private ArrayList<Figure> theFigures = new ArrayList<Figure>(); // holds the figures that are being created
	Color currentColor = Color.BLUE; // holds current color

	public DrawFigures() {
		buttonPanel = new JPanel(); // panel that holds the buttons in the bottom of the window


		// TODO: create a panel that holds color pick buttons

		drawPanel = new DrawPanel(); // in this panel figures are drawn
		jbtCircle = new JButton("Circle");
		jbtRectangle = new JButton("Rectangle");
		jbtTriangle = new JButton("Triangle");
		jbtFilledCircle = new JButton("Filled Cricle");
		jbtFilledRectangle = new JButton("Filled Rectangle");
		jbtFilledTriangle = new JButton("Filled Triangle");
		jbtClone = new JButton("Copy Last");
		jbtRemove = new JButton("Remove one");
		buttonPanel.add(jbtCircle);
		buttonPanel.add(jbtRectangle);
		buttonPanel.add(jbtTriangle);
		buttonPanel.add(jbtFilledCircle);
		buttonPanel.add(jbtFilledRectangle);
		buttonPanel.add(jbtFilledTriangle);
		buttonPanel.add(jbtClone);
		buttonPanel.add(jbtRemove);

		add(drawPanel, BorderLayout.CENTER); // add drawing panel to the center of the frame

		add(buttonPanel, BorderLayout.SOUTH); // adds button to the bottom of the frame

		// actionlisteners
		ButtonsListener bl = new ButtonsListener();
		jbtCircle.addActionListener(bl);
		jbtRectangle.addActionListener(bl);
		// connects rest of the buttons to the action listener

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



			if (kommando.equals("Circle")) {
				theFigures.add(new Circle(false, Color.BLUE, 20, 20, 50));
			} else if (kommando.equals("Rectangle")) {

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
			else
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
		}
	}
}
