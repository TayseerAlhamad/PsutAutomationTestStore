package LoginPage;

import java.util.List;
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
    String TheUserName = "randomFirstName + randomLastName + randomNumberForEmail";
    String ThePassword = "Ahmad#123";
    @BeforeTest
    public void mySetUp() {
        driver.manage().window().maximize();
        driver.get(theURL);
    }

    @Test(priority = 1)
    public void SignUp() throws InterruptedException {
        Thread.sleep(3000);
        driver.get(SignupPage);

        // Elements
        WebElement FirstNameInput = driver.findElement(By.id("AccountFrm_firstname"));
        WebElement LastNameInput = driver.findElement(By.id("AccountFrm_lastname"));
        WebElement EmailInput = driver.findElement(By.id("AccountFrm_email"));
        WebElement TelephoneInput = driver.findElement(By.id("AccountFrm_telephone"));
        WebElement FaxInput = driver.findElement(By.id("AccountFrm_fax"));
        WebElement companyInput = driver.findElement(By.id("AccountFrm_company"));
        WebElement FirstAddressInput = driver.findElement(By.id("AccountFrm_address_1"));
        WebElement SecondAddressInput = driver.findElement(By.id("AccountFrm_address_2"));
        WebElement CityInput = driver.findElement(By.id("AccountFrm_city"));
        WebElement ZipCodeInput = driver.findElement(By.id("AccountFrm_postcode"));
        WebElement LogInInput = driver.findElement(By.id("AccountFrm_loginname"));
        WebElement PasswordInput = driver.findElement(By.id("AccountFrm_password"));
        WebElement PasswordConfirmInput = driver.findElement(By.id("AccountFrm_confirm"));
        WebElement AgreeBox = driver.findElement(By.id("AccountFrm_agree"));
        WebElement ContinueButton = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));
        WebElement RegionSelect = driver.findElement(By.id("AccountFrm_zone_id"));
        WebElement CountrySelect = driver.findElement(By.id("AccountFrm_country_id"));

        // Data
        String[] firstnames = { "ahmad", "heba", "tayseer", "ali" };
        String randomFirstName = firstnames[rand.nextInt(firstnames.length)];

        String[] lastnames = { "sameer", "hatem", "abdallah", "mohammed" };
        String randomLastName = lastnames[rand.nextInt(lastnames.length)];
        TheUserName = randomFirstName + randomLastName ;
        ThePassword = "Ahmad#123";
        
        int randomNumberForEmail = rand.nextInt(7000);
        String email = randomFirstName + randomLastName + randomNumberForEmail + "@gmail.com";
        String telephone = "079" + (rand.nextInt(9000000) + 1000000);
        String fax = "06" + (rand.nextInt(900000) + 100000);
        String company = "Extensya";
        String firstaddress = "Amman North Marka";
        String secondaddress = "Khalda";
        String city = "Amman";
        String zipCode = "11953";
        int randomNumberLogin = rand.nextInt(8000);
        String password = "Ahmad#123";

        // Fill form
        FirstNameInput.sendKeys(randomFirstName);
        LastNameInput.sendKeys(randomLastName);
        EmailInput.sendKeys(email);
        TelephoneInput.sendKeys(telephone);
        FaxInput.sendKeys(fax);
        companyInput.sendKeys(company);
        FirstAddressInput.sendKeys(firstaddress);
        SecondAddressInput.sendKeys(secondaddress);
        CityInput.sendKeys(city);
        ZipCodeInput.sendKeys(zipCode);
        LogInInput.sendKeys(randomFirstName + randomLastName + randomNumberLogin);
        PasswordInput.sendKeys(password);
        PasswordConfirmInput.sendKeys(password);

        // Select random country
        Select countryDropdown = new Select(CountrySelect);
        int totalCountries = countryDropdown.getOptions().size();
        System.out.println("Total countries: " + totalCountries);

        int randomCountryIndex = rand.nextInt(1, totalCountries); // works in Java 17+
        // If Java <17: int randomCountryIndex = rand.nextInt(totalCountries - 1) + 1;

        countryDropdown.selectByIndex(randomCountryIndex);

        // Wait for region list to update
        Thread.sleep(2000);

        // Select random state (region)
        Select stateDropDown = new Select(RegionSelect);
        int numberOfRegions = stateDropDown.getOptions().size();
        System.out.println("Number of regions: " + numberOfRegions);

        if (numberOfRegions > 1) {
            int randomRegionIndex = rand.nextInt(1, numberOfRegions);
            stateDropDown.selectByIndex(randomRegionIndex);
        } else {
            System.out.println("No regions available for selected country.");
        }

        // Agree and submit
        AgreeBox.click();
         ContinueButton.click(); // Uncomment if you want to actually submit the form
        Thread.sleep(3000);
        
        System.out.println("✅ Random country and region selected successfully!");
        Thread.sleep(3000);
        
        //driver.quit();
        
    }
    @Test (priority = 2)
    public void Logout() throws InterruptedException {
    	
    	//element
    	WebElement LogoutButton = driver.findElement(By.linkText("Logoff"));
    	List<WebElement> buttons = driver.findElements(By.xpath("//a[normalize-space()='Continue']"));
    	
    	
    	//action
    	LogoutButton.click();
    	Thread.sleep(3000);
    	buttons.get(0).click();
    	
    }
    @Test (priority = 3)
    public void Login () {
        //element 
    	WebElement LoginButton = driver.findElement(By.partialLinkText("Login or "));
    	WebElement LoginName = driver.findElement(By.id("loginFrm_loginname"));
    	WebElement PasswordLogin = driver.findElement(By.id("loginFrm_password"));
    	WebElement LoginButton1 = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
    	
    	//action
    	LoginButton.click();
    	LoginName.sendKeys(TheUserName);
    	PasswordLogin.sendKeys(ThePassword);
    	LoginButton1.click();
    	
    }
}



