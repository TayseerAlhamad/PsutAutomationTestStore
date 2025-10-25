package LoginPage;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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

        // Elements
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
        WebElement PasswordConfirmInput = driver.findElement(By.xpath("//input[@id='AccountFrm_confirm']"));
        WebElement AgreeBox = driver.findElement(By.xpath("//input[@id='AccountFrm_agree']"));
        WebElement ContinueButton = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));
        WebElement RegoinStats = driver.findElement(By.xpath("//select[@id='AccountFrm_zone_id']"));
        WebElement CountrySelect = driver.findElement(By.xpath("//select[@id='AccountFrm_country_id']"));

        // Data
        String[] firstnames = { "ahmad", "heba", "tayseer", "ali" };
        String randomFirstName = firstnames[rand.nextInt(firstnames.length)];

        String[] lastnames = { "sameer", "hatem", "abdallah", "mohammed" };
        String randomLastName = lastnames[rand.nextInt(lastnames.length)];

        int randomNumberForEmail = rand.nextInt(7000);
        String email = randomFirstName + randomLastName + randomNumberForEmail + "@gmail.com";
        String telephone = "0897653247";
        String fax = "9874653472";
        String company = "abc";
        String firstaddress = "amman north marka";
        String secondaddress = "khalda";
        String city = "amman";
        String ZipCode = "3817";
        int randomNumberLogin = rand.nextInt(8000);
        String Password = "Ahmad#123";

        // Actions
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
        LogInInput.sendKeys(randomFirstName + randomLastName + randomNumberLogin);
        PasswordInput.sendKeys(Password);
        PasswordConfirmInput.sendKeys(Password);

        // Select Country
        Select countryDropdown = new Select(CountrySelect);
        countryDropdown.selectByVisibleText("Jordan");
        Thread.sleep(2000);

        // Select random state (region)
        Select stateDropDown = new Select(RegoinStats);
        int numberOfOptions = stateDropDown.getOptions().size();
        System.out.println("Number of options in state dropdown: " + numberOfOptions);
        int randomStateIndex = rand.nextInt(numberOfOptions);
        stateDropDown.selectByIndex(randomStateIndex);

        // Submit
        AgreeBox.click();
        ContinueButton.click();
        
    }
}


