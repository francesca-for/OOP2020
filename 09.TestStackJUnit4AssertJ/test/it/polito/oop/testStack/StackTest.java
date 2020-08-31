package it.polito.oop.testStack;

import org.junit.Before;
import org.junit.Test;
//import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class StackTest {
	
	Stack aStack;
	
	@Before
	public void createStack() {
		aStack = new Stack();
	}
	
	@Test
	public void testStack() {
		Stack aStack = new Stack();
		assertThat(aStack.isEmpty())
			.as("Stack should be empty")
			.isEqualTo(true);
//		stackMethod(aStack);
		aStack.push(10);
		assertThat(aStack.isEmpty())
			.as("Stack should not be empty!")
			.isEqualTo(false);
		aStack.push(-4);
		assertThat(aStack.pop())
			.isEqualTo(-4);
//			.isGreaterThan(-10)
//			.isLessThan(0);
		assertThat(aStack.pop()).isEqualTo(10);
	}
	
//	private void stackMethod(Stack a)
//	{
//		a.push(10);
//	}
	
	//I forgot to check the index in pop!
	//this test will not pass, pop throws ArrayIndexOutOfBoundsException
	@Test
	public void testPopOnEmptyStack() {
		Stack aStack = new Stack();
		aStack.pop();
	}
	
	//this test will pass, I catch the expected exception
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testPopOnEmptyStackCatchedException() throws ArrayIndexOutOfBoundsException {
		Stack aStack = new Stack();
		aStack.pop();
	}

}