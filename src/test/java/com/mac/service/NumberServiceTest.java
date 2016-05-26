package com.mac.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author fmacugay
 */
public class NumberServiceTest {

	@Test
	public void testSumOfCommonInteger() {
		int sum = NumberService
				.sumOfCommonInteger(new int[]{1, 2, 2, 3, 3, 4, 3});

		Assert.assertEquals(9, sum);
	}

	@Test
	public void testWithNegative() {
		int sum = NumberService.sumOfCommonInteger(
				new int[]{1, 2, -2, 3, 3, 4, 3, -2, -2, -2});

		Assert.assertEquals(-8, sum);
	}

	@Test
	public void testArrayNull() {
		int sum = NumberService.sumOfCommonInteger(null);
		Assert.assertEquals(0, sum);
	}

	@Test
	public void testArrayEmpty() {
		int sum = NumberService.sumOfCommonInteger(new int[]{});
		Assert.assertEquals(0, sum);
	}

	@Test
	public void testWithZero() {
		int sum = NumberService.sumOfCommonInteger(
				new int[]{0, 0, 0, 0, 1, 2, 2, 3, 3, 4, 3, -1, -1, -1});

		Assert.assertEquals(0, sum);
	}

	@Test
	public void testSingleElement() {
		int sum = NumberService.sumOfCommonInteger(new int[]{12});
		Assert.assertEquals(12, sum);
	}

	@Test
	public void testDoubleDigitNumbers() {
		int sum = NumberService.sumOfCommonInteger(new int[]{11, 10, 11});
		Assert.assertEquals(22, sum);
	}

	@Test
	public void testMultipleCommon() {
		int sum = NumberService.sumOfCommonInteger(new int[]{11, 10, 11, 10});
		Assert.assertEquals(20, sum);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotNumber() {
		NumberService.toPrimitiveInt(new String[]{"A"});
	}

	@Test
	public void testLargeArray() {
		int[] largeArray = new int[10000000];

		for (int i = 0; i < largeArray.length - 1; i++) {
			largeArray[i] = i + 1;
		}

		largeArray[largeArray.length - 1] = 1;

		int sum = NumberService.sumOfCommonInteger(largeArray);
		Assert.assertEquals(2, sum);
	}
}
