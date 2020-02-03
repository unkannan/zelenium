package AbstractClasses;

//Bank - BankSuperClass
//icici  - can i add
//hdfc
abstract class BankSuperClass{
	int amt=0;	
	
	int withDraw() {
		return amt+1000;
	}
	
	void Deposit(int depositAmount) {
		amt=depositAmount;
	}
	
	void ProvideDebitCard() {
		System.out.println("Please have the debit card for the saving account");
	}
	 //RBI rule every bank should have to give int % whenever you keep the saving account
	abstract void LoanOnSavings();
	abstract void CreditCardAccount();
	abstract void DebitCardAnnualFee();
	
	void StocksAccount() {
		System.out.println("please open the stocks account");
	}
}

class Icici extends BankSuperClass{   	
   void LoanOnSavings() {
	   //action
	   System.out.println("icici loan % is 5");
   }
   void CreditCardAccount() {
	   System.out.println("Credit card provided");
   }
   
   void openPrudentialLifeInsurance() {
	   
   }
   @Override
   void ProvideDebitCard() {
		System.out.println("Please have the debit card for the icici saving account");
	}
   void DebitCardAnnualFee() {
	   
   }
}

class Hdfc extends BankSuperClass{   	
	@Override
	void LoanOnSavings() {
		 System.out.println("Hdfc loan % is 15");
	   }
	 @Override
	 void CreditCardAccount() {
		 System.out.println("Credit card provided");
	   }
	 
	 void hdfcHFL() {
		 
	 }
	 void ProvideDebitCard() {
			System.out.println("Please have the debit card for the hdfc saving account");
		}
	@Override
	void DebitCardAnnualFee() {
		// TODO Auto-generated method stub
		
	}
}


class BankAbstractClass{
	public static void main(String[] args) {
		
		 BankSuperClass BSIcici=new Icici();
			BSIcici.Deposit(1000);
			System.out.println(BSIcici.withDraw());
			BSIcici.LoanOnSavings();
			BSIcici.ProvideDebitCard();
			
		BankSuperClass BShdfc=new Hdfc();
			BShdfc.Deposit(1000);
			System.out.println(BShdfc.withDraw());
			BShdfc.LoanOnSavings();
			BShdfc.ProvideDebitCard();
	}	  
}
//Banksubper class pointing to icici
