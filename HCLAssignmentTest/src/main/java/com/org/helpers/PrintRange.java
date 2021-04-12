package com.org.helpers;

import org.apache.log4j.Logger;


public class PrintRange {
	
	public static Logger logger = Logger.getLogger(PrintRange.class.getName());
	public String NumbersRange(int[] arr) {
		logger.info("Number Range Method is called");
		int start = arr[0], last = arr[0];
		String output = "";

		for (int i = 1; i <= arr.length; i++)
		{
		  if (i == arr.length || arr[i] != last+1)
		  {
		    if (output.length() != 0)
		      output += ",";
		    if (start == last)
		      output += start;
		    else
		      output += start + "-" + last;
		    if (i != arr.length)
		      start = last = arr[i];
		  }
		  else
		     last = arr[i];
		  
		}
		return output;
	}
}
