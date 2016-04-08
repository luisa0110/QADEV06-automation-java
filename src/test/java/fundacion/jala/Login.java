package fundacion.jala;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Login {
	private WebDriver driver;
	private String baseUrl;
	@BeforeClass
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	    baseUrl = "https://172.20.208.89:4040/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterClass
	public void tearDown() throws Exception {
		driver.findElement(By.xpath("//body/div[2]/nav/div[2]/ul/li[5]/a")).click();
	    driver.quit();
	}
	@Test
	public void testLogin() throws Exception {
		String username = "Maria";
		String password = "Control123";
	    driver.get(baseUrl + "/admin/#/login");
	    driver.findElement(By.id("loginUsername")).clear();
	    driver.findElement(By.id("loginUsername")).sendKeys(username);
	    driver.findElement(By.id("loginPassword")).click();
	    driver.findElement(By.id("loginPassword")).sendKeys(password);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Assert.assertEquals(driver.findElement(By.xpath("//body/div[2]/nav/div[2]/span/span")).getText(), username);
	  }
}
