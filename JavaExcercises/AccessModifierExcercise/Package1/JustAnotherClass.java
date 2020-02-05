package Package1;

public class JustAnotherClass {

	//i cannot access any one in parent until i create an object
	//if object then can access all except private
	public void subclassinsamepck() {
		Plant p=new Plant();
		//System.out.println(p.iprivate);
		System.out.println(p.iprotected);
		System.out.println(p.ipublic);
		System.out.println(p.idefault);
	}
}
