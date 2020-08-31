package it.polito.oop.rubrica.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//Junit5 does not support directly test suites, only using "hybrid" Junit4-5 runner
//To run test suites in JUnit5 (for now, JUnit5 full support to suites is a work in progress):
//	- mark the test SUITE with @RunWith(Suite.class)
//	- mark the test CLASSES with @RunWith(JUnitPlatform.class)
//	- create a test configuration for the test suite specifying execution with Junit4!
//		- right click on the suite class in the package explorer -> run as -> run configurations -> test runner = junit4
//		- this permits supporting Junit4 and Junit5 tests in the same suite (backward compatibility)
//		- Junit4 will be launched with the "JUnit Vintage" architecture, JUnit5 tests with the new "JUnit Jupiter"
//			- you can see this difference in the Junit dialog in Eclipse when running the suite
//see https://blog.codefx.org/design/architecture/junit-5-architecture-jupiter/ for more info

@RunWith(Suite.class)
@SuiteClasses({ 
	it.polito.oop.rubrica.tests.TestRubrica.class,
	it.polito.oop.rubrica.tests.TestVoce.class,
	it.polito.oop.rubrica.tests.TestRubricaJunit4.class
})
public class AllTests {
		
}
