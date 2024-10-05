package Resources;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


public class commonUtility {

	public static WebDriver driver;
 

	// soft assert common
	
	public static void hendleSoftAssert(String actual,String expected) {
		
		SoftAssert assertion = new SoftAssert();

		String Expected =expected ;
		
		String Actual=actual;
		
		assertion.assertEquals(Actual, Expected);
		
		assertion.assertAll();
	}
	
	//webdriver wait
	
		public static void hendlewebdriverwait(int duration,WebElement username) {
			
			WebDriverWait wb=new WebDriverWait(driver,Duration.ofSeconds(duration));
			wb.until(ExpectedConditions.visibilityOf(username));
		}
		
		//select common static Dropdown
		public static void hendlestaticDropdown(WebElement element,int index) {
			
			WebElement e=element;
			 Select s=new Select(e);
			 s.selectByIndex(index);
		}
}
