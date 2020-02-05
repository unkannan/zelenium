package FinalPackage;

//import org.omg.DynamicAny.DynAnyPackage.InvalidValue;

class BankFinalPackage{
  final int minimumBalance=1000; 
  
    String actType;
    BankFinalPackage(String acttype){    //constructor
    	actType="HousingLoan";
    }
    void SuperClasMethod() {
    	
    }
}

class AxisFinalPackage extends BankFinalPackage{
	
	//create an object pass what accoutn type it is
	public AxisFinalPackage(String acttype) {
		super(acttype);    // BankFinalPackage(acttype)
		//super.actType=acttype;
		//super.SuperClasMethod();
	}
	
	
	void accountCreate(int amt) {
		if(amt>=minimumBalance)
			System.out.println("account created in Axis");
		else
		{
			System.out.println("account cannot be created with less than min bal");
			throw new IllegalAccessError();
	}
	}
}

class PunjabBankFinalPackage extends BankFinalPackage{
	
PunjabBankFinalPackage(String acttype) {
		super(acttype);
		// TODO Auto-generated constructor stub
	}

void accountCreate(int amt) {
	//minimumBalance=500;
	if(amt>=minimumBalance)
		System.out.println("account created in punjabNational");
	
	else
	{
		System.out.println("account cannot be created with less than min bal");
		throw new IllegalAccessError();
}
	}
}

public class FinalExample {
	public static void main(String[] args) {
	AxisFinalPackage a=new AxisFinalPackage("Savings");
	a.accountCreate(1000);
	
	AxisFinalPackage Parvathy=new AxisFinalPackage("Current");     //calls axibank constructor-parameter ,    automatically send a commu to superclass
	
	PunjabBankFinalPackage p=new PunjabBankFinalPackage("Current");
	p.accountCreate(501);
	}
}






// Bank  - minimum value 1000
//open the act if it is below 1000
//RBI rule - cannot rbi rule

 





 























