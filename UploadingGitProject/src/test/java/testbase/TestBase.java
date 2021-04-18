package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import report.ExtentManager;

public class TestBase {

	public WebDriver driver = null;
	public ExtentReports report;
	public ExtentTest test;
	public SoftAssert softassert;
	
	
	@BeforeMethod
	public void inIt(ITestResult result) {
		
		report=ExtentManager.getExtentManager();
		test  =	report.createTest(result.getMethod().getMethodName().toString().toUpperCase());
		result.setAttribute("SendingtestObj", test);
		
		 softassert= new SoftAssert();
	}
	
	@AfterMethod
	public void quite() {
		
		report.flush();
		
		
	}
	
	
	public void log(String message) {
	
		System.out.println(message);
		test.log(Status.INFO, message);
	}
	
	public void logFailure(String message) {//only fail in extent report
		
		System.out.println(message);
		test.log(Status.FAIL, message);
	}
	
	
	public void softFailure(String message) {// fail in extent report, test ng and continue the test
		logFailure(message); // fail in extent reports
		softassert.fail(message); // fail in test ng
	}
	
	public void hardFailure(String message) {// fail in extent report, test ng and stop the test
		
		logFailure(message); // fail in extent reports
		softassert.fail(message); // fail in test ng
		softassert.assertAll();
	}
	
	
	public WebDriver browsers(String browser) {

		if (browser.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"D:\\Ashish code Selenium And Selenium Practice\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			// driver.get("https://yahoo.com");

		} else if (browser.equals("Mozilla")) {

			System.setProperty("webdriver.gecko.driver",
					"D:\\Ashish code Selenium And Selenium Practice\\FireFox GecoDriver\\64bit\\geckodriver.exe");

			driver = new FirefoxDriver();
			// driver.get("https://www.qtpselenium.com/");

		} else if (browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"D:\\Ashish code Selenium And Selenium Practice\\InternetExplorer Driver\\IEDriverServer.exe");

			driver = new InternetExplorerDriver();
			// driver.get("https://www.primevideo.com/");
		}
		return driver;

	}

	
	
	
	
	
}
