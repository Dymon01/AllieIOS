package ALLie_AutoTests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;



public class Basemethods extends BaseTest {
	protected String name;
	protected String xpath;
	protected String keys;
	protected String file;
	protected static WebDriver driver;
	  protected  WebDriverWait wait;
	public Basemethods(String file, String xpath,String name, String  keys, IOSDriver wd, WebDriver driver ) {
	super();	
		this.file = file;
		this.xpath = xpath;
		this.name = name;
		this.keys = keys;
		this.wd = wd;
		this.wait = new WebDriverWait(wd, 26);
		
	}
	
////for web
	public void setUpWeb() throws Exception {
	    //driver = new SafariDriver();
	    driver = new FirefoxDriver();
	    //wait = new WebDriverWait(driver, 26);
	    driver.manage().window().setSize(new Dimension(1180, 820));
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	  }

	
	public void  Get(String keys) throws Exception {
		driver.get(keys);
	  }
	
	public void  SendKeysID(String keys, String name) throws Exception {
	 driver.findElement(By.id(name)).sendKeys(keys);
	}
	
	public void ClickName(String name) throws Exception {
	driver.findElement(By.id(name)).click();

	}
	
	public void ClickclassName(String name) throws Exception {
	
	driver.findElement(By.className(name)).click();
	}
	
	
	public String GetTextWebXpath(String xpath) throws Exception {
		return driver.findElement(By.xpath(xpath)).getText();
	  }
	
	public void ClickcssSelector(String xpath) throws Exception {
		 driver.findElement(By.cssSelector(xpath)).click();
	  }
	
	public void  ClickXpath(String xpath) throws Exception {
	driver.findElement(By.xpath(xpath)).click();
	}
	public void  ClicklinkText(String keys) throws Exception {
	driver.findElement(By.linkText(keys)).click();
	}
	public void SwitchTo(String name) throws Exception {
	driver.switchTo().window(name);
	//driver.switchTo().window(driver.WindowHandles.Last());
		//driver.switchTo().window(lastHandle);
		System.out.println(driver.getTitle());
		driver.findElement(By.tagName("body")).click();
	}
	
	
	public void CkickSelfTarg(String xpath) throws Exception {
		
	//	((JavascriptExecutor)driver).executeScript("document.getElementByXPath('"+xpath+"').setAttribute('target', 'self');");
		//String parentHandle = driver.getWindowHandle(); // get the current window handle
		driver.findElement(By.xpath(xpath)).click(); // click some link that opens a new window

		for (String winHandle : driver.getWindowHandles()) {
			
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}

		//code to do something on new window
//
//		driver.close(); // close newly opened window when done with it
//		driver.switchTo().window(parentHandle); // switch back to the original window
	}
	
	public void  quit() throws Exception {
	driver.quit();
	}
	
	/// for mobile
	public void GetScreenShot(String file) throws Exception {
		try {
			// Get the screenshot
			File screenshot = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
			File testScreenShot = new File(file);
			//Copy the file to screenshot folder
			FileUtils.copyFile(screenshot, testScreenShot);
		} catch (Exception e1) {
		}  
	  }
	
	public String GetTextMobXpath(String xpath) throws Exception {
		return wd.findElement(By.xpath(xpath)).getText();
	  }
	public void  TapXpath(String xpath) throws Exception {
		 wd.findElement(By.xpath(xpath)).click();
	  }
	public void TapName(String name) throws Exception {
		 wd.findElement(By.name(name)).click();


	}
	public void WaitXpath(String xpath) throws Exception {
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	public void WaitName(String name) throws Exception {
	wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
	}
	public void SendKeysXpath(String  keys , String xpath) throws Exception {
		wd.findElement(By.xpath(xpath)).sendKeys(keys);
	}
	public void SendKeysName(String keys , String name) throws Exception {
		wd.findElement(By.name(name)).sendKeys(keys);
	}
}


	
	

