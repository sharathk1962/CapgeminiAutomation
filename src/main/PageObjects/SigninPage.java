package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SigninPage {

	public WebDriver driver;

	public SigninPage(WebDriver driver)
	{
		this.driver=driver;
	}


	By email=By.id("email_create");
	By submitemail=By.cssSelector("button#SubmitCreate");

	//homepage sign in button
	By signin= By.xpath("//a[@class='login']");
	
	//homepage account name
	By accountname=By.xpath("//span[contains(text(),'Sharath Kumar')]");

	public WebElement enteremailid()
	{
		return driver.findElement(email);
	}

	public WebElement submitemailid()
	{
		return driver.findElement(submitemail);
	}


	public WebElement clickonSignin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement verifyacctname()
	{
		return driver.findElement(accountname);
	}
}
