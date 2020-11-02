package com.gurukula.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.gurukula.pages.TechBeamersPage;
import com.gurukula.utility.Init;

public class WebTableExcercise  extends Init {
	
	public static Logger logger = Logger.getLogger(WebTableExcercise.class.getName());

	TechBeamersPage techBeamersPG;
	 
		@Test
		public void WebTableExcercise1() {
		 preSteps();
		 techBeamersPG.elementsinLearnPythonList();
		}
	
		private void preSteps() {
		 	techBeamersPG = new TechBeamersPage(driver);
		}
		
}
