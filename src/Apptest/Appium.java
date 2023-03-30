package Apptest;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

@Test()
public class Appium {
	SoftAssert softassert = new SoftAssert();
	@Test()
	public void testMain() throws MalformedURLException {
		// use desiredcabilites to tell info you need like device ,browser and platform.
		DesiredCapabilities caps = new DesiredCapabilities();
		// can tell by this command play the enviroment (platform )ineed
		caps.setCapability("platformName", "Android");
		// or you can use this command
		// caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//--------------------------------------------------------------------------------------------------
//Device name 
		caps.setCapability("deviceName", "Khitam");
		// or use this
		// caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Khitam");

//---------------------------------------------------------------------------------------------
//browser name 
		// caps.setCapability("browserName", "chrome");
		// or this
		//caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		
//-------------------------------------------------------------------------------------------------
//to setup the browser as same version in android device (Emulator) .
		//caps.setCapability("chromedriverExecutable", "D:\\ChromeLast\\chromedriver.exe");
		// set up Android driver you have to put inner it URl (local device then
		// webdriver then hub(responaible of android driver )
		// caps (from where should i read information) .********************************
	//AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		//driver.get("https:\\www.facebook.com");
		
//-----------------------------------------------------------------------------------------------------------------
//now to use the app you have two ways either declare the file and get it the app location 
//from  properties copy its link and comment the browser.
//and then setcapability to get the absolute path *********************************
//install it as a standalone application ***
//File app = new File("src/Apptest/calculator.apk");
//caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath()); 
//AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
//-------------------------------------------------------------------------------------------------------------
		
//or just the location of the app where it is with android driver as following 
		//install from your lap
caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\Khitam\\eclipse-workspace\\Appium_Final\\src\\Apptest\\calculator.apk");
AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
//now use appium inspector 
//driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
//driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
//driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
//driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
//try to click all elements
List <WebElement> numbers = driver.findElements(By.className("android.widget.ImageButton"));
for(int i = 0 ; i<numbers.size();i++) {
	if(numbers.get(i).getAttribute("resource-id").contains("digit")){
		numbers.get(i).click();	
	}
}
WebElement results = driver.findElement(By.id("com.google.android.calculator:id/formula"));
String myresults = results.getText();
System.out.println(myresults);
softassert.assertEquals(myresults, "7894561230");
softassert.assertAll();

	}
}
