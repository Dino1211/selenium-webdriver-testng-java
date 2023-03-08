package webdriver;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_19_Upload_Senkey {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	JavascriptExecutor jsExecutor;
	
	
	//Image name 
	String vietnam = "Viet Nam.jpg";
	String thailan = "Thai Lan.jpg";
	String lao = "Lao.jpg";
	
	// Upload file folder 
	String uploadFilefolderPath = projectPath + File.separator + "uploadFiles" + File.separator;
	
	// Image path 
	String vietnamFilePath = uploadFilefolderPath + vietnam;
	String thailanFilePath = uploadFilefolderPath + thailan;
	String laoFilePath = uploadFilefolderPath + lao;
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	//@Test
	public void TC_01_Upload_One_File_Per_time() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		By uploadFile = By.cssSelector("input[type='file']");
		
		//Load File lên
		driver.findElement(uploadFile).sendKeys(vietnamFilePath);
		driver.findElement(uploadFile).sendKeys(thailanFilePath);
		driver.findElement(uploadFile).sendKeys(laoFilePath);
		
		//Verify upload lên thành công
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + vietnam +"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + thailan +"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + lao +"']")).isDisplayed());
		
		//Thực hiện Upload
		
		List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));
		
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
			
		}
		
		//Verify image upload lên thành công
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + vietnam +"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + thailan +"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + lao +"']")).isDisplayed());
		
	}

	private void sleepInSecond(int i) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void TC_02_Upload_Multipile_File_Per_time() {
driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		By uploadFile = By.cssSelector("input[type='file']");
		
		//Load File lên
		driver.findElement(uploadFile).sendKeys(vietnamFilePath + "\n" + thailanFilePath + "\n" + laoFilePath);
		
		
		//Verify upload lên thành công
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + vietnam +"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + thailan +"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + lao +"']")).isDisplayed());
		
		//Thực hiện Upload
		
		List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));
		
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
			
		}
		
		//Verify image upload lên thành công
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + vietnam +"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + thailan +"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + lao +"']")).isDisplayed());
		

	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
