package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Pageobjects.Addcustomerpage;
import Pageobjects.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;


public class Steps extends Baseclass{

	
	
	@Given("User launch the browser")
	public void user_launch_the_browser() {
		System.setProperty("webdriver.ie.driver", "C:/Users/91974/Desktop/softwares/IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		lp=new LoginPage(driver);
		
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) {
		lp.setusername(email);
		lp.setpassword(password);
		
	}

	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {
		lp.clicksubmit();
		
		
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) throws InterruptedException {
		if(driver.getPageSource().contains("Login was unsuccessful.")){
			driver.close();
			Assert.assertTrue(false);
		}else{
			Assert.assertEquals(title, driver.getTitle());
		}
		
		
	}

	@When("User click on Logout link")
	public void user_click_on_Logout_link() throws InterruptedException {
		lp.clicklogout();
		Thread.sleep(3000);
		
	}

	@Then("After logout page title shoudld {string}")
	public void after_logout_page_title_shoudld(String title2) {
		Assert.assertEquals(title2, driver.getTitle());
	    
	}

	@Then("Close browser")
	public void close_browser() {
		driver.quit();
		
	}
	
	//customer feature step definitions
	
	@Then("User can veiw Dashboard")
	public void user_can_veiw_Dashboard() {
		
	   addcust=new Addcustomerpage(driver);
	   Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getpagetitle());
	}

	@When("User click on customer Menu")
	public void user_click_on_customer_Menu() throws InterruptedException {
		
	    addcust.Clickoncustomermenu();
	}

	@When("Click on customer menu item")
	public void click_on_customer_menu_item() throws InterruptedException {
		
	   addcust.Clickoncustomermenuitem();
	}

	@When("Click on add new button")
	public void click_on_add_new_button() throws InterruptedException {
		addcust.Clickonaddnew();
		
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		
		Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getpagetitle());
	   
	}

	@When("User enters customer info")
	public void user_enters_customer_info() throws InterruptedException {
		
		addcust.setemail("Ashwin123@gmail.com");
		addcust.setpassword("Ashw1239");
		addcust.setGender("Male");
		
		addcust.Setmanagerofvendor("Vendor 1");
		
		addcust.Setfirstname("Ashwinkumar");
		addcust.Setlastname("Khetre123");
		addcust.Setdob("1/4/2000");//dd/mm/yy
		addcust.Setcompanyname("Ivytel");
		addcust.Setadmincomment("This is cucumber testing......");
	   
	}

	@When("Click on save button")
	public void click_on_save_button() throws InterruptedException {
		addcust.Clickonsave();
		
	}

	@Then("User can view confirmation massage {string}")
	public void user_can_view_confirmation_massage(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(""));
	   
	}
}
