package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

	public WebDriver driver;
	public Properties prop;
	
	public ExtentSparkReporter htmlReporter; // responsible for look and feel
	public ExtentReports extent; // responsible for entries
	public ExtentTest test; // responsible for test status pass/fail

	public void initializeddriver() throws IOException {

		// to read data
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\data.properties");

		// to access data
		prop = new Properties();

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		// ChromeOptions options=new ChromeOptions();
		// options.addArguments("--remote-allow-origins=*");

		if (browserName.equalsIgnoreCase("chrome")) {
			// 79.0.9
			// WebDriverManager.chromedriver().browserVersion("120.0.6099.130").setup();//to
			// run
			// specific version
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new ChromeDriver();
			// firefox browser
		} else if (browserName.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();

			driver = new ChromeDriver();
			// edge browser
		} else {

			System.out.println("add valid browser data");

		}

	}
	
	@BeforeTest
	public void setup() {

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("hostname", "LocalHost");
		extent.setSystemInfo("os", "windows11");
		extent.setSystemInfo("Hardik", "chrome");//testername
	}
	
	@BeforeMethod
	public void launchURL() throws IOException {

		initializeddriver();
		String url = prop.getProperty("url");
		driver.get(url);
	}
	

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			test.log(Status.FAIL, "Test CASE Failed is " + result.getName()); // To add name in extent report

			test.log(Status.FAIL, "Test CASE Failed is " + result.getThrowable()); // To throw exception

			String screenshotPath = getScreenshot(driver, result.getName());

			test.addScreenCaptureFromPath(screenshotPath); // Adding screenshot

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "test case skipped is" + result.getName());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test case passed is" + result.getName());
		}

	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {

	  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	  TakesScreenshot ts = (TakesScreenshot) driver;

	  File source = ts.getScreenshotAs(OutputType.FILE);

	  String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";

	  File finalDestaination = new File(destination);
	  
	  FileUtils.copyFile(source, finalDestaination);
	
	  return destination;
	}

//	@BeforeMethod
//	public void launchURL() throws IOException {
//
//		initializeddriver();
//		String url = prop.getProperty("url");
//		driver.get(url);
//	}

}
