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

public class ANDR_YTStrm_resolution extends ANDR_Basemethods {

	private AndroidDriver wd;
	private WebDriverWait wait;
	private WebDriver driver;

	public ANDR_YTStrm_resolution(String file, String xpath, String name, String keys, AndroidDriver wd, WebDriver driver) {
		super(file, xpath, name, keys, wd, driver);
		this.file = file;
		this.xpath = xpath;
		this.name = name;
		this.keys = keys;
		this.wd = wd;
		this.wait = new WebDriverWait(wd, 18);
		this.driver = driver;

	}
	
	public void ResCheck() throws Exception {

		TapID("com.icrealtime.allie:id/camera_availability_status");
		
		int r = 0;
		do {
			ProgressBar();
			TapID("com.icrealtime.allie:id/broadcasting_button_bottom");
			
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm");
String namest = "Allie_Live_" + formater.format(calendar.getTime());
SendKeysMobID(namest,"com.icrealtime.allie:id/video_title_edittext");

SendKeysMobID("Enter Description_" + RandomStringUtils.randomAlphabetic(3),"com.icrealtime.allie:id/video_description_edittext");
		
			Thread.sleep(1000);
			if (r % 2 == 0) {
				System.out.println("1080p");
				TapID("android:id/text1");
				TapName("1080p");
			} else {
				System.out.println("720p");
				TapID("android:id/text1");
				TapName("720p");
			};
			wd.hideKeyboard();
		//wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 701); put("y", (double) 840); }});
		TapID("com.icrealtime.allie:id/radio_video_privacy_public");
		TapID("com.icrealtime.allie:id/button_dialog_ok");
		try {
			String live = null;
			int v = 0;
do {Thread.sleep(16000);
			 live = wd.findElement(By.id("com.icrealtime.allie:id/live_label_bottom")).getText();
			 System.out.print(live+"_");
			 v++;
}while (!live.equals("LIVE")&& v < 60);
		} catch (Exception e3) {
			Thread.sleep(1600);
			System.out.print("!_!");
			TapID("android:id/button1");
			String live = null;
			int v = 0;
			do {Thread.sleep(16000);
						 live = wd.findElement(By.id("com.icrealtime.allie:id/live_label_bottom")).getText();
						 System.out.print(live+"_");
						 v++;
			}while (!live.equals("LIVE")&& v < 60);
		}
Thread.sleep(7050);

TapID("com.icrealtime.allie:id/action_link");
TapXpath("//*[@class='android.widget.TextView' and @resource-id='android:id/text1' and @text='Gmail']");
Thread.sleep(3050);

SendKeysMobID("dpleamco@icrealtech.com","com.google.android.gm:id/to");
String link = wd.findElement(By.id("com.google.android.gm:id/body")).getText();
System.out.println("\n" +link );		
TapID("com.google.android.gm:id/send");


try {
	TapID("android:id/button1");
} catch (Exception e2) {
	
}

	


			Thread.sleep(7000);
			setUpWeb(); // WebDriver

			Get(link);
			try {	
				Thread.sleep(7000);
				String StreamAct = GetTextWebXpath("//div[2]/div[4]/div/div[4]/div[2]/div[2]/div/div[6]");
				System.out.println("__" + StreamAct);
				
//				<div class="ytp-spinner" data-layer="4" style="display: none;">
//				<span class="ytp-spinner-svg">
//				<svg width="100%" viewBox="0 0 22 
				
			} catch (Exception e2) {
				System.out.println("__stream is started"); 
			}
			try {
				ClickcssSelector("button.ytp-button.ytp-settings-button");
					ClickXpath("//div[@id='ytp-main-menu-id']/div[2]/div[2]");
					ClickcssSelector("div.ytp-menuitem-label > div > span");
				} catch (Exception e) {
					System.out.println("Posible stream is not started");
				}

			ClickcssSelector("button.ytp-size-button.ytp-button");
			//*[@id="eow-title"]
			Thread.sleep(2800);// WaitXpath("//div[2]/div[4]/div/div[5]/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/h1/span");
			try {
				String Name_stream2 = GetTextWebById(
						"eow-title");
				System.out.println(Name_stream2);
			} catch (Exception e) {
		
			}
			Thread.sleep(83400);
	
			try {
				String StreamAct = GetTextWebXpath("//div[2]/div[4]/div/div[4]/div[2]/div[2]/div/div[6]");
				System.out.println("__" + StreamAct);
			} catch (Exception e2) {
	
			}
			try {
				String StreamSt2 = GetTextWebCssPath("h2.ytp-fresca-byline");
				String StreamSt3 = GetTextWebCssPath("h1.ytp-fresca-heading");
				System.out.println(StreamSt2 + StreamSt3);
			} catch (Exception e1) {
				System.out.println("NEt");
			}
			if (r % 2 == 0) {
			//wd.findElement(By.name("Button resume stream")).click();
			}
			TapID("com.icrealtime.allie:id/streaming_stop_bottom");
		
			Thread.sleep(7900);
			// TapName("Gallery player button");
		

			try {
				String StreamSt2 = GetTextWebCssPath("h2.ytp-fresca-byline");
				String StreamSt3 = GetTextWebCssPath("h1.ytp-fresca-heading");
				System.out.println(StreamSt2 + StreamSt3);
			} catch (Exception e1) {
				System.out.println("NEt");
			}

		
			r++;
			System.out.println("YT_stream "+r);
			Thread.sleep(3800);
			try {
				quit(); // web
			} catch (Exception e) {
			}
			
		} while (r < 6);
	

	}

}