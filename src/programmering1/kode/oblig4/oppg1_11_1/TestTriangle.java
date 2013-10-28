package programmering1.kode.oblig4.oppg1_og_oppg3;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 26.10.13
 * Time: 00:16
 */

import java.util.ArrayList;
import java.util.Scanner;

public class TestTriangle {

	public static void main(String[] args) {
		Triangle t1, t2;
		Circle c1, c2;
		Rectangle r1, r2;
		
		double side1, side2, side3;
		String color;
		boolean filled;
		
		Scanner input = new Scanner(System.in);
		ArrayList<GeometricObject> list = new ArrayList<>();            //velger aa bruke Java 7 maaten aa deklarere arrays paa.
		
        System.out.println("Geometriske Figurer v. 1.0");
		System.out.println("Tast inn lengden paa de tre sidene av trekanten. Separer med MELLOMROM:");
		side1 = input.nextDouble();
		side2 = input.nextDouble();
		side3 = input.nextDouble();
		
		System.out.println("Velg farge:");
		color = input.next();
		
		System.out.println("Er trekanten fylt (true/false)?");
		filled = input.nextBoolean();
		

		t1 = new Triangle(side1, side2, side3);
		t1.setColor(color);
		t1.setFilled(filled);
		t2 = new Triangle();
		

		c1 = new Circle(5, "blue", true);
		c2 = new Circle(10, "green", false);
		

		r1 = new Rectangle(5, 10, "yellow", false);
		r2 = new Rectangle(15, 15,  "green", true);
		

		System.out.println(t1.toString());
		System.out.println("Area = " + t1.getArea());
		System.out.println("Perimiter = " + t1.getPerimiter());
		System.out.println("Color = " + t1.getColor());
		System.out.println("Filled = " + t1.isFilled());
		

		list.add(t1);
		list.add(t2);
		list.add(c1);
		list.add(c2);
		list.add(r1);
		list.add(r2);
		
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) instanceof Rectangle) {
				System.out.println("Rectangle: Height = " + ((Rectangle)list.get(i)).getHeight()
								+ " Width = " + ((Rectangle)list.get(i)).getWidth());
			}
			else if (list.get(i) instanceof Circle) {
				System.out.println("Circle: Radius = " + ((Circle)list.get(i)).getRadius());
			}
			else if (list.get(i) instanceof Triangle) {
				System.out.println("Triangle: Side1 = " + ((Triangle)list.get(i)).getSide1()
						+ " Side2 = " + ((Triangle)list.get(i)).getSide2()
						+ " Side3 = " + ((Triangle)list.get(i)).getSide3());
			}
			System.out.println(((GeometricObject)list.get(i)).toString() + "\n");
		}
	}

}
