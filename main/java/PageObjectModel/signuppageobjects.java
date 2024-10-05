package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class signuppageobjects {

	public WebDriver driver;
	private By firstName=By.xpath("//input[@name='UserFirstName']");
	
	private By LastName=By.xpath("//input[@name='UserLastName']");
	
	private By workEmail=By.xpath("//input[@name='UserEmail']");
	
	private By company=By.xpath("//input[@name='CompanyName']");
	
	private By phone=By.xpath("//input[@name='UserPhone']");
	
	private By jobtitle=By.xpath("//select[@name='UserTitle']");
	
	private By employees=By.xpath("//select[@name='CompanyEmployees']");
	
	private By checkBox=By.xpath("(//div[@class='checkbox-ui'])[2]");
	
	private By startMyFreeTrial =By.xpath("//button[@name='start my free trial']");

	private By alertMessageForNullEmployeesDropdown = By.xpath("(//span[@class='error-msg'])[6]");
	
	public signuppageobjects(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}

	public WebElement enterfirstname() {
		return driver.findElement(firstName);
	}
	
	public WebElement enterlastname() {
		return driver.findElement(LastName);
	}
	
	public WebElement enterworkEmail() {
		return driver.findElement(workEmail);
	}
	
	public WebElement entercompany() {
		return driver.findElement(company);
	}
	
	public WebElement enterphone() {
		return driver.findElement(phone);
	}
	
	public WebElement selectjobtitle() {
		return driver.findElement(jobtitle);
	}
	
	public WebElement selectEmployees() {
		return driver.findElement(employees);
	}
	
	public WebElement selectCheckbox() {
		return driver.findElement(checkBox);	
	}
	
	public WebElement selectstartMyFreeTrial() {
		return driver.findElement(startMyFreeTrial);
	}

	public WebElement showAlertForEmployeesDropdown() {
		return driver.findElement(alertMessageForNullEmployeesDropdown);
	}

	
}

