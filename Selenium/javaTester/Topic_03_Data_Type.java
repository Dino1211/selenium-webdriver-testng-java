package javaTester;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_03_Data_Type {

	public static void main(String[] args) {
		
		// Cách khai báo 1 biến 
		// 1 - kiểu dữ liệu của biến
		// 2 - tên biến
		// 3 - giá trị của biến
		
		// 2 cách khai báo và gán giá trị
		// 1 - Vừa khai báo vừa gán trực tiếp luôn
		// String name = "Automation Testing";
		
		// 2 - Khai báo trước rồi gán sau
		// String name;
		// name = " Automation Testing ";
		
		
		
		// 2 loại kiểu dữ liệu 
		
		// I - Kiểu dữ liệu nguyên thủy
		// 8 loại
		// Số nguyên : byte/short/int/lonh
		
		
		// Số thực : float/double
		
		// Kí tự : char
		
		// Logic: boolean
		
		
		// Kiểu dữ liệu tham chiếu
		// chuỗi: String
		
		// class/ Interface
		Date date = new Date();
		
		WebDriver driver = new FirefoxDriver();
		
		
		
		// Đối tượng: Object
		
		// Array( Mảng)
		
		//List/Set/Queue

	}

}
