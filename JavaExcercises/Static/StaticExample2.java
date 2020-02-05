

//All objects to share same variable
class Bankstatic{
	static int count=0;
	//int count=0;
	
	
	void accountCreate() {
		count++; 
		System.out.println(count);
	}
}
 

public class StaticExample2 {
public static void main(String[] args)
{
	Bankstatic b=new Bankstatic();
   b.accountCreate();
  
   
   Bankstatic b1=new Bankstatic();
   b1.accountCreate();
   
   Bankstatic b2=new Bankstatic();
   b2.accountCreate();
   
   Bankstatic b3=new Bankstatic();
   b3.accountCreate();
    
}
}
