package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BookParserTest {

	@Test
	@Category(value = UnitTest.class)
	public void parseALine() {
		Book book = BookParser.parseLine("Sam Adams~The Revolution~2016-04-10");
		assertThat(book.getPersonName()).isEqualTo("Sam Adams");
		assertThat(book.getTitle()).isEqualTo("The Revolution");
		assertThat(book.getCheckoutDate()).isEqualTo(LocalDate.of(2016, 4, 10));
	}
//
//	@Test
//	@Category(value = BrokenTest.class)
//	public void parseALineThatIsEmpty() {
//		try {
//			Book book = BookParser.parseLine("");
//			fail("This should not pass");
//		} catch (IllegalArgumentException iae) {
//			assertThat(iae).hasMessage("Line cannot be blank");
//		}
//	}
//
//	@Test
//	@Category(value = BrokenTest.class)
//	public void parseALineThatIsWithOnlyTwo() {
//		try {
//			Book book = BookParser.parseLine("Bob The Novel~Jan");
//			fail("This should not pass");
//		} catch (IllegalArgumentException iae) {
//			assertThat(iae).hasMessage("Line cannot be blank");
//		}
//	}

	@Test
	@Category(value = UnitTest.class)
	public void testParsingFixedStream() throws IOException {
		String data = "Bob The Novel~Jan~2015-03-01\nAnother Book~Bob~2016-03-01";
		BufferedReader reader = new BufferedReader(new StringReader(data));
        List<Book> books = BookParser.parseStream(reader);
        assertThat(books).hasSize(2);
        reader.close();
	}
	
	@Test
	@Category(value = IntegrationTest.class)
	public void testParsingActualLibraryFile() throws IOException {
		Reader reader = new InputStreamReader(getClass().getResourceAsStream("/library.txt"));
		BufferedReader buffReader = new BufferedReader(reader);
        List<Book> books = BookParser.parseStream(buffReader);
        assertThat(books).hasSize(15);
        buffReader.close();
        reader.close();
	}
	
	@Test
	@Category(value = IntegrationTest.class)
	public void testParsingActualLibraryFileFromURL() throws IOException {
		URL url = new URL("https://raw.githubusercontent.com/dhinojosa/tdd20160609/master/basic-tdd/src/main/resources/library.txt");
		URLConnection connection = url.openConnection();
		Reader reader = new InputStreamReader(connection.getInputStream());
		BufferedReader buffReader = new BufferedReader(reader);
        List<Book> books = BookParser.parseStream(buffReader);
        assertThat(books).hasSize(15);
        buffReader.close();
        reader.close();
	}
	
	
}
