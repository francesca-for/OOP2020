package it.polito.oop.testStackJUnit4Hamcrest;

import org.junit.Before;
import org.junit.Test;

import it.polito.oop.testStack.Stack;

//import static org.junit.Assert.*;
import static
org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class StackTest {
	
	Stack aStack;
	
	@Before
	public void createStack() {
		aStack = new Stack();
	}
	
	@Test
	public void testStack() {
		assertThat("Stack should be empty",
				aStack.isEmpty(), is(equalTo(true)));
//		stackMethod(aStack);
		aStack.push(10);
		assertThat("Stack should not be empty!",
				aStack.isEmpty(), is(equalTo(false)));
		aStack.push(-4);
		assertThat(aStack.pop(), is(equalTo(-4)));
		assertThat(aStack.pop(), is(equalTo(10)));
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