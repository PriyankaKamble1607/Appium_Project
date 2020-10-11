package APPIUM.APPIUM;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity6
{
	
	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
  @BeforeClass
  public void beforeClass() throws MalformedURLException 
   {
	  DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 3");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 50);
		driver.get("https://www.training-support.net/selenium");
   }
  @Test
  public void f()
  {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='Get Started!']")));

	  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollForward().scrollIntoView(textContains(\"PopUps\"))")).click();
	  
	  driver.findElementByXPath("//android.widget.Button[@text='Sign In']").click();
	  
	  //driver.switchTo().activeElement();
	  driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").click();
	  driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").sendKeys("admin");
	  
	  driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").click();
	  driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys("password");
	  
	  driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
	  
	 String success= driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']").getText();
	 Assert.assertEquals(success, "Welcome Back, admin");
	 
	  driver.findElementByXPath("//android.widget.Button[@text='Sign In']").click();
	  driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").clear();
	  driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").sendKeys("admin1");
	  
	  driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").clear();
	  driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys("password1");
	  
	  driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
	  String failure= driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']").getText();
		 Assert.assertEquals(failure, "Invalid Credentials");

  }
  

  @AfterClass
  public void afterClass() 
  {
	  driver.quit();
  }

}
