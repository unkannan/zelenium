
 
	
	class Bank{
		   int ParentClassVariables=20;
		   void parentMethod() {
			   System.out.println("Hi I am ParentClass");
		   }
		   
		   void deposit()
		   {
			   System.out.println("depoisited amount in Main Bank");
		   }
		}
	
	
	
		class ICICI extends Bank{
			int childClassvariable=10;
			   void childMethod() {
				   System.out.println("Hi I am ChildClass");
			   }
			   
			   void deposit()
			   {
				   System.out.println("depoisited amount in ICICI Bank");
			   }
		}
			
		
		
	public class DynamicBinding {
		public static void main(String[] args) {
			
			Bank p=new Bank();
		   //   p.parentMethod();
		      p.deposit();
		      
		      Bank i=new ICICI();
		      i.deposit();
		}
	}
