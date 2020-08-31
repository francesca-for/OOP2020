//JUNIT 5
package it.polito.oop.testStack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

//annotation needed to include test class in suite, if used only standalone can be omitted
@RunWith(JUnitPlatform.class)
public class StackTest {
	@Test
	public void testStack() {
		Stack aStack = new Stack();
		assertTrue(aStack.isEmpty(), "Stack should be empty");
		aStack.push(10);
		assertFalse(aStack.isEmpty(), "Stack should not be empty!");
		aStack.push(-4);
		assertEquals(-4, aStack.pop());
		assertEquals(10, aStack.pop());
	}
	 
	//I forgot to check the index in pop!
	//this test will not pass, pop throws ArrayIndexOutOfBoundsException
	@Test
	public void testPopOnEmptyStack() {
		Stack aStack = new Stack();
		aStack.wrongPop();
	}
	
	//this test will pass, I catch the expected exception
	@Test
	public void testPopOnEmptyStackCatchedException()
	{
		Stack aStack = new Stack();
		
		assertThrows(ArrayIndexOutOfBoundsException.class,
					()->{
							aStack.pop(); 
						});
	}
}
