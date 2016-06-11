package com.xyzcorp;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookParser {

	protected static Book parseLine(String line) {
		String[] items = line.split("~");
		return new Book(items[0], items[1], LocalDate.parse(items[2]));
	}

	public static List<Book> parseStream(BufferedReader reader) throws IOException {
         List<Book> books = new ArrayList<>();
         String line = null;
         while((line = reader.readLine()) != null) {
            books.add(parseLine(line));   	 
         }
         return books;
	}
}
