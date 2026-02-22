package myTestCases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Hello extends TestData{
	
	
	
	@BeforeTest
	
	public void myBeforeTest() throws SQLException {
		
		driver.get(MyWebSite);
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","ayaali");
		
		
		
	}
	
	
	@Test(priority = 1 , enabled = true)
	
	public void myTestToAddData() throws SQLException {
		
		stmt = con.createStatement();
		
		String Query = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit) VALUES (9999, 'Raghad Obidat Store', 'Obidat', 'Raghad', '+962 7 9123 4567', 'Wasfi Al-Tal Street', NULL, 'Amman', NULL, '11118', 'Jordan', 1370, 50000.00);";
		stmt.execute(Query);
	}
	
	@Test(priority = 2)
	public void ReadData() throws SQLException {
		stmt = con.createStatement();
		
		String query = "select * from customers where customerNumber = 9999";
		rs =stmt.executeQuery(query);
		
		while (rs.next()) {
			
			 firstname =rs.getString("customerName");
			 customerID =rs.getString("customerNumber");
			 customerPhone =rs.getString("phone");
			 lastname = rs.getString("contactLastName");
			

			
			
			System.out.println(firstname);
			System.out.println(customerID);
			System.out.println(customerPhone);


		}
		

		System.out.println(firstname);
		System.out.println(customerID);
		System.out.println(customerPhone);

		
	}
	
	


	@Test (priority = 3,enabled = true)

	public void SignupWithDataBase() throws InterruptedException {
		
		
		String TheEmail = firstname+lastname+randomEmailNumber+randomEmailNumber2+"@gmail.com";
		
		System.out.println(TheEmail);
		
		//   استخدمنا االسطر السابق لانه بعد اول اختبار الي كان قراءة رح يصير في قيم لل فيرست و لاست نيم ويتم تعريفهم

		WebElement LoginAndRegisterButton = driver.findElement(By.linkText("Login or register"));
		LoginAndRegisterButton.click();

		// to press on Continue Button

		WebElement ContinueButtonBeforeSignupPage = driver.findElement(By.xpath("//button[@title='Continue']"));
		ContinueButtonBeforeSignupPage.click();

//...............you are inside the sign up page..........

		// Elements

	WebElement FirstNameInptuField = driver.findElement(By.id("AccountFrm_firstname"));
		WebElement LastNameInptuField = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement EmailInputField = driver.findElement(By.id("AccountFrm_email"));
		WebElement Address1 = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement CountryDropDown = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement StateDropDown = driver.findElement(By.id("AccountFrm_zone_id"));
		WebElement CityInput = driver.findElement(By.id("AccountFrm_city"));
		WebElement PostalInput = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement LoginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement PasswordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement ConrirmPasswordInput = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement ConditionAndCheckbox = driver.findElement(By.id("AccountFrm_agree"));
		WebElement ContinueButton = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));

		// Actions

		FirstNameInptuField.sendKeys(firstname);
		LastNameInptuField.sendKeys(lastname);
		EmailInputField.sendKeys(TheEmail);
		Address1.sendKeys("Amman");
		Select CountrySelect = new Select(CountryDropDown);
		CountrySelect.selectByVisibleText("Jordan");
		Thread.sleep(5000);
	int randomstate = rand.nextInt(StateDropDown.findElements(By.tagName("option")).size());
		Select SelectforStateDropDown = new Select(StateDropDown);
		SelectforStateDropDown.selectByIndex(randomstate);
		CityInput.sendKeys("RandomCity");
		PostalInput.sendKeys(customerPhone);
		
		ConditionAndCheckbox.click();
	

		// Assertion

		//Assert.assertEquals(driver.getCurrentUrl().contains("succes"), true);

		//Assert.assertEquals(driver.getPageSource().contains("Congratulations"), true);

		//WebElement WelcomeMessageArea = driver.findElement(By.id("customernav"));

		//Assert.assertEquals(WelcomeMessageArea.getText().contains(randomFirstName), true);

	}
	

	@Test(priority = 4)
	public void myTestToUpdateData() throws SQLException {
			
			stmt = con.createStatement();
			
			String Query = " UPDATE customers SET customerName = 'dana and raghad' WHERE customerNumber = 9999;";
			stmt.execute(Query);
		}
		
	@Test(priority = 5)
	public void myTestToDeleteData() throws SQLException {
			
			stmt = con.createStatement();
			
			String Query = " delete from customers where customerNumber = 9999;";
			stmt.execute(Query);
		}
	
	
	

}
