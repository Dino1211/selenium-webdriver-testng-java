package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Alert {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Alert alert;
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	//@Test
	public void TC_01_Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		sleepInsecond(3);
	
		
		alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(),"I am a JS Alert");
		
		alert.accept();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked an alert successfully");
		
	}

	//@Test
	public void TC_02_Comfirm_Alert() {
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		sleepInsecond(3);
		
		alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(),"I am a JS Confirm");
		
		alert.dismiss();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked: Cancel");
		
	}
	
	//@Test
	public void TC_03_Pormpt_Alert() {
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		sleepInsecond(3);
		
		alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(),"I am a JS prompt");
		
		String text = "haunguyen";
		alert.sendKeys(text);
		
		alert.accept();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You entered: " + text);
	}
	
	@Test
	public void TC_04_Authentication_Alert() {
		
		//driver.get("http://the-internet.herokuapp.com/basic_auth");
		
		//format: http://Username:Passwword@doamin
		
		String username = "admin";
		String password = "admin";
		String url = "http://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
		
		driver.get(url);
		
		String contentText = driver.findElement(By.cssSelector("div#content p")).getText();
		Assert.assertTrue(contentText.contains("Congratulations! You must have the proper credentials."));
		
		
		
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	private void sleepInsecond(int i) {
		// TODO Auto-generated method stub
		
	}
}
