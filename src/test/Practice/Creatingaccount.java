package Practice;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.Accountcreation;
import PageObjects.SigninPage;
import resources.Base;

public class Creatingaccount extends Base {
	
	public static Logger log=LogManager.getLogger(Creatingaccount.class.getName());	

	SigninPage sp;
	
	@BeforeTest
	public void accountsetup() throws IOException, InterruptedException
	{

		driver=initailisedriver();
		sp=new SigninPage(driver);
		sp.clickonSignin().click();
		sp.enteremailid().sendKeys("sharath10.k1991@gmail.com");;
		sp.submitemailid().click();
		log.info("email id entered and navigated to account creation page ");

	}

	@Test(priority=1)
	public void fillacoountdetails() throws InterruptedException {

		Accountcreation ac=new Accountcreation(driver);
		WebDriverWait wb=new WebDriverWait(driver, 10);
		wb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='uniform-id_gender1']")));
		ac.selectgender().click();
		ac.selectfirstname().sendKeys("Sharath");
		ac.selectlastname().sendKeys("Kumar");
		ac.enterpassword().sendKeys("qwerty");
		ac.enteraddress().sendKeys("Shristi apartments");
		ac.entercity().sendKeys("Bangalore");
		ac.enterpostcode().sendKeys("12345");
		WebElement day=driver.findElement(By.name("days"));
		WebElement month=driver.findElement(By.name("months"));
		WebElement year=driver.findElement(By.name("years"));
		WebElement state=driver.findElement(By.name("id_state"));
		Select date=new Select(day);
		date.selectByValue("19");
		Select months=new Select(month);
		months.selectByVisibleText("September ");
		Select years=new Select(year);
		years.selectByValue("1991");
		Select states=new Select(state);
		states.selectByVisibleText("Arizona");
		ac.selectnewslettercheckbox().click();
		ac.phoneno().sendKeys("9739221652");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		ac.submitaccountdetails().click();;
		log.info("account created succesfully");
		ac.navigatetohomepage().click();
		if(sp.verifyacctname().isDisplayed()) {
			log.info("Succesfully verified username");
		}else {
			log.error("Logged in user name did not match");
		}
	}

	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}


}
