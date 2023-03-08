package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Custom_Dropdown {

	WebDriver driver;
	WebDriverWait explicitWait;
	
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Honda() {
		
		driver.get("https://www.honda.com.vn/o-to/du-toan-chi-phi");
		
		selectItemInCustomDropdown("button#selectize-input", "button#selectize-input+div>a", "ACCORD Ghi Bạc/Đen");
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("button#selectize-input")).getText(), "ACCORD Ghi Bạc/Đen");
		
	}
	

	private void selectItemInCustomDropdown(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		
	}

	//@Test
	public void TC_02_React() {
		
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		
		selectItemInCustomDropdown1("div.dropdown", "div.menu span.text", "Jenny Hess");
		sleepInSecond(5);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Jenny Hess");
		
		

	}

	private void sleepInSecond(int i) {
		// TODO Auto-generated method stub
	}

	@AfterClass
	public void afterClass() {
	driver.quit();
	}

	public void selectItemInCustomDropdown1(String parentLocator, String childLocator, String textExpectedItem) {
		
		driver.findElement(By.cssSelector(parentLocator)).click();
		
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		
		List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));
		
		for (WebElement item : allItems) {
			String textActualItem = item.getText();
			if (textActualItem.equals(textExpectedItem)) {
				item.click();
				break;
				
			}
		}
	}
	
	public void enterItemInCustomDropdown1(String parentLocator, String childLocator, String textExpectedItem) {
		
		driver.findElement(By.cssSelector(parentLocator)).clear();
		driver.findElement(By.cssSelector(parentLocator)).sendKeys(textExpectedItem);
		sleepInSecond(1);
		
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		
		List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));
	
		for (WebElement item : allItems) {
			
			String textActualItem = item.getText();
			
			if (textActualItem.equals(textExpectedItem)) {
				item.click();
				break;
				
			}
		}
	}
	}


