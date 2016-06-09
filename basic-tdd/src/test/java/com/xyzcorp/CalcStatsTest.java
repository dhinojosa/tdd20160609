package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
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

}







