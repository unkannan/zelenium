package Package1;

public class SubClassSamePackage extends Plant {

	//I cannot access private
	//Same pack so i can access pub, prot,default
	// Any sub class  can access the public, protected and default vairables of super class
	
	public SubClassSamePackage() {    //constructor
		
	}
	
	
	
	public void subclassinsamepck() {
	//	System.out.println(iprivate);
		System.out.println(iprotected);
		System.out.println(ipublic);
		System.out.println(idefault);
	}
	
	
	
	
	public static void main(String[] args) {
		SubClassSamePackage cp=new SubClassSamePackage();
		cp.subclassinsamepck();
		 
	   
}
}
