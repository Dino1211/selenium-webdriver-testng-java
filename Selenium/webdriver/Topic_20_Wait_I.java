package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_Wait_I {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	JavascriptExecutor jsExecutor;
	WebDriverWait explicitWait;
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		
		explicitWait = new WebDriverWait(driver, 10);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	
	public void TC_01_Visible_Displayed_Vivibility() {
		
		driver.get("https://www.facebook.com/");
		
		// 1. Có trên UI ( bắt buộc )
		// 1. Có trong HTML ( bắt buộc )
		
		//Chờ cho email address textbox hiển thị trong vòng 10s
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		
	}

	
	public void TC_02_Invisible_Undisplayed_Invisibility_I() {
		
		driver.get("https://www.facebook.com/");
		
		// 1. Không Có trên UI ( bắt buộc )
		// 1. Có trong HTML 
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		//Chờ cho Re-enter email textbox k hiển thị trong vòng 10s
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
		

	}

	
	public void TC_02_Invisible_Undisplayed_Invisibility_II() {
		
		driver.get("https://www.facebook.com/");
		
		// 1. Không Có trên UI ( bắt buộc )
		// 1. Không Có trong HTML 
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		//Chờ cho Re-enter email textbox k hiển thị trong vòng 10s
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));

	}
	

	public void TC_03_Presence_I() {
		
		driver.get("https://www.facebook.com/");
		
		// 1.  Có trên UI 
		// 1. Có trong HTML ( bắt buộc )
		
		//Chờ cho email address textbox presence trong HTNL trong vòng 10s
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));

	}
	
	
	public void TC_03_Presence_II() {
		
		driver.get("https://www.facebook.com/");
		
		// 1. Không Có trên UI 
		// 1. Có trong HTML ( bắt buộc )
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		//Chờ cho Re-enter email textbox k hiển thị trong vòng 10s
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.name("reg_email_confirmation__")));

	}
	
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
