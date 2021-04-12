class Bank2{
	
	String name; int amt;
	
	Bank2(String name,int amt){
		System.out.println("2 arg constructor");
		this.name=name;
		System.out.println(name);
		System.out.println(amt);
	}
	
	Bank2(int amt){
		System.out.println("1 arg constructor");
		System.out.println(amt);
	}
	 
	Bank2(){
		System.out.println("Bank2 defult constructor");
	}
	void totalBalance() {
		System.out.println("total balance");
	}
}

class Bank3{
	Bank3(){
		System.out.println("default constructor");
	}
	void totalBalance() {
		System.out.println("total balance");
	}
}


public class Constructors {
	  public static void main(String[] args) {
		  Bank2 b=new Bank2("Raj",10000);
		  b.totalBalance();
		  
		  
		  Bank2 b2=new Bank2(10000);
		  b2.totalBalance();
		  //b2.Bank2();
		  
		 //Bank2 b3=new Bank2();
		  							
		  Bank3 b4=new Bank3();
	  }
}
