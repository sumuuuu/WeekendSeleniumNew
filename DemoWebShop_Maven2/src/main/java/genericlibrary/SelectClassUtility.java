package genericlibrary;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectClassUtility {
	
	Select s;
	
	public void selectOptionIndex(WebElement dropDown, int intdexNum)
	{
		s = new Select(dropDown);
		s.selectByIndex(intdexNum);
	}
	public void selectOptionByValue(WebElement dropdown, String value)
	{
		s = new Select(dropdown);
		s.selectByValue(value);
	}
	public void selectOptionByVisibleText(WebElement dropdown, String visibleText)
	{
		s = new Select(dropdown);
		s.selectByVisibleText(visibleText);
	}
	
	public void deselectOptionIndex(WebElement dropdown, int indexNum)
	{
		s = new Select(dropdown);
		s.deselectByIndex(indexNum);
	}
	public void deselectOptionByValue(WebElement dropdown, String value)
	{
		s = new Select(dropdown);
		s.deselectByValue(value);
	}
	public void deselectOptionByVisibleText(WebElement dropdown, String visibleText)
	{
		s = new Select(dropdown);
		s.deselectByVisibleText(visibleText);
	}
	public void deseleOptionByAll(WebElement dropdown)
	{
		s = new Select(dropdown);
		s.deselectAll();
	}
	
	public List<WebElement> fetchAllOption(WebElement dropDown)
	{
		s = new Select(dropDown);
		return s.getOptions();
	}
	public boolean verifyMultiselectDropDown(WebElement dropDown)
	{
		s = new Select(dropDown);
		return s.isMultiple();
	}
	
}
