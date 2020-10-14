//overriding
//super keyword is used to call the super constructors and also super class methods
class A1  {
	A1(){
		 System.out.println("super class constructor is called");
	}
	A1(int marks){
		 System.out.println("marks");
	}
}

class B1 extends A1{
	  B1(){
		  //super();
		  System.out.println("child constructor is called");
	  }
	  B1(int rollno){
		  super(10);
		  System.out.println(rollno);
		 
	  }
	  B1(String name,String address){
		  super(101);
	  }
}

//single level inheritance  Can child access the parent objects
public class superClassConstructors {
	public static void main(String args[]) {
		B1 b1=new B1();
		
		B1 b=new B1(101);
	}
}



 