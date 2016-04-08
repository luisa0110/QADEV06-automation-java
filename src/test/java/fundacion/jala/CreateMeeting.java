package fundacion.jala;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateMeeting {
	private WebDriver driver;
	private String baseUrl;
	@BeforeClass
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "https://172.20.208.229:4040/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown() throws Exception {
	    driver.quit();
	  }
	@Test
	  public void testMeeting() throws Exception {
	    driver.get(baseUrl + "/tablet/#/register");
	    driver.findElement(By.id("service-url-input")).clear();
	    driver.findElement(By.id("service-url-input")).sendKeys("https://172.20.208.229:4040/");
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("rodrigo");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("Control123!");
	    driver.findElement(By.xpath("//div[@type='submit']")).click();
	    driver.findElement(By.cssSelector("span.fa.fa-caret-left")).click();
	    driver.findElement(By.xpath("//section[@id='rm-account-status']/div[3]/div[2]/div/rm-select-item/div/div[2]/div/a[9]")).click();
	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	    driver.findElement(By.cssSelector("div.info")).click();
	    driver.findElement(By.id("txtSubject")).clear();
	    driver.findElement(By.id("txtSubject")).sendKeys("meeting");
	    driver.findElement(By.xpath("//input[@type='time']")).clear();
	    driver.findElement(By.xpath("//input[@type='time']")).sendKeys("14:50:00.000");
	    driver.findElement(By.xpath("(//input[@type='time'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@type='time'])[2]")).sendKeys("15:10:00.000");
	    driver.findElement(By.id("txtOrganizer_value")).sendKeys("maria");
	    driver.findElement(By.xpath("//div[@id='txtOrganizer_dropdown']/div[3]/div")).click();
	    driver.findElement(By.id("_value")).sendKeys("rodrigo");
	    driver.findElement(By.xpath("//div[@id='_dropdown']/div[3]/div[2]")).click();
	    driver.findElement(By.xpath("//button")).click();
	    driver.findElement(By.xpath("//input[@type='password']")).clear();
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Control123!");
	    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	    driver.findElement(By.cssSelector("span.vis-item-content")).click();
	    //assertTrue(isElementPresent(By.id("txtOrganizer_value")));
	    driver.findElement(By.cssSelector("span.vis-item-content")).click();
	    driver.findElement(By.cssSelector("div.vis-item-content")).click();
	    driver.findElement(By.xpath("//button[3]")).click();
	    driver.findElement(By.xpath("//input[@type='password']")).clear();
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Control123!");
	    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	  }

}
