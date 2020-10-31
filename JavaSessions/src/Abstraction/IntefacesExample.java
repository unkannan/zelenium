package Abstraction;

interface Vehicle{
     void runs_on();
}

interface Engine{
	 void enginesystem();
}
class plane implements Vehicle,Engine{

	@Override
	public void runs_on() {
		System.out.println("plane would fly");
	}
	@Override
	public void enginesystem() {
		System.out.println("plane has flying enginesystem");
		
	}
   
}

class car implements Vehicle{

	@Override
	public void runs_on() {
		System.out.println("car runs on road");
	}
   
}
public class IntefacesExample {
  public static void main(String args[]) {
	   Vehicle v=new plane();   v.runs_on();
	    Vehicle c=new car();   c.runs_on();
	    
  }
}
