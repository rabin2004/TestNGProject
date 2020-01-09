package TestNG;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.google.common.io.Files;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;
import org.openqa.selenium.TakesScreenshot;

public class SecondTest {
	public WebDriver driver;
	public String url="http://blazedemo.com/";
	
  @BeforeTest
  public void OpenApplication() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chrome driver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(url);
	  Thread.sleep(2000);
  }
  
  @Test (priority=0, groups= {"regression test"})
  public void FindFlights() throws InterruptedException, Exception{
	  Select drp1=new Select(driver.findElement(By.name("fromPort")));
	  drp1.selectByVisibleText("Boston");
	  Select drp2=new Select(driver.findElement(By.name("toPort")));
	  drp2.selectByVisibleText("New York");
	  driver.findElement(By.xpath("/html/body/div[3]/form/div/input")).click();
	  String expected="Flights from Boston to New York:";
	  String actual=driver.findElement(By.xpath("/html/body/div[2]/h3")).getText();
	  Assert.assertEquals(actual, expected);
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File source=ts.getScreenshotAs(OutputType.FILE);
	  Files.copy(source, new File("./screenshot/FindFlights.jpg"));
	  System.out.println("FindFlight Screenshot: "+source);
	  Thread.sleep(2000);
  }
  @Test (priority=1)
  public void SelectFlight( ) throws InterruptedException, Exception {
	  driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[4]/td[1]/input")).click();
	  String expected="Your flight from Boston to New York has been reserved.";
	  String actual=driver.findElement(By.xpath("/html/body/div[2]/h2")).getText();
	  Assert.assertEquals(actual, expected);
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File source=ts.getScreenshotAs(OutputType.FILE);
	  Files.copy(source, new File("./screenshot/SelectFlight.jpg"));
	  System.out.println("SelectFlight Screenshot: "+source);
	  Thread.sleep(2000);
  }

  @Test (priority=2, groups= {"smoketest"})
  public void PurchaseFlight() throws InterruptedException, Exception {
	  driver.findElement(By.name("inputName")).sendKeys("Jonny Sepherd");
	  driver.findElement(By.name("address")).sendKeys("254 54th street 9th");
	  driver.findElement(By.name("city")).sendKeys("NY");
	  driver.findElement(By.name("state")).sendKeys("NY");
	  driver.findElement(By.name("zipCode")).sendKeys("12345");
	  Select drp3=new Select(driver.findElement(By.name("cardType")));
	  drp3.selectByVisibleText("American Express");
	  driver.findElement(By.id("creditCardNumber")).sendKeys("1234-5678-9012-3456");
	  driver.findElement(By.id("creditCardMonth")).sendKeys("09");
	  driver.findElement(By.id("creditCardYear")).sendKeys("2021");
	  driver.findElement(By.id("nameOnCard")).sendKeys("Jonny Sepherd");
	  driver.findElement(By.id("rememberMe")).click();
	  driver.findElement(By.xpath("/html/body/div[2]/form/div[11]/div/input")).click();
	  String expected="Thank you for your purchase today!";
	  String actual=driver.findElement(By.xpath("/html/body/div[2]/div/h1")).getText();
	  Assert.assertTrue(actual.contains(expected));
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File source=ts.getScreenshotAs(OutputType.FILE);
	  Files.copy(source, new File("./screenshot/PurchaseFlight.jpg"));
	  Thread.sleep(2000);
	  String PurchaseConfirmation = driver.findElement(By.xpath("/html/body/div[2]/div/h1")).getText();
	  System.out.println("Purchase Confirmation: "+PurchaseConfirmation);
  }
  
  @AfterTest 
  public void CloseApplication(){
	  driver.close();
	  driver.quit();
  }
}



