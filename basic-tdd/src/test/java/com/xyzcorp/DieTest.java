package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;

import java.util.Random;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DieTest {
	
  @Test	
  @Category(value = UnitTest.class)
  public void testDieIsDefault1() {
	  Random random = new Random() {
		  @Override
		  public int nextInt() {
			  return 4;  
		  }
	  }; //Stub!
	
	 Die die = new Die(random);
	 assertThat(die.getPips()).isEqualTo(1);
  }
  
  @Test
  @Category(value = UnitTest.class)
  public void testSimpleRollOf4() {
	  Random random = new Random() {
		  @Override
		  public int nextInt(int bound) {
			  return 3;  
		  }
	  }; //Stub!
	  Die die = new Die(random); //Subject under test
	  Die rolledDie = die.roll();
	  assertThat(rolledDie.getPips()).isEqualTo(4);
  }
  
  @Test
  @Category(value = UnitTest.class)
  public void testSimpleRollOf5() {
	  Random random = new Random() {
		  @Override
		  public int nextInt(int bound) {
			  return 4;  
		  }
	  }; //Stub!
	  Die die = new Die(random); //Subject under test
	  Die rolledDie = die.roll();
	  assertThat(rolledDie.getPips()).isEqualTo(5);
  }
  
  @Test
  @Category(value = UnitTest.class)
  public void testSimpleRollOf4AndRollItTwice() {
	  Random random = new Random() {
		  @Override
		  public int nextInt(int bound) {
			  return 3;  
		  }
	  }; //Stub!
	  Die die = new Die(random); //Subject under test
	  Die rolledDie = die.roll().roll();
	  assertThat(rolledDie.getPips()).isEqualTo(4);
  }
  
  @Test
  @Category(value = IntegrationTest.class)
  public void testDieIntegration() { //This is not a unit test
	  Random random = new Random();
	  Die die = new Die(random);
	  for (int i = 0; i < 1000000; i++) {
		assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);  
	  }
  }
  
  //If your test has more than 2 mocks, _consider_ redesign
  @Test
  @Category(value = UnitTest.class)
  public void testBUG4021() {
	  Random random = createMock(Random.class);
	  
	  //rehearse with the mock
	  //expect(random.nextInt(anyInt())).andReturn(4);
	  expect(random.nextInt(6)).andReturn(4);
	  
	  //replay
	  replay(random);
	  
	  Die die = new Die(random); //Subject under test
	  Die rolledDie = die.roll();
	  assertThat(rolledDie.getPips()).isGreaterThan(0).isLessThan(7);
	  
	  //verify
	  verify(random);
  }
  
  @Test
  @Category(value = UnitTest.class)
  public void testBUG4021_WithAZero() {
	  Random random = createMock(Random.class);
	  
	  //rehearse with the mock
	  expect(random.nextInt(anyInt())).andReturn(0);
	  
	  //replay
	  replay(random);
	  
	  Die die = new Die(random); //Subject under test
	  Die rolledDie = die.roll();
	  assertThat(rolledDie.getPips()).isEqualTo(1);
	  
	  //verify
	  verify(random);
  }
}
