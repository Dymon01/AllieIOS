package ALLie_AutoTests;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.jetty.html.Target;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.server.handler.ExecuteScript;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {

	
  protected IOSDriver wd;
  protected WebDriver driver;
  protected  WebDriverWait wait;
	protected String name;
	protected String xpath;
	protected String keys;
	protected String file;
  public Calendar calendar = Calendar.getInstance();
  public SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm");
	@BeforeMethod
	
	public Object setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		Thread.sleep(2000);
	//	capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("autoAcceptAlerts", true);
	//	capabilities.setCapability("waitForAppScript", "$.delay(18000); $.switchTo().alert(); $.defaultButton().tap(); true;");
		//capabilities.setCapability("platformVersion", "8.3");
		capabilities.setCapability("deviceName", "iPad Air");
		capabilities.setCapability("app","com.icrtech.allie");
		wd = new IOSDriver(new URL("http://127.0.0.1:4724/wd/hub"),	capabilities);
		wd.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		 wait = new WebDriverWait(wd, 10);
		return wd;
	}
  
	public Object WebsetUp() throws Exception {
	    driver = new SafariDriver();
	    //driver = new FirefoxDriver();
	    wait = new WebDriverWait(driver, 10);
	    driver.manage().window().setSize(new Dimension(1180, 820));
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    return driver;
	  }

	
  @AfterMethod
  (alwaysRun=true)
  public void catchExceptions(ITestResult result) throws InterruptedException, IOException{
    Calendar calendar = Calendar.getInstance();
      SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
      String methodName = result.getName();
      //System.out.println(wd.getSessionId());
      
    	  
    	  try { 
    	  if (wd != null
    			  && ((RemoteWebDriver) wd).getSessionId() != null
    			  && !result.isSuccess()) {
    	 	  //Get the screenshot
    		  System.out.println("Create screenshot");
            File screenshot = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
            File testScreenShot = new File("Documents/workspace/TEST00/AutoTestsLogs/ScreenshotFail/" + methodName+"_"+formater.format(calendar.getTime())+".jpg");
        //Copy the file to screenshot folder
        FileUtils.copyFile(screenshot, testScreenShot);  
        
        }
      } 
      
       catch (Exception e) {
    	   e.printStackTrace(); 
    	  } finally {
    	  wd.quit();
    	  }
  
        }
          
      
  
}
