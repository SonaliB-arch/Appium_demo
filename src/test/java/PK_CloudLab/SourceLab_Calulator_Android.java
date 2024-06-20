package PK_CloudLab;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SourceLab_Calulator_Android {
	
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
		sauceOptions.setCapability("build", "build1.1");
		sauceOptions.setCapability("name", "cal");
		sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
		caps.setCapability("sauce:options", sauceOptions);

		URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		 driver = new AndroidDriver(url, caps);
		 wait = new WebDriverWait(driver ,10);
		 
	}
	
	
	@Test
	public void testCal() throws Exception {
		System.out.println("Welcome to Calculator");
		// locate the Text on the calculator by using By.name()
		WebElement two = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.calculator2:id/digit_6")));
		// WebElement
		// two=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/digit_2']")));
		two.click();
		WebElement plus = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.calculator2:id/op_add")));
		plus.click();
		WebElement four = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.calculator2:id/digit_4")));
		four.click();
		WebElement equalTo = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.calculator2:id/eq")));
		equalTo.click();
		// locate the edit box of the calculator by using By.tagName()
		WebElement results = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.calculator2:id/result")));
		// Check the calculated value on the edit box
		assert results.getText().equals("10")
				: "Actual value is : " + results.getText() + " did not match with expected value: 10";

	}

	@AfterTest
	public void teardown() {
		// close the app
		driver.quit();
	} 
  
	
	
	


}
