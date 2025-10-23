package LoginPage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestPage {

	
	
	WebDriver driver = new ChromeDriver();
	String theURL = "https://automationteststore.com/";
	String SignupPage = "https://automationteststore.com/index.php?rt=account/create";
     Random rand = new Random();
	@BeforeTest 
	
	public void mySetUp() {
		
		driver.get(theURL);
		driver.manage().window().maximize();
	}
	@Test(priority = 1)
	public void SignUp() throws InterruptedException {
		Thread.sleep(3000);
		driver.get(SignupPage);
		
		//elements
		WebElement FirstNameInput = driver.findElement(By.xpath("//input[@id='AccountFrm_firstname']"));
		WebElement LastNameInput = driver.findElement(By.xpath("//input[@id='AccountFrm_lastname']"));
		WebElement EmailInput = driver.findElement(By.xpath("//input[@id='AccountFrm_email']"));
		WebElement TelephoneInput = driver.findElement(By.xpath("//input[@id='AccountFrm_telephone']"));
		WebElement FaxInput = driver.findElement(By.xpath("//input[@id='AccountFrm_fax']"));
		WebElement companyInput = driver.findElement(By.xpath("//input[@id='AccountFrm_company']"));
		WebElement FirstAddressInput = driver.findElement(By.xpath("//input[@id='AccountFrm_address_1']"));
		WebElement SecondAddressInput = driver.findElement(By.xpath("//input[@id='AccountFrm_address_2']"));
		WebElement CityInput = driver.findElement(By.xpath("//input[@id='AccountFrm_city']"));
		WebElement ZipCodeInput = driver.findElement(By.xpath("//input[@id='AccountFrm_postcode']"));
		WebElement LogInInput = driver.findElement(By.xpath("//input[@id='AccountFrm_loginname']"));
		WebElement PasswordInput = driver.findElement(By.xpath("//input[@id='AccountFrm_password']"));
		WebElement PasswordConfirmInput= driver.findElement(By.xpath("//input[@id='AccountFrm_confirm']"));
		
		//data
		String [] firstnames ={"ahmad","heba","tayseer","ali"};
		int randomIndexForFirstName= rand.nextInt(firstnames.length);
		String randomFirstName =firstnames[randomIndexForFirstName];
		
		
		
		String[] lastname ={"sameer","hatem","abdallah","mohammed"};
		int randomForLastName = rand.nextInt(lastname.length);
		String randomLastName = lastname[randomForLastName];
		
		int randomNumberForEmail = rand.nextInt(7000);
		String email =randomFirstName + randomLastName+randomNumberForEmail+"gmail.com";
		String telephone ="0897653247";
		String fax ="9874653472";
		String company ="abc";
		String firstaddress ="amman north marka";
		String secondaddress ="khalda ";
		String city ="amman";
		String ZipCode="3817";
		int randomNumberLogin = rand.nextInt(8000);
		String Password = "Ahmad#123";
		String PasswordConfirm ="Ahmad#123";
		//action 
		 FirstNameInput.sendKeys(randomFirstName);
		LastNameInput.sendKeys(randomLastName);
		
		
		EmailInput.sendKeys(email);
		TelephoneInput.sendKeys(telephone);
		FaxInput.sendKeys(fax);
		 companyInput.sendKeys(company);
		FirstAddressInput.sendKeys(firstaddress);
		SecondAddressInput.sendKeys(secondaddress);
		CityInput.sendKeys(city);
		ZipCodeInput.sendKeys(ZipCode);
		LogInInput.sendKeys(randomFirstName+randomLastName+randomNumberLogin);
		
		PasswordInput.sendKeys(Password);
		PasswordConfirmInput.sendKeys(PasswordConfirm);
		
	}
}
