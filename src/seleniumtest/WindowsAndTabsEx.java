package seleniumtest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsAndTabsEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.crome.driver","chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		String ParentWindow = driver.getWindowHandle();
		System.out.println("Before clicking the tab window is : " + ParentWindow);
		
		WebElement Tab = driver.findElement(By.id("tabButton"));
		Tab.click();
		
		System.out.println("After clicking the tab");
		Set<String> allwins = driver.getWindowHandles();
		
		for(String win : allwins) {
			
			System.out.println(win);
			if(!win.equals(ParentWindow)) {
				driver.switchTo().window(win);
			}
		}
			WebElement childheader = driver.findElement(By.id("sampleHeading"));
			System.out.println(childheader.getText());
			
		
			driver.switchTo().window(ParentWindow);
			WebElement WinBtn = driver.findElement(By.id("windowButton"));
			System.out.println("******* TC Window Button Executed ********");
			WinBtn.click();
			driver.quit();
		
	}

}
