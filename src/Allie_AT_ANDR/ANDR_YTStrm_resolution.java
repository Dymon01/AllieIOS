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
			
		TapID("com.icrealtime.allie:id/radio_video_privacy_public");
		TapID("com.icrealtime.allie:id/button_dialog_ok");
		String live = null;
do {Thread.sleep(16000);
		 live = wd.findElement(By.id("com.icrealtime.allie:id/live_label_bottom")).getText();
		 System.out.print(live+"_");
}while (!live.equals("LIVE"));
Thread.sleep(7050);

TapID("com.icrealtime.allie:id/action_link");
TapXpath("//*[@class='android.widget.TextView' and @resource-id='android:id/text1' and @text='Gmail']");
Thread.sleep(3050);

SendKeysMobID("dpleamco@icrealtech.com","com.google.android.gm:id/to");
String link = wd.findElement(By.id("com.google.android.gm:id/body")).getText();
System.out.println("\n" +link );		
TapID("com.google.android.gm:id/send");


TapID("android:id/button1");

	


			Thread.sleep(7000);
			setUpWeb(); // WebDriver

			Get(link);
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
			Thread.sleep(5900);
	
		
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
			System.out.println(r);
			Thread.sleep(3800);
			try {
				quit(); // web
			} catch (Exception e) {
			}
			
		} while (r < 6);
	

	}

}