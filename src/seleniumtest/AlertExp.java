package seleniumtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.crome.driver","chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement Button1 = driver.findElement(By.id("alertButton"));
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("arguments[0].scrollIntoView();", Button1);
		Button1.click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		//alert.dismiss();		
		
		WebElement Button3 = driver.findElement(By.id("confirmButton"));
		obj.executeScript("arguments[0].scrollIntoView();", Button3);
		Button3.click();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		
		WebElement Button4 = driver.findElement(By.id("promtButton"));
		obj.executeScript("arguments[0].scrollIntoView();", Button4);
		Button4.click();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		alert.sendKeys("Hello");
		alert.accept();
		driver.close();
	}

}
