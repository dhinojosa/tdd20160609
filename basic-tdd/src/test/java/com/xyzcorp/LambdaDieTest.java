package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import java.util.function.Supplier;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LambdaDieTest {
	  @Test	
	  @Category(value = UnitTest.class)
	  public void testDieIsDefault1() {
		 LambdaDie die = new LambdaDie();
		 assertThat(die.getPips()).isEqualTo(1);
	  }
	  
	  @Test
	  @Category(value = UnitTest.class)
	  public void testSimpleRollOf4() {
		  LambdaDie die = new LambdaDie(new Supplier<Integer>() {
			@Override
			public Integer get() {
				// TODO Auto-generated method stub
				return 4;
			}
		  }); //Subject under test
		  LambdaDie rolledDie = die.roll();
		  assertThat(rolledDie.getPips()).isEqualTo(4);
	  }

}
