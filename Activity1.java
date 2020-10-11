package APPIUM.APPIUM;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1
{
	    AppiumDriver<MobileElement> driver = null;
	    
	    @BeforeClass
	    public void beforeClass() throws MalformedURLException
	    {
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "Pixel 3");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage","com.google.android.apps.tasks");
	        caps.setCapability("appActivity", "com.google.android.apps.tasks.ui.TaskListsActivity");
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	    }

	    @Test
	    public void GoogleTasks() throws InterruptedException 
	    {
	    		    	
	    	ArrayList<String> activities= new ArrayList<String>();
	    	activities.add("Complete Activity with Google Tasks");
	    	activities.add("Complete Activity with Google Keep");
	    	activities.add("Complete the second Activity Google Keep");
	    	
	    	
	    	for(String activity:activities)
	    	{
	    	Thread.sleep(4000);
	        driver.findElementById("tasks_fab").click();
	        Thread.sleep(4000);
	        driver.findElementById("add_task_title").sendKeys(activity);
	        Thread.sleep(4000);
	        driver.findElementById("add_task_done").click();
	        Thread.sleep(6000);
	        
	        
	        List<MobileElement> Expectedactivities=driver.findElementsByXPath("//android.widget.TextView[@text=' "+ activity +"']");
	       	
	        for(MobileElement Expectedactivity : Expectedactivities) 
			 {
			  
			 Assert.assertEquals(Expectedactivity.getText(), Expectedactivity);
	    	}
	    	}
	    	 
	    	
	       
	    }
/*
	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	    */
	}
	
