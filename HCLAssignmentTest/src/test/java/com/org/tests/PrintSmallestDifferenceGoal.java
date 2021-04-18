package com.org.tests;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class PrintSmallestDifferenceGoal {
	public static Logger logger = Logger.getLogger(PrintSmallestDifferenceGoal.class.getName());
	
	@Test
	public void TeamWithSmallestDifferenceGoal() throws IOException {
		logger.info("*********************************************");
		logger.info("Test Case Started for: TeamWithSmallestDifferenceGoal");
		String fileContent = "";
		String datfilepath="resources//football.dat";
		String TeamName = null;
		int ForGoal = 0;
		int AgainstGoal = 0; 
		int flag=0;int PresentDifference=0; int SmallestDifferenceGoal=0;
		BufferedReader fileStream =null; 
		int IndexTeamName=1,IndexForGoal=6,IndexAgainstGoal=8;
		
			 fileStream =ProvideFileStream(datfilepath);
			 String temp = fileStream.readLine();
			
			 while (temp != null) {
				fileContent = fileContent + " " + temp;
				temp = fileStream.readLine();
				String[] values = fileContent.split(" "); // Get the values
				int j = 0;
				
				for (int i = 0; i < values.length; i++) {// For each value
					if (values[i].length() > 0) {
						if (j == IndexTeamName)
							TeamName = values[i];
						if ((j == IndexForGoal || j == IndexAgainstGoal) && values[i] != "-") {
							if (j == 6)
								try {
									ForGoal = Integer.parseInt(values[i]);
								} catch (Exception e) {}
							 if(j==8) {
								 AgainstGoal=Integer.parseInt(values[i]);
								 PresentDifference=ForGoal-AgainstGoal;
								 flag=1;
							 }
						}
						j++;
					}
					if(flag==1) {
						if(SmallestDifferenceGoal>PresentDifference){
							SmallestDifferenceGoal=PresentDifference;
						}
					}
					flag=0;
				}
				fileContent = "";
			}
			 logger.info("team with the smallest difference in ‘for’ and ‘against’ goals is");
			 logger.info(TeamName+"  "+SmallestDifferenceGoal);
			fileStream.close();
			assertEquals(TeamName, "Leicester");
			assertEquals(SmallestDifferenceGoal, -34);
	}
	
	public BufferedReader ProvideFileStream(String Filepath){
		try {
			FileReader file = new FileReader(Filepath);
			BufferedReader fileStream = new BufferedReader(file);
			 return fileStream;
		}catch (FileNotFoundException e) {

			logger.info("No file was read");
		}
		return null;
	}

}