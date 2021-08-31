package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Addcustomerpage {
	WebDriver ldriver;

	public Addcustomerpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By linkcustomer_menu=By.xpath("//body/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]/p[1]");
	By linkcustomer_menuitem=By.xpath("//body/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/p[1]");

	By addnewbtn=By.xpath("//body/div[3]/div[1]/form[1]/div[1]/div[1]/a[1]/i[1]"); //Add new

	By txtemail=By.xpath("//input[@id='Email']");
	By txtpass=By.xpath("//input[@id='Password']");

	By txtcustomerrole=By.xpath("//body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");

	By listitemadminst=By.xpath("//li[.='Administrators']");
	By listitemforum=By.xpath("//li[.='Forum Moderators']");
	By listitemguest=By.xpath("//li[.='Guests']");
	By listitemregis=By.xpath("//li[.='Registered']");
	By listitemvendores=By.xpath("//li[contains(text(),'Vendors')]");

	By dropdvendorid=By.xpath("//*[@id='VendorId']");
	By rdiGendermale=By.xpath("//input[@id='Gender_Male']");
	By rdiGenderfemale=By.xpath("//input[@id='Gender_Female']");

	By txtfirstname=By.xpath("//input[@id='FirstName']");
	By txtlastname=By.xpath("//input[@id='LastName']");

	By txtdob=By.xpath("//input[@id='DateOfBirth']");
	By txtcompanyname=By.xpath("//input[@id='Company']");

	By txtadmincomment=By.xpath("//textarea[@id='AdminComment']");
	By btnsave=By.xpath("//button[@name='save']");

	//Actions method

	public String getpagetitle()
	{
		return ldriver.getTitle();
		
	}
	
	public void Clickoncustomermenu(){
		ldriver.findElement(linkcustomer_menu).click();
	}
	public void Clickoncustomermenuitem(){
		ldriver.findElement(linkcustomer_menuitem).click();
	}
	public void Clickonaddnew(){
		ldriver.findElement(addnewbtn).click();
	}
	public void setemail(String email){
		ldriver.findElement(txtemail).sendKeys(email);
	}
	public void setpassword(String password){
		ldriver.findElement(txtpass).sendKeys(password);
	}
	public void Setcustomerrole(String role) throws InterruptedException{
		ldriver.findElement(txtcustomerrole).click();
		WebElement listitem;

		Thread.sleep(3000);

		if(role.equals("Administrators"))
		{
			listitem=ldriver.findElement(By.xpath("listitemadminst"));
		}
		else if(role.equals("Forum Moderators"))
		{
			listitem=ldriver.findElement(By.xpath("listitemforum"));
		}
		else if(role.equals("Guests"))
		{
			listitem=ldriver.findElement(By.xpath("listitemguest"));

		}
		else if(role.equals("Registered"))
		{
			listitem=ldriver.findElement(By.xpath("listitemregis"));

		}
		else 
		{
			listitem=ldriver.findElement(By.xpath("listitemvendores"));

		}
          listitem.click();
		//JavascriptExecutor js=(JavascriptExecutor) ldriver;
		//js.executeScript("arguments[0].click();", listitem);
	}
	public void Setmanagerofvendor(String value){
		Select drp=new Select(ldriver.findElement(dropdvendorid));
		drp.selectByVisibleText(value);
	}
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdiGendermale).click();

		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(rdiGenderfemale).click();
		}
		else
		{
			ldriver.findElement(rdiGendermale).click();
		}


	}
	public void Setfirstname(String firstname){

		ldriver.findElement(txtfirstname).sendKeys(firstname);
	}
	public void Setlastname(String lastname){

		ldriver.findElement(txtlastname).sendKeys(lastname);
	}
	public void Setdob(String dob){

		ldriver.findElement(txtdob).sendKeys(dob);
	}
	public void Setcompanyname(String companyname){
		ldriver.findElement(txtcompanyname).sendKeys(companyname);
		
	}
	public void Setadmincomment(String comment){
		
		ldriver.findElement(txtadmincomment).sendKeys(comment);
	}
	public void Clickonsave()
	{
		ldriver.findElement(btnsave).click();
	}



}
