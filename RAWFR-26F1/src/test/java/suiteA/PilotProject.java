package suiteA;

import org.testng.annotations.Test;

import testbase.TestBase;

public class PilotProject extends TestBase{

	@Test
	public void login() {
		
		browsers("Chrome");
		driver.get("https://www.youtube.com/watch?v=COKb4YKh3rw");
		
	}
	
	
}
