package webdriver;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Window_Tab {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	JavascriptExecutor jsExecutor;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	//@Test
	public void TC_01_Basic_form() {
	}

	//@Test
	public void TC_02_TechPanda() {
		driver.get("http://live.techpanda.org/index.php/mobile.html");
		
		driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(),"The product Samsung Galaxy has been added to comparison list.");
		
		driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(),"The product Sony Xperia has been added to comparison list.");
		
		driver.findElement(By.cssSelector("button[title='Compare']")).click();
		sleepInSencond(3);
		
		//Switch qua Windows compare
		switchToWindowByTitle("Products Comparison List - Magento Commerce");
		
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Compare Products']")).isDisplayed());
		
		driver.findElement(By.cssSelector("button[title='Close Window']")).click();
		sleepInSencond(3);
		
		//Switch qua mobile
		switchToWindowByTitle("Mobile");
		
		driver.findElement(By.id("search")).sendKeys("Samsung Galaxy");
		sleepInSencond(5);
		
	}
	
	@Test
	public void TC_03_Cambridge() {
		driver.get("https://dictionary.cambridge.org/vi/");
		
		driver.findElement(By.cssSelector("//span[text()='Đăng nhập']//ancestor::span[contains(@class,'cdo-login-button')]"));
		
		switchToWindowByTitle("Login");
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Log in')]//parent::div[contains(@class,'with-site-login')]//input[@name='username']")).isDisplayed());
		
		Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'Log in')]//parent::div[contains(@class,'with-site-login')]//input[@name='username']")).getText(), "This field is required");
		
		Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'Log in')]//parent::div[contains(@class,'with-site-login')]//input[@name='password']")).getText(), "This field is required");
		
		
	}
	
	
	
	// Nó chỉ dùng cho duy nhất 2 tab/window 
	public void switchToWindowByID(String parentID) {
		// Lấy ra tất cả ID của tab/window đang có
		Set<String> allWindowIDs = driver.getWindowHandles();
		//Dùng vòng lặp để duyệt qua từng ID
		for (String id : allWindowIDs) {
		// Nếu như có ID nào mà khác với parentID
			if(!id.equals(parentID)) {
		//Switch vào 
				driver.switchTo().window(id);
				sleepInSencond(2);
	}
	}
	}
	
	// Dùng được cho 2 hoặc nhiều hơn 2 tab/window
	
	public void switchToWindowByTitle(String expectedPageTitle) {
		// Lấy ra tất cả ID của tab/window đang có
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		//Dùng vòng lặp để duyệt qua từng ID
		for (String id : allWindowIDs) {
			//Switch  vào từng tab/window trước 
			driver.switchTo().window(id);
			
			//Lấy ra cái title của page đã switch vào
			String currentPageTitle = driver.getTitle();
			System.out.println(currentPageTitle);
			
			if(currentPageTitle.equals(expectedPageTitle)) {
		// Thoát khỏi vòng lặp - k duyệt tiếp nữa
				break;
				
	}
 }
	}
	

	private void sleepInSencond(int i) {
		// TODO Auto-generated method stub
		
	}

	//@Test
	public void TC_02_() {
		

	}

	//@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
