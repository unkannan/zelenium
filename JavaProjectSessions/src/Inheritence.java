class Vehicles{
	public void engine() {
		System.out.println("Base Class Engine built");
	}
	private void gears() {
		System.out.println("gears method");
	}
	protected void Stirring() {
		System.out.println("Stirring method");
	}
	
	void speed() {
		System.out.println("speed method");
	}
	
}



class car extends Vehicles{
	void Suv() {
		engine();
		System.out.println("Suv model built");
		Stirring();
	}
	void speed() {
		System.out.println("speed method");
	}
	
}

class Bus extends Vehicles{
	void cyntel() {
		engine();
		System.out.println("bus constructed");
		speed();
	}
	void speed() {
		System.out.println("speed method");
	}
	
}

class smallCAR extends Vehicles{  // But java will not allow you to have multiple inher
	
}

public class Inheritence {
	 public static void main(String[] args) {
		 car c1=new car();
		 c1.Suv();
		 
		 Bus b1=new Bus();
		 b1.cyntel();
	 }
}
