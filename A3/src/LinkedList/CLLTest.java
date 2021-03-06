package LinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class CLLTest {

	@Test
	public void testConstructor(){
		CLL<Integer> b = new CLL<Integer>();
		assertEquals("[]", b.toString());
		assertEquals("[]", b.toStringRev());
		assertEquals(0, b.size());
	}
	
	@Test
	public void testAppend() {
		CLL<Integer> c = new CLL<Integer>();
		
		c.append(5);
		assertEquals("[5]", c.toString());
		assertEquals("[5]", c.toStringRev());
		assertEquals(1, c.size());
		
		c.append(6);
		assertEquals("[5, 6]", c.toString());
		assertEquals("[6, 5]", c.toStringRev());
		assertEquals(2, c.size());		
	}
	
	@Test
	public void testPrepend() {
		CLL<Integer> c = new CLL<Integer>();
		c.prepend(5);
		
		//add 
		
		c.prepend(6);
		assertEquals("[6, 5]", c.toString());
		assertEquals("[5, 6]", c.toStringRev());
		assertEquals(2, c.size());	
	}
	
	@Test 
	public void testGetNode() {
		CLL<Integer> c = new CLL<Integer>();
		c.append(1);
		c.append(4);
		c.append(5);
		assertEquals(Integer.valueOf(1), c.getNode(0).getValue());
		assertEquals(Integer.valueOf(4), c.getNode(1).getValue());
		
		try {
			c.getNode(-1);
			fail();
		}
		catch (IndexOutOfBoundsException e){
			System.out.println(e);
		}
		
		try{
			c.getNode(5);
			fail();
		}
		catch (IndexOutOfBoundsException e){
			System.out.println(e);
		}	
	}
	
	@Test
	public void testInsertAfter() {
		CLL <Integer> c = new CLL<Integer>();
		c.append(2);
		c.append(4);
		c.insertAfter(3, c.getNode(0));
		assertEquals("[2, 3, 4]", c.toString());
		assertEquals("[4, 3, 2]", c.toStringRev());
		assertEquals(3, c.size());
		
		c.insertAfter(5, c.getLast());
		assertEquals("[2, 3, 4, 5]", c.toString());
		assertEquals("[5, 4, 3, 2]", c.toStringRev());
		assertEquals(4, c.size());		
	}
	
	@Test
	public void testRemove() {
		CLL<Integer> c = new CLL<Integer>();
		
		//Test the assertion: size != 0
		try{
			c.remove(c.getFirst());
			fail();
		}
		catch (AssertionError e){
			System.out.println(e);
		}
		
				
		c.append(2);
		
		//test if the size of list equals 1 and remove the only node in the list
		c.remove(c.getNode(0));
		assertEquals("[]", c.toString());
		assertEquals("[]", c.toStringRev());
		assertEquals(0, c.size());
		
		c.append(2);
		c.append(4);
		
		//Test the assertion: n != null
		try{
			c.remove(null);
			fail();
		}
		catch (AssertionError e) {
			System.out.println(e);
		}
		
		c.append(5);
		
		assertEquals("[2, 4, 5]", c.toString());
		assertEquals("[5, 4, 2]", c.toStringRev());
		assertEquals(3, c.size());
		c.remove(c.getNode(0));
		assertEquals("[4, 5]", c.toString());
		assertEquals("[5, 4]", c.toStringRev());
		assertEquals(2, c.size());
		
		c.remove(c.getNode(1));
		assertEquals("[4]", c.toString());
		assertEquals("[4]", c.toStringRev());
		assertEquals(1, c.size());
	}
	

}
