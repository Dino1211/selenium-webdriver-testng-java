package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	public void beforeClass() {
		
	}

	@Test
	public void TC_01_Browser() {
		// Các hàm tương tác vs browser sẽ thông qua biến driver
		
		// Đóng tab/ Window đang active
		driver.close();
		
		// Đóng browser
		driver.quit();
		
		// tìm ra 1 element ( single)
		driver.findElement(By.cssSelector(""));
		
		// tìm ra nhiều element (multiple)
		driver.findElements(By.cssSelector(""));
		
		// Mở ra 1 cái url truyền vào
		driver.get("https://www.facebook.com/");
		
		// Trả về 1 Url tại page đang đứng 
		driver.getCurrentUrl();
		
		
		
		
	}

	@Test
	public void TC_02_Element() {
		// Các hàm tương tác với element sẽ thông qua element
		

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
