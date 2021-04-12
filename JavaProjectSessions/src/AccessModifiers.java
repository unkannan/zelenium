class Bank{
    private int money;
    private int account;
	public String actType;
	protected String name;
	//Policy that it can accept only 10000 and you cannot open an act with les than this
	
	void deposit(int amt){
		if(amt<10000)
			System.out.println("cannot create an account");
		else
		{
			money=amt;
			System.out.println("account created succesfully");
		}
	}
	void withdraw(int amt){
		money=money-amt;
		}
	void totalBalace() {
		System.out.println(money);
	}
}

public class AccessModifiers {
	public static void main(String args[]){
		Bank Jack=new Bank();
		  Jack.deposit(15000);
		  Jack.totalBalace();
		  
		 // Jack.money=5000;
		//  Jack.totalBalace();
	}
}
