

public class ClassGetSetter {
	private int accoutno;
		private String name;
		private String BankName="HDFC";
		int getAcctno(){
			return accoutno;
		}
		String getAcctname(){
			return name;
		}
		String getBankName() {
			return BankName;
		}
		//class as readyonly   write only
		 void setAccountDetails(int accoutnumber,String name) {
	/*		 if(name is an alphabet)
			if *number is digits and int*/
				 this.accoutno=accoutnumber;
				this.name=name;
				
	}
	
		 public static void main(String[] args) {
			 
			 ClassGetSetter c=new ClassGetSetter();
			 
			 c.setAccountDetails(4804,"Gauri");
			 ClassGetSetter c1=new ClassGetSetter();
			 
		//	 c1.setAccountDetails(4804,"xflddsamlfmdsl;fmsd;lfmsdlmfl;sdnfl;sdnmfldsnlfnmsdlfmldskfok@@#@#!@$@##@424");
		//	 ClassGetSetter c2=new ClassGetSetter();
		//	 c2.setAccountDetails(24324314513531513413,"xflddsamlfmdsl;fmsd;lfmsdlmfl;sdnfl;sdnmfldsnlfnmsdlfmldskfok@@#@#!@$@##@424");
			 
			 int actno=c.getAcctno(); 
			 String actname=c.getAcctname();
			 String BankName=c.getBankName();
			 System.out.println(actno+actname+BankName);
			 
			 
			 
		 }
}
