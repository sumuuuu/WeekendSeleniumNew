package POMREPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class RegisterPage {
	@FindBy(id="gender-male")
	private WebElement MaleRadioButton;
	@FindBy(id="gender-female")
	private WebElement FemaleRadioButton;
	@FindBy(id="FirstName")
	private WebElement FirstNameTextField;
	@FindBy(id="LastName")
	private WebElement LastNameTextField;
	@FindBy(id="Email")
	private WebElement EmailTextField;
	@FindBy(id="Password")
	private WebElement passwordTextField;
	@FindBy(id="ConfirmPassword")
	private WebElement ConfirmpasswordTextField;
	@FindBy(id="register-button")
	private WebElement RegisterButton;
	
	public RegisterPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

	public WebElement getMaleRadioButton() {
		return MaleRadioButton;
	}

	public WebElement getFemaleRadioButton() {
		return FemaleRadioButton;
	}

	public WebElement getFirstNameTextField() {
		return FirstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return LastNameTextField;
	}

	public WebElement getEmailTextField() {
		return EmailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getConfirmpasswordTextField() {
		return ConfirmpasswordTextField;
	}

	public WebElement getRegisterButton() {
		return RegisterButton;
	}

	
}

