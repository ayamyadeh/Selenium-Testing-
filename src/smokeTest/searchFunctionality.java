package smokeTest;

import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageObjects.Actions;
import pageObjects.Assertions;
//عشان يطلع هاد الملف  بالريبورت بالتست
@Listeners

public class searchFunctionality extends Actions {


	Assertions assertion = new Assertions();

	String productName = "bag";
	String title = "Search results for: " + "'" + productName + "'";

	@BeforeTest
	public void beforeTest() {
		maximizeBrowser();
		openWebsite();
	}

	@Test(description = "serachItem")
	public void searchItem() {
		extentTest=extentReport.createTest("serachItem");
		extentTest.log(Status.INFO, "serachItem Test Start");
		typeSearchInputField(productName);
		assertion.checkPageTitleIsContain(title);

	}

	@AfterTest
	public void aterTest() {
		// action.closeBrowser();

	}
}
