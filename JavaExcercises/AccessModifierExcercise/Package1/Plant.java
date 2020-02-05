package Package1;

import java.awt.image.SampleModel;

public class Plant {


	private int iprivate=10; // why do we use // if private then how do we accesss
								// using getter and setter
	protected int iprotected=20;
	
	public int ipublic=30;
	
	
	
	int idefault=40;


	//same class - i can access as it is my ownfamily
	public void sameclassMethod() {
		    System.out.println(iprivate);
			System.out.println(iprotected);
			System.out.println(ipublic);
			System.out.println(idefault);
	 }
	
	public static void main(String[] args) {
		Plant p=new Plant();
		  p.sameclassMethod();
	}
}
