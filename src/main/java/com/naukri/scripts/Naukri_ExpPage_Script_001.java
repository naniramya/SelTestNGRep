package com.naukri.scripts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.naukri.commons.MySqlDBConnection;
import com.naukri.commons.NaukriConstants;
import com.naukri.pageobjects.NaukriExpBasicDetailsPage;

public class Naukri_ExpPage_Script_001 {
	WebDriver driver;
	Connection con;
	NaukriExpBasicDetailsPage nb;
	private final static Logger LOGGER = Logger.getLogger(NaukriExpBasicDetailsPage.class.getName());
	

	@BeforeTest
	public void setUp() throws SQLException, ClassNotFoundException {
		System.setProperty("webdriver.chrome.driver", "N:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		con = MySqlDBConnection.getConnnection();
		nb = new NaukriExpBasicDetailsPage(driver, con);
	}

	@Test(priority = 1)
	public void openBrowser() {
		nb.openBrowser();
	}

	@Test(priority = 2)
	public void verifyPage() {
		nb.clickRegForFreeButton();
		nb.clickIamFresherButton();
		String actText = nb.verifyPage();
		Assert.assertEquals(actText, NaukriConstants.EXP_TEXT);
		System.out.println("in fresher basic details page");
		LOGGER.info("in fresher basic details page..");
	}

	@Test(priority = 3)
	public void enterName() throws ClassNotFoundException, SQLException {
		nb.enterName();
		System.out.println("name entered...");
		LOGGER.info("name entered--->>");
	}

	@Test(priority = 4)
	public void enterEmailId() throws ClassNotFoundException, SQLException {
		nb.enterEmailId();
		System.out.println("email Id entered...");
		LOGGER.info("email Id entered--->>");
	}
	@Test(priority = 5)
	public void enterCreatePassword() throws ClassNotFoundException, SQLException {
		nb.enterPassword();
		System.out.println("password entered...");
		LOGGER.info("password entered--->>");
	}

	@AfterTest
	public void afterTest() {
		nb.closeBrowser();
	}

}
