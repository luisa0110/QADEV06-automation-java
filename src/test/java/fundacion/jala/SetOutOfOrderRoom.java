package fundacion.jala;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetOutOfOrderRoom {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private Actions action;
	  @BeforeClass
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    String username = "Maria";
	    String password = "Control123";
	    driver.manage().window().maximize();
	    action = new Actions(driver);
	    baseUrl = "https://172.20.208.89:4040/";
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    driver.get(baseUrl + "/admin/#/login");
	    driver.findElement(By.id("loginUsername")).clear();
	    driver.findElement(By.id("loginUsername")).sendKeys(username);
	    driver.findElement(By.id("loginPassword")).click();
	    driver.findElement(By.id("loginPassword")).clear();
	    driver.findElement(By.id("loginPassword")).sendKeys(password);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	  }

	  @Test
	  public void testVerifyThatARoomIsConfiguredAsOutOfOrder() throws Exception {
	    driver.findElement(By.linkText("Conference Rooms")).click();
	   (new WebDriverWait(driver, 10))
	      .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.ng-scope.ngRow.even")));
	    WebElement element = driver.findElement(By.xpath("//div[@id='roomsGrid']/div[2]/div/div[4]/div[3]/div[2]/div/span[2]"));
	    action.doubleClick(element).doubleClick().build().perform();
	    element = driver.findElement(By.linkText("Out of Order Planning"));
	    action.doubleClick(element).doubleClick().build().perform();
	    action.doubleClick(element).doubleClick().build().perform();
	    
	    (new WebDriverWait(driver, 10))
	    .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Outof ")));
	    
	    driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("10");
	    driver.findElement(By.xpath("(//input[@type='text'])[5]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("30");
	    driver.findElement(By.xpath("(//input[@type='text'])[7]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys("10");
	    driver.findElement(By.xpath("(//input[@type='text'])[8]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("45");
	    driver.findElement(By.cssSelector("span.fa.fa-caret-down")).click();
	    driver.findElement(By.linkText("Closed for maintenance")).click();
	    driver.findElement(By.xpath("//textarea")).sendKeys("This room is out of order");
	    driver.findElement(By.cssSelector("button.info")).click();//);
	    driver.findElement(By.linkText("Resources")).click();
	    driver.findElement(By.linkText("Locations")).click();
	    //assertTrue(isElementPresent(By.xpath("//div[@id='roomsGrid']/div[2]/div/div[5]/div[2]/div[2]/out-of-order-icon/div/div/div/span")));
	  }

	  @AfterClass
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
}
