package suiteA;

import org.testng.annotations.Test;

import mydataproviders.CustomDataProviders;
import testbase.TestBase;

public class TestAA extends TestBase{

	@Test(dataProviderClass=CustomDataProviders.class,dataProvider="dataTestSuiteA")
	public void testAA(String name, String Surname) {
		
		log("Test AA Starting"+name+Surname);
		log("Test AA Executing"+name+Surname);
		
		if(!"Title1".equals("Title")) {
			softFailure("Title do not match");
			softassert.assertEquals("Title1", "Title");//This line print log and actual error in last line in Reports.
		}
		
			
		log("Test AA Executing"+name+Surname);
		log("Test AA Executing"+name+Surname);
		log("Test AA Executing"+name+Surname);
		
		if(!"Text1".equals("Text")) {
			softFailure("Text do not match");
			softassert.assertEquals("Text1", "Text");//This line print log and actual error in last line in Reports.
		}
		
		log("Test AA Ending"+name+Surname);
		log("Test AA Ending"+name+Surname);
		log("Test AA Ending"+name+Surname);
		
		//Now using hard failure , and it will stop the test 
		if(!"bookingID1".equals("bookingID")) {
			hardFailure("Booking ID do not match and its a criticle failure");
			softassert.assertEquals("bookingID1", "bookingID");//This line print log and actual error in last line in Reports.
		}
		
		log("Test AA Ending"+name+Surname);
		log("Test AA Ending"+name+Surname);
		
		softassert.assertAll();
		
	}
}
