package Package2;

 
import Package1.Plant;// to use the super class or any class from other package

public class ChildClassDiffPackage extends Plant {
	
	//if different package
	//i can access only pub, prot if extend my parent
		public void Example2()  {
			
			//System.out.println(p.iprivate);
			System.out.println(iprotected);
			System.out.println(ipublic);
			//System.out.println(p.idefault);
		}
	
		public static void main(String[] args) {
			ChildClassDiffPackage cp=new ChildClassDiffPackage();
			cp.Example2();
		   
	}
}
