package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LambdaDieTest {
	  @Test	
	  @Category(value = BrokenTest.class)
	  public void testDieIsDefault1() {
		 LambdaDie die = new LambdaDie();
		 assertThat(die.getPips()).isEqualTo(1);
	  }
	  
	  @Test
	  @Category(value = BrokenTest.class)
	  public void testSimpleRollOf4() {
		  LambdaDie die = new LambdaDie(() -> 4); //Subject under test
		  LambdaDie rolledDie = die.roll();
		  assertThat(rolledDie.getPips()).isEqualTo(4);
	  }
	  
	  @Test
	  @Category(value = BrokenTest.class)
	  public void testDieIntegration() { //This is not a unit test
		  Random random = new Random();
		  LambdaDie die = new LambdaDie(() -> random.nextInt(6) + 1);
		  for (int i = 0; i < 1000000; i++) {
			assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);  
		  }
	  }
}
