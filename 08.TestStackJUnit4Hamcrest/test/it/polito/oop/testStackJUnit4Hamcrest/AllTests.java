package it.polito.oop.testStackJUnit4Hamcrest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({ 
	StackTest.class, AnotherStackTest.class 
})
public class AllTests { }