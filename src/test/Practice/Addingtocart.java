package Practice;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.Itemtocart;
import resources.Base;

public class Addingtocart extends Base {

	public static Logger log=LogManager.getLogger(Addingtocart.class.getName());	


	@Test(priority=2)
	public void additemstocart() throws InterruptedException, IOException
	{
		Actions a =new Actions(driver);
		//navigates to women tab and search for summer dresses
		WebElement womentab=driver.findElement(By.xpath("//a[@title='Women']"));
		a.moveToElement(womentab).build().perform();;
		WebElement summerdresses=driver.findElement(By.xpath("//a[@title='Summer Dresses']"));
		a.moveToElement(summerdresses).click().build().perform();
		log.info("navigated to women tab and searched for summer dresses");

		//Once navigates to summer tab add items to cart and continue shopping
		Itemtocart ic=new Itemtocart(driver);
		ic.mouseoverinstock().click();
		ic.additems().click();
		log.info("item added to cart suceesfully");
		WebElement shoppingtext=driver.findElement(By.cssSelector("span[title='Continue shopping']"));
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(shoppingtext));
		ic.clcikoncheckoutbutton().click();
		WebElement cartitempresent=driver.findElement(By.xpath("//td//a[contains(text(),'Printed Chiffon Dress')]"));
		WebDriverWait wait1=new WebDriverWait(driver, 5);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		wait1.until(ExpectedConditions.visibilityOf(cartitempresent));
		String cartaddeditem=cartitempresent.getText();
		Assert.assertEquals(cartaddeditem, "Printed Chiffon Dress");
		log.info("Verified added item in the cart");

	}


}
