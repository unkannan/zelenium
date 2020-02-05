

//All objects to share same variable
class Bank{
	static int count=0;
	Bank(){
	//	count=count+1;
	}
}

class AxisBank extends Bank{
	AxisBank(){
		count=count+1;//1
	}
}

class iciciBank extends Bank{
	iciciBank(){
		count=count+1;//2
	}
	void method() {}//declaration
	//void method1() {slfjsdlfj;slafjslf}
}

class hdfcBank extends Bank{
	hdfcBank(){
		count=count+1;
	}
}

public class StaticExample {
public static void main(String[] args)
{
	Bank b=new Bank();
   System.out.println(b.count);//0
   AxisBank a=new AxisBank();
   System.out.println(a.count);
   iciciBank i=new iciciBank();
   System.out.println(i.count);
   hdfcBank h=new hdfcBank();
   System.out.println(h.count);
}
}
