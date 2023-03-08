package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Textbox_Textarea {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, employeeID, editFirstName, editLastName;
	String immigrationNumber, comments;
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		firstName = "A";
		lastName = "B";
		editFirstName = "C";
		editLastName = "D";
		immigrationNumber = "257908806";
		comments = "97 Glenburnie Rd\nRichmond\nVA 23226, USA";
		
		
		
	}

	@Test
	public void TC_01_TextBox_TextArea() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		//Nhập vào Username& Password
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("admin123");
		
		//Click Login button
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		sleepInsecond(5);
		
		//Mở màn hình Add Employee
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");
		
		//Nhập dữ liệu vào màn hình Add Employee
		driver.findElement(By.cssSelector("input#firstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("input#lastName")).sendKeys(lastName);
		
		// Lưu giá trị Employee ID vào biến 
		// Lấy ra giá trị + gán vào biến 
		// Phép gán giá trị = 
		employeeID = driver.findElement(By.cssSelector("input#employeeId")).getAttribute("value");
		
		//click Save button
		driver.findElement(By.cssSelector("input#btnSave")).click();
		
		//Verify the fields are disable
		Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).isEnabled());
		Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).isEnabled());
		Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmployeeId")).isEnabled());
		
		
		//Verify actual valuethe same expected value		
		Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).getAttribute("value"),firstName);
		Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).getAttribute("value"),lastName);
		Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmployeeId")).getAttribute("value"),employeeID);
		
		
		// click Save Button
		driver.findElement(By.cssSelector("input#btnSave")).click();
		sleepInsecond(5);
		
		//Verify the fields are enable
		Assert.assertTrue(driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).isEnabled());
		Assert.assertTrue(driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).isEnabled());
		Assert.assertTrue(driver.findElement(By.cssSelector("input#personal_txtEmployeeId")).isEnabled());
		
		//Edit the field: Firstname/ Lastname
		driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).clear();
		driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).sendKeys(editFirstName);
		driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).clear();
		driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).sendKeys(editLastName);
		
		// click Save Button
		driver.findElement(By.cssSelector("input#btnSave")).click();
		sleepInsecond(5);
		
		//Verify the fields are disable
		Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).isEnabled());
		Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).isEnabled());
		Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmployeeId")).isEnabled());
		
		//Verify actual valuethe same expected value
		
		Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).getAttribute("value"), editFirstName);
		Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).getAttribute("value"), editLastName);
		Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmployeeId")).getAttribute("value"), employeeID);
		
		//Open Immgration tab
		driver.findElement(By.xpath("//a[text()='Immigration']")).click();
		
		//click add button
		driver.findElement(By.cssSelector("input#btnAdd")).click();
		
		
		//Enter to Immigration Number and Comments textarea
		driver.findElement(By.cssSelector("input#immigration_number")).sendKeys(immigrationNumber);
		driver.findElement(By.cssSelector("textarea#immigration_comments")).sendKeys(comments);
		sleepInsecond(5);
		
		//click add button save
		driver.findElement(By.cssSelector("input#btnSave")).click();
		sleepInsecond(5);
		
		//click to Passport link
		driver.findElement(By.xpath("//a[text()='Passport']")).click();
		
		//Verify actual valuethe same expected value
		Assert.assertEquals(driver.findElement(By.cssSelector("input#immigration_number")).getAttribute("value"), immigrationNumber);
		Assert.assertEquals(driver.findElement(By.cssSelector("textarea#immigration_comments")).getAttribute("value"), comments);
	}

	//@Test
	public void TC_02_() {
		

	}

	
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
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
