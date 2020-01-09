package TestNG;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TableIdentification {
	public WebDriver driver;
	public String url="https://www.w3schools.com/html/html_tables.asp";
	
@BeforeTest 
public void OpenApplication() {
	System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chrome driver\\chromedriver.exe");
	driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(url);
}

@Test (priority=0)
public void CheckTableRowsColumns() {
	WebElement Table=driver.findElement(By.id("customers"));
	List<WebElement> Rows=Table.findElements(By.tagName("tr"));
	System.out.println("Number of Rows: " +Rows.size());
	
	for (WebElement R:Rows) {
		List<WebElement> Column=R.findElements(By.tagName("td"));
		System.out.println("Number of Columns in each row: "+Column.size());
		List<WebElement> Cols=R.findElements(By.tagName("th"));
		System.out.println("Table Headings: "+Cols.size());
	}
}

@Test (priority=1)
public void TableData() {
	WebElement Table=driver.findElement(By.id("customers"));
	List<WebElement> Columns=Table.findElements(By.tagName("td"));
	System.out.println("Number of Columns: "+Columns.size());
	for (WebElement C:Columns) {
		System.out.println("Data in Cells: "+C.getText());
	}
}

@Test (priority=2)
public void DataSpecificCell4_2() {
	WebElement TableValue=driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[4]/td[2]"));
	System.out.println("Value in 4th row & 2nd column: "+TableValue.getText());
	String expected="Roland Mendel";
	String actual=driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[4]/td[2]")).getText();
	Assert.assertEquals(actual, expected);
}

@Test (priority=3)
public void DataSpecificCell7_3() {
	WebElement TableValue=driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[7]/td[3]"));
	System.out.println("Value in 7th row & 3rd column: "+TableValue.getText());
	String expected="Roland Mendel";
	String actual=driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[7]/td[3]")).getText();
	Assert.assertTrue(actual.contains(expected));
}

@AfterTest
public void CloseApplication() {
	driver.close();
	driver.quit();
}
}
