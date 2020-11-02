package EncapsulateJavaSession;
//public, protected, private and no access modifier (default)

public class Bank{
	public int pubi=10;
	protected int proti=20;
					private int pvti=30;
	int defaulti=40;
	public void print() {
		System.out.println(pvti);
	}
	
	private void interest() {
		System.out.println(pvti);
	}
}

class childClass extends Bank{
	void method2() {
		//child class can access public
	 System.out.println(pubi);
	     //Child class cannot access private variables of superclass
	// System.out.println(pvti);
	  //child class can access all protected variables of super class
	 System.out.println(proti);
	 //child class cann access the defaults or no access modifiers
	 System.out.println(defaulti);
	 print();
	 
	}
}
 
 
