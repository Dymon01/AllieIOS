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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountScreen extends Basemethods{

	private IOSDriver wd;
	private WebDriverWait wait;

	
	public Calendar calendar = Calendar.getInstance();
	  public SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm");
	public AccountScreen(String file, String xpath,String name, String  keys, IOSDriver wd) {
		super(file, xpath, name, keys, wd);	
		this.file = file;
		this.xpath = xpath;
		this.name = name;
		this.keys = keys;
		this.wd = wd;
		this.wait = new WebDriverWait(wd, 6);
		
	}

	public void AccountCheck() throws Exception {
		  
		TapName("LOGIN");
		TapName("CREATE ACCOUNT");
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
		SendKeysXpath("dpleamco+" + formater.format(calendar.getTime())+ "@icrealtech.com",
				"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]");
		SendKeysXpath("dymon0101",
				"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]");
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[2]");
		SendKeysXpath("dymon0101",
				"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[2]");
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
		
		TapName("CREATE");
		
		
		wd.quit();
	}


}