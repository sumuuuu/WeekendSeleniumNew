package TestScripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericlibrary.BaseTest;

    @Listeners(genericlibrary.ListnersImplimentation.class)

public class TC02_AddToCartTestCase extends BaseTest {
	
	@Test(groups = "products")
	public void addTocart() throws InterruptedException
	{
	//Smrutimayeepanda243@gmail.com
	//smruti@123
		
	//Step3: To navigate to Digital downloads
	driver.findElement(By.partialLinkText("Digital downloads")).click();
	
	if (driver.getTitle().equals("Demo Web Shop. Digital downloads")) {
		Reporter.log("Digital download page is displayed");
	} else 
		Reporter.log("Digital download page is not displayed");

	//Step 4 : Located all AddToCart buttons	
	List<WebElement>allProducts = driver.findElements(By.xpath("//input[@value='Add to cart']"));
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	//Step 5:To Add all the products to the cart
	for (WebElement Product : allProducts) {
		Product.click();
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//a[text()='Shopping cart']"))));
		Thread.sleep(10000);
	}
	
	//Step 6 : To navigate to shopping cart
	driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
	
	//String message = "Shopping Cart page displayed";
	//Assert.assertEquals(driver.getTitle().equals("Demo Web Shop. Shopping Cart"), message);
	//Reporter.log("Shopping cart is not displayed");
	if (driver.getTitle().equals("Demo Web Shop. Shopping Cart")) {
    	Reporter.log("Shopping Cart page displayed");
	} else 
		Reporter.log("Shopping cart page not displayed");
	
	List<WebElement>CartProducts=driver.findElements(By.xpath("//tr[@class='cart-item-row']"));
	
	//Step 7 : Validate the number of products in shopping cart
	if (allProducts.size() == CartProducts.size()) {
		Reporter.log("AddToCart Test case Pass");
	} else {
		Reporter.log("AddTocart Test case Fail");
	}
	
	}
}
