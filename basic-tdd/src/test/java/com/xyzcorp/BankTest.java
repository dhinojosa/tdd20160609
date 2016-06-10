package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BankTest {

	@Test
	@Category(value = UnitTest.class)
	public void testDeposit() {
		Bank bank = new Bank();
		Resource resource = new Resource();
		bank.deposit(t -> {
			assertThat(t).isEqualTo("/accounts/resource");
			return resource;
		}, 1000);
        assertThat(resource.getBalance()).isEqualTo(1000);
	}

}
