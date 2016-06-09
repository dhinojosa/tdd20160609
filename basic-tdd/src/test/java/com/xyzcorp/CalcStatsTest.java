package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.assertj.core.data.Offset;
import org.junit.Test;

public class CalcStatsTest {

	@Test
	public void testMinimumOfAnEmptyArray() {
		int[] values = {};
		CalcStats calcStats = new CalcStats(values); // Subject under test
		Integer result2 = calcStats.getMinimum();
		assertNull(result2);
	}

	@Test
	public void testMinimumOfAnArrayOfOneItem() {
		int[] values = { 4 };
		CalcStats calcStats = new CalcStats(values); // Subject under test
		Integer result2 = calcStats.getMinimum();
		assertEquals(new Integer(4), result2);
	}

	@Test
	public void testMinimumOfMultipleItemsAsc() {
		int[] values = { 3, 4 };
		CalcStats calcStats = new CalcStats(values); // Subject under test
		Integer result2 = calcStats.getMinimum();
		assertEquals(new Integer(3), result2);
		assertEquals(new Integer(3), result2);
	}

	@Test
	public void testMinimumOfMultipleItemsDesc() {
		int[] values = { 4, 3 };
		CalcStats calcStats = new CalcStats(values); // Subject under test
		Integer result2 = calcStats.getMinimum();
		assertEquals(new Integer(3), result2);
		assertEquals(new Integer(3), result2);
	}

	@Test
	public void testMinimumOfMultipleItemsRandomWithNegative() {
		int[] values = { 4, 3, -10, 5 };
		CalcStats calcStats = new CalcStats(values); // Subject under test
		Integer result2 = calcStats.getMinimum();
		assertEquals(new Integer(-10), result2);
		assertEquals(new Integer(-10), result2);
	}

	@Test
	public void testMinimumOfMultipleItemsRandomWithAZero() {
		int[] values = { 4, 3, 0, 5, -15 };
		CalcStats calcStats = new CalcStats(values); // Subject under test
		Integer result2 = calcStats.getMinimum();
		assertEquals(new Integer(-15), result2);
	}

	@Test
	public void testNullArray() {
		try {
			new CalcStats(null);
			fail("Should not be here");
		} catch (NullPointerException npe) {
			assertEquals("values cannot be null", CalcStats.VALUES_CANNOT_BE_NULL_MSG);
		}
	}
	
	@Test
	public void testMaximumOfAnEmptyArray() {
		int[] values = {};
		CalcStats calcStats = new CalcStats(values); // Subject under test
		Integer result2 = calcStats.getMaximum();
		assertThat(result2).isNull();
	}

	@Test
	public void testMaximumOfAnArrayOfOneItem() {
		int[] values = { 4 };
		CalcStats calcStats = new CalcStats(values); // Subject under test
		Integer result2 = calcStats.getMaximum();
		assertEquals(new Integer(4), result2);
	}

	@Test
	public void testMaximumOfMultipleItemsAsc() {
		int[] values = { 3, 4 };
		CalcStats calcStats = new CalcStats(values); // Subject under test
		Integer result2 = calcStats.getMaximum();
		assertEquals(new Integer(4), result2);
	}

	@Test
	public void testMaximumOfMultipleItemsDesc() {
		int[] values = { 4, 3 };
		CalcStats calcStats = new CalcStats(values); // Subject under test
		Integer result2 = calcStats.getMaximum();
		assertEquals(new Integer(4), result2);
	}

	@Test
	public void testMaximumOfMultipleItemsSame() {
		int[] values = { 4, 4 };
		CalcStats calcStats = new CalcStats(values); // Subject under test
		Integer result2 = calcStats.getMaximum();
		assertEquals(new Integer(4), result2);
	}
	
	@Test
	public void testMaximumOfMultipleItemsRandomWithNegative() {
		int[] values = { 4, 3, -10, 5 };
		CalcStats calcStats = new CalcStats(values); // Subject under test
		Integer result2 = calcStats.getMaximum();
		assertEquals(new Integer(5), result2);
	}
	
	@Test
	public void testMaximumOfMultipleItemsRandomWithAZero() {
		int[] values = { 4, 3, 0, 5, -15 };
		CalcStats calcStats = new CalcStats(values); // Subject under test
		Integer result2 = calcStats.getMaximum();
		assertEquals(new Integer(5), result2);
	}

	@Test
	public void testSizeOfAnEmptyArray() {
		int[] values = {};
		CalcStats calcStats = new CalcStats(values); // Subject under test
		Integer result2 = calcStats.getSize();
		assertThat(result2).isEqualTo(0);
	}

	@Test
	public void testSizeOfAnArrayOfOneElement() {
		int[] values = {5};
		CalcStats calcStats = new CalcStats(values); // Subject under test
		Integer result2 = calcStats.getSize();
		assertThat(result2).isEqualTo(1);
	}
	
	@Test
	public void testSizeOfAnArrayOfFourElements() {
		int[] values = {5, 10, 50, 32};
		CalcStats calcStats = new CalcStats(values); // Subject under test
		Integer result2 = calcStats.getSize();
		assertThat(result2).isEqualTo(4);
	}
	
	@Test
	public void testAverageOfAnEmptyArray() {
		int[] values = {};
		CalcStats calcStats = new CalcStats(values); // Subject under test
		assertThat(calcStats.getAverage()).isNull();
	}
	
	@Test
	public void testAverageOfAnArrayOfOneItem() {
		int[] values = {4};
		CalcStats calcStats = new CalcStats(values); // Subject under test
		assertThat(calcStats.getAverage()).isEqualTo(4.0);
	}
	
	@Test
	public void testAverageOfAnArrayOfTwoItems() {
		int[] values = {4, 8};
		CalcStats calcStats = new CalcStats(values); // Subject under test
		assertThat(calcStats.getAverage()).isEqualTo(6.0);
	}
	
	@Test
	public void testAverageOfAnArrayOfTwoItemsWhereTheAvgIsntStraightForward() {
		int[] values = {4, 7};
		CalcStats calcStats = new CalcStats(values); // Subject under test
		assertThat(calcStats.getAverage()).isEqualTo(5.5);
	}
	
	@Test
	public void testAverageOfAnArrayOfTwoItemsWhereTheAvgIsntStraightForward2() {
		int[] values = {4, 5};
		CalcStats calcStats = new CalcStats(values); // Subject under test
		assertThat(calcStats.getAverage()).isEqualTo(4.5);
	}
	
	@Test
	public void testAverageOfAnArrayOfThreeItems() {
		int[] values = {1,0,0};
		CalcStats calcStats = new CalcStats(values); // Subject under test
		assertThat(calcStats.getAverage()).isEqualTo(.333, Offset.offset(0.001));
		assertEquals(.333, calcStats.getAverage(), 0.001);
	}
}







