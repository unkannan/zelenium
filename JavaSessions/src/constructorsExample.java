
class Students{
	int rollno;
	String stdname;
	String address;
	
	//this keyword used to call local class constructors
	Students(int rollno,String stdname,String address){
		    this(rollno);         //assigning rollno.
				this.stdname=stdname;  //this(rollno,stdname);   
				   this.address=address;
	}
		//Same class name
	//constructors will not have return types
	Students(int rollno){
		this.rollno=rollno;
	}
	
	Students(int rollno,String stdname){
		this.rollno=rollno;
		this.stdname=stdname;
	}
	//constructor with no arguments
	Students(){
		System.out.println("this is a school");
	}
	
	void createStudent(int rollno,String name) {
		this.rollno=rollno;
		stdname=name;
	}
	
	void printStudent() {
		System.out.println(rollno);
		System.out.println(stdname);
	}
	
}

public class constructorsExample {
	public static void main(String args[]) {
		Students S3=new Students(103);  // parameterized constructors
		//S3.createStudent(rollno, name);
		Students S4=new Students(104,"Jacob");  // Overload constructors
		S4.printStudent();
		Students S5=new Students(105,"Rajesh","NL");
		
		
		
	}
}

//public private, default, protected
//static, final

