class HDFCBank{
	
	int money;
	
	int account;
	String actType;
	String name;
	
	void deposit(int amt){
		money=amt;
		
	}
	void withdraw(int amt){
		money=money-amt;
		}
	
	 
}

public class firstProgram {
	public static void main(String args[]){

		HDFCBank Jack=new HDFCBank();
	       Jack.deposit(10000);
	       int money=3000;
	         Jack.withdraw(money);
	         	System.out.println("The jacks money is "+Jack.money);
	         	
	         	HDFCBank Suresh=new HDFCBank();
	         	Suresh.deposit(5000);
	         	Suresh.withdraw(1000);
	 	         	System.out.println("Suresh Money------>"+Suresh.money);
		
		
		
 	 //clasname objectname=new classname(); -  syntax
 	 HDFCBank Raj=new HDFCBank();
 	  
 	
 //	  Raj.money=1000;
 	  	Raj.money=5000;
 	  			System.out.println(Raj.money);
 	  			Raj.account=480;
 	  			Raj.actType="Savings";
 	  			Raj.name="Rajesh";
 	  	
 	  
 	  			
 	  
	
	}

}
