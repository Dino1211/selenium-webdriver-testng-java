package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Custom_checkbox_radio {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	JavascriptExecutor jsExecutor;
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		jsExecutor = (JavascriptExecutor) driver;
		
	}

	//@Test
	public void TC_01_() {
		driver.get("https://material.angular.io/components/radio/examples");
		
		By radioButton = By.xpath("//input[@value='Summer']/parent::span");
		driver.findElement(radioButton).click();
		sleepInsecond(3);
		Assert.assertEquals(driver.findElement(radioButton).getAttribute("tabindex"), "0");
		
		
		
	}


	@Test
	public void TC_02_() {
		driver.get("https://material.angular.io/components/checkbox/examples");
		
		// DK để thỏa mãn ( Vừa click vừa verify được )
		// - K dùng thẻ input để click
		// - Thẻ input dùng để verify
		
		//By checkedCheckboxText = By.xpath("//span[text()='Checked']");
		//driver.findElement(checkedCheckboxText).click();
		//sleepInsecond(3);
		
		//By checkedCheckbox = By.xpath("//span[text()='Checked']/preceding-sibling::span/input");
		//Assert.assertTrue(driver.findElement(checkedCheckbox).isSelected());
		
		// dùng java
		By checkedCheckbox = By.xpath("//span[text()='Checked']/preceding-sibling::span/input");
		
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(checkedCheckbox));
		sleepInsecond(3);
		
		Assert.assertTrue(driver.findElement(checkedCheckbox).isSelected());
		
	}
	

	//@Test
	public void TC_03_GoogleDocs() {
		
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
		//Radio
		By hanoiRadio = By.xpath("//div[@aria-label='Hà Nội']");
		driver.findElement(hanoiRadio).click();
		sleepInsecond(3);
		Assert.assertEquals(driver.findElement(hanoiRadio).getAttribute("aria-checked"), "true");
		
		//checkbox
		By quangnamCheckbox = By.xpath("//div[@aria-label='Quảng Nam']");
		driver.findElement(quangnamCheckbox).click();
		sleepInsecond(3);
		Assert.assertEquals(driver.findElement(quangnamCheckbox).getAttribute("aria-checked"), "true");
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	private void sleepInsecond(int i) {
		// TODO Auto-generated method stub
		
	}

}
