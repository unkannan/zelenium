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
	void Mortgages() {
		System.out.println("icici mortgages");
	}
	@Override
	void interestCalculation() {
		System.out.println("ïcici style of interestcalculation");
	}
}
 
class hdfc extends BankParent{
	void MortgagesofHdfc() {
		System.out.println("hdfc mortgages");
	}
	@Override
	void interestCalculation() {
		System.out.println("hdfc style of interestcalculation");
	}
}

 
public class abstractClasses {
	public static void main(String args[]) {
			 ICICI icicibank=new ICICI();
			// icicibank.Mortgages();
			// icicibank.interestCalculation();
			   
			  		BankParent bp=new hdfc();
			  		bp.savingsAccount();
			  		bp.CurrentAccount();
			  		bp.interestCalculation();
			  		
			  		bp=new ICICI();
			  		bp.interestCalculation();
	}
}
 
    	


