package SecondTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;
public class NewTest {
	public WebDriver driver;
	public String url="http://www.newtours.demoaut.com/";
 @BeforeTest
  public void firstOpenApplicaction() throws InterruptedException {
	 System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chrome driver\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get(url);
	 Thread.sleep(2000);
  }
 
 @Test (groups= {"smoketest"})
 public void firstTestVerifyFlightsLink() throws InterruptedException {
	 driver.findElement(By.linkText("Flights")).click();	 
	 String expected="Registered users can sign-in here to find the lowest fare on participating airlines.";
	 String actual=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[1]/td/font")).getText();
	 Assert.assertEquals(actual, expected);
	 Thread.sleep(2000);
 }
 
 @Test (priority=2)
 public void SignInWithValidUserIDPassword() throws InterruptedException {
	 driver.findElement(By.name("userName")).sendKeys("JonnySepherd@gmail.com");
	 driver.findElement(By.name("password")).sendKeys("J@S12345");
	 driver.findElement(By.name("login")).click();
	 String expected="Use our Flight Finder to search for the lowest fare on participating airlines. Once you've booked your flight, don't forget to visit the Mercury Tours Hotel Finder to reserve lodging in your destination city.";
	 String actual=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td")).getText();
	 Assert.assertTrue(actual.contains(expected));
	 Thread.sleep(2000);
 }
 
 @Test (priority=3)
public void ProvideFlightDetails() throws InterruptedException {
	 driver.findElement(By.xpath("//input[@value='roundtrip']")).click();
	 Select drp1=new Select(driver.findElement(By.name("passCount")));
	 drp1.selectByVisibleText("2");
	 Select drp2=new Select(driver.findElement(By.name("fromPort")));
	 drp2.selectByVisibleText("New York");
	 Select drp3=new Select(driver.findElement(By.name("fromMonth")));
	 drp3.selectByVisibleText("February");
	 Select drp4=new Select(driver.findElement(By.name("fromDay")));
	 drp4.selectByVisibleText("4");
	 Select drp5=new Select(driver.findElement(By.name("toPort")));
	 drp5.selectByVisibleText("London");
	 Select drp6=new Select(driver.findElement(By.name("toMonth")));
	 drp6.selectByVisibleText("March");
	 Select drp7=new Select(driver.findElement(By.name("toDay")));
	 drp7.selectByVisibleText("4");
	 driver.findElement(By.xpath("//input[@value='First']")).click();
	 Select drp8=new Select(driver.findElement(By.name("airline")));
	 drp8.selectByVisibleText("Unified Airlines");
	 driver.findElement(By.name("findFlights")).click();
	 String expected="Select your departure and return flight from the selections below. Your total price will be higher than quoted if you elect to fly on a different airline for both legs of your travel.";
	 String actual=driver.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > font")).getText();
	 Assert.assertEquals(actual, expected);
	 Thread.sleep(2000);
 }
 
 @Test (priority=4)
 public void SelectFlight() throws InterruptedException{
	 driver.findElement(By.xpath("//input[@value='Unified Airlines$363$281$11:24']")).click();
	 driver.findElement(By.xpath("//input[@value='Unified Airlines$633$303$18:44']")).click();
	 driver.findElement(By.name("reserveFlights")).click();
	 String expected="Please review your travel itinerary and make your purchase.";
	 String actual=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font")).getText();
	 Assert.assertTrue(actual.contains(expected));
	 Thread.sleep(2000);
 }
 
 @Test (priority=5)
 public void BookAFlight() throws InterruptedException {
	 driver.findElement(By.name("passFirst0")).sendKeys("Jonny");
	 driver.findElement(By.name("passLast0")).sendKeys("Sepherd");
	 Select drp9=new Select(driver.findElement(By.name("pass.0.meal")));
	 drp9.selectByVisibleText("Hindu");
	 driver.findElement(By.name("passFirst1")).sendKeys("Annie");
	 driver.findElement(By.name("passLast1")).sendKeys("Sepherd");
	 Select drp10=new Select(driver.findElement(By.name("pass.1.meal")));
	 drp10.selectByVisibleText("Hindu");
	 Select drp11=new Select(driver.findElement(By.name("creditCard")));
	 drp11.selectByVisibleText("Visa");
	 driver.findElement(By.name("creditnumber")).sendKeys("1234-5678-9012-3456");
	 Select drp12=new Select(driver.findElement(By.name("cc_exp_dt_mn")));
	 drp12.selectByVisibleText("02");
	 Select drp13=new Select(driver.findElement(By.name("cc_exp_dt_yr")));
	 drp13.selectByVisibleText("2010");
	 driver.findElement(By.name("cc_frst_name")).sendKeys("Jonny");
	 driver.findElement(By.name("cc_last_name")).sendKeys("Sepherd");
	 driver.findElement(By.name("billAddress1")).sendKeys("254 54th Street");
	 driver.findElement(By.name("billAddress2")).sendKeys("9th floor");
	 driver.findElement(By.name("billCity")).sendKeys("NY");
	 driver.findElement(By.name("billState")).sendKeys("NY");
	 driver.findElement(By.name("billZip")).sendKeys("12345");
	 Select drp14=new Select(driver.findElement(By.name("billCountry")));
	 drp14.selectByVisibleText("UNITED STATES ");
	 driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input")).click();
	 driver.findElement(By.name("buyFlights")).click();
	String expected="Your itinerary has been booked!";
	String actual=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]")).getText();
	 Assert.assertEquals(actual, expected);
	 String Confirmation=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[1]/td/table/tbody/tr/td[1]/b/font/font/b/font[1]")).getText();
	 System.out.println("Flight Confirmation number: "+Confirmation);
	 Thread.sleep(2000);
 }
 
 @AfterTest 
 public void CloseApplication() {
	driver.close();
	driver.quit();
 }
}
