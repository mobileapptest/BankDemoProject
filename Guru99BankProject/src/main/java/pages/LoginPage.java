package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import util.Reports;

public class LoginPage{

	FirefoxDriver driver;
	String strActualTitle = "Guru99 Bank Manager HomePage";
		
	long snapNumber = 100000L;
	String strFilePath = "C:\\Workspace_Selenium\\Gruru99DemoProject\\reports\\Images\\";
	
	
	@Test
	public void launchBrowser() {
		System.out.println("launching firefox browser"); 
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void openApplication() throws Exception {
		// Enter Website name 
		driver.get("http://www.demo.guru99.com/V4/");
		System.out.println("launch web page sucessfully");
		//takeSnapShot(driver, strFilePath+snapNumber+"1.jpg") ;
		
	}
		
	@Test
	public void webSiteLogin() throws Exception {
		
		String strGetTitle;
			
		// Enter User name
		driver.findElementByName("uid").clear(); // Good practice to clear a field before use
		driver.findElementByName("uid").sendKeys("mngr309297");
									
		// Enter Password
		driver.findElementByName("password").clear(); // Good practice to clear a field before use
		driver.findElementByName("password").sendKeys("hyqUsEt");
											
		// Login Button.
		driver.findElementByName("btnLogin").click();
				
		strGetTitle = driver.getTitle();
		if (strGetTitle.contains(strActualTitle)) {
			System.out.println("Test case: Passed");
			//takeSnapShot(driver, strFilePath+snapNumber+"3.jpg") ;
		} 
		else {
			System.out.println("Test case : Failed");
		}
					
		driver.close();
	}
	
	@Test
	public void closeDriver() {
		if(driver!=null) {
			driver.close();
		}
	}
			
}
