package com.org.tests;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.org.helpers.AreaCalculatehelper;
import com.org.helpers.PrintRange;

public class AdhocTestCaseRun {
	public static Logger logger = Logger.getLogger(PrintRange.class.getName());

	@Test
	public void PrintGiveRange() {
		PrintRange p = new PrintRange();
		logger.info("Array Range of Numbes is declared");
		int[] arr = { 1, 2, 3, 4, 5, 6, 8, 10, 11 };
		String outputActual = p.NumbersRange(arr);
		String expected = "1-6,8,10-11";
		logger.info("outputActual:" + outputActual);
		assertEquals(outputActual, expected);

	}

	@Test
	public void TriangleArea() {
		logger.info("Test in progress to calculate the area of the triangle");
		AreaCalculatehelper Areacalculator = new AreaCalculatehelper();

		float base = 4;
		float height = 13;

		float areaActualResult = Areacalculator.getTraingleArea(base, height);
		float expectedResult = (float) 26.0;
		assertEquals(areaActualResult, expectedResult, 0.0f);
	}
}
