package LoginPage;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestPage {

    WebDriver driver = new ChromeDriver();
    String theURL = "https://automationteststore.com/";
    String SignupPage = "https://automationteststore.com/index.php?rt=account/create";
    Random rand = new Random();
    String TheUserName = "randomFirstName + randomLastName + randomNumberForEmail";
    String ThePassword = "Ahmad#123";
    String ConfirmtionMessage = "Your Account Has Been Created!";
    @BeforeTest
    public void mySetUp() {
        driver.manage().window().maximize();
        driver.get(theURL);
    }

    @Test(priority = 1 ,enabled = true)
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

        // Select Country state
        Select country = new Select(CountrySelect);
        int randomCountry = new Random().nextInt(country.getOptions().size());
        country.selectByIndex(randomCountry);

        // wait 
        Thread.sleep(1000);

        // Select Region
        Select region = new Select(RegionSelect);
        if (region.getOptions().size() > 0) {
            int randomRegion = new Random().nextInt(region.getOptions().size());
            region.selectByIndex(randomRegion);
        // Agree and submit
        AgreeBox.click();
         ContinueButton.click(); // Uncomment if you want to actually submit the form
        Thread.sleep(3000);
        
        System.out.println("✅ Random country and region selected successfully!");
        Thread.sleep(3000);
        
        //driver.quit();
       boolean  actualResalt= driver.getPageSource().contains(ConfirmtionMessage);
        
        Assert.assertEquals(actualResalt, true,"this is to test that account has been created ");
        
        
    }}
    @Test (priority = 2,enabled = true)
    public void Logout() throws InterruptedException {
 
    	
    	WebElement logoutButton = driver.findElement(By.linkText("Logoff"));
    	logoutButton.click();

    	// wait a bit to allow the page to reload
    	Thread.sleep(3000);

    	// find and click the "Continue" button
    	WebElement continueButton = driver.findElement(By.xpath("//a[normalize-space()='Continue']"));
    	continueButton.click();
    	
    }
    @Test (priority = 3,enabled = false)
    public void Login() throws InterruptedException {
    	// Step 1: click the login link first
    	WebElement loginLink = driver.findElement(By.partialLinkText("Login or "));
    	loginLink.click();

    	// Step 2: wait a bit to allow the login form to load
    	Thread.sleep(3000);

    	// Step 3: locate the login form fields
    	WebElement loginName = driver.findElement(By.id("loginFrm_loginname"));
    	WebElement password = driver.findElement(By.id("loginFrm_password"));
    	WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

    	// Step 4: perform login
    	loginName.sendKeys(TheUserName);
    	password.sendKeys(ThePassword);
    	loginButton.click();
    	
    }
    @Test (priority = 4,invocationCount = 1 )
    public void AddToCart() throws InterruptedException {
    	
    	driver.navigate().to("https://automationteststore.com/");
    	Thread.sleep(1000);
    	List<WebElement> TheListOfIteams = driver.findElements(By.className("prdocutname"));
    	int TheTotalNumberOfIteams = TheListOfIteams.size();
    
    System.out.println(2);
    int RandomIteamIndex = rand.nextInt(TheTotalNumberOfIteams);
    TheListOfIteams.get(0).click();
    
    Thread.sleep(3000);
    WebElement AddToCartButton = driver.findElement(By.className("productpagecart"));
    
    if (AddToCartButton.getText().equals("Out of Stock")) {
    	driver.navigate().back();
    	
    	System.out.println("sorry the iteam out of the stoke");
    }
    else {
    	if(driver.getCurrentUrl().contains("product_id=116")) {
    		WebElement Shose = driver.findElement(By.xpath("//input[@id=\"option344747\"]"));
    		Shose.click();
    		
    	}
    	AddToCartButton.click();
    	WebElement ChechOutButton = driver.findElement(By.linkText("Checkout"));
    	ChechOutButton.click();
    	
    }
    }
    
    
}



