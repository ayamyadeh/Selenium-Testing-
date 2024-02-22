package smokeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class homePage {
	WebDriver driver = new ChromeDriver();
	String email = "hihi@gmail.com";
	String pass = "Aya123aya";

	@BeforeTest
	public void beforeTest() {
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");

	}

	// الاولوية عشان يشغل التست عالترتيب اذا كان عندي اكثر من وحدة
	// enabled ما بتعملها رن
	@Test(description = "serach", priority = 1, enabled = false)
	public void search() {
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.id("search")).sendKeys("bag" + Keys.ENTER);
		WebElement element = driver.findElement(By.className("page-title"));

		System.out.print(element.getText());
	}

	@Test(description = "printCategoriesName", priority = 1, enabled = false)
	public void printCategoriesName() {

		// css selctor اذا كان اكثر من كلاس
		List<WebElement> elemnents = driver.findElements(By.cssSelector(".category-item.level0 "));

		for (int i = 0; i < elemnents.size(); i++) {
			System.out.print(elemnents.get(i).getText());
		}
	}

	@Test(description = "Login functionality", priority = 1, enabled = false)
	public void loginFunctionality() {

		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.name("login[username]")).sendKeys(email + Keys.ENTER);
		driver.findElement(By.id("pass")).sendKeys(pass + Keys.ENTER);
		driver.findElement(By.id("send2")).click();

	}

	@Test(description = "Filter functionality", priority = 1, enabled = false)
	public void filterFunctionality() throws InterruptedException {
		Thread.sleep(1500);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/nav/ul/li[1]/a/span")).click();
		driver.findElement(By.linkText("Jackets")).click();
		WebElement element = driver.findElement(By.id("sorter"));
		Select dropdown = new Select(element);
		// dropdown.selectByVisibleText("Price");
		// dropdown.selectByIndex(1);
		dropdown.selectByValue("position");
	}
	@Test(description = "print the name of the even product in hor seller section", priority = 1, enabled = false)
	public void printNameOfEvenProducts() {
		List <WebElement> elements=driver.findElements(By.className("product-item"));
		for(int i =0 ;i<elements.size();i++ ) {
	if (i%2==0) {
		System.out.print(elements.get(i).getText());
	}
		
	}}
	@Test(enabled = true , description = "Add Unavailable Product To Cart")
	public void addUnavailableProducttoCart () throws InterruptedException {
		Thread.sleep(3000);
		
		
	}

	@AfterTest
	public void aterTest() {
		// driver.close();

	}

}
