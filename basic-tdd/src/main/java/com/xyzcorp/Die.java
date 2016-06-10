package com.xyzcorp;

import java.util.Random;

public class Die {
	private Random random;
	private int pips;

	public Die(Random random) {
       this(random, 1);
	}

	private Die(Random random, int pips) {
		this.random = random;
		this.pips = pips;
	}

	public int getPips() {
		return pips;
	}

	public Die roll() {
		return new Die(random, random.nextInt(6) + 1);
	}

}
