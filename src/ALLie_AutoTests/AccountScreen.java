package ALLie_AutoTests;

import static org.junit.Assert.assertEquals;
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

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountScreen extends Basemethods{

	private IOSDriver wd;
	private WebDriverWait wait;
	 private WebDriver driver;
	
	
	public AccountScreen(String file, String xpath,String name, String  keys, IOSDriver wd, WebDriver driver, String num) {
		super(file, xpath, name, keys, wd, driver, num );	
		this.file = file;
		this.xpath = xpath;
		this.name = name;
		this.keys = keys;
		this.wd = wd;
		this.wait = new WebDriverWait(wd, 18);
		this.driver = driver;
		
	}

	public void AccountCheck() throws Exception {
		int r = 0;
		do {
			Calendar calendar = Calendar.getInstance();
			 SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm");
			 String num = GenerateCheckDigit(null);
		


		String mailID = new String("dpleamco+" + formater.format(calendar.getTime())+ "@icrealtech.com");
		TapName("LOGIN");
		TapName("CREATE ACCOUNT");
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
		SendKeysXpath(mailID,
				"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
		System.out.println(mailID);
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]");
		SendKeysXpath("dymon0101",
				"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]");
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[2]");
		SendKeysXpath("dymon0101",
				"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[2]");
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
		TapName("CREATE");
		
		setUpWeb(); //WebDriver
		Get("https://accounts.google.com/");
		SendKeysID("dpleamco@icrealtech.com","Email");
		ClickName("next");
		SendKeysID("Dymon0101","Passwd");
		ClickName("signIn");
		
		ClickcssSelector("a.gb_b.gb_Nb");
		ClickcssSelector("#gb23 > span.gb_3");
		//WaitXpath("//div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div[3]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[1]/div[2]/div[1]/table/tbody/tr[1]/td[2]/div/span[2]");
wd.resetApp();
		Thread.sleep(8000);
		
		
		String mailIDf = GetTextWebXpath("//div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div[4]/div[1]/div/table/tbody/tr[1]/td[4]/div[2]/span");
		//System.out.println(mailIDf);
		//String mailIDw = GetTextWebXpath("//div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div[4]/div[1]/div/table/tbody/tr[1]/td[6]/div/div/div/span[1]/b");
		//System.out.println(mailIDw);
		if (mailIDf.equals("ALLie Home"))
		ClickXpath("//div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div[4]/div[1]/div/table/tbody/tr[1]/td[4]/div[2]/span");
		CkickSelfTarg("//div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[1]/div[2]/div[7]/div/a[2]");
		
		
		ClicklinkText("Start Using ALLie");
		
		
		ClickclassName("header__icon");
		String mailIDs = GetTextWebXpath("//div[1]/div[1]/div[2]/ul/li[5]/span");
		//System.out.println(mailIDs);
			quit();

		
		
		TapName("LOGIN");
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
		SendKeysXpath(mailID,
				"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]");
		SendKeysXpath("dymon0101",
				"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]");
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
		TapName("LOGIN");
		
		
		Thread.sleep(6000);
		WaitName("Buy new allie");
		TapName("Add new allie small");
		TapName("FIND NEW ALLIE");
		
		WaitName("Select device");
		TapName("Allie-16155100228");
		
		
	//	try {
		//
//		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");
//			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[4]")).click();
			Thread.sleep(8000);
			WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");
			TapName("AllieGO 5GHz");
			try {
				wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIASecureTextField[1]")).sendKeys("splinex271813");
				TapXpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");
			} catch (Exception e) {
			}
			Thread.sleep(9600);
			WaitName("SUCCESS!");
			TapName("Side menu button");
			TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
			Thread.sleep(2600);
			TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");


//			try { // other wifi 
//				TapName("Ok");
//				//wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")).click();
//				TapName("Configure wifi network on your camera");
//				//wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIAActionSheet[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")).click();
//				WaitName("AllieGO 5GHz");
//				TapName("AllieGO 5GHz");
//				Thread.sleep(1000);
//				String Err = GetTextWebXpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[2]");
//				System.out.println(Err);
//				TapName("Ok");
//				
//			//wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")).click();
//				TapName("Back button black");
//				
//			} catch (Exception e1) {
//			}
			
			
			GetScreenShot("Screenshots/Cam.jpg");
			TapName("Gallery player button");
		try {
			WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]");
String Gall = GetTextWebXpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]");
System.out.println(Gall);
		} catch (Exception e2) {
		}
			TapName("Back button black");
			Thread.sleep(1000);
			TapName("Snapthot player button");
			TapName("Gallery player button");
			
//			String photo = GetTextWebXpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
//			System.out.println(photo);
			try {
				TapXpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
				TapName("Gallery remove video");
//	TapName("Cancel");
				TapXpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]");
			} catch (Exception e1) {

			}
			TapName("Back button black");
			try {
				TapName("Edit");
				TapName("Edit_control");
				TapName("DELETE");
				//TapXpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]");
				TapName("Yes");
			} catch (Exception e1) {
			}
//			String Gall2 = GetTextWebXpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]");
//			System.out.println(Gall2);
			TapName("Back button black");
			TapName("Record player button");
			TapName("OK");
			WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAPageIndicator[1]");
			TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAPageIndicator[1]");
			TapName("SELECT PLAN");
			// add card
			WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");
			TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");
			//SendKeysXpath(num,"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");
			SendKeysXpath("4716009218642732","//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");
			TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[2]");
			SendKeysXpath("Apr","//UIAApplication[1]/UIAWindow[4]/UIAPicker[1]/UIAPickerWheel[1]");
			TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[4]");
			SendKeysXpath("2017","//UIAApplication[1]/UIAWindow[4]/UIAPicker[1]/UIAPickerWheel[1]");
			TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[3]");
			SendKeysXpath("123","//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[3]");
			
			TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[1]");
			SendKeysXpath("Dmitriy","//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[1]");
			TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[2]");
			SendKeysXpath("Pleamco","//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[2]");
			TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[3]");
			SendKeysXpath("32568","//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[3]");
			TapName("SUBMIT");
			
			Thread.sleep(9900);
			GetScreenShot("Screenshots/Cam2.jpg");
			WaitName("Back button black");
			TapName("Back button black");
			try {
				TapName("Back button black");
				TapName("Back button black");
			} catch (Exception e) {
			}
			
		//	TapXpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");
			
			//			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]")).click();
//			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]")).click();
//			TapName("Configure wifi network on your camera");
//			//wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIAActionSheet[1]/UIACollectionView[1]/UIACollectionCell[1]")).click();
//			TapName("AllieGO 5GHz");
//			
			
			TapName("Button My ALLies Edit");
			wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 414); put("y", (double) 199); }});
			//TapName("Camera open settings");
			String BLEpass = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[11]/UIAStaticText[2]");
			System.out.println(BLEpass);
			TapName("Cloud");
			WaitName("REMOVE PLAN");
			TapName("REMOVE PLAN");
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")).click();
			WaitName("Remove ALLie");
			
			TapName("Remove ALLie");
			//wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[12]")).click();
			
			WaitName("ARE YOU SURE?");
			TapName("REMOVE");
			try {
				TapName("OK");
			} catch (Exception e) {

			}
	//	} catch (Exception e) {		}
		

		TapName("Side menu button");
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]");
		
	TapName("Change password");
	
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[5]/UIAButton[1]");

		
		//	wd.resetApp();
		r++;
		System.out.println(r);
		
	} while (r < 90);
		wd.quit();
		
	}


}