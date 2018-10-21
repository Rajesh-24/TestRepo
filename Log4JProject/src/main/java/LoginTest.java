import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest 
{
	WebDriver driver;
	Logger log = Logger.getLogger(LoginTest.class);
	@BeforeMethod
	public void setUp()
	{
		log.info("****************Started TestCases**********************");
		driver = new FirefoxDriver();
		driver.get("http://localhost/website/");	
	}
	
	@Test(priority=1)
	public void doLogin()
	{
		log.info("****************** Verify Login **********************");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();		
	}

	@Test(priority=2)
	public void checkTitle()
	{
		log.info("*******************Login Page Title Test***********************");
		String actualTitle =driver.getTitle();
		assertEquals(actualTitle, "dddgdg");
	}	
	@AfterMethod
	public void shutDown()
	{
		log.info("**********************close browser*********************************");
		driver.quit();		
	}
}
