package Package3Excercise;

class Parent{
	 public int i=10;
	 protected int j=20;
	 private int k=30;
}

class Child extends Parent{
	void method1() {
		System.out.println("i="+i);
		   System.out.println("j="+j);
		  // System.out.println("k="+k);
	}
}
 
public class AccessModifiers {	 
	public static void main(String args[]) {
		Parent p=new Parent();
	   System.out.println("i="+p.i);
	   System.out.println("j="+p.j);
	 //  System.out.println("k="+p.k);
	
	   Child c=new Child();
	   c.method1();
}
}

// access with objects else by child
// 