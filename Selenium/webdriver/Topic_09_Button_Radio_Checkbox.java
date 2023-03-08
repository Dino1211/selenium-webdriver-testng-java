package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Button_Radio_Checkbox {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	//@Test
	public void TC_01_Button() {
		
		driver.get("https://www.fahasa.com/customer/account/create");
		sleepInSecond(5);
		
		driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
		
		By loginButtonBy = By.cssSelector("button.fhs-btn-login");
		
		Assert.assertFalse(driver.findElement(loginButtonBy).isEnabled());
		
		driver.findElement(By.id("login_username")).sendKeys("haunguyen@gmail.net");
		driver.findElement(By.id("login_password")).sendKeys("123456");
		
		Assert.assertTrue(driver.findElement(loginButtonBy).isEnabled());
		
		String loginButtonBackgroundColor = driver.findElement(loginButtonBy).getCssValue("background-color");
		System.out.println(loginButtonBackgroundColor);
		
	}

	

	//@Test
	public void TC_02_() {
		
		driver.get("https://automationfc.github.io/multiple-fields/");
		sleepInSecond(5);
		
		driver.findElement(By.xpath("//input[@value='Emotional Disorder']")).click();
		driver.findElement(By.xpath("//input[@value='Gallstones']")).click();
		driver.findElement(By.xpath("//input[@value='1-2 days']")).click();
		driver.findElement(By.xpath("//input[@value='I have a strict diet']")).click();
		sleepInSecond(5);
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Emotional Disorder']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Gallstones']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='1-2 days']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='I have a strict diet']")).isSelected());
		
		driver.findElement(By.xpath("//input[@value='Emotional Disorder']")).click();
		driver.findElement(By.xpath("//input[@value='Gallstones']")).click();
		driver.findElement(By.xpath("//input[@value='1-2 days']")).click();
		driver.findElement(By.xpath("//input[@value='I have a strict diet']")).click();
		sleepInSecond(5);
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Emotional Disorder']")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Gallstones']")).isSelected());
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='1-2 days']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='I have a strict diet']")).isSelected());
		

	}
	
	@Test
	public void TC_03_() {
		//checkbox
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		
		By conditionChoose = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input]");
		
		driver.findElement(conditionChoose).click();
		sleepInSecond(3);
		
		//Assert.assertTrue(driver.findElement(conditionChoose).isSelected());
		
		 //driver.findElement(conditionChoose).click();
		
		//Assert.assertFalse(driver.findElement(conditionChoose).isSelected());
		
	
	
	}
	
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	private void sleepInSecond(int i) {
		// TODO Auto-generated method stub
		
	}

}
