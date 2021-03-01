package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Accountcreation {

	public WebDriver driver;


	public Accountcreation(WebDriver driver)
	{
		this.driver=driver;

	}

	By gender=By.xpath("//div[@id='uniform-id_gender1']");
	By firstname=By.id("customer_firstname");
	By lastname=By.name("customer_lastname");
	By phonenum=By.name("phone_mobile");
	By password=By.id("passwd");
	By address=By.id("address1");
	By city=By.id("city");
	By postcode=By.id("postcode");
	//dropdown we use select class
	By day=By.name("days");
	By month=By.name("months");
	By year=By.name("years");
	By newsletter=By.id("uniform-newsletter");
	By state=By.name("id_state");
	By submitaccount=By.name("submitAccount");
	By navigatehomepage=By.xpath("//img[@class='logo img-responsive']");

	public WebElement selectgender()
	{
		return driver.findElement(gender);
	}

	public WebElement selectfirstname()
	{
		return driver.findElement(firstname);
	}

	public WebElement selectlastname()
	{
		return driver.findElement(lastname);
	}
	public WebElement phoneno()
	{
		return driver.findElement(phonenum);
	}
	
	public WebElement enterpassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement enteraddress()
	{
		return driver.findElement(address);
	}
	
	public WebElement entercity()
	{
		return driver.findElement(city);
	}
	public WebElement enterpostcode()
	{
		return driver.findElement(postcode);
	}

	
	
	
	public WebElement selectday()
	{
		return driver.findElement(day);
	}

	public WebElement selectmonth()
	{
		return driver.findElement(month);
	}

	public WebElement selectyear()
	{
		return driver.findElement(year);
	}

	public WebElement selectstate()
	{
		return driver.findElement(state);
	}

	public WebElement selectnewslettercheckbox()
	{
		return driver.findElement(newsletter);
	}

	public WebElement submitaccountdetails()
	{
		return driver.findElement(submitaccount);
	}

	public WebElement navigatetohomepage()
	{
		return driver.findElement(navigatehomepage);
	}


}
