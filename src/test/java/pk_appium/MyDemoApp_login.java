package pk_appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MyDemoApp_login {

	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;

	@BeforeTest
	public void LaunchApp() throws MalformedURLException {
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

	/*@Test
	public void logintoEribank() {
		//System.out.println("Welcome to Calculator");
		// locate the Text on the calculator by using By.name()
		WebElement username = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/usernameTextField")));
		// WebElement
		// two=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/digit_2']")));
		//username.click();
		username.sendKeys("Company");

		WebElement Password = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/passwordTextField")));
		//Password.click();
		Password.sendKeys("Company");
		WebElement login = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/loginButton")));
		login.click();

		WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/logoutButton")));
		logout.isDisplayed();
		logout.click();
		/*
		 * assert results.getText().equals("10")
		 * 
		 * : "Actual value is : " + results.getText() +
		 * " did not match with expected value: 10";
		 */

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
				
//				wait.until(ExpectedConditions.visibilityOfElementLocated
//						(By.id("com.experitest.ExperiBank:id/logoutButton"))).click();
		}
}
		
	/*	@Test(priority=2)
		public void MakePayment() {
			
			
			  wait.until(ExpectedConditions.visibilityOfElementLocated
						(By.id("com.experitest.ExperiBank:id/makePaymentButton"))).click();

			  wait.until(ExpectedConditions.visibilityOfElementLocated
						(By.id("com.experitest.ExperiBank:id/phoneTextField"))).sendKeys("123456789");
			  wait.until(ExpectedConditions.visibilityOfElementLocated
						(By.id("com.experitest.ExperiBank:id/nameTextField"))).sendKeys("Dixit");
			  wait.until(ExpectedConditions.visibilityOfElementLocated
						(By.id("com.experitest.ExperiBank:id/amount"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated
						(By.id("com.experitest.ExperiBank:id/countryTextField"))).sendKeys("India");
			  wait.until(ExpectedConditions.visibilityOfElementLocated
						(By.id("com.experitest.ExperiBank:id/countryButton"))).click();
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/text1"))).click();
			  
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView["+Country+"]"))).click();
			  
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text, 'India')]"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated
						(By.id("com.experitest.ExperiBank:id/sendPaymentButton"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated
						(By.id("android:id/button1"))).click();
			  wait.until(ExpectedConditions.visibilityOfElementLocated
						(By.id("com.experitest.ExperiBank:id/logoutButton"))).click();
				
			  String LoginButton=wait.until(ExpectedConditions.visibilityOfElementLocated
						(By.id("com.experitest.ExperiBank:id/loginButton"))).getText();
			  Assert.assertEquals("Login", LoginButton);
			
		}
		
		
		@BeforeTest
		public void LaunchApp() throws MalformedURLException
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", "Nexus");
			caps.setCapability("udid", "emulator-5554");
			//caps.setCapability("udid", "07c261d7028a5114"); //DeviceId from "adb devices" command
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "10.0");
			caps.setCapability("skipUnlock","true");
			//Launch Device at run time
			//caps.setCapability("avd","Galaxy_Nexus_7");
			caps.setCapability("appPackage", "com.experitest.ExperiBank");
			caps.setCapability("appActivity","com.experitest.ExperiBank.LoginActivity");
			caps.setCapability("noReset","false");
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);

			wait = new WebDriverWait(driver, 60);
		}
		
		  @AfterTest
		  public void CloseApp() {
			  driver.quit();
			  
		  }
	}
}*/
