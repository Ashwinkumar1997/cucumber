package StepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import Pageobjects.Addcustomerpage;
import Pageobjects.LoginPage;

public class Baseclass {
	public WebDriver driver;
	public LoginPage lp;
	public Addcustomerpage addcust;
	
	//created for generating random string unique email id
	public static String randomstring1(){
		String generatedstring1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedstring1);
		
	}

}
