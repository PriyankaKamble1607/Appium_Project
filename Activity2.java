package APPIUM.APPIUM;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Activity2 
{
	 AppiumDriver<MobileElement> driver;
	 
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
	  Thread.sleep(5000);
	  driver.findElementById("editable_title").click();
	  Thread.sleep(3000);
	  driver.findElementById("editable_title").sendKeys("Quote1");
	  Thread.sleep(3000);
	  driver.findElementById("edit_note_text").sendKeys("People say nothing is impossible,but I do nothing every day.");
	  Thread.sleep(3000);
	  driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
	  String actualTitle=driver.findElementById("index_note_title").getText();
	  Assert.assertEquals(actualTitle, "Quote1");
	  
  }
  }
  
