package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_18_Javascript_Executor {

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
	public void TC_01_TechPanda() {
		//********************************
		navigateToUrlByJS("http://live.techpanda.org/");
		sleepInSecond(5);
		
		String techPandaDomain = (String) executeForBrowser("return document.domain");
		Assert.assertEquals(techPandaDomain, "live.techpanda.org");
		
		String homePageUrl = (String) executeForBrowser("return document.URL");
		Assert.assertEquals(techPandaDomain, "http://live.techpanda.org/");
		
		//********************************
		hightlightElement("//a[text()='Mobile']");
		clickToElementByJS("//a[text()='Mobile']");
		sleepInSecond(3);
		
		hightlightElement("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']");
		clickToElementByJS("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']");
		sleepInSecond(3);
		
		Assert.assertTrue(areExpectedTextInInnerText("Samsung Galaxy was added to your shopping cart."));
		
		//******************************
		hightlightElement("//a[text()='Customer Service']");
		clickToElementByJS("//a[text()='Customer Service']");
		sleepInSecond(3);
		
		//********************************
		hightlightElement("//input[@id='newsletter']");
		clickToElementByJS("//input[@id='newsletter']");
		sleepInSecond(3);
		
		String emailAddress = "afc" + generateRandomNumber() + "@hotmail.vn";
		sendkeyToElementByJS("//input[@id='newsletter']", emailAddress);
		
		//*****************************
		hightlightElement("//button[@title='Subscribe']");
		clickToElementByJS("//button[@title='Subscribe']");
		sleepInSecond(3);
		
		Assert.assertTrue(areExpectedTextInInnerText("Thank you for your subscription."));
		
		//*************************************
		navigateToUrlByJS("https://demo.guru99.com/v4/");
		sleepInSecond(5);
		
		String guru99Domain = (String) executeForBrowser("return document.domain");
		Assert.assertEquals(guru99Domain, "demo.guru99.com");
		
		
	}

	private String generateRandomNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void TC_02_() {
		navigateToUrlByJS("http://live.techpanda.org/");
		sleepInSecond(5);
		
		hightlightElement("//a[@title='My Account']//ancestor::div[@id='header-account']//following-sibling::li[@class='first']");
		clickToElementByJS("//a[@title='My Account']//ancestor::div[@id='header-account']//following-sibling::li[@class='first']");
		sleepInSecond(3);
		
		hightlightElement("//a[@title='Create an Account']");
		clickToElementByJS("//a[@title='Create an Account']");
		sleepInSecond(3);
		
		String firstName = "nguyen";
		sendkeyToElementByJS("//input[@id='firstname']", firstName);
		
		String middleName = "dinh";
		sendkeyToElementByJS("//input[@id='middlename']", middleName);
		
		String lastName = "hau";
		sendkeyToElementByJS("//input[@id='lastname']", lastName);
		

		String emailAddress = "afc" + generateRandomNumber() + "@hotmail.vn";
		sendkeyToElementByJS("//input[@id='email_address']", emailAddress);
	
		String passWord = "123456";
		sendkeyToElementByJS("//input[@id='password']", passWord);
		
		String confirmPassWord = "123456";
		sendkeyToElementByJS("//input[@id='confirmation']", confirmPassWord);
		
		
		hightlightElement("//button[@title='Register']");
		clickToElementByJS("//button[@title='Register']");
		sleepInSecond(3);
		
		Assert.assertTrue(areExpectedTextInInnerText("Thank you for registering with Main Website Store."));
		
		
		

	}
	
	public Object executeForBrowser(String javaScript) {
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText() {
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage() {
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(String url) {
		JavascriptExecutor jsExecutor;
		JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
		
		jsExecutor1.executeScript("window.location = '" + url + "'");
	}

	public void hightlightElement(String locator) {
		WebElement element = getElement(locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		
		
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	private void sleepInSecond(int i) {
		// TODO Auto-generated method stub
		
	}

	public void clickToElementByJS(String locator) {
		jsExecutor.executeScript("arguments[0].click();", getElement(locator));
	}

	public void scrollToElementOnTop(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
	}

	public void scrollToElementOnDown(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
	}

	public void sendkeyToElementByJS(String locator, String value) {
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
	}

	public void removeAttributeInDOM(String locator, String attributeRemove) {
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
	}

	public String getElementValidationMessage(String locator) {
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
	}

	public boolean isImageLoaded(String locator) {
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getElement(locator));
		return status;
	}

	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}

	//@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
