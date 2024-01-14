package genericlibrary;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersImplimentation implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult results)
	{
		
		TakesScreenshot ts = (TakesScreenshot)BaseTest.listenersDriver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("./failedTC/F1.png");
		
	}
	
}
