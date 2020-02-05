package Package3Excercise;

interface iDatabase{
void update();	
}

class CustomerDB implements iDatabase{

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}

class SupplierDB implements iDatabase{
	 public void update() {
		
	}
}

public class InterObjDatabase {
	
	static int k=10;
	public void method1() {
		
		final int i=9;
		System.out.println(k);
	}
	
	public void method2() {
		System.out.println(k);
	}
	
	public static void main(String args[]) {
	 InterObjDatabase db=new InterObjDatabase();
			 db.method1();
		db.method2();
	}
}
