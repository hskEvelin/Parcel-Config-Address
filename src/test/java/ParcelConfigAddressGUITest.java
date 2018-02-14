package test.java;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ParcelConfigAddressGUITest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  DesiredCapabilities capability = DesiredCapabilities.phantomjs();
	  
	  capability.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/home/lucas/bin/phantomjs");
	driver = new PhantomJSDriver(capability);
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testParcelAddressGUI() throws Exception {
    driver.get("http://vm.parcel.aps.com:1150/ParcelConfigService/");
    driver.findElement(By.id("cfg-recp-name")).click();
    driver.findElement(By.id("cfg-recp-name")).clear();
    driver.findElement(By.id("cfg-recp-name")).sendKeys("Lucas Greising");
    driver.findElement(By.id("cfg-recp-street")).clear();
    driver.findElement(By.id("cfg-recp-street")).sendKeys("Sommerstraße");
    driver.findElement(By.id("cfg-recp-nr")).clear();
    driver.findElement(By.id("cfg-recp-nr")).sendKeys("31");
    driver.findElement(By.id("cfg-recp-plz")).clear();
    driver.findElement(By.id("cfg-recp-plz")).sendKeys("81543");
    driver.findElement(By.id("cfg-recp-city")).clear();
    driver.findElement(By.id("cfg-recp-city")).sendKeys("München");
    driver.findElement(By.id("cfg-recp-country")).clear();
    driver.findElement(By.id("cfg-recp-country")).sendKeys("Deutschland");
    driver.findElement(By.id("cfg-sent-name")).clear();
    driver.findElement(By.id("cfg-sent-name")).sendKeys("Lucas Greising");
    driver.findElement(By.id("cfg-sent-firm")).clear();
    driver.findElement(By.id("cfg-sent-firm")).sendKeys("Hochschule Kempten");
    driver.findElement(By.id("cfg-sent-steet")).clear();
    driver.findElement(By.id("cfg-sent-steet")).sendKeys("Bahnhofstraße");
    driver.findElement(By.id("cfg-sent-nr")).clear();
    driver.findElement(By.id("cfg-sent-nr")).sendKeys("61");
    driver.findElement(By.id("cfg-sent-plz")).clear();
    driver.findElement(By.id("cfg-sent-plz")).sendKeys("87543");
    driver.findElement(By.id("cfg-sent-city")).clear();
    driver.findElement(By.id("cfg-sent-city")).sendKeys("Kempten");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
