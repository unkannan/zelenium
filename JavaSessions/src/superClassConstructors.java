//overriding
//super keyword is used to call the super constructors and also super class methods
class A1  {
	int a;
	A1(){
		 System.out.println("super class constructor is called");
	}
	  A1(int a){
		  System.out.println("parameter A1 constructor "+a);
	  } 
	  void withDraw() {}
}

class B1 extends A1{
	 
	  B1(){
		  super();
		  //calls the parent class constructor - java will call implicitly default constructor
		  System.out.println("child constructor is called");
	  }
	  B1(int k){
		  super(50);// does default called NO 
		  System.out.println("sub class parameter constructor "+k);
		  super.a=50;
	  }
	   void subclassMethod() {
		 //  super();
		   super.a=90;
		   super.withDraw();
	   }
}

//single level inheritance  Can child access the parent objects
public class superClassConstructors {
	public static void main(String args[]) {
		B1 b1=new B1();
		 B1 b2=new B1(20);
	}
}



 