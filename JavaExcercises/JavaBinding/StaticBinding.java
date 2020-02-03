

   class parentClass{
	   int ParentClassVariables=20;
	
	   void printParent() {
		   System.out.println("Hi I am ParentClass");
	   }
	}
   
   
   
	class childClass extends parentClass{
		int childClassvariable=10;
		  
		
		void printChild() {
			   System.out.println("Hi I am ChildClass");
		   }
	}
		
	
	
public class StaticBinding {
	public static void main(String[] args) {
		
		childClass c=new childClass();
		c.printChild();
		c.printParent();
		
		
		//childClass c=new childClass();
		 //c.parentClassMethod();
		 //c.childClassMethod();
	}
	
}
