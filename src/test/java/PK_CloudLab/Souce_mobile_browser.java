package PK_CloudLab;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class Souce_mobile_browser {
	
	RemoteWebDriver driver ;
	
	@BeforeTest
	public void LaunchApp() throws MalformedURLException {
		
		
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setCapability("platformName", "Windows 11");
		browserOptions.setCapability("browserVersion", "126");
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("build", "build1");
		sauceOptions.put("name", "Test1");
		sauceOptions.put("username", "oauth-testmyboibkc-8e47d");
		sauceOptions.put("accessKey", "7de3a0cd-4c13-434b-a59b-b0c7f92fc4d2");
		browserOptions.setCapability("sauce:options", sauceOptions);

		URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
	 driver = new RemoteWebDriver(url, browserOptions);
	
	
	
	}

	@Test
	public void EriBank_SignOn() throws InterruptedException {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		driver.findElement(By.linkText("Logout")).isDisplayed();
		driver.findElement(By.linkText("Logout")).click();
	}

	@AfterTest
	public void CloseApp() {
		driver.quit();

	}




}
