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

public class YTStrm_resolution extends Basemethods {

	private IOSDriver wd;
	private WebDriverWait wait;
	private WebDriver driver;

	public YTStrm_resolution(String file, String xpath, String name, String keys, IOSDriver wd, WebDriver driver) {
		super(file, xpath, name, keys, wd, driver, keys);
		this.file = file;
		this.xpath = xpath;
		this.name = name;
		this.keys = keys;
		this.wd = wd;
		this.wait = new WebDriverWait(wd, 18);
		this.driver = driver;

	}
	
	public void ResCheck() throws Exception {
		//GetScreenShot("Screenshots/CamList.jpg");
		//

		String button = GetAttributeMobXpath("name", "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
		// System.out.println(button); //Buy new allie
		if (button.equals("LOGIN")) {
			Registration_Change_Restore_Pass();
		}

		int r = 0;
		do {

			try {
				WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");

				TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");
			} catch (Exception e1) {
			}

			Player_ActivityIndicator();
			
			Thread.sleep(2300);
			wd.findElement(By.name("Button stream")).click();

			try {
				youtube_login();
				wd.findElement(By.name("Button stream")).click();

			} catch (Exception e3) {

			}

			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm");

		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]"))
					.sendKeys("Allie_Live_" + formater.format(calendar.getTime()));
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]"))
					.sendKeys("Enter Description_" + RandomStringUtils.randomAlphabetic(3));
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]")).click();
		
			Thread.sleep(1000);
			if (r % 2 == 0) {
				System.out.println("1920 x 1080");
				//1280 x 720
				wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 724); put("y", (double) 732); }});
			} else {
				System.out.println("1280 x 720");
			wd.executeScript("mobile: tap", new HashMap<String, Double>() {
				{
					put("tapCount", (double) 1);
					put("touchCount", (double) 1);
					put("duration", 0.5);
					put("x", (double) 427);
					put("y", (double) 949);
				}	
			});
			}
			// wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]")).sendKeys("1280
			// × 720");

			TapName("SUBMIT");
			// wd.findElement(By.name("Return")).click();
			//Thread.sleep(90000);
			Player_ActivityIndicator();
			FPScheck();
			try {
				
				Thread.sleep(1000);
				String live = GetAttributeMobXpath("value", "//UIAApplication[1]/UIAWindow[1]/UIAImage[3]");
				System.out.println(live);
			} catch (Exception e3) {

			}

			setUpWeb(); // WebDriver

			Get("https://www.youtube.com/account");

			SendKeysID("dpleamco@icrealtech.com", "Email");
			ClickName("next");
			SendKeysID("Dymon0101", "Passwd");
			ClickName("signIn");

			Thread.sleep(2000);
			Get("https://www.youtube.com/my_live_events");
			Thread.sleep(9000);

			ClickXpath("//div[2]/div[4]/div/div[5]/div/div[2]/div[10]/ol/li[1]/div/div[1]/div[2]/div[1]/div/a");

			try {
				String stream_st = GetTextWebXpath(
						"//div[2]/div[4]/div/div[5]/div/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/div[14]/div[2]/div/h2");
				System.out.println(stream_st);
			} catch (Exception e1) {

			}
			try {
				ClickcssSelector("button.ytp-button.ytp-settings-button");
					ClickXpath("//div[@id='ytp-main-menu-id']/div[2]/div[2]");
					ClickcssSelector("div.ytp-menuitem-label > div > span");
				} catch (Exception e) {
		
				}

			ClickcssSelector("button.ytp-size-button.ytp-button");
			
			Thread.sleep(2800);// WaitXpath("//div[2]/div[4]/div/div[5]/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/h1/span");
			String Name_stream = GetTextWebXpath(
					"//div[2]/div[4]/div/div[5]/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/h1/span");
			System.out.println(Name_stream);

		
			Thread.sleep(2800);
			wd.findElement(By.name("Button pause stream")).click();
			Thread.sleep(3000);
			wd.findElement(By.name("Snapthot player button")).click();
				// wd.findElement(By.name("Microphone player button off")).click();
			FPScheck();
			
			String stream_st2 = GetTextWebXpath(
					"//div[2]/div[4]/div/div[4]/div[2]/div[2]/div/div[13]/div[2]/div/h1");
			System.out.println(stream_st2);
			wd.findElement(By.name("Button resume stream")).click();
			FPScheck();
			wd.findElement(By.name("Share player button")).click();
			Thread.sleep(50);
			wd.findElement(By.name("Mail")).click();
			Thread.sleep(2050);
			wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 327); put("y", (double) 577); }});
			wd.findElement(By.name("toField")).sendKeys("dpleamco@icrealtech.com");
			wd.findElement(By.name("subjectField")).sendKeys("liveYT");
			try {
				String links = GetAttributeMobXpath("value", "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[3]");
				System.out.println(links);
			} catch (Exception e) {
			}
				
			
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]")).click();

		
			Thread.sleep(7000);
			
			try {
				String fotball4 = wd.findElement(By.name("StreamFPS")).getAttribute("value");
				System.out.println(fotball4);
			} catch (Exception e) {
	
			}
	
			
			
			String stream_st3 = GetTextWebXpath(
					"//div[2]/div[4]/div/div[4]/div[2]/div[2]/div/div[20]/div[2]/div[1]/div/button");
			System.out.println(stream_st3);

			TapName("Button stream stop");

			Thread.sleep(7000);
			try {
				String stream_st = GetTextWebXpath(
						"//div[2]/div[4]/div/div[5]/div/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/div[14]/div[2]/div/h2");
				System.out.println(stream_st);
			} catch (Exception e1) {

			}
			quit(); // web

			// WaitName("Gallery player button");
			Thread.sleep(1900);
			// TapName("Gallery player button");
			WaitName("Back button black");
			TapName("Back button black");
			r++;
			System.out.println(r);

		} while (r < 3);
		wd.quit();

	}

}