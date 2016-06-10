package com.xyzcorp;

import java.util.Random;

public class DieImpl implements Die {
	private Random random;
	private int pips;

	public DieImpl(Random random) {
       this(random, 1);
	}

	private DieImpl(Random random, int pips) {
		this.random = random;
		this.pips = pips;
	}

	/* (non-Javadoc)
	 * @see com.xyzcorp.Die#getPips()
	 */
	@Override
	public int getPips() {
		return pips;
	}

	/* (non-Javadoc)
	 * @see com.xyzcorp.Die#roll()
	 */
	@Override
	public Die roll() {
		return new DieImpl(random, random.nextInt(6) + 1);
	}

}
