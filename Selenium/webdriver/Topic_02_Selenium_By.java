package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_By {
	// B1: Mở browser lên 
	// B2: Nhập vào Url
	// B3: Click vào my acoount để mở trang login ra
	// B4: Click login
	// B5: Virify lỗi hiển thị
	// B6: Đóng Browser
	
// Khai báo 1 biến để đjai diện cho thư viện Selenium Webdriver
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		// B1: Mở Browser lên
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		// Bấm cho maximize browser lên
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_() {
		// B2: Nhập vào Url
		driver.get("https://account.magento.com/customer/account/login");
		
		//B3: Cleck vào Myaccount để mở trang login ra
		
		//HTML của Element ( Email Textbox)
//		<input name="login[username]" value="" autocomplete="off"
//		id="email" type="email" class="input-text spectrum-Textfield spectrum-Textfield-input is-keyboardFocused mage-error" 
//		title="Email" data-validate="{required:true, 'validate-email':true}" 
//		aria-required="true" aria-invalid="true" aria-describedby="email-error">
		
		//Xpath
		//tagname[@attribute-name='attribute-value']
		
		//input[@name='login[username]']*
		//input[@id='email']*
		//input[@class='input-text spectrum-Textfield spectrum-Textfield-input is-keyboardFocused mage-error']*
		//input[@title='Email']*
		//input[@aria-invalid='true']*
		//input[@aria-describedby='email-error']*
		
		//CSS Format:  tagname[attribute-name='attribute-value']
		
		// ID
		driver.findElement(By.id("email"));
		
		//Class
		//Cách gõ code ít bị lỗi:
		// Không được dư ký tự: ()
		// Thiếu ký tự: ;
		// Ctrl Space
		
		//CLass - Login
		// 1 - Giá trị ko có khoảng trắng -> Lấy hết 
		// 2 - Giá trị có khoảng trắng -> Lấy 1 phần 
		driver.findElement(By.className("login-form__bottom"));
		
		//Name - Email Textbox
		driver.findElement(By.name("login[username]"));
		
		//Tagname - Tìm xem có bn element trên màn hình
		driver.findElement(By.tagName("a"));
		
		//LikText - Text tuyệt đối
		//driver.findElement(By.linkText("Sign in"));
		
		//Partial Linktext - Text tuowng đối/ tuyệt đối
		//driver.findElement(By.partialLinkText("Sign in"));
		//driver.findElement(By.partialLinkText("in"));
		//driver.findElement(By.partialLinkText("Sign"));
	
		
		//Css - cover được hết cả 6 loại trên
		driver.findElement(By.cssSelector("input[name='login[username]']"));
		driver.findElement(By.cssSelector("input[id='email']"));
		driver.findElement(By.cssSelector("input[title='Email']"));
		
		//Xpath
		driver.findElement(By.xpath("//input[@name='login[username]']"));
		driver.findElement(By.xpath("//input[@id='email']"));
		driver.findElement(By.xpath("//input[@title='Email']"));
		
			}
	//@Test
	//public void TC_02_ValidatePageTitle() {
		
	//}
	//@Test
	//public void TC_03_LoginFormDisplayed() {
		// Login form displayed
		//Assert.assertTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
	//}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
