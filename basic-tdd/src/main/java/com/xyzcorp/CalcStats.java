package com.xyzcorp;

import java.util.function.BiPredicate;

public class CalcStats {

	protected static final String VALUES_CANNOT_BE_NULL_MSG = "values cannot be null";
	private int[] values;

	public CalcStats(int[] values) {
		if (values == null)
			throw new NullPointerException(VALUES_CANNOT_BE_NULL_MSG);
		this.values = values;
	}
	
	private Integer filter(BiPredicate<Integer, Integer> predicate) {
		if (values.length == 0)
			return null;
		Integer answer = values[0];
		for (int i = 1; i < values.length; i++) {
			if (predicate.test(values[i], answer))
				answer = values[i];
		}
		return answer;
	}
	
	public Integer getMinimum() {
		return filter((next, currentAnswer) -> next < currentAnswer);
	}

	public Integer getMaximum() {
		return filter((next, currentAnswer) -> next > currentAnswer);
	}

	public int getSize() {
		return values.length;
	}

	public Double getAverage() {
		if (getSize() == 0) return null;
		int total = 0;
		for (int value: values) {
			total += value;
		}
		return (total + 0.0) / getSize();
	}
}
