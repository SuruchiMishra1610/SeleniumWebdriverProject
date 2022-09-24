package seleniumtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		WebElement SignUp = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		SignUp.click();
		
		WebElement FName = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement LName = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement Mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement Password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		
		
		FName.sendKeys("Tom");
		LName.sendKeys("timbak");
		Mobile.sendKeys("123456789");
		Password.sendKeys("timbaklll");
		
		WebElement Month = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select ddMonth = new Select(Month);
		ddMonth.selectByVisibleText("Oct");
		
		System.out.println("Selected Month is : " + ddMonth.getFirstSelectedOption().getText());
		
		WebElement Day = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select ddDay = new Select(Day);
		ddDay.selectByVisibleText("16");
		
		WebElement Year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select ddYear = new Select(Year);
		ddYear.selectByVisibleText("1992");
	
		
		List<WebElement> Months = ddMonth.getOptions();
		for(WebElement elm: Months) {
			System.out.println(elm.getText());
			
			List<WebElement> AllMonths = driver.findElements(By.xpath("select[@name='birthday_month']/option']"));
			for(WebElement elms: AllMonths) {
				System.out.println(elms.getText());
				
				String Gender = "Female";
				//WebElement Female = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
				//WebElement Male = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
				//WebElement Other = Male = driver.findElement(By.xpath("//input[@type='radio' and @value='-1']"));
				
				//if(Gender.equals("Female")) {
				//Female.click();
			//}else if (Gender.equals("Male")){
				//Male.click();
			//}else {
				//Other.click();
			//}
				
		WebElement GenderRadiobtn = driver.findElement(By.xpath("//label[text()= '" + Gender + "']//following-sibling::input"));
		GenderRadiobtn.click();
			}
		}
		
	}

}
