package APPIUM.APPIUM;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Activity3 
{
	 AppiumDriver<MobileElement> driver;
	 WebDriverWait wait;
	 
	 @BeforeClass
	    public void beforeClass() throws MalformedURLException {
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "Pixel 3");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage","com.google.android.keep");
	        caps.setCapability("appActivity", "com.google.android.keep.activities.BrowseActivity");
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	        
	 }
  @Test
  public void GoogleKeep() throws InterruptedException
  {
	  driver.findElementById("new_note_button").click();
	  wait = new WebDriverWait(driver, 30);
	  
	  driver.findElementById("editable_title").click();
	  
	  driver.findElementById("editable_title").sendKeys("Quote1");
	  
	  driver.findElementById("edit_note_text").sendKeys("People say nothing is impossible,but I do nothing every day.");
	  
	 // driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
	  driver.findElementById("menu_switch_to_list_view").click();
	  
	  //driver.findElementByXPath("time_spinner").click();
	 
	  //driver.findElementByXPath("//*contains[text(),'Evening']").click();
	  driver.findElementById("save").click();
	
	  driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
	  
	  String actualTitle=driver.findElementById("index_note_title").getText();
	  Assert.assertEquals(actualTitle, "Quote1");
	  String actual=driver.findElementById("reminder_chip_text").getText();
	  Assert.assertEquals(actual, "Today, 7:30 PM");
  }
  }
  
