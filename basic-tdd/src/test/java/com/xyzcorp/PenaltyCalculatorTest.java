package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Test;

public class PenaltyCalculatorTest {
	@Test
	public void testSameDate() {
		float result = PenaltyCalculator.determinePenalty(LocalDate.of(2016, 6, 10),  //checkout 
				                           LocalDate.of(2016, 6, 10)); //current
		assertThat(result).isEqualTo(0.0f);
	}

	@Test
	public void testExactlyOneMonth() {
		float result = PenaltyCalculator.determinePenalty(LocalDate.of(2016, 6, 10),  //checkout 
				                           LocalDate.of(2016, 7, 10)); //current
		assertThat(result).isEqualTo(0.0f);
	}
	
	@Test
	public void testExactlyOneMonthOneDay() {
		float result = PenaltyCalculator.determinePenalty(LocalDate.of(2016, 6, 10),  //checkout 
				                           LocalDate.of(2016, 7, 11)); //current
		assertThat(result).isEqualTo(1.0f);
	}
}
