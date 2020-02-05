package Package1;

public class MainApp {

//Ex:1.  Same package -  I can access  public, prot, default;
	
	public static void Example1() {
		Plant p=new Plant();
		//System.out.println(p.iprivate);
		System.out.println(p.iprotected);
		System.out.println(p.ipublic);
		System.out.println(p.idefault);
	}

	public static void main(String[] args) {
		Example1();
		SubClassSamePackage sp=new SubClassSamePackage();
		sp.subclassinsamepck();
	}

	
	
}


