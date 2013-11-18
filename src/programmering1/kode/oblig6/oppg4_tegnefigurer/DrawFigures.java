package programmering1.kode.oblig6.oppg4_tegnefigurer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 14.11.13
 * Time: 20:05
 */



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

	private ArrayList<Figure> theFigures = new ArrayList<Figure>();
	Color currentColor = Color.BLUE;

	public DrawFigures() {
		buttonPanel = new JPanel();
		colorPanel = new JPanel();




		drawPanel = new DrawPanel();
		jbtCircle = new JButton("Sirkel");
		jbtRectangle = new JButton("Rektangel");
		jbtTriangle = new JButton("Triangel");
		jbtFilledCircle = new JButton("Fylt Sirkel");
		jbtFilledRectangle = new JButton("Fylt Rektangel");
		jbtFilledTriangle = new JButton("Fylt Triangel");
		jbtClone = new JButton("Kopier Siste");
		jbtRemove = new JButton("Fjern En");

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

		add(drawPanel, BorderLayout.CENTER);

		add(buttonPanel, BorderLayout.SOUTH);

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


		ColorButtonsListener cbl = new ColorButtonsListener();

		jbtGreen.addActionListener(cbl);
		jbtBlue.addActionListener(cbl);
		jbtRed.addActionListener(cbl);



	}

	/** Main method */
	public static void main(String[] args) {
		JFrame frame = new DrawFigures();
		frame.setTitle("Program som lager figurer");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 600);
		frame.setVisible(true);
	}



	class ButtonsListener implements ActionListener {


		@Override
		public void actionPerformed(ActionEvent e) {
			String kommando = e.getActionCommand();

			int width = drawPanel.getWidth();
			int heigth = drawPanel.getHeight();

			//System.out.println(kommando);

			if (kommando.equals("Sirkel")) {
				theFigures.add(new Circle(false, currentColor, 20, 20, 50));
			} else if (kommando.equals("Fylt Sirkel")) {
				theFigures.add(new Circle(true, currentColor, 80, 20, 50));
			} else if (kommando.equals("Rektangel")) {
				theFigures.add(new Rectangle(false, currentColor, 310, 30, 95, 95));
			} else if (kommando.equals("Fylt Rektangel")) {
				theFigures.add(new Rectangle(true, currentColor, 400, 30, 90, 90));
			} else if (kommando.equals("Triangel")) {
				theFigures.add(new Triangle(false, currentColor, 50, 190, 80, 70));
			} else if (kommando.equals("Fylt Triangel")) {
				theFigures.add(new Triangle(true, currentColor, 66, 250, 95, 83));
			} else if (kommando.equals("Kopier Siste")) {
				if (theFigures.size()>0)
				{

					theFigures.add(theFigures.get(theFigures.size()-1).clone());
				}
			} else if (kommando.equals("Fjern En")) {
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

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (Figure f : theFigures)
				f.drawMySelf(g);

			g.setColor(Color.BLACK);
			g.drawString("Antall figurer = "+theFigures.size(), 20, 450);
		}
	}
}
