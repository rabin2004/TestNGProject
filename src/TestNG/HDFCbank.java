package TestNG;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class HDFCbank {
	public WebDriver driver;
	public String url="https://www.hdfcbank.com/";
	
	@BeforeTest
	public void OpenApplication() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chrome driver\\chromedriver.exe");
		driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get(url);
		  Thread.sleep(8000);
	}
	@Test
	public void OpenWindow() throws InterruptedException {
		
		 driver.findElement(By.xpath("//*[@id=\"parentdiv\"]/img")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("Important Messages")).click();
		 Set<String> Handles=driver.getWindowHandles();
		 String HandlesID=driver.getTitle();
		 System.out.println("window Handles ID: "+HandlesID);
		 System.out.println("Number of windows: "+Handles.size());
		// String window1=(String) Handles.toArray()[1];
		// driver.switchTo().window(window1);
		 driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/ul/li[1]/a")).click(); 
  }
	
	@AfterTest (enabled=false)
	public void CloseApplication() {
		 driver.close();
		 driver.quit();
	}
}
