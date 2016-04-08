package fundacion.jala;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateResource {
	private WebDriver driver;
	private String baseUrl;
	private WebElement resourceCreated;
	@BeforeTest
	public void setUp() throws Exception {
		String username = "Maria";
		String password = "Control123";
	    driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	    baseUrl = "https://172.20.208.89:4040/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl + "/admin/#/login");
	    driver.findElement(By.id("loginUsername")).clear();
	    driver.findElement(By.id("loginUsername")).sendKeys(username);
	    driver.findElement(By.id("loginPassword")).clear();
	    driver.findElement(By.id("loginPassword")).sendKeys(password);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	  }
	@AfterTest
	 public void tearDown() throws Exception {
	    resourceCreated.findElement(By.xpath("div[1]")).click();
		driver.findElement(By.id("btnRemove")).click();
		driver.findElement(By.cssSelector("button.info")).click();
	    driver.quit();
	}
	@Test
	public void testResource() throws Exception {
		String nameResource = "computerxxx";
		String actualResult ="";
	    driver.findElement(By.linkText("Resources")).click();
	    driver.findElement(By.xpath("//button/span[contains(text(), 'Add')]")).click();
    	driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(nameResource);
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(nameResource);
        driver.findElement(By.cssSelector("button.info")).click();
        (new WebDriverWait(driver, 10))
        .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Email Servers")));
        driver.findElement(By.linkText("Email Servers")).click();
        driver.findElement(By.linkText("Resources")).click();
        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='resourcesGrid']/div[2]/div[@class='ngCanvas']/div"));
        for (WebElement row : rows) {
        	if(row.findElement(By.xpath("div[3]")).getText().trim().equalsIgnoreCase(nameResource)){
        		actualResult = row.findElement(By.xpath("div[3]")).getText().trim();
        		resourceCreated = row;	
        	}
		}    
        Assert.assertEquals(nameResource, actualResult);
	}
}
