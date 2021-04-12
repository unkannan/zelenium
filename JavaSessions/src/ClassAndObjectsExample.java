//1. Method with out arguments or parameters
//2. Mehods with arugments or parameters
//3. Methods with return types;
//4. Methods with arguments and return types
//5. Classes
//6. class print
//7. one package and you can hv different classes
//8. chrome , IE  (IE in one package or lib) import and use them
// java.io.file

class Bank{
	int money;
	String name;
	 
	
	void CreateAccount(int money,String name) {
		this.money=money;
		this.name=name;
		System.out.println("Account Created");
	}
	void printBankDetails() {
		System.out.println("Money Deposited="+money);
		System.out.println("The account name is ="+name);
	}
	
	//Constructors //method which has same class name
	 public Bank(int money,String name){
		this.money=money;
		this.name=name;
		System.out.println("Account Created");
		
	}
	public Bank(){
		System.out.println("default constructor");
	}
	protected Bank(int a, int b, int c){
		System.out.println("3 parameter constructor");
	}
	
}


public class ClassAndObjectsExample{
	public static void main(String args[]) {
		Bank icici=new Bank();
		icici.CreateAccount(1000, "xyz");
		icici.printBankDetails();
		
		Bank Rajesh=new Bank(5000,"Rajesh");
		Rajesh.printBankDetails();
		
		Bank Mahesh=new Bank(10000,"Mahesh");
		
		
		Bank kk=new Bank();
		Bank Suresh=new Bank(15000,"Suresh");
		Bank kk1=new Bank(10,20,30);
		 
		
	}
}


//can u call a mehod from a class with our objects - 

// Bank- state - moneydeposit, Customerid   

//-behavrio - customerCreate,createSavingsAccount, createCurrentAccout, createHomeLoans,
//presentLoanInterestRate

