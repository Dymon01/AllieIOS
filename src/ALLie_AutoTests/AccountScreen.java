package ALLie_AutoTests;

import static org.junit.Assert.assertEquals;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.Spring;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountScreen extends Basemethods{

	private IOSDriver wd;
	private WebDriverWait wait;
	 private WebDriver driver;
	
	
	public AccountScreen(String file, String xpath,String name, String  keys, IOSDriver wd, WebDriver driver) {
		super(file, xpath, name, keys, wd, driver );	
		this.file = file;
		this.xpath = xpath;
		this.name = name;
		this.keys = keys;
		this.wd = wd;
		this.wait = new WebDriverWait(wd, 18);
		this.driver = driver;
		
	}

	public void AccountCheck() throws Exception {	
	//	RunLog();

		Thread.sleep(7000);
WaitXpath( "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
		
		String button = GetAttributeMobXpath("name", "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
		// System.out.println(button); //Buy new allie
if (!button.equals("LOGIN"))
{
	Restore();
	wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[5]/UIAButton[1]")).click();
	}

		int r = 0;
		do {
		Registration_Change_Restore_Pass();
		
		//Thread.sleep(6000);
		AddCamera();
	//	RunLog();
			
			CheckSocialAcc(r);
			Thread.sleep(5600);
			
			TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");

			//CamSettings();
			GetScreenShot("Screenshots/Cam.jpg");		
				//	youtube_stream();	
		YTStrm_resolution runres = new YTStrm_resolution(file, xpath, name, keys, wd, driver);	runres.ResCheck();
	
			Snapshot_Gallery();
			
			AddCardinTrialPlan();
			Sharing();

			try {
				TapName("Back button black");
				TapName("Back button black");
				TapName("Back button black");
				TapName("Back button black");
			} catch (Exception e) {
			}
			
				TapName("Side menu button");
			TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
			Thread.sleep(5600);
			
			
			SecurityMode checksecurity = new SecurityMode(file, xpath, name, keys, wd, driver); checksecurity.SecMode();
			
			Restore();

	
	SharingCheckWeb();
	
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[5]/UIAButton[1]");

		
		
		
		//	wd.resetApp();
		r++;	System.out.println(r);
	
	} while (r < 90);
		wd.quit();
		
	}


}