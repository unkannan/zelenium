//Default constructor
//Parameterized Constructor
//Overloading in Java
//Copy Constructor
//Difference between constructor and method i
class constructorExample {
	constructorExample(){
	   System.out.println("default constructors");
   }
   
	//can i overload
	constructorExample(String accttype){
		   System.out.println("single parameter constructors");
	   }
	
	//can i overload // same name different signatures
		constructorExample(String accttype, String actDetails){
			   System.out.println("two parameter constructors");
		   }
}

//default when object is created - default constructor - which has 



public class ConstructorTest{
	public static void main(String[] args) {
		constructorExample c=new constructorExample();   //constructors is called when declarations of objects done
		// c.constructorExample();
		constructorExample d=new constructorExample("saving");   //c
		constructorExample e=new constructorExample("savings","NRI");   //c
	}
	
}


