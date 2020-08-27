package com.naukri.pageobjects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaukriExpBasicDetailsPage {
	WebDriver driver;
	Connection con;
	Statement stmt;
	ResultSet rs;
	private final static Logger LOGGER = Logger.getLogger(NaukriExpBasicDetailsPage.class.getName());
	
	@FindBy(xpath = "//button[@class='btn'][contains(text(),'Register for free')]")
	WebElement regForFree;

	@FindBy(xpath = "//button[contains(text(),'I am a Fresher')]")
	WebElement iamFresher;

	@FindBy(xpath = "//div[contains(text(),'Personal')]")
	WebElement personal;

	@FindBy(id = "fname")
	WebElement fName;

	@FindBy(id = "email")
	WebElement emailId;

	@FindBy(name="password")
	WebElement createPassword;
	
	public NaukriExpBasicDetailsPage(WebDriver driver, Connection con) {
		this.driver = driver;
		this.con = con;
		PageFactory.initElements(driver, this);
	}

	public void openBrowser() {
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		LOGGER.info("browser maximized..");
	}

	public void clickRegForFreeButton() {
		regForFree.click();
		LOGGER.info("Reg for Free button clicked.. ");
	}

	public void clickIamFresherButton() {
		iamFresher.click();
		LOGGER.info("Iam Fresher button clicked..");
	}

	public String verifyPage() {
		return personal.getText();
	}

	public void getTableData() throws SQLException {
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from FresherBasicDetails where id=102 ");
		rs.next();
	}

	public void enterName() throws SQLException {
		getTableData();
		String name = rs.getString("name");
		System.out.println("name is.." + name);
		LOGGER.info("name is ::::" + name);
		fName.sendKeys(name);
		LOGGER.info("name entered as :: " +name);
	}
	public void enterEmailId() throws SQLException{
		getTableData();
		String email = rs.getString("emailId");
		System.out.println("email is.." + email);
		LOGGER.info("email is ::::" + email);
		emailId.sendKeys(email);
		LOGGER.info("email entered as :: " +email );
	}
	public void enterPassword() throws SQLException{
		getTableData();
		String pw = rs.getString("Password");
		System.out.println("password is.." + pw);
		LOGGER.info("password is ::::" + pw);
		createPassword.sendKeys(pw);
		LOGGER.info("password entered as :: " +pw );
	}	
	
	/*
	 * public void enterName() throws SQLException, ClassNotFoundException { 
	 * String name = null; 
	 * stmt = con.createStatement(); 
	 * rs =stmt.executeQuery("select * from FresherBasicDetails where id=102 "); 
	 * while (rs.next())
	 *  { 
	 *  name = rs.getString("name");
	 * System.out.println("name is.." + name); 
	 * } 
	 * fName.sendKeys(name); 
	 * }
	 * 
	 * public void enterEmailId() throws SQLException, ClassNotFoundException {
	 * String email = null; 
	 * stmt = con.createStatement(); 
	 * rs =stmt.executeQuery("select * from FresherBasicDetails where id=102 "); 
	 * while(rs.next()) {
	 *  email = rs.getString("emailId");
	 * System.out.println("-------------->>" + email);
	 *  } 
	 *  emailId.sendKeys(email); }
	 */

	public void closeBrowser() {
		driver.close();
		LOGGER.info("browser closed..");
	}
}
