package ALLie_AutoTests;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.ios.IOSDriver;

public class BaseTest {

	
  protected IOSDriver wd;
  protected WebDriver driver;
  protected  WebDriverWait wait;
	protected String name;
	protected String xpath;
	protected String keys;
	protected String file;
	protected String num;

	@BeforeMethod
	
	public Object setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
//	capabilities.setCapability("autoDismissAlerts", true);
		//capabilities.setCapability("autoAcceptAlerts", true);
	//capabilities.setCapability("waitForAppScript", "$.delay(180000); $.switchTo().alert(); $.defaultButton().tap(); true;");
	//capabilities.setCapability("waitForAppScript", "$.delay(30000); UIATarget.localTarget().frontMostApp().alert(); $.acceptAlert(); true");
		capabilities.setCapability("waitForAppScript", "$.delay(30000); $.acceptAlert()");
		capabilities.setCapability("sendKeyStrategy", "grouped");
		capabilities.setCapability("newCommandTimeout", 999999);
		capabilities.setCapability("platformVersion", "8.2");
		capabilities.setCapability("deviceName", "iPad Air");
		capabilities.setCapability("app","com.icrtech.allie");
		wd = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),	capabilities);
		wd.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		 wait = new WebDriverWait(wd, 20);
		return wd;
	}
  
//	public Object WebsetUp() throws Exception {
////	    driver = new SafariDriver();
////	    //driver = new FirefoxDriver();
////	    wait = new WebDriverWait(driver, 10);
////	    //driver.manage().window().setSize(new Dimension(1180, 820));
////	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	    return driver;
//	  }

	
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
            File testScreenShot = new File("AutoTestsLogs/ScreenshotFail/" + methodName+"_"+formater.format(calendar.getTime())+".jpg");
        //Copy the file to screenshot folder
        FileUtils.copyFile(screenshot, testScreenShot);  
        
        try {
        	wd.switchTo().alert().accept();
        } catch (Exception e1) {
		}
        }
      } 
      
       catch (Exception e) {
    	   e.printStackTrace(); 
    	  } finally {
    		  
    		
    	  wd.quit();
    	  
    	  try {
			driver.quit(); // web
		} catch (Exception e) {
			
		}
    	  }
  
        }
          
      
  
}
