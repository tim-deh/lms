/**
 * 
 */
package com.ss.training.author;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author nrdxp
 *
 */
public class AuthorTest {
	
	Author auth = new Author("jack");
	Author auth2 = new Author("jim jones");
	Author auth3 = new Author("jack");

	@Test
	public void uniqueId() {
		assertNotEquals(auth.getId(), auth2.getId());
	}
	
	@Test
	public void authorEquals() {
		assertEquals(auth, auth3);
		assertEquals(auth, auth);
		assertNotEquals(auth, auth2);
		assertNotEquals(auth, "foobar");
	}
	
	@Test
	public void testGetters() {
		assertNotNull(auth.getName());
	}

}
