package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Frame_Iframe {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Iframe_Kyna() {
		//A
		driver.get("https://kyna.vn/");
		
		// A-> B
		driver.switchTo().frame(driver.findElement(By.cssSelector("div.fanpage iframe")));
		
		//B
		String facebookLikenumber = driver.findElement(By.xpath("//a[text()='Kyna.vn']/parent::div//following-sibling::div")).getText();
		Assert.assertEquals(facebookLikenumber,"166K likes");
		
		//B->A
		driver.switchTo().defaultContent();
		
		//A->C
		driver.switchTo().frame("cs_chat_iframe");
		
		//C
		driver.findElement(By.cssSelector("div.meshim_widget_Widget")).click();
		sleepInseCond(3);
		
		driver.findElement(By.cssSelector("input.input_name")).sendKeys("hau.nd");
		driver.findElement(By.cssSelector("input.input_phone")).sendKeys("0987654321");
		new Select(driver.findElement(By.cssSelector("select#serviceSelect"))).selectByVisibleText("HỖ TRỢ KỸ THUẬT");
		driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("Hi!");
		sleepInseCond(5);
		
		//C->A
		driver.switchTo().defaultContent();
		
		//A
		String keyword = "Excel";
	
		driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys(keyword);
		driver.findElement(By.cssSelector("button.search-button")).click();
		sleepInseCond(5);
		
		//Verify
		
		List<WebElement> courseNames = driver.findElements(By.cssSelector("div.k-box-card-wrap>a"));
		
		Assert.assertEquals(courseNames.size(), 10);
		
		for(WebElement course : courseNames) {
		
			System.out.println(course.getText());
			Assert.assertTrue(course.getText().contains(keyword));
			
		}
		
		
		
		
		
	}

	private void sleepInseCond(int i) {
		// TODO Auto-generated method stub
		
	}

	//@Test
	public void TC_02_() {
		

	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
