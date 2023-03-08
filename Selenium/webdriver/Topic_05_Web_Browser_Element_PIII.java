package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser_Element_PIII {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	//@Test
	public void TC_01_Is_Displayed() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Email textbox
		WebElement emailTextbox = driver.findElement(By.cssSelector("input#email"));
		
		if (emailTextbox.isDisplayed()) {
			emailTextbox.sendKeys("Automation Testing Textbox");
			System.out.println("Email textbox is displayed");
		} else {
			System.out.println("Email textbox is not displayed");
		}
		
		// Age under 18 Radio Button
		WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
		
		if (ageUnder18Radio.isDisplayed()) {
			ageUnder18Radio.click();
			System.out.println("Age Under 18 Radio is displayed");
		} else {
			System.out.println("Age Under 18 Radio is not displayed");
		}
		
		// Education TextArea
		WebElement educationTextarea = driver.findElement(By.cssSelector("textarea#edu"));
		
		if (educationTextarea.isDisplayed()) {
			educationTextarea.sendKeys("Automation Testing Textarea");
			System.out.println("Education Textarea is displayed");
		} else {
			System.out.println("Education Textarea is not displayed");
		}
		
		//Image 5 (Undisplayed)
		WebElement image5 = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
		
		if (image5.isDisplayed()) {
			System.out.println("Image5 is displayed");
		} else {
			System.out.println("Image5 is not displayed");
		}
	}


	//@Test
	public void TC_02_Is_Enabled() {
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Email Textbox
		WebElement emailTextbox = driver.findElement(By.cssSelector("input#email"));
		if (emailTextbox.isEnabled()) {
			System.out.println("Email Textbox is enabled");
		} else {
			System.out.println("Email Textbox is disabled");
		}
		
		//Password Textbox
		WebElement passwordTextbox = driver.findElement(By.cssSelector("input#disable_password"));
		if (passwordTextbox.isEnabled()) {
			System.out.println("Password Textbox is enabled");
	 	} else {
			System.out.println("Password Textbox is disabled");
		}

	}
	
	//@Test
	public void TC_03_Is_Selected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		// age under 18 radio
		WebElement AgeUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
		AgeUnder18Radio.click();
		
		if (AgeUnder18Radio.isSelected()) {
			System.out.println("Age Under 18 Radio is selected");
		} else {
			System.out.println("Age Under 18 Radio is de-selected");
		}
		
		//Java checkbox
		WebElement Javacheckbox = driver.findElement(By.cssSelector("input#java"));
		Javacheckbox.click();
		
		if (Javacheckbox.isSelected()) {
			System.out.println("Java checkbox is selected");
		} else {
			System.out.println("Java checkbox is de-selected");
		}
	}

	@Test
	public void TC_04_MailChimp() {
		driver.get("https://login.mailchimp.com/signup/");
		
		//Email/Username/Textbox
		driver.findElement(By.cssSelector("input#email")).sendKeys("haunguyen@gmail.com");
		sleepInsecond(3);
		
		WebElement passwordTextbox = driver.findElement(By.cssSelector("input#new_password"));
		
		//check lowercase ( viết thường )
		passwordTextbox.sendKeys("aa");
		sleepInsecond(2);
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
	
		//check upercase ( viết hoa )
		passwordTextbox.clear();
		passwordTextbox.sendKeys("AA");
		sleepInsecond(2);
				
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		//check number
		passwordTextbox.clear();
		passwordTextbox.sendKeys("123");
		sleepInsecond(2);
						
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		//check special character
		passwordTextbox.clear();
		passwordTextbox.sendKeys("!@#$");
		sleepInsecond(2);
						
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		//check 8 characters
		passwordTextbox.clear();
		passwordTextbox.sendKeys("abcABC@@");
		sleepInsecond(2);
						
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		
	}	
	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

		//sleep cứng 
	      public void sleepInsecond(long timeInSecond) {
	    	  try {
	    		  Thread.sleep(timeInSecond * 1000);
	    	  } catch (InterruptedException e) {
	    		  e.printStackTrace();
	    	  }
	      }
}
