package smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.aventstack.extentreports.Status;

import pageObjects.Actions;
import pageObjects.Assertions;
@Listeners
public class filterFunctionality extends Actions  {
	String productName = "Jackets";
	String option = "Product Name";
	Assertions assertion = new Assertions();

	@BeforeTest
	public void beforeTest() {
		maximizeBrowser();
		openWebsite();
	}

	@Test(description = "Filter functionality")
	
	public void filterFunctionality() throws InterruptedException {
		extentTest=extentReport.createTest("Filter functionality");
		extentTest.log(Status.INFO, "Filter functionality Test Start");
		Thread.sleep(1500);
		clickOnCategory();
		clickOnProductlink(productName);
		SelectProductByIndex();
		assertion.checkSelectIsContain(option);
		assertion.checkOutputOfFilterIsSortedByAscendingOrder();

	}

	@AfterTest
	public void aterTest() {
		// action.closeBrowser();

	}

}
