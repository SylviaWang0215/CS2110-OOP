import static org.junit.Assert.*;

import org.junit.Test;

public class PHDTester {
	@Test
	/**This test is for PHD() and other basic method to get the info about the PHD*/
	public void testGroupA() {
		PHD x1 = new PHD("Mary", 'f', 2, 4);
		
		assertEquals("Mary", x1.getName());
		assertEquals(2, x1.getYear());
		assertEquals(4, x1.getMonth());
		assertEquals(false, x1.isMale());
		assertEquals(null, x1.advisor1());
		assertEquals(null, x1.advisor2());
		assertEquals(0, x1.numAdvises());
		
		PHD x2 = new PHD("Jack", 'm', 5, 3);
		assertEquals(true, x2.isMale());
		
		try {
			x2.setAdvisor1(null); 
			fail("");
		}
		catch (AssertionError e){
			if (e.getMessage() != null)
				fail();
		}
	}
	
	@Test
	public void testGroupB() {
		PHD x3 = new PHD("John", 'm', 20, 3);
		PHD x4 = new PHD("Selena", 'f', 6, 10);
		PHD x5 = new PHD("Taylor", 'f', 40, 5);
		x3.setAdvisor1(x4);
		x5.setAdvisor1(x4);
		assertEquals(2, x4.numAdvises());
		assertEquals(x4, x3.advisor1());
		assertEquals(x4, x5.advisor1());
		try {
			x5.setAdvisor2(null);
			fail("");
		}
		catch (AssertionError e){
			if (e.getMessage() != null)
				fail();
		}
	}
	
	@Test
	public void testGroupC(){
		PHD x1 = new PHD("Mary", 'f', 2, 4);
		PHD x2 = new PHD("Jack", 'm', 5, 3);
		PHD x3 = new PHD("Selena", 'f', 6, 10, x1);
		PHD x4 = new PHD("Taylor", 'm', 40, 5, x1, x2);
		assertEquals("Selena", x3.getName());
		assertEquals(6, x3.getYear());
		assertEquals(10, x3.getMonth());
		assertEquals(false, x3.isMale());
		assertEquals(true, x4.isMale());
		assertEquals(x1, x3.advisor1());
		assertEquals(x2, x4.advisor2());
		assertEquals(2, x1.numAdvises());
		assertEquals(1, x2.numAdvises());
		
		try {
			x3.setAdvisor2(null);
			fail("");
		}
		catch (AssertionError e){
			if (e.getMessage() != null) 
				fail();
		}
	}
	
	@Test
	public void testGroupD(){
		PHD x1 = new PHD("Mary", 'f', 2, 4);
		PHD x2 = new PHD("Jack", 'm', 2, 3);
		PHD x3 = new PHD("Selena", 'f', 6, 10, x1);
		PHD x4 = new PHD("Taylor", 'f', 40, 5, x1, x2);
		assertEquals(true, x3.gotBefore(x4));
		assertEquals(false, x4.gotBefore(x1));
		assertEquals(true, x2.gotBefore(x1));
		assertEquals(true, x3.arePHDSiblings(x4));
	}
}
