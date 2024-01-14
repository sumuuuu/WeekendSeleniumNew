package TestScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.BaseTest;

public class TC04_PlaceOrderTestCase extends BaseTest {
	
	   @Test(groups="order")
	    public void PlaceOrder() throws InterruptedException
	    {
		//String emailid = "smrutimayeepanda243@gmail.com;
	    //Smrutimayeepanda243@gmail.com
	    //smruti@123
		
		
		
		//Step4 : Click on computers
		driver.findElement(By.linkText("Computers")).click();
		
		//Step5 : Click on Desktop
		driver.findElement(By.linkText("Desktops")).click();
		
		//Step6 : Click on Simple computer product
		driver.findElement(By.linkText("Simple Computer")).click();
		
		//Step7 : Select processor
		driver.findElement(By.id("product_attribute_75_5_31_96")).click();
		
		//Step8 : Add the product to cart
		driver.findElement(By.id("add-to-cart-button-75")).click();
		
		//Step9 : Navigate to shopping cart page
		driver.findElement(By.linkText("Shopping cart")).click();
		
		//Step10 : Place Order
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.id("checkout")).click();

		//step11 : To click on all the buttons
		driver.findElement(By.xpath("(//input[@title='Continue'])[1]")).click();
		driver.findElement(By.xpath("(//input[@title='Continue'])[2]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[3]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[4]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[5]")).click();
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		
		//step8 : verify order placed or not
		WebElement text = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
		System.out.println(text.getText());
		
		String actualText = "Your order has been successfully processed!";
		
		if (text.getText().equals(actualText)) {
			Reporter.log("Test case is pass",true);
		} else {
			Reporter.log("Test case is fail...",true);
		}
			
		
	}

}
