package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import support.Constants;
import support.extentReportClass;

public class Actions extends extentReportClass  implements Constants  {
	
	public static int productQty = 0; 
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void openWebsite() {
		driver.get("https://magento.softwaretestingboard.com/");
	}

	public void clickOnSignInLink() {
		//RelativeLocator بستعمله لما يكون مش لاقي السيلكتور عن طريف فايند ايلمنت 
		By locator=RelativeLocator.with(By.tagName("a")).toLeftOf(By.linkText("Create an Account"));
		driver.findElement(locator).click();
	 //   driver.findElement(By.linkText("Sign In")).click();
	}
	
	public void typeInEmailInputField() {
		By locator=RelativeLocator.with(By.tagName("input")).above(By.name("login[password]"));
		driver.findElement(locator).sendKeys(email);

	  //  driver.findElement(By.name("login[username]")).sendKeys(email);
	}
	
	public void typeInPasswordInputField() {
	    driver.findElement(By.name("login[password]")).sendKeys(pass);
	}
	
	public void clickOnSignInButton() {
	    driver.findElement(By.name("send")).click();
	}
	
	


	public void typeSearchInputField(String product) {
		driver.findElement(By.id("search")).sendKeys(product + Keys.ENTER);
	}

	public void printPageTitle() {
		WebElement element = driver.findElement(By.className("page-title"));
		System.out.println(element.getText());
	}

	public void clickOnCategory() {
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/nav/ul/li[1]/a/span")).click();

	}

	public void clickOnProductlink(String product) {
		driver.findElement(By.linkText(product)).click();

	}

	public void SelectProductByIndex() {
		WebElement element = driver.findElement(By.id("sorter"));
		Select dropdown = new Select(element);
		// dropdown.selectByVisibleText("Price");
		dropdown.selectByIndex(1);
		// dropdown.selectByValue("position");
	}

	public void chooseItem(String product) {
	driver.findElement(By.linkText(product)).click();
	}
	public void clickOnAddToCartButton() {
		 driver.findElement(By.id("product-addtocart-button")).click();
		
	}
	public void clickOnCategory(String product ) {
	driver.findElement(By.linkText(product)).click();
	}
	
	public void clickOnProductLink(String product ) {
		driver.findElement(By.linkText(product)).click();

	}
	public void chooseListMode(){
		 driver.findElement(By.className("mode-list")).click();
	}
	public void addWatchToCompareList() {
		List<WebElement> products =  driver.findElements(By.className("product-item-info"));
          for (int i=0;i<products.size();i++) {
        	  try {
        	  WebElement swatchPrice =  products.get(i).findElement(By.cssSelector(".price-box .price"));
           		String  swatchPriceText = 	swatchPrice.getText().substring(1,3);
           		int swatchPriceTextIntegr=Integer.parseInt(swatchPriceText);
           		if (swatchPriceTextIntegr>50) {
           			products.get(i).findElement(By.className("tocompare")).click();
           			productQty++;
           		}
          } catch (StaleElementReferenceException e) {
   	        // Re-locate the watches list as it might have become stale
        	  products = driver.findElements(By.cssSelector(".product.product-item"));
 	            i--; // Re-try the current iteration
 	            
 	            //i=0 
   	    }
   		
   		// i =2 
   		
   		//i = 1 
   		
    	}
	}
        	  
          
	
	
	public void closeBrowser() {
		driver.close();
	}

}
