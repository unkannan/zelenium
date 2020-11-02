package Abstraction;

class Bank{
	private int depositMoney;
	  private int fixedincome;
	  
	public void setdepositMoney(int money) {
		if(money>1000)
		depositMoney=money;
		else
			System.out.println("wrong amt");
	}
	public int getdepositmoney() {
		return depositMoney;
	}
	
	 
	void deposit(){
		System.out.println(getdepositmoney());
	}
	void withdraw(int withdrawamt) {
		
		System.out.println(depositMoney-withdrawamt);
	}
}

public class getSetterExample {
   public static void main(String args[]) {
	   Bank b=new Bank();
	   
	    b.setdepositMoney(1001);
	   
	    int k=b.getdepositmoney();
	    
	    System.out.println(k);
	    Bank b1=new Bank();
	    b.setdepositMoney(-39999);
	    b.withdraw(90);
	    
	   }
   }
