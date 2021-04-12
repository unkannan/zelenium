class calculation{
//state
	//actions
	  public void largestnumbercheck() {
		  double n1 = -4.5, n2 = 3.9, n3 = 2.5;

	        if( n1 >= n2 && n1 >= n3)
	            System.out.println(n1 + " is the largest number.");

	        else if (n2 >= n1 && n2 >= n3)
	            System.out.println(n2 + " is the largest number.");

	        else
	            System.out.println(n3 + " is the largest number.");
	  }
	  
	  public void add() {
		  int first = 10;
	        int second = 20;
	        System.out.println("Enter two numbers: " + first + " " + second);
	        int sum = first + second;
	        System.out.println("The sum is: " + sum);
	  }
	  
	  public int add_new() {
		  int first = 10;
	        int second = 20;
	        System.out.println("Enter two numbers: " + first + " " + second);
	        int sum = first + second;
	        System.out.println("The sum is: " + sum);
			return sum;
	  }
}
class StringOperations{ //access modifier -  public, private, prot, default
	 String style = "Bold";
     String style2 = "Bold";
	
	void comparetwoStrings(){
	        if(this.style == this.style2)
	            System.out.println("Equal");
	        else
	            System.out.println("Not Equal");
	}
	void comparetwoStrings(String a, String b){ //method overaloading  - overriding
        if(a == b )
            System.out.println("Equal");
        else
            System.out.println("Not Equal");
	}
	
	
	String concattwoStrings(String a, String b){ //method overaloading  - overriding
		 String c= a.concat(b);
		 return c;
	}
}
public class FewExamples {
	    public static void main(String[] args) {
	        calculation c1=new calculation();
	        c1.largestnumbercheck();
	        c1.add();
	        int sum=c1.add_new();
	        System.out.println(sum);
	      
	        
	        
	         StringOperations s1=new StringOperations();
	        String c=s1.concattwoStrings("unni","kannan");
	        System.out.println(c);
	        String k=s1.concattwoStrings("java","language");
	        System.out.println(k);
	         
	        
	        
	    }
}
