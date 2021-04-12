  
class Employee{
	
	Employee(){
		System.out.println("Default Constructor with no args");
	}
	Employee(String name){
		//super();
		System.out.println("Constructor called having Arguments having name");
	}
	Employee(int Empno){
		//super();
		System.out.println("Constructor called having integer argument ");
	}
}


public class Constructor_Super {
	 public static void main(String[] args) {
		 Employee e1=new Employee();
		 Employee e2=new Employee("singleArgument");
		 Employee e3=new Employee(10);
	 }
}
