package mydataproviders;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.testng.annotations.DataProvider;

import testbase.TestBase;


public class CustomDataProviders{

	@DataProvider
	public static Object[][] dataTestSuiteA(Method m) throws IOException {
		HashMap<String, String> test = new HashMap<String, String>();
		
		
		TestBase base= new TestBase();
		
		test=base.ReadExcelFile(System.getProperty("user.dir")+"\\src\\test\\resources", "data.xlsx", "Data", 1);
		
		
		Object data[][]=null;
		
		System.out.println(m.getName().toUpperCase());
		
		
		
		if(m.getName().toUpperCase().equals("TESTA")) {
			
			 data= new Object[2][2];
			 String name=test.get("Name");
			 
			data[0][0]=name;
			data[0][1]="Newalkar";
			
			
			data[1][0]="Mukesh";
			data[1][1]="Saini";
			
		} else{
			
			 data= new Object[2][2];
			 
			data[0][0]="Pradeep";
			data[0][1]="Bhandaroo";
			
			
			data[1][0]="Akhilesh";
			data[1][1]="Khandelwal";
			
			
		}
			
			
			
		
		return data;
		
	}
	
}
