/*Open the Chrome app on your device.
Go to the following URL: https://www.training-support.net/selenium
Scroll to find the To-Do List card and click it.
Once the page loads, find the input field on the page and enter the following three tasks:
Add tasks to list
Get number of tasks
Clear the list
Click on each of the tasks added to strike them out.
Finally, clear the list.
Add assertions to verify that the test has passed or failed.
*/

package APPIUM.APPIUM;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity4 {

	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// Set the Desired Capabilities
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
	public void f() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='Get Started!']")));

		driver.findElement(MobileBy.AndroidUIAutomator(
				"UiScrollable(UiSelector().scrollable(true)).scrollForward().scrollIntoView(textContains(\"To-Do List\"))"))
				.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[@text='']")));

		ArrayList<String> tasks = new ArrayList<String>();
		tasks.add("Add tasks to list");
		tasks.add("Get number of tasks");
		tasks.add("Clear the list");

		for (String task : tasks) {

			driver.findElementByXPath("//android.widget.EditText[@text='']").click();
			driver.findElementByXPath("//android.widget.EditText[@text='']").sendKeys(task);
			driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();			
			System.out.println(task);

			
			 List<MobileElement> taskNames = driver.findElementsByXPath("//android.view.View[@text='" + task + "']");
 
			 for(MobileElement taskName : taskNames) 
			 {
			  
			 Assert.assertEquals(taskName.getText(), task);
			 
			  taskName.click();
			  
			  }
			 
			 

		}
		
		driver.findElementByXPath("//android.widget.TextView[@text='Clear List']").click();
		// driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).getChildByText(UiSelector().className(\"android.view.View\"),
		// \"To-Do List\")")).click();

		// driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(textContains(\"To-Do
		// List  Elements get added at run time\"))")).click();

		// driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).getChildByDescription(UiSelector().className(\"android.view.View\"),
		// \"To-Do List  Elements get added at run time\")")).click();

		// driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).scrollIntoView(UiSelector().textContains(\"To-Do
		// List\").instance(0))"));
		// driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new
		// UiSelector().scrollable(true).instance(0)).scrollIntoView(new
		// UiSelector().textContains(\"To-Do List\").instance(0))")).click();
		// driver.findElementByXPath("//android.view.View[@text='To-Do List']").click();
		// driver.findElementByXPath("//android.view.View[3]/android.view.View[15]/android.view.View").click();

	}
	/*
	 * @AfterClass public void afterClass() { driver.quit(); }
	 */
}
