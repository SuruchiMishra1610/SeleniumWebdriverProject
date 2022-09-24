package seleniumtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement FileUpload = driver.findElement(By.name("uploadfile_0"));
		FileUpload.sendKeys("/home/suruchimishra16/Desktop/file");
		
		WebElement TC = driver.findElement(By.id("terms"));
		TC.click();
		
		WebElement Submit = driver.findElement(By.id("submitbutton"));
		Submit.click();
		
		System.out.println("****** Uploaded File Successfully ********");
	
		
	}

}
