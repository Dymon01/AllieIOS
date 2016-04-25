package Allie_AT_ANDR;

import static org.junit.Assert.assertEquals;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
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

public class Andr_AccountScreen extends ANDR_Basemethods{

	private AndroidDriver wd;
	private WebDriverWait wait;
	 private WebDriver driver;
	
	
	public Andr_AccountScreen(String file, String xpath,String name, String  keys, AndroidDriver wd, WebDriver driver) {
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

		try {
			TapID("com.icrealtime.allie:id/after_splash_login");
		} catch (Exception e) {
			Restore();
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

			CamSettings();
			GetScreenShot("Screenshots/Cam.jpg");		
				//	youtube_stream();	
	//	YTStrm_resolution runres = new YTStrm_resolution(file, xpath, name, keys, wd, driver);	runres.ResCheck();
	
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
			
			
		//	SecurityMode checksecurity = new SecurityMode(file, xpath, name, keys, wd, driver); checksecurity.SecMode();
			
			WaitName("Button My ALLies Edit");
			TapName("Button My ALLies Edit");
			wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 414); put("y", (double) 199); }});
			//TapName("Camera open settings");
			String BLEpass = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[11]/UIAStaticText[2]");
			System.out.println(BLEpass);
			TapName("Cloud");
			try {
				WaitName("REMOVE PLAN");
				TapName("REMOVE PLAN");
				TapName("Yes");
			} catch (Exception e1) {
				TapName("Back button black");
			}
		WaitName("Remove ALLie");
		TapName("Remove ALLie");
			WaitName("ARE YOU SURE?");
			TapName("REMOVE");
			try {
				TapName("OK");
			} catch (Exception e) {

			}

		TapName("Side menu button");
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]");
		
	TapName("Change password");
	SharingCheckWeb();
	
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[5]/UIAButton[1]");

		
		
		
		//	wd.resetApp();
		r++;	System.out.println(r);
	
	} while (r < 90);
		wd.quit();
		
	}


}