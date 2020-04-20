/**
 * 
 */
package com.ss.training.book;

import com.ss.training.book.Book;
import com.ss.training.author.Author;
import com.ss.training.publisher.Publisher;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author nrdxp
 *
 */
public class BookTest {

	Author auth = new Author("jim");
	Publisher pub = new Publisher("penguin", "1224 Master Ln");
	Book book = new Book("test", pub, auth);
	Book book2 = new Book("foo", pub, auth);
	Book book3 = new Book("test", pub, auth);

	@Test
	public void uniqueId() {
		assertNotSame(book.getId(), book2.getId());
	}

	@Test
	public void bookEquals() {
		assertEquals(book, book);
		assertEquals(book, book3);
		assertNotEquals(book, book2);
		assertNotEquals(book, pub);
	}

	@Test
	public void testGetters() {
		assertEquals(book.getName(), "test");
		assertEquals(book.getAuthor(), auth);
		assertEquals(book.getPublisher(), pub);
	}

	@Test
	public void testSetters() {
		book2.setName("bar");
		assertEquals(book2.getName(),"bar");
	}
	
	@Test
	public void testToString() {
		assertEquals(book.toString(),"Title: test\n" + 
				"Author: jim\n" + 
				"Publisher: penguin\n" + 
				"	Address: 1224 Master Ln");
	}
}
