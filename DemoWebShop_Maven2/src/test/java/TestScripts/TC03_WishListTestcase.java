package TestScripts;

import java.time.Duration;

import org.apache.poi.sl.draw.geom.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.BaseTest;

public class TC03_WishListTestcase extends BaseTest {
	
	
	//Navigate to Wishlist
	@Test(groups="smoke")
	public void wishlist() {
			
		
		//step-1:click on books
		driver.findElement(By.linkText("Books")).click();
		
		//step-2:Click on fiction EX
		driver.findElement(By.xpath("//a[contains(text(),'Fiction EX')]")).click();
		
		//step-3:click on wish list button
		driver.findElement(By.id("add-to-wishlist-button-78")).click();
		
		//step-4:click on wish list page
		driver.findElement(By.xpath("//a[contains(text(),'Wishlist')]")).click();
		
		//step5: Verify the book is present in wish list page
		WebElement text = driver.findElement(By.xpath("//a[contains(text(),'Fiction EX')]"));
		System.out.println(text.getText());
		
		String actualText = "Fiction EX";
		
		if (text.getText().equals(actualText)) {
			Reporter.log("Product is present",true);
		} else {
			Reporter.log("Product is not present",true);
		}

		//step6 : Selecting and then removing the book from the wish list
		driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
		driver.findElement(By.xpath("//input[@value='Update wishlist']")).click();
		
		//step7 : verify product is removed or not
		WebElement currentText = driver.findElement(By.xpath("//div[@class='wishlist-content']"));
		System.out.println(currentText.getText());
		
		String fixedText = "The wishlist is empty!";
		
		Assert.assertEquals(currentText.getText(), fixedText);
		Reporter.log("Test case is pass", true);
		
		if (currentText.getText().equals(fixedText)) {
			Reporter.log("Passed, wishlist is empty",true);	
		} else {
			Reporter.log("Failed, wishlist is not empty",true);

		}
		
		
	}

}
