//overriding
//
class A  {
	A(){
		 System.out.println("super class constructor is called");
	}
void method1() {
	System.out.println("parent method1");
}
	void parentmethod() {
		System.out.println("parentmethod");
 }
}

class B extends A{
	  
  void method2() {}
  void method2(int l) {}
  void method2(int k1, String k) {}
  
  void method1(){
    super.method1();
	  System.out.println("child method1");
  }
}

//single level inheritance  Can child access the parent objects
public class overloadedmethods {
	public static void main(String args[]) {
		B b1=new B();
		B b=new B();
        b.method2();  b.method2(10); b.method2(10,"raj");
       
        b.parentmethod();
     
        b.method1();  //java will give priority to local method
	}
}
 
