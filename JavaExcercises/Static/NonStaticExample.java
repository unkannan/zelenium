


	
	//All objects to share same variable
	class Bank1{
		int count=0;
		Bank1(){
		//	count=count+1;
		}
	}
	
	class AxisBank1 extends Bank1{
		AxisBank1(){
			count=count+1;
		}
	}
	
	class iciciBank1 extends Bank1{
		iciciBank1(){
			count=count+1;
		}
	}
	
	class hdfcBank1 extends Bank1{
		hdfcBank1(){
			count=count+1;
		}
	}
	
	public class NonStaticExample {
	public static void main(String[] args)
	{
		Bank1 b=new Bank1();
	   System.out.println(b.count);
	   AxisBank1 a=new AxisBank1();
	   System.out.println(a.count);
	   iciciBank1 i=new iciciBank1();
	   System.out.println(i.count);
	   hdfcBank1 h=new hdfcBank1();
	   System.out.println(h.count);
	}
}
