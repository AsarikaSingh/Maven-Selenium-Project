package newPackage;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor; 
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FormAutomate {
	
	    WebElement root = FirstBasic.driver.findElement(By.className("wpb_text_column"));
		String header = root.findElement(By.tagName("h1")).getText();
		WebElement partialLink = root.findElement(By.cssSelector("a[title = 'Automation Practice Form']"));
		WebElement link = root.findElement(By.cssSelector("a[title = 'Automation Practice Table']"));
		// extract all headers from DOM
		WebElement firstName = root.findElement(By.xpath("//*[contains(text(), 'First name:')]"));
		WebElement lastName = root.findElement(By.xpath("//*[contains(text(), 'Last name:')]"));
		WebElement gender = root.findElement(By.xpath("//*[contains(text(), 'Sex')]"));    
		WebElement yrsOfExp = root.findElement(By.xpath("//*[contains(text(), 'Years of Experience')]")); 
		WebElement date = root.findElement(By.xpath("//p[contains(text(), 'Date: ')]"));
		WebElement profession = root.findElement(By.xpath("//label[contains(text(), 'Profession')]"));
		WebElement profilePic = root.findElement(By.xpath("//label[contains(text(), 'Profile Picture')]"));
		WebElement automationTool = root.findElement(By.xpath("//label[contains(text(), 'Automation Tool')]"));
		WebElement continents = root.findElement(By.xpath("//label[contains(text(), 'Continents')]"));
		WebElement selCommands = root.findElement(By.xpath("//label[contains(text(), 'Selenium Commands')]"));
		
		// extract all values and fields from DOM
		WebElement firstNameTxt = root.findElement(By.cssSelector("input[name='firstname']"));
		WebElement lastNameTxt = root.findElement(By.cssSelector("input[name='lastname']"));
		List<WebElement> genderRadio = root.findElements(By.cssSelector("input[name='sex']"));    
		List<WebElement> yrsOfExpRadio = root.findElements(By.cssSelector("input[name='exp']")); 
		WebElement dateTxt = root.findElement(By.cssSelector("input[id='datepicker']"));
		List<WebElement> professionCheckbx = root.findElements(By.cssSelector("input[name='profession'][type='checkbox']"));
		WebElement profilePicInput = root.findElement(By.cssSelector("input[name='photo']"));
		List<WebElement> automationToolCheckbx = root.findElements(By.cssSelector("input[name='tool']"));
		List<WebElement> continentsDropDown = root.findElements(By.cssSelector("select[id='continents']"));
		List<WebElement> selCommandsDropDown = root.findElements(By.cssSelector("select[id='selenium_commands']"));
		
		WebElement submitBtn = root.findElement(By.cssSelector("button[id='submit']"));
		
	public static void main(String[] args) {
		FirstBasic.initiateDriver();
		//Test case 4 automating form and checking various fields.
		FirstBasic.driver.get("http://toolsqa.com/automation-practice-form/");
		FormAutomate formAutomate = new FormAutomate(); 
		System.out.println("We are in form named as -"+ formAutomate.header);
		//assert will check all the headers are present in form or not.
        Asserts.check(true, "First Name header is present", formAutomate.firstName);
        Asserts.check(true, "Last Name header is present", formAutomate.lastName);
        Asserts.check(true, "Gender header is present", formAutomate.gender);
        Asserts.check(true, "Year of Experience header is present", formAutomate.yrsOfExp);
        Asserts.check(true, "Date header is present", formAutomate.date);
        Asserts.check(true, "Profession header is present", formAutomate.profession);
        Asserts.check(true, "Profile Picture header is present", formAutomate.profilePic);
        Asserts.check(true, "Continents header is present", formAutomate.continents);
        Asserts.check(true, "Automation tool header drop down is present", formAutomate.automationTool);
        Asserts.check(true, "Selenium Commands drop down header is present", formAutomate.selCommands);
        //Will fill form and click on submit
        formAutomate.firstNameTxt.sendKeys("Namratha");
        ((JavascriptExecutor)FirstBasic.driver).executeScript("arguments[0].scrollIntoView();", formAutomate.lastNameTxt);
        formAutomate.lastNameTxt.sendKeys("Pallai");
        formAutomate.genderRadio.get(1).click();
        formAutomate.yrsOfExpRadio.get(3).click();
        formAutomate.dateTxt.sendKeys("12-10-2018");
        System.out.println("HEY am in");
        formAutomate.professionCheckbx.get(0).click();
        // how to handle dropdown is pending in this form.
        formAutomate.submitBtn.click();
        
		FirstBasic.closeDriver();
	}

}
