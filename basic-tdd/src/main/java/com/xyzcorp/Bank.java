package com.xyzcorp;

import java.util.function.Function;

public class Bank {

	public void deposit(Function<String, Resource> function, int i) {
		Resource resource = function.apply("/accounts/resource");
	    resource.deposit(i);
	}

}
