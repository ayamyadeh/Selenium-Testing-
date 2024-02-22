package smokeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Actions;
import pageObjects.Assertions;

public class testCases extends Actions {
	Assertions assertion;

	@BeforeTest
	public void myBeforetest() {
		assertion = new Assertions();
		maximizeBrowser();
		openWebsite();
 	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sign In")));
	}
	
	@Test(enabled = false , description = "print the name of the even product in hor seller section")
	public void printNameOfEvenProducts() {
		List<WebElement> products =  driver.findElements(By.className("product-item-link"));
		for(int i = 0 ; i<products.size(); i++) {
			// index is even 
			if(i%2==0) {
				System.out.println(products.get(i).getText());
			}
		}
	}
	
	@Test(enabled = false , description = "Add Unavailable Product To Cart")
	public void addUnavailableProducttoCart () throws InterruptedException {
		typeSearchInputField("Push It Messenger Bag");
		Thread.sleep(3000);
		chooseItem("Push It Messenger Bag");
		Thread.sleep(1000);
		clickOnAddToCartButton();
		Thread.sleep(2000);
		assertion.checkMessagebarContainValue("The requested qty is not available");
	}
	
	@Test(enabled=true,description = "Add Product to Compare List")
	public void addProductToCompare() throws InterruptedException {
		 clickOnCategory("Gear");
		 clickOnProductLink("Watches");
		 chooseListMode();
		 addWatchToCompareList();
		 Thread.sleep(2000);
      	 assertion.checkCounterQtyOfCompareListContainValue(productQty+" items");
      
	}
	
	
	
	@AfterTest
	public void myafter() {
		closeBrowser();
	}
	
}