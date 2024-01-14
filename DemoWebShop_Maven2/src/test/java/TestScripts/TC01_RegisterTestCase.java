package TestScripts;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import POMREPO.RegisterPage;
import genericlibrary.BaseTest;
import genericlibrary.DataUtility;

public class TC01_RegisterTestCase extends BaseTest {
	
	
	@Test(groups="account",dataProvider="smruti")
	public void testcase(String Firstname, String LastName, String Email, String Password, String ConfirmPassword) throws InterruptedException
	{
	String emailid="smrutimayee243@gmail.com";
	//Smruti
	//Panda
	//Smrutimayeepanda243@gmail.com
	//Smruti@123
	 
	{
		driver.findElement(By.linkText("Log out")).click();
	}
	
	
	//Step3 : Navigate to Register page
	driver.findElement(By.partialLinkText("Register")).click();
	//Step4 : Validate Register Page is displayed or not
	Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Register" , "Register page is not displayed...");
	Reporter.log("Register page is displayed",true);
	
	RegisterPage  register_page = new RegisterPage(driver);
	
	register_page.getFemaleRadioButton().click();
	register_page.getFirstNameTextField().sendKeys(Firstname);
	register_page.getLastNameTextField().sendKeys(LastName);
	register_page.getEmailTextField().sendKeys("a"+utility_Methods.getRandomNumber()+Email);
	register_page.getPasswordTextField().sendKeys(Password);
	register_page.getConfirmpasswordTextField().sendKeys(Password);
	register_page.getRegisterButton().click();
	
	//step7 : Fetching the register successful message
	String expText =driver.findElement(By.xpath("//div[@class='result']")).getText();
	System.out.println(expText);
	
	//step8 : validating Register successful or not
	Assert.assertEquals(expText,"Your registration completed", "Register TestCase Fail");
	Reporter.log("Register TestCase Pass...", true);
	
	
	
	}
	@DataProvider(name ="smruti")
	public Object[][] datasupply() throws EncryptedDocumentException, IOException
	{
	return DataUtility.getAllDataFromExcel("RegisterTestCase");
	}
}
