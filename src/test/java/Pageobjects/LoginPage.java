package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);


	}
	@FindBy(name="Email")
	@CacheLookup
	WebElement txtuname;
	@FindBy(name="Password")
	@CacheLookup
	WebElement txtpass;
	@FindBy(xpath="//button[.='Log in']")
	@CacheLookup
	WebElement loginbutton;
	@FindBy(xpath="//a[.='Logout']")
	@CacheLookup
	WebElement logoutbutton;

	public void setusername(String uname)
	{
		txtuname.clear();
		txtuname.sendKeys(uname);
	}
	public void setpassword(String pass)
	{
		txtpass.clear();
		txtpass.sendKeys(pass);
	}
	public void clicksubmit()
	{
		loginbutton.click();
	}
	public void clicklogout()
	{
		logoutbutton.click();
	}

}
