/**
 * 
 */
package com.ss.training.lms;

import java.util.ArrayList;
import static com.ss.training.lms.LMS.main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author nrdxp
 *
 */
public class LMSTest {

	@Test
	public void newTest() {
		main(new String[] {"new", "Captain Jack", "John Smoth", "Royland Publishing", "1847 Rutheford lane"});
	}
	
	@Test
	public void deleteTest() {
		main(new String[] {"delete", "Captain Jack"});
		main(new String[] {"delete", "-p", "Royland Publishing"});
		main(new String[] {"delete", "-a", "John Smoth"});
	}
	
	@Test
	public void listTest() {
		main(new String[] {"list"});
	}
	
	@Test
	public void updateTest() {
		main(new String[] {"update", "Captain Jack", "Captain Smack"});
		main(new String[] {"update", "-p", "Royland Publishing", "Roland Publishing"});
		main(new String[] {"update", "-p", "-a", "Roland Publishing", "1947 Rutheford Lane"});
		main(new String[] {"update", "-a", "John Smoth", "John Smith"});
	}


}
