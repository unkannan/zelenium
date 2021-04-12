package com.org.enums;
/*
 * These are the warning messages/ error messages which user might see for for invalid inputs.
 * These messages are used to do the validations/verifications
 * */

import java.io.File;

import org.apache.log4j.Logger;


public class AppValidationConstantMessages {
	public static Logger logger = Logger.getLogger(AppValidationConstantMessages.class.getName());

	public static final long IMPLICIT_WAIT_TIME = 10;
	public static final long EXPLICIT_WAIT_TIME = 15;
	
	private static String FileType="png";
	private static String SCREENSHOT_LOCATION =
	        System.getProperty("user.dir") + File.separator + "target"	
	            + File.separator + "photos" + File.separator;
	
	public static String getScreenshotLocation() {
		logger.info("Verifying if dir is available and if not gets created");
		File file = new File(SCREENSHOT_LOCATION);
		boolean dirCreated = file.mkdir();
		logger.info(dirCreated);
		if(dirCreated)
			logger.info("Photos directory is created in target folder");
		else
			logger.info("Photos directory is avaiable in target folder");
		return SCREENSHOT_LOCATION;
	}
	
	public static String getFileType() {
		return FileType;
	}
}


