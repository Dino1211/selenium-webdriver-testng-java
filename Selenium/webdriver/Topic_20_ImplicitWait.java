package webdriver;

import java.io.File;
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

public class Topic_20_ImplicitWait {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	JavascriptExecutor jsExecutor;
	
	//Image name 
	String vietnam = "Viet Nam.jpg";
	String thailan = "Thai Lan.jpg";
	
		
	// Upload file folder 
	String uploadFilefolderPath = projectPath + File.separator + "uploadFiles" + File.separator;
		
	// Image path 
	String vietnamFilePath = uploadFilefolderPath + vietnam;
	String thailanFilePath = uploadFilefolderPath + thailan;

	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

	}

	
	public void TC_01_Not_Enough_Time() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.get("https://automationfc.github.io/dynamic-loading/");
		
		driver.findElement(By.cssSelector("div#start>button")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
		
	}

	
	public void TC_02_Enough_Time() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://automationfc.github.io/dynamic-loading/");
		
		driver.findElement(By.cssSelector("div#start>button")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
		

	}
	

	public void TC_03_More_Time() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://automationfc.github.io/dynamic-loading/");
		
		driver.findElement(By.cssSelector("div#start>button")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
		

	}
	

	public void TC_04_Ajax_Loading() {
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx/");
		
		WebDriverWait explicitWait = new WebDriverWait(driver, 15);
		
		// Wait cho Date Picker được hiển thị 
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.RadCalendar")));
		
		// Verify  cho Selected Dates là k có ngày nào được chọn  
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "No Selected Dates to display.");
		
		//Wait cho ngày 10 được click 
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='10']")));
		
		// click vào ngày 10
		driver.findElement(By.xpath("//a[text()='10']")).click();
		
		//Wait cho ajax icon loading biến mất ( invisible)
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));
		
		//Wait cho ngày vừa được chọn được phép click trở lại 
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='rcSelected']/a[text()='10']")));
		
		//Verify cho Selected Date laf " Monday, October 10, 2022"
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "Monday, October 10, 2022");

	}
	
	@Test
	public void TC_05_Upload_File() {
		driver.get("https://gofile.io/?t=uploadFiles");
		
		WebDriverWait explicitWait = new WebDriverWait(driver, 15);
		
		//Wait cho Add file button được visible
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#rowUploadButton button.uploadButton")));
		
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(vietnamFilePath + "\n" + thailanFilePath);
		
		//Wait Loading icon của từng File biến mất 
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div#rowUploadProgress-list div.progress"))));
		
		//Wait cho Upload message sucessful
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Your files have been successfully uploaded']")));
		
		//Verify message này Displayed
		Assert.assertTrue(driver.findElement(By.xpath("//h5[text()='Your files have been successfully uploaded']")).isDisplayed());
		
		//Wait + click cho shopw files button được clickable
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#rowUploadSuccess-showFiles"))).click();
		
		//Wait + Verify: cho file name + button dowload hiển thị 
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + thailan + "']/parent::a/parent::div/following-sibling::div//button[@id='contentId-download']"))).isDisplayed());
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + vietnam + "']/parent::a/parent::div/following-sibling::div//button[@id='contentId-download']"))).isDisplayed());
		
		//Wait + Verify: cho file name + button play hiển thị 
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + thailan + "']/parent::a/parent::div/following-sibling::div//button[contains(@class,'contentPlay')]"))).isDisplayed());
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + vietnam + "']/parent::a/parent::div/following-sibling::div//button[contains(@class,'contentPlay')]"))).isDisplayed());
				
		
		
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
