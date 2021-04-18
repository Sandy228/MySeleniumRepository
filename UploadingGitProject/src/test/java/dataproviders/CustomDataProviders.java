package dataproviders;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class CustomDataProviders {

	@DataProvider
	public static Object[][] dataTestSuiteA(Method m) {
		
		Object data[][]=null;
		
		System.out.println(m.getName().toUpperCase());
		
		
		
		if(m.getName().toUpperCase().equals("TESTA")) {
			
			 data= new Object[2][2];
			
			data[0][0]="Sandeep";
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
