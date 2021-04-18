package suiteA;

import org.testng.annotations.Test;

import dataproviders.CustomDataProviders;
import testbase.TestBase;

public class TestA extends TestBase{

	@Test(dataProviderClass=CustomDataProviders.class,dataProvider="dataTestSuiteA")
	public void testA(String name, String Surname) {
		
		log("Test A Starting"+name+Surname);
		log("Test A Executing"+name+Surname);
		log("Test A Ending"+name+Surname);
	}
	
}
