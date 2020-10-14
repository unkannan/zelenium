//1. Method with out arguments or parameters
//2. Mehods with arugments or parameters
//3. Methods with return types;
//4. Methods with arguments and return types
//5. Classes
//6. class print
//7. one package and you can hv different classes
//8. chrome , IE  (IE in one package or lib) import and use them
// java.io.file

class Bank {

	int moneydeposit;
	int Customerid;

	void customerCreate(int money) {

		moneydeposit = money;
	}

	void createSavingsAccount(int custid, int money) {
		if (money >= 1000) {
			customerCreate(money);
			System.out.println("Savings accoutnis created for Customer" + custid);
			System.out.println("Money deposited" + money);
		} else
			System.out.println("deposity poclicy is not met");
	}

	void createCurrentAccout() {

	}

	void createHomeLoans() {
	}

	int presentLoanInterestRate() {
		return 10;
	}
}

public class ClassAndObjectsExample {

	public static void main(String args[]) {
		Bank ICICI = new Bank();
		ICICI.createSavingsAccount(102, 900);

		int loanintrate = ICICI.presentLoanInterestRate();
		System.out.println(loanintrate);

		Bank HDFC = new Bank();
		HDFC.createSavingsAccount(103, 1100);

	}
}

//can u call a mehod from a class with our objects - 
