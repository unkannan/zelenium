package Abstraction;

public class carAbstractClass {
  public static void main(String args[]){
	     CARS c=new hyundai();  c.gearsystem();
	      c=new suzuki();  c.gearsystem();  // CARS z=new suzuki(); z.gearsystem();
	      
	    
  }
}

class hyundai extends CARS{

	@Override
	void gearsystem() {
		System.out.println("hyundai gears");
	}

	@Override
	void breakSystem() {
	}

	@Override
	void Engine() {
	}
	
}

class suzuki extends CARS{
	 void mileage() {
		 System.out.println("high mileage");
	 }

	@Override
	void gearsystem() {
		System.out.println("suzkui gears");
	}

	@Override
	void breakSystem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void Engine() {
		// TODO Auto-generated method stub
		
	}
}


abstract class CARS
	{  
		CARS(){
			System.out.println("this is a constructor");
		}
	    abstract void  gearsystem(); 
		abstract void breakSystem(); 
		abstract void Engine();  
		
		void tyreshave4(){
		     System.out.println("has 4 tyres"); //body - definition of the method
			} //  common method
		void powerSteering() 
			{
			System.out.println("this is powersteering");
			}//  common method
	}
