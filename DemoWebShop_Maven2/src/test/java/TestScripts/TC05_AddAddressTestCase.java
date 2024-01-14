package TestScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.BaseTest;

public class TC05_AddAddressTestCase extends BaseTest {
	
	
	@Test(groups="address")
    public void PlaceOrder()
    {
	//String emailid = "smrutimayeepanda243@gmail.com;
    //String password = "smruti@123";
	
	
	//Step4 : Click on my account
	driver.findElement(By.linkText("smrutimayeepanda243@gmail.com")).click();
	
	//Step5 : Click on address
	driver.findElement(By.linkText("Addresses")).click();
	
	//step6 : Click on add new
	driver.findElement(By.xpath("//input[@value='Add new']")).click();
	
	//step7 : Enter all the details
	driver.findElement(By.id("Address_FirstName")).sendKeys("Smruti");
	driver.findElement(By.id("Address_LastName")).sendKeys("panda");
	driver.findElement(By.id("Address_Email")).sendKeys("smrutimayeepanda243@gmail.com");
	driver.findElement(By.xpath("//option[@value='41']")).click();
	driver.findElement(By.id("Address_City")).sendKeys("Bangalore");
	driver.findElement(By.id("Address_Address1")).sendKeys("Murgeshpallya");
	driver.findElement(By.id("Address_ZipPostalCode")).sendKeys("560017");
	driver.findElement(By.id("Address_PhoneNumber")).sendKeys("8885555652");
	driver.findElement(By.xpath("//input[@value='Save']")).click();
	
	//step8 : Validate address is showing or not
	WebElement text = driver.findElement(By.xpath("//h1[text()='My account - Addresses']"));
	System.out.println(text.getText());
	
	String actualText = "My account - Addresses";
	
	if (text.getText().equals(actualText)) {
		Reporter.log("Test case is pass",true);
	} else {
		Reporter.log("Test case is fail...",true);
	}
	
    }
}
