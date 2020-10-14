package Abstraction;

 abstract class BankParent{
	int loan;
	void savingsAccount() {
		System.out.println("Saving Account");
	};
	void CurrentAccount() {
		System.out.println("Current Account");
	};
	abstract void interestCalculation(); //  no definition
}
  
class ICICI extends BankParent{
	void sharesAccount() {
		System.out.println("child method - shares account");
	}
	void Mortgages() {
		System.out.println("child method - mortgages account");
	}
	@Override
	void interestCalculation() {
		System.out.println("ïcici style of interestcalculation");
	}
}
 
 
public class abstractClasses {
	public static void main(String args[]) {
			 ICICI icicibank=new ICICI();
			 icicibank.sharesAccount();
			 icicibank.Mortgages();
			 icicibank.interestCalculation();
			  		 
	}
}
 
    	


