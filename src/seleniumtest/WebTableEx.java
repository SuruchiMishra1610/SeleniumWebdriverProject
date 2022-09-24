package seleniumtest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		
		List<WebElement> Rows = driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr"));
		System.out.println("Total numbers of rows are :" + Rows.size());
		
		List<WebElement> Column = driver.findElements(By.xpath("//table[@class='ws-table-all']//th"));
		System.out.println("Total number of Column are : " + Column.size());
		
		WebElement Data = driver.findElement(By.xpath("//table[@class='ws-table-all']//tr[4]/td[1]"));
		System.out.println("3rd row and 1st column value is : " + Data.getText());
		
	//	for(WebElement row: Rows) {
	//		List<WebElement> AllCell = row.findElements(By.tagName("td"));
//			for(WebElement cell : AllCell) {
//				System.out.print(cell.getText() + "\t");
//			}
//			System.out.println();
//		}
		
		for(int row=1; row<=Rows.size(); row++) {
			for(int col=1; col<=Column.size(); col++) {
				WebElement cell = driver.findElement(By.xpath("//table[@class='ws-table-all']//tr[" + row +"]/*[" + col +"]"));
				System.out.print(cell.getText() + "\t");
			}
				System.out.println();
		}
		
		String Company = "Island Trading";
		
		String Xpath = "//td[text()='" + Company + "']/following-sibling::td[2]";
		WebElement Country = driver.findElement(By.xpath(Xpath));
		System.out.println("The Country is : " + Country.getText());
		
	}

}
