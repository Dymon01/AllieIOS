package Allie_AT_ANDR;

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
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecurityMode extends ANDR_Basemethods {

	private IOSDriver wd;
	private WebDriverWait wait;
	private WebDriver driver;

	public SecurityMode(String file, String xpath, String name, String keys, IOSDriver wd, WebDriver driver) {
		super(file, xpath, name, keys, wd, driver);
		this.file = file;
		this.xpath = xpath;
		this.name = name;
		this.keys = keys;
		this.wd = wd;
		this.wait = new WebDriverWait(wd, 18);
		this.driver = driver;

	}
	public void SecMode() throws Exception {
		
		WaitName("Button My ALLies Edit");
		String cloud = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[3]");
		System.out.println("cloud - " + cloud);
		wd.findElement(By.name("Side menu button")).click();
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]")).click();
		TapName("Cloud");
		
		try {
			TapName("CHANGE");
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAPageIndicator[1]")).click();
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAPageIndicator[1]")).click();
			TapName("SELECT PLAN");
			
			WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIATextField[1]");
			TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIATextField[1]");
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIATextField[1]")).sendKeys("123");
			TapName("SUBMIT");
			
		} catch (Exception e) {
			TapName("SELECT PLAN");
			AddCard();
			System.out.println("____CardAdded____");
			
		}
		WaitName("Side menu button");
		wd.findElement(By.name("Side menu button")).click();
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")).click();
		WaitName("Button My ALLies Edit");
		String cloud1 = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[3]");
		System.out.println("cloud - " + cloud1);
	
	
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]")).click();

		Player_ActivityIndicator();
		wd.findElement(By.name("Settings player button")).click();
		try {
			wd.findElement(By.name("Switch Mode Event")).click();
			wd.findElement(By.name("OK")).click();
			
			wd.findElement(By.name("Blue arrow rotated")).click();
			
		} catch (Exception e1) {
			wd.findElement(By.name("Switch Mode Security")).click();
			wd.findElement(By.name("OK")).click();
			TapName("Orange arrow rotated");
			Player_ActivityIndicator();
			wd.findElement(By.name("Settings player button")).click();
			wd.findElement(By.name("Switch Mode Event")).click();
wd.findElement(By.name("OK")).click();
			wd.findElement(By.name("Blue arrow rotated")).click();
		}
		
		
	
		try {	
			WaitName("Ok");
			TapName("Ok");
			TapName("Back button black");
			WaitName("Button My ALLies Edit");
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]")).click();
		} catch (Exception e1) {
			
			
		}
	

		wd.rotate (ScreenOrientation.LANDSCAPE);

		Player_ActivityIndicator();
		GetScreenShot("Screenshots/TimeLineSecM_Landscape.jpg");	
		
		wd.rotate (ScreenOrientation.PORTRAIT);
		WaitName("Snapthot player button");
		TapName("Snapthot player button");
		WaitName("Snapthot player button");
		TapName("Snapthot player button");
		TapName("Gallery player button");
		WaitName("Back button black");
		try {
			String items = GetAttributeMobXpath("name", "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAStaticText[2]");
			System.out.println(items);
		} catch (Exception e) {}
		TapName("Back button black");
		Player_ActivityIndicator();
		wd.findElement(By.name("Record player button")).click();
		wd.rotate (ScreenOrientation.LANDSCAPE);
		
		GetScreenShot("Screenshots/TimeLineSecM_Landscape2.jpg");	
		Thread.sleep(15300);
		try {
			WaitName("Snapthot player button");
			TapName("Snapthot player button");
		} catch (Exception e2) {
			System.out.println("SnapthotFailed____");
		}
		wd.findElement(By.name("Stop player button")).click();
		TapName("Gallery player button");
		
		wd.findElement(By.name("Video_play_button")).click();
//		wd.rotate (ScreenOrientation.PORTRAIT);
//		GetScreenShot("Screenshots/GallSec_Landscape.jpg");	
//		wd.rotate (ScreenOrientation.LANDSCAPE);
		TapName("Back button black");
		TapName("Back button black");
		Player_ActivityIndicator();
		try {
			WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[16]");
			String time = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[16]");
			System.out.println(time);
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[13]")).click();
			String time1 = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[16]");
			System.out.println(time1);
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[12]")).click();
			String time2 = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[16]");
			System.out.println(time2);
		} catch (Exception e1) {
			wd.findElement(By.name("Record player button")).click();
			try {
				WaitName("Snapthot player button");
				TapName("Snapthot player button");
			} catch (Exception e2) {
				System.out.println("SnapthotFailed_rec_time__");
			}
			Thread.sleep(10300);
			wd.findElement(By.name("Stop player button")).click();
			TapName("Back button black");
			WaitName("Button My ALLies Edit");
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]")).click();
			Player_ActivityIndicator();
			try {
				WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[16]");
				String time = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[16]");
				System.out.println(time);
				wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[13]")).click();
				String time1 = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[16]");
				System.out.println(time1);
			} catch (Exception e) {
				System.out.println("GetValueFromTimerFail");
			}
		}
		wd.findElement(By.name("Record player button")).click();
		try {
			WaitName("Snapthot player button");
			TapName("Snapthot player button");
		} catch (Exception e2) {
			System.out.println("SnapthotFailed____");
		}
		wd.findElement(By.name("Stop player button")).click();
		TapName("Gallery player button");
		try {
			String items = GetAttributeMobXpath("name", "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAStaticText[2]");
			System.out.println(items);
		} catch (Exception e) {}
		TapName("Back button black");
		TapName("Back button black");
		GetScreenShot("Screenshots/Camlist_Landscape.jpg");	
		wd.rotate (ScreenOrientation.PORTRAIT);
		wd.findElement(By.name("Side menu button")).click();
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]")).click();
		wd.findElement(By.name("Edit")).click();
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAButton[1]")).click();
		wd.findElement(By.name("Delete")).click();
		try {
			wd.findElement(By.name("Edit")).click();
			System.out.println("Fail to remove folder");
		} catch (Exception e) {
			System.out.println("Gallery is empty");
		}
		wd.findElement(By.name("Side menu button")).click();
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")).click();
	
	}
}
