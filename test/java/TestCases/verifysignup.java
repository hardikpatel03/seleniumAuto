package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageObjectModel.loginpageobjects;
import PageObjectModel.signuppageobjects;
import Resources.baseClass;
import Resources.commonUtility;
import Resources.constant;

public class verifysignup extends baseClass {

	@Test
	public void signUp() throws IOException, InterruptedException{ 
		
		 test=extent.createTest("signup testcases");
		
		 loginpageobjects LPO=new loginpageobjects(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		 driver.manage().window().maximize();
		LPO.clicktryforfree().click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		signuppageobjects SPO=new signuppageobjects(driver);
		
		SPO.enterfirstname().sendKeys(constant.firstname);

		SPO.enterlastname().sendKeys(constant.lastname);
		
		SPO.enterworkEmail().sendKeys(constant.email);
		
		SPO.entercompany().sendKeys(constant.companyname);
		
		SPO.enterphone().sendKeys(constant.contact);
		
		//job title static dropdown
		
		commonUtility.hendlestaticDropdown(SPO.selectjobtitle(),5);
	
		/*	WebElement jobt=SPO.selectjobtitle();
		 Select s=new Select(jobt);
		 e.selectByIndex(5);
		*/
		
		 // check box
		 WebElement ch=SPO.selectCheckbox();
		 ch.click();
		// SPO.selectCheckbox().click();
		 
		 //employee static dropdown
		 
		// commonUtility.hendlestaticDropdown(SPO.selectEmployees(), 2);
		/* WebElement emp=SPO.selectEmployees();
		 Select e=new Select(emp);
	     e.selectByIndex(2);*/
		 
		
		 SPO.selectstartMyFreeTrial().click();
		 
	     commonUtility.hendleSoftAssert(SPO.showAlertForEmployeesDropdown().getText(), constant.expectedErrorForEmployeeDropdown);

	     
		
	}
}
