package com.xyzcorp;

import java.time.LocalDate;

public class Book {

	private String name;
	private String title;
	private LocalDate checkoutDate;

	public Book(String name, String title, LocalDate checkoutDate) {
		this.name = name;
		this.title = title;
		this.checkoutDate = checkoutDate;
	}

	public String getPersonName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

}
