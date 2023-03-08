package webdriver;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.GetElementAttribute;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Default_Dropdown{

	WebDriver driver;
	Select select;
	Random rand;
	
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		rand = new Random();
				
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	//@Test
	public void TC_01_Default_Dropdown() {
		driver.get("https://demo.nopcommerce.com/");
		
		driver.findElement(By.cssSelector("a.ico-register")).click();
		
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Hau");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Nguyen");
		
		// Khởi tạo select để thao tác với Day dropdow
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		select.selectByVisibleText("12");
		
		// Khởi tạo select để thao tác với Month dropdow
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
		select.selectByVisibleText("November");
		
		// Khởi tạo select để thao tác với Year dropdow
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
		select.selectByVisibleText("1997");
		
		String EmailAddress = "haunguyen" + rand.nextInt(9999) + "@gmail.com";
				
		driver.findElement(By.cssSelector("input#Email")).sendKeys(EmailAddress);
		driver.findElement(By.cssSelector("input#Company")).sendKeys("Vietnamese");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
		
		driver.findElement(By.cssSelector("button#register-button")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")). getText(), "Your registration completed");
		
		driver.findElement(By.cssSelector("a.ico-account")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), "Hau");
		Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), "Nguyen");
		
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(),"12"); 
		
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(),"November");
		
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(),"1997");
		
		Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), EmailAddress);
		Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), "Vietnamese");	
		

		
		
		
		
	}

	//@Test
	public void TC_02_() {
		
		driver.get("https://rode.com/en/support/where-to-buy");
		
		select = new Select(driver.findElement(By.id("country")));
		select.selectByValue("Vietnam");
		sleepInsecond(3);
		
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Vietnam");
		
		List<WebElement> dealers = driver.findElements(By.cssSelector("div#map h4"));
		
		for (WebElement element : dealers) {
			System.out.println(element.getText());
		}
	}
	
	@Test
	public void TC_03_HTML_Dropdown_() {
		
		driver.get("https://applitools.com/automating-tests-chrome-devtools-recorder-webinar/");
		
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Dinh");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Hau");
		
		select = new Select(driver.findElement(By.id("Person_Role__c")));
		select.selectByValue("Software Developer");
		sleepInsecond(3);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Software Developer");
		
		driver.findElement(By.cssSelector("input#Company")).sendKeys("Vietnamese");
		select = new Select(driver.findElement(By.id("Test_Framework__c")));
		select.selectByValue("Selenium");
		sleepInsecond(3);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Selenium");
		
		select = new Select(driver.findElement(By.id("Self_Report_Country__c")));
		select.selectByValue("Vietnam");
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Vietnam");
		
		
	}

	private void sleepInsecond(int i) {
		// TODO Auto-generated method stub
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
