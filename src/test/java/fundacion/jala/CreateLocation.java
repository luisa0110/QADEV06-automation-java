package fundacion.jala;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateLocation {
	private WebDriver driver;
	private String baseUrl;
	private WebElement locationCreated;
	@BeforeClass
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    String username = "Maria";
	    String password = "Control123";
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
	@AfterClass
	public void tearDown() throws Exception {
		locationCreated.findElement(By.xpath("div[1]")).click();
	    driver.findElement(By.xpath("//button[2]")).click();
	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	    driver.quit();
	}
	@Test
	public void testVerifyThatALocationIsCreated() throws Exception {
		String locationName = "Foundation";
	    String actualResult = "";
	    driver.findElement(By.linkText("Locations")).click();
	    driver.findElement(By.xpath("//div[4]/div/button")).click();
	    driver.findElement(By.id("location-add-name")).clear();
	    driver.findElement(By.id("location-add-name")).sendKeys(locationName);
	    driver.findElement(By.id("location-add-display-name")).clear();
	    driver.findElement(By.id("location-add-display-name")).sendKeys(locationName);
	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	    driver.findElement(By.linkText("Email Servers")).click();
	    driver.findElement(By.linkText("Locations")).click();
	    List<WebElement> rows = driver.findElements(By.xpath("//div[@id='locationGrid']/div[2]/div[@class='ngCanvas']/div"));
        for (WebElement row : rows) {
        	if(row.findElement(By.xpath("div[3]")).getText().trim().equalsIgnoreCase(locationName)){
        		actualResult = row.findElement(By.xpath("div[3]")).getText().trim();
        		locationCreated = row;	
        	}
		}     
        Assert.assertEquals(actualResult, locationName);
	 }
}
