package genericlibrary;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityMethods<WebElement> implements FrameWork_Constants {

	public int getRandomNumber()
	{
		Random r = new Random();
		return r.nextInt(10000);
		
	}
	
	public void takeScreenshot(WebDriver driver, String name) 
	{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File trg = new File(screenshot_path+name+".png");
	try {
		FileHandler.copy(src, trg);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void acceptAlertPopUp(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlertPopUp(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void passvalueToAlert(WebDriver driver, String value)
	{
		driver.switchTo().alert().sendKeys(value);
	}
	
	public String getAlertMessage(WebDriver driver)
	{
	  return driver.switchTo().alert().getText();
	}
	
}