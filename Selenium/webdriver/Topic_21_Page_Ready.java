package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_21_Page_Ready {

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
		

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Orange_HRM() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("div.oxd-form-actions")).click();
		
		//click xong move page new 
		Assert.assertTrue(isPageLoadedSuccess());
		
		driver.findElement(By.cssSelector("a.oxd-main-menu-item")).click();
		Assert.assertTrue(isPageLoadedSuccess());
		
		
		
		
	}

	public void TC_02_() {
		

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
    public boolean isPageLoadedSuccess() {
    	
    explicitWait = new WebDriverWait(driver, 30);
	jsExecutor =(JavascriptExecutor) driver;
	ExpectedCondition<Boolean>jQueryLoad = new ExpectedCondition<Boolean>() {
		@Override
		public Boolean apply(WebDriver driver) {
		return (Boolean)jsExecutor.executeScript("return(window.jQuery!=null)&&(jQuery.active===0);");
	}
	};
	
	ExpectedCondition<Boolean> jsLoad=new ExpectedCondition<Boolean>() {
		@Override
		public Boolean apply(WebDriver driver) {
		return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
	}
	};
	return explicitWait.until(jQueryLoad)&&explicitWait.until(jsLoad);
}
}
