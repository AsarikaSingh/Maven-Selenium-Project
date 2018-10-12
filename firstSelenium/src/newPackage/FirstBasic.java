package newPackage;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class FirstBasic {
	public static WebDriver driver;
	
	public static void initiateDriver() {
		//setting path for firefox browser to help locate it
		 System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		 //setting gecko path and calling driver through it
		 String Firefoxdriverpath = "C:\\ccviews\\geckodriver-v0.23.0-win32\\geckodriver.exe";
		 System.setProperty("webdriver.gecko.driver", Firefoxdriverpath);
		 //creating profile object and setting default ff profile through firefox options
		 ProfilesIni profile = new ProfilesIni();
		 FirefoxProfile ffprofile = profile.getProfile("default");
		 FirefoxOptions options = new FirefoxOptions();
		 options.setProfile(ffprofile);
		 
		 driver = new FirefoxDriver(options);
	}
	
	public static void closeDriver() {
		driver.close();
	}

public static void main(String []args) {
	FirstBasic.initiateDriver();
	 
	 // Test case 1	
	 String Url = "http://demo.guru99.com/test/newtours/";
	 String expectedText = "Welcome: Mercury Tours";
	 String actualText = "";
	 
	 driver.get(Url);
	actualText = driver.getTitle();
	if(expectedText.equalsIgnoreCase(actualText)) {
		System.out.println("Title are same");
	}
	else System.out.println("title are not same");
	
	// Test case 2, Understand frames and switching
	//to swtich to frame just find locator which search all frames and save in collection/list/ArrayList
	driver.navigate().to("http://demo.guru99.com/selenium/deprecated.html");
	List<WebElement> frame = driver.findElements(By.cssSelector("frame[name$= 'Frame']"));
    //old for loop for extracting values from webElement frame, just check value is extracted using attribute method.
	for(int i= 0; i<frame.size(); i++) {
	System.out.println(frame.get(i).getAttribute("name"));
	}
	//new for loop and check value extraction.
	for (WebElement webElement : frame) {
		System.out.println(webElement.getAttribute("name"));
	}
	
	driver.switchTo().frame("classFrame");
	WebElement depcrecateTab = driver.findElement(By.xpath("//div[@class='topNav']//a[contains(text(),'Deprecated')]"));
	depcrecateTab.click();
	
	//Test case 3, handling Alert 
	
	driver.navigate().to("http://jsbin.com/usidix/1");
	WebElement buttonGo = driver.findElement(By.cssSelector("input[value= 'Go!']"));
	buttonGo.click();
    Alert alert = driver.switchTo().alert(); // Use alert from seleniumhq to store driver handle provide to alert and then perform task.
    String messageFromAlert = alert.getText();
    System.out.println(messageFromAlert);
	alert.accept();
	FirstBasic.closeDriver();

 }
}
