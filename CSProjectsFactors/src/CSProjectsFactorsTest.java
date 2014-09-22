import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class CSProjectsFactorsTest {

	@Test
	public void testGetFactorEven() {
		int[] testFactors12 = {12, 6, 4, 3, 2, 1};
		ArrayList<Integer> testFactors = arrayToList(testFactors12);
		Assert.assertEquals("Factors of 12 should be 1, 2, 3, 4, 6, 12", testFactors, Factors.getFactors(12));
	}
	
	@Test
	public void testGetFactorOdd() {
		int[] testFactors45 = {45, 15, 9, 5, 3, 1};
		ArrayList<Integer> testFactors = arrayToList(testFactors45);
		Assert.assertEquals("Factors of 45 should be 45, 7, 5, 1", testFactors, Factors.getFactors(45));
	}
	
	@Test
	public void testGetFactorLow() {
		int[] testFactors1 = {1};
		ArrayList<Integer> testFactors = arrayToList(testFactors1);
		Assert.assertEquals("Factor of 1 should be 1", testFactors, Factors.getFactors(1));
	}
	
	@Test
	public void testGetFactorHigh() {
		int[] testFactors100 = {100, 50, 25, 20, 10, 5, 4, 2, 1};
		ArrayList<Integer> testFactors = arrayToList(testFactors100);
		Assert.assertEquals("Factors of 100 should be 100, 50, 25, 10, 4, 2, 1", testFactors, Factors.getFactors(100));
	}
	
	@Test
	public void testGetFactorTooLow() {
		int[] testFactors0 = {};
		ArrayList<Integer> testFactors = arrayToList(testFactors0);
		Assert.assertEquals("No factors of 0", testFactors, Factors.getFactors(0));
	}
	
	@Test
	public void testGetFactorTooHigh() {
		int[] testFactors101 = {};
		ArrayList<Integer> testFactors = arrayToList(testFactors101);
		Assert.assertEquals("Factors of 101 do not exist within given range", testFactors, Factors.getFactors(101));
	}
	
	@Test
	public void testGetGDCTwoDigits() {
		int[] testGDC2Digits = {24, 34};
		ArrayList<Integer> testGDC = arrayToList(testGDC2Digits);
		Assert.assertEquals("GDC of 24 and 34 should be 2", 2, Factors.getGDC(testGDC));
	}
	
	@Test
	public void testGetGDCFourDigits() {
		int[] testGDC4Digits = {3, 6, 9, 30};
		ArrayList<Integer> testGDC = arrayToList(testGDC4Digits);
		Assert.assertEquals("GDC of 3, 6, 9, and 30 should be 3", 3, Factors.getGDC(testGDC));
	}
	
	@Test
	public void testGetGDCLow() {
		int[] testGDCLow = {1, 34};
		ArrayList<Integer> testGDC = arrayToList(testGDCLow);
		Assert.assertEquals("GDC of 1 and 34 should be 1", 1, Factors.getGDC(testGDC));
	}
	
	@Test
	public void testGetGDCHigh() {
		int[] testGDCHigh = {100, 34};
		ArrayList<Integer> testGDC = arrayToList(testGDCHigh);
		Assert.assertEquals("GDC of 100 and 34 should be 2", 2, Factors.getGDC(testGDC));
	}
	
	@Test
	public void testGetGDCTooLow() {
		int[] testGDCTooLow = {0, 34};
		ArrayList<Integer> testGDC = arrayToList(testGDCTooLow);
		Assert.assertEquals("GDC of 0 and 34 should not return anything", 1, Factors.getGDC(testGDC));
	}
	
	@Test
	public void testGetGDCTooHigh() {
		int[] testGDCTooHigh = {101, 34};
		ArrayList<Integer> testGDC = arrayToList(testGDCTooHigh);
		Assert.assertEquals("GDC of 101 and 34 should not return anything", 1, Factors.getGDC(testGDC));
	}
	
	public static ArrayList<Integer> arrayToList(int[] testArray) {
		ArrayList<Integer> test = new ArrayList<Integer>();
		for(int i = 0; i < testArray.length; i++) {
			test.add(testArray[i]);
		}
		return test;
	}
}
