package smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.Actions;
import pageObjects.Assertions;
import support.Constants;
@Listeners

public class loginPage extends Actions   {

	Assertions assertion = new Assertions();
	String currentUrl = "https://magento.softwaretestingboard.com/";
	String message = "Welcome, aa aa!";

	@BeforeTest
	public void beforeTest() {
	maximizeBrowser();
		openWebsite();

	}

	@Test(description = "Login functionality")
	public void loginFunctionality() throws InterruptedException {
		extentTest=extentReport.createTest("Login functionality");
		extentTest.log(Status.INFO, "Login functionality Test Start");
		clickOnSignInLink();
		typeInEmailInputField();
		typeInPasswordInputField();
		clickOnSignInButton();
		assertion.checkCurrentURLIsContain(currentUrl);
		Thread.sleep(3000);
		assertion.checkHeaderIsContain(message);

	}

	@AfterTest
	public void aterTest() {
		// action.closeBrowser();

	}
}
