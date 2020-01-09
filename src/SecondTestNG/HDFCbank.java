package SecondTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class HDFCbank {
	public WebDriver driver;
	public String url="https://www.hdfcbank.com/";
	
	@BeforeTest
	public void OpenApplication() {
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chrome driver\\chromedriver.exe");
		driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get(url);
	}
	@Test
	public void OpenWindow() {
		driver.switchTo().alert();
		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/div[1]/ul/li[8]/a")).click();
	
  }
	@AfterTest
	public void CloseApplication() {
		 driver.close();
		  driver.quit();
	}
}
