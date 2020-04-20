/**
 * 
 */
package com.ss.training.publisher;

import static org.junit.Assert.*;
import com.ss.training.publisher.Publisher;

import org.junit.Test;

/**
 * @author nrdxp
 *
 */
public class PublisherTest {
	Publisher pub = new Publisher("penguin", "1243 Angst Ave");
	Publisher pub2 = new Publisher("Random House", "1243 Boulder Ave");
	Publisher pub3 = new Publisher("penguin", "1243 Angst Ave");
	
	@Test
	public void uniqueId() {
		assertNotEquals(pub.getId(), pub2.getId());
	}

	@Test
	public void testEquals() {
		assertEquals(pub, pub);
		assertEquals(pub, pub3);
		assertNotEquals(pub, pub2);
		assertNotEquals(pub, "foobar");
		assertNotEquals(pub, null);
	}
	
	@Test
	public void testGetters() {
		assertEquals(pub.getName(), "penguin");
		assertEquals(pub.getAddress(), "1243 Angst Ave");
	}

}
