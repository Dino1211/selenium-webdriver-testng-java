package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_15_Fixed_Popup {

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
	public void TC_01_Fixed_In_Dom_Ngoaingu24h() {
		driver.get("https://ngoaingu24h.vn/");

		WebElement loginPopup = driver.findElement(By.xpath("//div[@id='modal-login-v1'][1]"));

		Assert.assertFalse(loginPopup.isDisplayed());

		driver.findElement(By.cssSelector("button.login_")).click();
		sleepInSecond(3);

		//Assert.assertTrue(loginPopup.isDisplayed());

		driver.findElement(By.xpath("//div[@id='modal-login-v1'][1]//input[@id='account-input']")).sendKeys("haund");
		driver.findElement(By.xpath("//div[@id='modal-login-v1'][1]//input[@id='password-input']")).sendKeys("123456");
		driver.findElement(By.xpath("//div[@id='modal-login-v1'][1]//button[contains(@class,'btn-login-v1')]")).click();
		sleepInSecond(3);

		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='modal-login-v1'][1]//div[@class='row error-login-panel']")).getText(), "Tài khoản không tồn tại!");

		driver.findElement(By.xpath("//div[@id='modal-login-v1'][1]//button[@class='close']")).click();
		sleepInSecond(3);

		Assert.assertFalse(loginPopup.isDisplayed());

	}

	//@Test
	public void TC_02_Fixed_In_Dom_Kyna() {
		driver.get("https://kyna.vn/");

		WebElement loginPopup = driver.findElement(By.cssSelector("div#k-popup-account-login"));

		Assert.assertFalse(loginPopup.isDisplayed());

		driver.findElement(By.cssSelector("a.login-btn")).click();
		sleepInSecond(3);
		
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.alertIsPresent());
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//		
		Assert.assertTrue(loginPopup.isDisplayed());

		driver.findElement(By.cssSelector("input#user-login")).sendKeys("haunguyen@gmail.com");
		driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");
		driver.findElement(By.cssSelector("button#btn-submit-login")).click();
		sleepInSecond(3);


	

		Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(),
				"Sai tên đăng nhập hoặc mật khẩu");

		driver.findElement(By.cssSelector("button.k-popup-account-close")).click();
		sleepInSecond(3);

		Assert.assertFalse(loginPopup.isDisplayed());

	}

	private void sleepInSecond(int i) {
		// TODO Auto-generated method stub

	}

	// @Test
	public void TC_04_Radom_InDom_Kmplayer() {
		driver.get("https://www.kmplayer.com/home");

		WebElement popupLayer = driver.findElement(By.cssSelector("div.pop-layer"));

		if (popupLayer.isDisplayed()) {

			jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("area#btn-r")));
			sleepInSecond(5);
		}

		driver.findElement(By.cssSelector("p.donate-coffee")).click();
		sleepInSecond(5);

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.buymeacoffee.com/kmplayer?ref=hp&kind=top");

	}

	 @Test
	public void TC_05_Random_Not_Indom_Dehieu() {

		driver.get("https://dehieu.vn/");

		List<WebElement> contentPopup = driver.findElements(By.cssSelector("div.popup-content"));

		if (contentPopup.size() > 0 && contentPopup.get(0).isDisplayed()) {
			driver.findElement(By.id("popup-name")).sendKeys("haunguyen");
			driver.findElement(By.id("popup-email")).sendKeys("haunguyen@gmail.com");
			driver.findElement(By.id("popup-phone")).sendKeys("0987654321");

			driver.findElement(By.cssSelector("button#close-popup"));
			sleepInSecond(3);
		}

		driver.findElement(By.xpath("//a[text()='Tất cả khóa học']")).click();
		sleepInSecond(3);

		Assert.assertEquals(driver.getCurrentUrl(), "https://dehieu.vn/khoa-hoc");

	}

	// @AfterClass
	public void afterClass() {
		driver.quit();
	}

}
