package ProcessMessages;

import java.io.File;
import java.io.IOException;
import org.junit.*;
import ProcessMessages.SendToQueueAppTest; 


public class RunAllFunctionalFiles {
	
	static String ExcelFilePath="C:\\Data\\data.xlsx";  
	static String VETResourceFolderPath="/VETFunctionalTestData/";
	static String HUMANResourceFolderPath="/HumanFunctionalTestData/";
	static String inboxQueue="jms/phv/messaging-inbox"; 
	static String VetProdLikeadrinboxphv06Queue="jms/phv/vet/adr/message_queue";
	static String Humanadrinboxphv06Queue="jms/phv/human/adr/gateway_read";
	static String srcfolder="C:\\Project\\TestData\\R3\\4.CT-backlog\\";
	static String VETdestnationResourceAbsPath="C:\\Users\\kannanu\\eclipse-workspace\\adr-messaging-tests\\src\\main\\resources\\VETFunctionalTestData\\";
	static String HUMANdestnationResourceAbsPath="C:\\Users\\kannanu\\eclipse-workspace\\adr-messaging-tests\\src\\main\\resources\\HumanFunctionalTestData\\";

    
   //@Test
  	 public void VET_SendToQueue() throws IOException { 		    			
  		    File folder = new File(VETdestnationResourceAbsPath);
  	    	File[] listOfFiles = folder.listFiles();
  	    	for (File file : listOfFiles) {
  	    	    if (file.isFile()) {
  	    	        System.out.println(file.getName());
  	    	          String FileName=VETResourceFolderPath +file.getName();
  	    	         // String[] args = {FileName,VetProdLikeadrinboxphv06Queue};
  	    	          		String[] args = {FileName,inboxQueue};
  	    	          			SendToQueueAppTest app=new SendToQueueAppTest();
  	    	          				app.fun(args);
  	             }
  	    	}
  	 }	    
    

  @Test
 	 public void HUMAN_SendToQueue1() throws IOException { 		   
 		    File folder = new File(HUMANdestnationResourceAbsPath);
 	    	File[] listOfFiles = folder.listFiles();
 	    	for (File file : listOfFiles) {
 	    	    if (file.isFile()) {
 	    	        System.out.println(file.getName());
 	    	          String FileName=HUMANResourceFolderPath +file.getName();
 	    	     //  String[] args = {FileName,Humanadrinboxphv06Queue};
 	    	        String[] args = {FileName,inboxQueue};
 	    	          	SendToQueueAppTest app=new SendToQueueAppTest();
 	    	          		app.fun(args);
 	             }
 	    	}
  }
 	    	
 	    	 public void HUMAN_SendToQueueRun1(String HUMANdestnationResourceAbsPath) throws IOException { 		   
 	 		    File folder = new File(HUMANdestnationResourceAbsPath);
 	 	    	File[] listOfFiles = folder.listFiles();
 	 	    	for (File file : listOfFiles) {
 	 	    	    if (file.isFile()) {
 	 	    	        System.out.println(file.getName());
 	 	    	          String FileName=HUMANdestnationResourceAbsPath +file.getName();
 	 	    	     //  String[] args = {FileName,Humanadrinboxphv06Queue};
 	 	    	        String[] args = {FileName,inboxQueue};
 	 	    	          	SendToQueueAppTest2 app=new SendToQueueAppTest2();
 	 	    	          		app.sendToQueue(FileName,HUMANdestnationResourceAbsPath,inboxQueue);
 	 	             }
 	 	    	}
 	 }	    
}
	
