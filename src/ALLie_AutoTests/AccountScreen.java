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

		
//		WebElement menu = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[5]/div/div[1]/ul/li[5]/h3/a")); // the triger event element
//
//	    Actions build = new Actions(driver); // heare you state ActionBuider
//	    build.moveToElement(menu).build().perform(); // Here you perform hover mouse over the needed elemnt to triger the visibility of the hidden
//	    WebElement m2m= driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[5]/div/div[1]/ul/li[5]/ul/li[1]/a/span"));//the previous non visible element
//	    m2m.click();
		
	
//		RunLog();
		try {
			WaitName("LOGIN");
			String buttonNo = null;
			do{
			TapName("NO INTERNET CONNECTION RETRY");
			buttonNo = GetAttributeMobXpath("name", "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
			}while(buttonNo.equals("Buy new allie"));
		} catch (Exception e3) {
			
		}
		
			
		 String button = GetAttributeMobXpath("name", "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
		// System.out.println(button); //Buy new allie
if (!button.equals("LOGIN"))
{Restore();}



		int r = 0;
		do {
			Calendar calendar = Calendar.getInstance();
			 SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm");
			 String num = GenerateCheckDigit(null);

				WaitName("LOGIN");
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
		ClickXpath("//div[1]/div[1]/div/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a");
		//ClickcssSelector("a.gb_b.gb_Nb");
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
		Thread.sleep(6000);
		
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
		System.out.println("____LOGIN_Passed____");
		
		Thread.sleep(6000);
		WaitName("Buy new allie");
		TapName("Add new allie small");
		TapName("FIND NEW ALLIE");
		
		WaitName("Select device");
		TapName("Allie-16155100228");
		try {//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextField[1]
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIASecureTextField[1]")).sendKeys("admin");
			TapXpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");
		} catch (Exception e) {
		}
		
//		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");
//			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[4]")).click();
			Thread.sleep(18000);
			try {
				WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");
				TapName("1503-5G");
			} catch (Exception e4) {

			}
			try {
				wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIASecureTextField[1]")).sendKeys("splinex271813");
				TapXpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");
			} catch (Exception e) {
			}
			Thread.sleep(18600);
			WaitName("SUCCESS!");
			TapName("Side menu button");
			TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
			System.out.println("____CamAdded____");
			RunLog();
			
			wd.findElement(By.name("Side menu button")).click();
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]")).click();
			TapName("Social");
			Thread.sleep(950);
			String acc = GetAttributeMobXpath("value", "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIAStaticText[1]");
			System.out.println(acc);
			if (acc.equals("Youtube: dpleamco@icrealtech.cm"))
			{
			wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 717); put("y", (double) 160); }});
			//(JavascriptExecutor)wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1); put("touchCount", 1); put("duration", 0.5); put("x", 360); put("y", 318); }});
			
				TapName("Unlink");

				Thread.sleep(9500);
				wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 724); put("y", (double) 174); }});

			
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")).click();
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")).sendKeys("dpleamco@icrealtech.com");
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")).click();
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")).sendKeys("Dymon0101");
			wd.findElement(By.name("Go")).click();
		//	wd.context("NATIVE_APP");
			Thread.sleep(9600);


//System.out.println(String.valueOf(wd.getPageSource()));
			
			
			
			Point loc = (wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")).getLocation());
			String locs = loc.toString();
			

			String[] parts = locs.split(",");
			String xp = parts[0];
			String yp = parts[1];
			xp = xp.replace("(", "").replace(" ", "");
			yp = yp.replace(")", "").replace(" ", "");
		

			int xpd = Integer.parseInt(xp);
			int ypd = Integer.parseInt(yp);
			System.out.println(xp + "  " + yp);
			//wd.context("NATIVE_APP");
			wd.tap(1, xpd, ypd, 1);
		//wd.context(originalContext);
			}
			
			TapName("Back button black");

			
			wd.findElement(By.name("Side menu button")).click();
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
			
			ath: //UIAApplication[1]/UIAWindow[1]/UIAStaticText[4]
				
				xpath: //UIAApplication[1]/UIAWindow[1]/UIAImage[3]
					
					wd.findElement(By.name("Button stream")).click();
			


			
			try {
				WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]");
				wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")).click();
				wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")).sendKeys("dpleamco@icrealtech.com");
				wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")).click();
				wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")).sendKeys("Dymon0101");
				wd.findElement(By.name("Go")).click();
//	wd.context("NATIVE_APP");
				Thread.sleep(9600);


//System.out.println(String.valueOf(wd.getPageSource()));
				
				
				
				Point loc = (wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")).getLocation());
				String locs = loc.toString();
				

				String[] parts = locs.split(",");
				String xp = parts[0];
				String yp = parts[1];
				xp = xp.replace("(", "").replace(" ", "");
				yp = yp.replace(")", "").replace(" ", "");


				int xpd = Integer.parseInt(xp);
				int ypd = Integer.parseInt(yp);
				System.out.println(xp + "  " + yp);
				//wd.context("NATIVE_APP");
				wd.tap(1, xpd, ypd, 1);
				wd.findElement(By.name("Button stream")).click();
				
			} catch (Exception e3) {
	
			}
			Thread.sleep(6000);
			WaitXpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextField[1]");
				wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextField[1]")).sendKeys("Allie"+RandomStringUtils.randomNumeric(3));
				wd.findElement(By.name("Return")).click();
				Thread.sleep(9000);

try {
	String time = GetAttributeMobXpath("value", "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]");
	System.out.println(time);
	Thread.sleep(1000);
	String live = GetAttributeMobXpath("value", "//UIAApplication[1]/UIAWindow[1]/UIAImage[3]");
	System.out.println(live);
} catch (Exception e3) {

}

setUpWeb(); //WebDriver


Get("https://www.youtube.com/account");	
 
SendKeysID("dpleamco@icrealtech.com","Email");
ClickName("next");
SendKeysID("Dymon0101","Passwd");
ClickName("signIn");


Thread.sleep(2000);
Get("https://www.youtube.com/my_live_events");
Thread.sleep(9000);

ClickXpath("//div[2]/div[4]/div/div[5]/div/div[2]/div[10]/ol/li[1]/div/div[1]/div[2]/div[1]/div/a");

String Name_stream = GetTextWebXpath("//div[2]/div[4]/div/div[5]/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/h1/span");
System.out.println(Name_stream);



				wd.findElement(By.name("Button pause stream")).click();
				Thread.sleep(3000);
				wd.findElement(By.name("Snapthot player button")).click();
		//		wd.findElement(By.name("Microphone player button off")).click();

				wd.findElement(By.name("Button resume stream")).click();
				wd.findElement(By.name("Share player button")).click();
				Thread.sleep(2000);
				wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIAActivityView[1]/UIAActionSheet[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[3]/UIACollectionView[1]/UIACollectionCell[2]")).click();
						wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
TapName("Done");
wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 399); put("y", (double) 941); }});
							//crash
						//wd.findElement(By.name("Camera vr")).click();
					//	

				
						TapName("Button stream stop");
						quit(); // web
						
					//	WaitName("Gallery player button");
						Thread.sleep(1000);
					//	TapName("Gallery player button");
		try {
			WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]");
//String Gall = GetAttributeMobXpath("value", "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]");
//System.out.println(Gall);
		} catch (Exception e2) {
		}
		
		TapName("Snapthot player button");
		TapName("Gallery player button");
		WaitName("Back button black");
			TapName("Back button black");
			Thread.sleep(1000);

			
//		String photo = GetAttributeMobXpath("value", "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
//			System.out.println(photo);
			try {
				TapXpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
				TapName("Gallery remove video");
	TapName("Cancel");
				//TapXpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]");
			} catch (Exception e1) {

			}
		//	TapName("Back button black");
			try {
				TapName("Edit");
				TapName("Edit_control");
				TapName("DELETE");
				//TapXpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]");
				TapName("Yes");
			} catch (Exception e1) {
			}
//			String Gall2 = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]");
//			System.out.println(Gall2);
		//	TapName("Back button black");
			
			TapName("Record player button");
			TapName("OK");
			WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAPageIndicator[1]");
			TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAPageIndicator[1]");
			TapName("SELECT PLAN");
			// add card
			Thread.sleep(1000);
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
			System.out.println("____CardAdded____");
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
		r++;	System.out.println(r);
	
	} while (r < 90);
		wd.quit();
		
	}


}