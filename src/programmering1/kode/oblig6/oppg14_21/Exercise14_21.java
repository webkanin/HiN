package programmering1.kode.oblig6.oppg14_21;

import java.io.*;
import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 17.11.13
 * Time: 22:30
 */

public class Exercise14_21
{	
   	static JFrame frame;
	
	class GraphPanel extends JPanel 
	{
		
		MyPoint[] points;

	        GraphPanel(MyPoint[] points) {
        	    // set a preferred size for the custom panel.
		    this.points = points;
	            setPreferredSize(new Dimension(250,250));
	        }

        	@Override
	        public void paintComponent(Graphics g) {
        	    super.paintComponent(g);
	
        	    //g.drawString(, 20, 20);
	            //g.drawRect(10, 10, 20, 20);
		   	for(int i=0; i<points.length; i++)
			{
				g.fillOval(points[i].x, points[i].y, 13, 13);
				g.drawString(i+"", points[i].x-6, points[i].y-4);
				for(int j=0; j<points[i].connected.length; j++)
				{
					int k = points[i].connected[j];
					g.drawLine(points[i].x+6, points[i].y+6, points[k].x+6, points[k].y+6);
				}
			}
	
	        }
	}
	
	class MyPoint
	{
		int x;
		int y;
		int[] connected;
	}

	private MyPoint[] OpenFile(String fileName)
	{
  		MyPoint[] result = null;

		try {
			BufferedReader reader = 
		            new BufferedReader(new FileReader(fileName));

			String firstRow = reader.readLine();
			int count = Integer.parseInt(firstRow);

			result = new MyPoint[count];

			for(int i=0;i<count;i++)
			{
				String dataRow = reader.readLine();
				if (dataRow != null)
				{
					String[] dataArray = dataRow.split(" ");
					int index = Integer.parseInt(dataArray[0]);
					result[index] = new MyPoint();
					result[index].x = Integer.parseInt(dataArray[1]);
					result[index].y = Integer.parseInt(dataArray[2]);
					result[index].connected = new int[dataArray.length-3];
					for(int j=3; j<dataArray.length; j++)
						result[index].connected[j-3] = Integer.parseInt(dataArray[j]);		
				}
			}

		}
		catch (IOException ioe) 
		{
		}
		
		
		return result;		
	
	}

	private void Run()
	{
		String fileName = JOptionPane.showInputDialog(null, " Enter file name (for ex: graph.txt)");
		MyPoint[] points = OpenFile(fileName);

		if (points!=null)
		{
			frame = new JFrame("Exercise14_21");
			frame.setVisible(true);
			frame.setSize(200,220);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			GraphPanel panel = new GraphPanel(points);
			frame.add(panel);
		}

	}

	public static void main(String[] args) 
	{
		Exercise14_21 obj = new Exercise14_21();
		obj.Run();				
	
	}

}