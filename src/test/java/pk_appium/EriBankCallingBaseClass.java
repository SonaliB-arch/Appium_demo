package pk_appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class EriBankCallingBaseClass {
	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;
  
  @BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName","Nexus");
		caps.setCapability("udid", "emulator-5554");
		// caps.setCapability("udid", "07c261d7028a5114"); // DeviceId from "adb
		// devices" command
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10.0");
		// caps.setCapability("platformVersion", "7.0");
		caps.setCapability("skipUnlock", "true");

		caps.setCapability("appPackage", "com.experitest.ExperiBank");
		// This package name of your app (you can get it from apk info app)
		caps.setCapability("appActivity", "com.experitest.ExperiBank.LoginActivity"); // This is Launcher activity of
																						// your
																						// app (you can get it from apk
																						// info
																						// app)
		// Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the configurations
		// specified in Desired Capabilities
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 10);
	}
  
  
  @Test(priority=1)//Main Method
	public void Login() {
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("android:id/button1"))).click();
		
		  wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.id("com.experitest.ExperiBank:id/usernameTextField"))).sendKeys("company");

			wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.id("com.experitest.ExperiBank:id/passwordTextField"))).sendKeys("company");

			wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.id("com.experitest.ExperiBank:id/loginButton"))).click();
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.id("com.experitest.ExperiBank:id/logoutButton"))).isDisplayed();
			
//			wait.until(ExpectedConditions.visibilityOfElementLocated
//					(By.id("com.experitest.ExperiBank:id/logoutButton"))).click();
	}

	

  
  @AfterMethod
  public void CallScreenshotMethod(ITestResult result) throws Exception {
	  if (ITestResult.FAILURE==result.getStatus())
		{
	  //BaseClass cls = new BaseClass();
	  BaseTest.getScreenhot(driver, result.getName());
		}
  }

}
