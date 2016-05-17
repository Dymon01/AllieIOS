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

		int r = 0;
		do {

			Thread.sleep(7000);

		try {
			TapID("com.icrealtime.allie:id/after_splash_login");
		} catch (Exception e) {
			Restore();
		}
	
	

		Registration_Change_Restore_Pass();
		
		//Thread.sleep(6000);
		AddCamera();
	//	RunLog();
			
		//	CheckSocialAcc(r);
			Thread.sleep(5600);
		
		//	CamSettings();
		//	GetScreenShot("Screenshots/Cam.jpg");		
				//	youtube_stream();	
	
		//	Snapshot_Gallery();
			
		//	AddCardinTrialPlan();
			Sharing();
			SharingCheckWeb();
			ANDR_YTStrm_resolution runres = new ANDR_YTStrm_resolution(file, xpath, name, keys, wd, driver);	runres.ResCheck();
			try {
				TapName("Navigate up");
			} catch (Exception e) {
		
			}
			//Restore();

	
		r++;	System.out.println("Suite " +r);
	
	} while (r < 90);
		wd.quit();
		
	}


}