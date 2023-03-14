package org.jfree.data;

import static org.junit.Assert.*;
import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTestA2 {
	private Range range1;
	private Range range2;
	private Range range3;
	
	@BeforeClass public static void setUpBeforeClass() throws Exception {
	}
	
	@Before
	public void setup() throws Exception {
		range1 = new Range(-1,1);
		range2 = new Range(-10,0);
		range3 = new Range(1,10);
	}	

	 
	// Testing method combine(Range range1, Range range2)
	@Test
    public void CombineOverlappingRanges() throws Exception{
		Range r1 = new Range(0, 5);
		Range r2 = new Range(3, 10);
		Range result = Range.combine(r1, r2);
		Range expected = new Range(0, 10);
    	assertEquals("The combined range should be 0, 10", result, expected);
    }
	
	// Testing method combine(Range range1, Range range2)
	@Test
    public void CombineSubsetRanges() throws Exception{
		Range r1 = new Range(0, 5);
		Range r2 = new Range(1, 2);
		Range result = Range.combine(r1, r2);
		Range expected = new Range(0, 5);
    	assertEquals("The combined range should be 0, 5", result, expected);
    }
	
	// Testing method combine(Range range1, Range range2)
	@Test
    public void CombineSeparatedRanges() throws Exception{
		Range r1 = new Range(0, 1);
		Range r2 = new Range(3, 4);
		Range result = Range.combine(r1, r2);
		Range expected = new Range(0, 4);
    	assertEquals("The combined range should be 0, 4", result, expected);
    }
	// Testing method combine(Range range1, Range range2)
	@Test
    public void CombineAdjacentRanges() throws Exception{
		Range r1 = new Range(0, 1);
		Range r2 = new Range(1, 2);
		Range result = Range.combine(r1, r2);
		Range expected = new Range(0, 2);
    	assertEquals("The combined range should be 0, 2", result, expected);
    }
	
    @Test
    public void CombinedRangeShouldBeRange1() throws Exception{
    	assertEquals("The combined range should be -1,1",range1,Range.combine(range1,null));
    }
    
    @Test
    public void CombinedRangeShouldBeRange2() throws Exception{
    	assertEquals("The combined range should be 1,2",range2,Range.combine(null,range2));
    }
    
    @Test
    public void CombinedRangeShouldBeNull() throws Exception{
    	assertNull("The combined range should be null", Range.combine(null, null));
    }
    
    // Testing method constrain(double value)
    @Test
    public void ConstrainReturnValueShouldBeLowerBound() throws Exception {
    	double constrainValue = range1.constrain(-5);
    	assertEquals("The expected value was -1.0 but the returned value was " + constrainValue, -1.0, constrainValue, .000000001d);
    }
    
    @Test
    public void ConstrainReturnValueShouldBeUpperBound() throws Exception {
    	double constrainValue = range1.constrain(10);
    	assertEquals("The expected value was 1.0 but the returned value was " + constrainValue, 1.0, constrainValue, .000000001d);
    }
    
    @Test
    public void ConstrainReturnValueShouldBe5() throws Exception {
    	double constrainValue = range3.constrain(5);
    	assertEquals("The expected value was 5.0 but the returned value was " + constrainValue, 5.0, constrainValue, .000000001d);
    }
    
    @Test
    public void ConstrainReturnValueShouldBe0() throws Exception {
    	Range testRange = new Range(0, 0);
    	double constrainValue = testRange.constrain(-5);
    	assertEquals("The expected value was 0.0 but the returned value was " + constrainValue, 0.0, constrainValue, .000000001d);
    }
    
    // Testing method contains(double value)
    @Test
    public void ContainsReturnsTrue() throws Exception {
    	assertTrue("Contains should return true for argument 2 on range3",range3.contains(2));
    }
    
    @Test
    public void ContainsReturnsFalse() throws Exception {
    	assertFalse("Contains should return false for argument -5 on range3",range3.contains(-5));
    }
    
    @Test 
    public void ContainsLowerBound() throws Exception {
    	assertTrue("Contains should return false for argument 1 on range3", range3.contains(1));
    }
    
    @Test
    public void ContainsUpperBound() throws Exception {
    	assertTrue("Contains should return false for argument 10 on range3", range3.contains(10));
    }
    
    // Testing method equals(Object obj)
    @Test
    public void EqualsSameRange() throws Exception {
    	Range testRange = new Range(-1, 1);
    	assertTrue("The equals method should be returning true on equivalent ranges.", testRange.equals(testRange));
    }
    
    @Test
    public void NotEqualsRange() throws Exception {
    	Range range = new Range(-1, 2);
    	assertFalse("The equals method should be returning false on nonequivalent ranges.", range.equals(range1));
    }
    
    @Test
    public void EqualsSimilarRangeObject() throws Exception {
    	Range range1Similar = new Range(-1, 1);
    	assertTrue("The equals method should be returning false on equivalent ranges.", range1.equals(range1Similar));
    }
    
    // Testing method expand(Range range, double lowerMargin, double upperMargin)
    @Test
    public void ExpandsPercentanges() throws Exception {
    	Range testRange = new Range(2, 6);
    	Range newRange = Range.expand(testRange, 0.25, 0.5);
    	Range expectedRange = new Range(1,8);
    	assertTrue("The range did not properly expand bounds.", newRange.equals(expectedRange));
    }
    
    @Test
    public void ExpandsPercentangesBottom() throws Exception {
    	Range testRange = new Range(2, 6);
    	Range newRange = Range.expand(testRange, 0.25, 0.0);
    	Range expectedRange = new Range(1,6);
    	assertTrue("The range did not properly expand the lower bound.", newRange.equals(expectedRange));
    }
    
    @Test
    public void ExpandsPercentangesTop() throws Exception {
    	Range testRange = new Range(2, 6);
    	Range newRange = Range.expand(testRange, 0.0, 0.5);
    	Range expectedRange = new Range(2, 8);
    	assertTrue("The range did not properly expand the upper bound.", newRange.equals(expectedRange));
    }
    
    @Test (expected = InvalidParameterException.class)
    public void ExpandThrowsException() {
    	Range.expand(null, 2, 6);
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}