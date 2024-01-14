package genericlibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public WebDriver driver;
	public DataUtility du = new DataUtility();
	public static WebDriver listenersDriver;
	public UtilityMethods utility_Methods = new UtilityMethods();
	@BeforeClass(alwaysRun=true)
	public void launchBrowser() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		listenersDriver = driver ;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(du.getDataFromProperties("url"));
		
		}
	
	@BeforeMethod(alwaysRun=true)
	public void login1() throws IOException { 
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(du.getDataFromProperties("emailid"));
		driver.findElement(By.id("Password")).sendKeys(du.getDataFromProperties("pwd"));
		driver.findElement(By.cssSelector("[value='Log in']")).click();
			
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void logout() {
		driver.findElement(By.linkText("Log out")).click();
	}
	
	@AfterClass(alwaysRun=true)
	public void closeBrowser() {
		driver.close();
	}
	
	
	
}
