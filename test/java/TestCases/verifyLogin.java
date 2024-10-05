package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import PageObjectModel.loginpageobjects;
import Resources.baseClass;
import Resources.commonUtility;
import Resources.constant;



public class verifyLogin extends baseClass {

	@Test
	public void login() throws IOException  {
		
		test=extent.createTest("login testcase"); 
		loginpageobjects LPO = new loginpageobjects(driver);

		//webdriver wait
		//commonUtility.hendlewebdriverwait(2, LPO.enterusername());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		//wrong Username and password enter
		LPO.enterusername().sendKeys(constant.username);

		LPO.enterpassword().sendKeys(constant.password);

		LPO.clicktologin().click();

		
		commonUtility.hendleSoftAssert(LPO.showalertmesageForWrongUserNameandPassword().getText(), constant.expectedForWrongUserNameandPassword);
		
		/*SoftAssert assertion = new SoftAssert();

		String Expected = constant.expected;
		
		String Actual=LPO.showalertmesage().getText();
		
		assertion.assertEquals(Actual, Expected);
		
		assertion.assertAll();*/
		
		//enter username and Null password submit
		LPO.enterusername().sendKeys(constant.username);
		LPO.clicktologin().click();
		commonUtility.hendleSoftAssert(LPO.showalertmessageForEnterUsernameAndNullpasword().getText(), constant.expectedForEnterUsernameAndNullpasword);

		driver.quit();
	}
	
}
