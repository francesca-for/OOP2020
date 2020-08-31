package it.polito.oop.testStackJUnit3;

import it.polito.oop.testStack.Stack;
import junit.framework.TestCase;

public class StackTest extends TestCase {

	Stack aStack;
	
	protected void setUp() throws Exception {
		aStack = new Stack();
	}

	public void testStack() {
		assertTrue("Should be empty at first!",
				aStack.isEmpty());
		aStack.push(10);
		assertTrue("Should not be empty!",
				!aStack.isEmpty());
//		assertFalse("Should not be empty!",
//				aStack.isEmpty());
		aStack.push(-4);
		assertEquals(-4, aStack.pop());
		assertEquals(10, aStack.pop());
	}
	
}
