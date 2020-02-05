package Interfaces;
interface ShapeForm{
	
	//String drawingObject="Pen";
	
	double Pie=3.14;
		
	public void draw();
	void resize();
}

class CircleShape implements ShapeForm{
	
	public void draw() {
		System.out.println("Draw a c");
	}
 
	public void resize() {
		double size=Pie*6*6;
		System.out.println("Size to the circle"+size);
	}
}

//class rectangle implementing the shapeform

public class Shape{
	
	public static void main(String args[]) {
		//ShapeForm sf=new ShapeForm();
		ShapeForm sf=new CircleShape();
		sf.draw();
		sf.resize();
	}
}
