class BankParent{
	int loan;
	
	void savingsAccount() {
		System.out.println("Saving Account");
	};
	void CurrentAccount() {
		System.out.println("Current Account");
	};
}

class ICICI extends BankParent{
	void sharesAccount() {
		System.out.println("child method - shares account");
	}
	void Mortgages() {
		System.out.println("child method - mortgages account");
	}
}
  
   
class iciciHomeLoans extends ICICI{  //savings, current, homeloans  but cannot access sharesaccoutn or mortgages
	void Homeloans() {
		System.out.println("homeloans");
	}
}
 
//single level inheritance  Can child access the parent objects
public class inheritanceExample {
	public static void main(String args[]) {
			ICICI child=new ICICI();
			  child.sharesAccount();
			  child.Mortgages();
			   
			   
			  	child.savingsAccount();
			  	child.CurrentAccount();
			  	
			  	BankParent parent=new BankParent();
			  			parent.savingsAccount();
			  			parent.CurrentAccount();  //parent.sharesAccount();
			  			
	}
}


