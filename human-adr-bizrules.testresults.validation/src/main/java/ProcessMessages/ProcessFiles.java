package ProcessMessages;

import java.io.IOException;
import eu.europa.ema.phv.adr.tests.*;


public class ProcessFiles{
	/*
	public void HumanFilesSendToQueue() {
	 String HUMANdestnationResourceAbsPath="c://data";//"./src/main/resources/HumanFunctionalTestData/";
			RunAllFunctionalFiles run=new RunAllFunctionalFiles();
			try {
				run.HUMAN_SendToQueueRun(HUMANdestnationResourceAbsPath);
			} catch (IOException e1) {
		// 	TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
*/
	public void HumanFilesSendToQueue() {
		 String HUMANdestnationResourceAbsPath="c://data";//"./src/main/resources/HumanFunctionalTestData/";
		 RunAllFunctionalFiles run=new RunAllFunctionalFiles();
		// eu.europa.ema.phv.adr.messaging.tests.FunctionalTestCases.RunAllFunctionalFiles
				try {
					run.HUMAN_SendToQueueRun1(HUMANdestnationResourceAbsPath);
				} catch (IOException e1) {
			// 	TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}

	
}
