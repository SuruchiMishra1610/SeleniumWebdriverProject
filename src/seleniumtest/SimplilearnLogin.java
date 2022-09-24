package seleniumtest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimplilearnLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com");
		System.out.println("Launched Browser successfully");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		// Step1 Click on login link
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();
		
		WebElement UserName = driver.findElement(By.className("email"));
		UserName.sendKeys("Xyz@abc.com");
		
		WebElement UserPass = driver.findElement(By.id("password"));
		UserPass.sendKeys("Test@1234");
		
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		LoginBtn.click();
		
		WebElement Errormsg = driver.findElement(By.id("msg_box"));
		String ActError = Errormsg.getText();
		String ExpError = "The email or password you have entered is invalid.";
		
		if (ActError.equals(ExpError)) {
			
			System.out.println("TC Pasesd");
		}else {
			System.out.println("TC Failed");
		}
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("Total Number of Links : " + Links.size());
		for(int i = 0; i < Links.size(); i++) {
			
			System.out.println(Links.get(i).getAttribute("href"));
		}
		driver.close();
		
	}

}
