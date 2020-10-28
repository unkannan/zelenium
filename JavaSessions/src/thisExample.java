//this keyword example
//Every object occupy space so java internally assign default values for the variables

class Student{
	int rollno;
	String stdname;
	
	void createStudent(int rollno,String name) {
		this.rollno=rollno;
		this.stdname=name;
	}
	
	void printStudent() {
		System.out.println(rollno);
		System.out.println(stdname);
	}
	
	void assignValues(int rollno, String stdname) {
		this.rollno=rollno;
		this.stdname=stdname;
	}
 
}




public class thisExample {
	public static void main(String args[]) {
		Student s1=new Student();  //create Object
		s1.createStudent(101, "john");//explicity you are calling the method
		s1.printStudent(); //101 john
		
		Student s2=new Student(); 
		s2.printStudent();  
		
		Student RajObj=new Student();
		RajObj.createStudent(102, "Raj");
		RajObj.printStudent(); //102 Raj
	}
}

