//JUNIT 4
package it.polito.oop.testStackJUnit4;

import org.junit.Test;

import it.polito.oop.testStack.Stack;

import static org.junit.Assert.*;

import org.junit.Before;

public class StackTest {
	
	Stack aStack;
	
	@Before
	public void createStack() {
		aStack = new Stack();
	}
	
	@Test
	public void testStack() {
		assertTrue("Stack should be empty",
				aStack.isEmpty());
//		stackMethod(aStack);
		aStack.push(10);
		assertFalse("Stack should not be empty!", aStack.isEmpty());
		aStack.push(-4);
		assertEquals(-4, aStack.pop());
		assertEquals(10, aStack.pop());
	}
	
//	private void stackMethod(Stack a)
//	{
//		a.push(10);
//	}
	
	//I forgot to check the index in pop!
	//this test will not pass, pop throws ArrayIndexOutOfBoundsException
	@Test
	public void testPopOnEmptyStack() {
		aStack.pop();
	}
	
	//this test will pass, I catch the expected exception
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testPopOnEmptyStackCatchedException() throws ArrayIndexOutOfBoundsException {
		aStack.pop();
	}

}
