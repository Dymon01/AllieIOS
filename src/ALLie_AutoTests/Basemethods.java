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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
	public Basemethods(String file, String xpath,String name, String  keys, IOSDriver wd) {
	//super();	
		this.file = file;
		this.xpath = xpath;
		this.name = name;
		this.keys = keys;
		this.wd = wd;
		this.wait = new WebDriverWait(wd, 6);
	}
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


	
	


