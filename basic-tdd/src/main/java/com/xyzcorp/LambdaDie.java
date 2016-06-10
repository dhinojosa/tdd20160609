package com.xyzcorp;

import java.util.function.Supplier;

public class LambdaDie implements Die {

	public LambdaDie(Supplier<Integer> supplier) {
	}

	public LambdaDie() {
	}

	@Override
	public int getPips() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LambdaDie roll() {
		// TODO Auto-generated method stub
		return null;
	}

}
