package myTestCases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestData {
	
Random rand = new Random();
	
	Connection con ;
	Statement stmt ;
	ResultSet rs ;
	
	
	String firstname ;
	String customerID ;
	String customerPhone ;
	String lastname;

	WebDriver driver = new ChromeDriver();
	
	

	int randomEmailNumber =rand.nextInt(5478);
	int randomEmailNumber2 =rand.nextInt(978);
	
	String TheEmail = firstname+lastname+randomEmailNumber+randomEmailNumber2+"@gmail.com";
	
	String MyWebSite = "https://automationteststore.com/";
	

}
