package com.org.helpers;

import org.apache.log4j.Logger;

public class AreaCalculatehelper{
	
	public static Logger logger = Logger.getLogger(AreaCalculatehelper.class.getName());
	
	public float getTraingleArea(float base,float height) {
		logger.info("AreaCalculatehelper is called");
		return (base*height) / 2 ;  
		
	}

}
