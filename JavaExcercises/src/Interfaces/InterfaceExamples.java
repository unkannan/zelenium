package Interfaces;

//all methods in interface is a abstract
//becos all are abstract by default
//by default all variables are final in the interface

 interface FlyInterface{
	final int wings=2;
	void canFly(); 
}
 
 interface LivingThing{
	 void canEat();
 }
 
 interface Organs{
	 void legs();
	 void sound();
	 
 }
 
 class BodyParts{
	 public void feathers() {}
	 
 }
 

 class Bird implements FlyInterface,LivingThing,Organs{

	@Override
	public void canFly() {
		System.out.println("I am a bird and i have two wings "+wings);
		System.out.println("Birds can fly");
		
	}

	@Override
	public void canEat() {
		 System.out.println("can Eat");
		
	}

	@Override
	public void legs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		
	}
	
}

 class Aeroplane implements FlyInterface{

	@Override
	public void canFly() {
		System.out.println("I am aeroplance and have two wings "+wings);
		System.out.println("Aeroplance can fly");
		
	}
		
}


public class InterfaceExamples {
  public static void main(String[] args) {
	  FlyInterface b=new Bird();
	  b.canFly();
	  FlyInterface a=new Aeroplane();
	  a.canFly();
  }
	
}
 