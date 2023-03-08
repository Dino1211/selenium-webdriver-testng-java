package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Actions_PI {

	WebDriver driver;
	Actions action;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}

	//@Test
	public void TC_01_Hover() {
		driver.get("https://automationfc.github.io/jquery-tooltip/");
		
		WebElement ageTextbox = driver.findElement(By.cssSelector("input#age"));
		action.moveToElement(ageTextbox).perform();
		sleepInSecond(2);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(),  "We ask for your age only for statistical purposes.");
		
	}

	private void sleepInSecond(int i) {
		// TODO Auto-generated method stub
		
	}

	//@Test
	public void TC_02_Hover() {
		driver.get("https://fptshop.com.vn/");
		
		WebElement fptLink = driver.findElement(By.xpath("//a[@title='ĐIỆN THOẠI']"));
		action.moveToElement(fptLink).perform();
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//a[text()='Apple (iPhone)']")).click();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://fptshop.com.vn/dien-thoai/apple-iphone");
	
	}
	
	//@Test
	public void TC_03_Click_and_Hold() {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		List<WebElement> allNumbers = driver.findElements(By.cssSelector("ol#selectable>li"));
		Assert.assertEquals(allNumbers.size(), 12);
	     action.clickAndHold(allNumbers.get(0))
	     .moveToElement(allNumbers.get(3))
	     .release()
	     .perform();
	     
	     allNumbers = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
	     Assert.assertEquals(allNumbers.size(), 4);
	
	}
	
	
//	@Test
//	public void TC_04_lick_And_Select() {
//		driver.get("https://automationfc.github.io/jquery-selectable/");
//		
//		List<WebElement> allNumbers = driver.findElements(By.cssSelector("ol#selectable>li"));
//		Assert.assertEquals(allNumbers.size(), 12);
//		Object keys;
//		action.keyDown(Keys.CONTROL).perform();
//		
//		action.click(allNumbers.get(0))
//		.click(allNumbers.get(2))
//		.click(allNumbers.get(4))
//		.click(allNumbers.get(6)).perform();
//		
//		action.keyUp(Keys.CONTROL).perform();
//		
//	     allNumbers = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
//	     Assert.assertEquals(allNumbers.size(), 4);
//	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
