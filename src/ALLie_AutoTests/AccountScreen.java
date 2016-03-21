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
		
	
	//	RunLog();
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
{
	Restore();
	}



		int r = 0;
		do {
			Registration_Change_Restore_Pass();
		
		//Thread.sleep(6000);
		AddCamera();
			//RunLog();
			
			CheckSocialAcc();
			Thread.sleep(5600);
			
			
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
			
			
		//	GetScreenShot("Screenshots/Cam.jpg");
			
					
					youtube_stream();


			
//		String photo = GetAttributeMobXpath("value", "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
//			System.out.println(photo);

			//Snapshot_Gallery();
//			String Gall2 = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]");
//			System.out.println(Gall2);
		//	


	
			
			AddCardinTrialPlan();
			Sharing();

			try {
				TapName("Back button black");
				TapName("Back button black");
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