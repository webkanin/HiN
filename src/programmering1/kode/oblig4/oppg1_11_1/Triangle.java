package programmering1.kode.oblig4.oppg1_11_1;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 26.10.13
 * Time: 00:15
 */

public class Triangle extends GeometricObject {
private double side1 = 1.0, side2 = 1.0, side3 = 1.0;

	public Triangle() {
		
	}
	public Triangle(double side1, double side2, double side3) throws IllegalTriangleException{
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;

        double[] sides = new double[]{side1,side2,side3};
        Arrays.sort(sides);

        if (sides[0]+sides[1]<sides[2]) throw new IllegalTriangleException();




	}
	
	public double getSide1() {
		return side1;
	}
	
	public void setSide1(double side1) {
		this.side1 = side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public void setSide2(double side2) {
		this.side2 = side2;
	}
	
	public double getSide3() {
		return side3;
	}
	
	public void setSide3(double side3) {
		this.side3 = side3;
	}
	
	public double getArea() {

		double p = getPerimiter() / 2;
		return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
	}

	public double getPerimiter() {
		return side1 + side2 + side3;
	}
	
	public String toString() {
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}
}
