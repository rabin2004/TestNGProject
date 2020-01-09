package SecondTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ThirdTest {
	public WebDriver driver;
	public String url="https://www.bankrate.com/";

  @BeforeTest
  public void OpenApplication() {
	  System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chrome driver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(url);
  }
  
  @Test (priority=0)
  public void SavingsCalculator() throws InterruptedException {
	  Actions action=new Actions(driver);
	  WebElement Banking=driver.findElement(By.linkText("Banking"));
	  action.moveToElement(Banking).perform();
	  WebElement ClickSavingCalculator=driver.findElement(By.linkText("Savings calculator"));
	  action.moveToElement(ClickSavingCalculator).click().perform();
	  String expected="Simple Savings Calculator";
	  String actual=driver.findElement(By.xpath("//*[@id=\'csstyle\']/div[5]/div[1]/div/h1")).getText();
	  Assert.assertEquals(actual, expected);
	  Thread.sleep(2000);
  }

  @Test (priority=1)
  public void PersonalLoans() throws InterruptedException {
	  Actions action=new Actions(driver);
	  WebElement Loans=driver.findElement(By.linkText("Loans"));
	  action.moveToElement(Loans).perform();
	  WebElement PersonalLoan=driver.findElement(By.linkText("Personal loans"));
	  action.moveToElement(PersonalLoan).click().perform();
	  String expected="Personal loans can help you consolidate debt, renovate your home, pay for college and more. Calculate monthly payments and see the latest personal loan rates to find the option that’s right for you.";
	  String actual=driver.findElement(By.xpath("//*[@id=\'csstyle\']/div[5]/section[1]/div[2]/div/div/p")).getText();
	  Assert.assertEquals(actual, expected);
	  Thread.sleep(2000);
  }
  
  @Test (priority=2)
	  public void BankRate() throws InterruptedException {
	  Actions action=new Actions(driver);
	  WebElement BankRate=driver.findElement(By.xpath("//*[@id=\'csstyle\']/div[3]/header/a"));
	  action.moveToElement(BankRate).click().perform();
	  String expected="We help you find and compare rates";
	  String actual=driver.findElement(By.xpath("//*[@id=\'csstyle\']/section[1]/div[8]/h2")).getText();
	  Assert.assertEquals(actual, expected);
	  Thread.sleep(2000);
  }
  
  @Test (groups= {"smoketest"})
  public void SignInTab() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\'authenticatedAppMenu\']/li[2]/a")).click();
	  driver.findElement(By.id("email")).sendKeys("John000@gmail.com");
	  driver.findElement(By.id("password")).sendKeys("John@123456789");
	  driver.findElement(By.id("sign-in-button")).click();
	  String expected="To personalize your dashboard, tell us your financial goal";
	  String actual=driver.findElement(By.xpath("//*[@id=\'bae\']")).getText();
	  Assert.assertEquals(actual, expected);
	  Thread.sleep(2000); 
  }
  
  @AfterTest
  public void CloseApplication() {
	  driver.close();
	  driver.quit();
  }
}