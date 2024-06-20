package PK_CloudLab;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SouceLab_EriBankApp_Android {
	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:app", "storage:filename=EriBank.apk");  // The filename of the mobile app
		caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
		caps.setCapability("appium:platformVersion", "7.0");
		caps.setCapability("appium:automationName", "UiAutomator2");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("appiumVersion", "2.0.0");
		sauceOptions.setCapability("username", "oauth-testmyboibkc-8e47d");
		sauceOptions.setCapability("accessKey", "7de3a0cd-4c13-434b-a59b-b0c7f92fc4d2");
		sauceOptions.setCapability("build", "<your build id>");
		sauceOptions.setCapability("name", "<your test name>");
		sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
		caps.setCapability("sauce:options", sauceOptions);

		URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		 driver = new AndroidDriver(url, caps);
		 wait = new WebDriverWait(driver ,10);
		 
	}

	

		@Test(priority=1)//Main Method
		public void Login() {
			
			
			/*wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.id("android:id/button1"))).click();*/
			
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

		
	
		
		
		
		  @AfterTest
		  public void CloseApp() {
			  driver.quit();
			  
		  }


}
