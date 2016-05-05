package Allie_AT_ANDR;
import java.awt.Point;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;



public class ANDR_Basemethods extends ANDR_BaseTest {
	protected String name;
	protected String xpath;
	protected String keys;
	protected String file;
	protected String num;
	protected static WebDriver driver;
	  protected  WebDriverWait wait;
	public ANDR_Basemethods(String file, String xpath,String name, String  keys, AndroidDriver wd, WebDriver driver ) {
	super();	
		this.file = file;
		this.xpath = xpath;
		this.name = name;
		this.keys = keys;
		this.wd = wd;
		this.wait = new WebDriverWait(wd, 10);
		
		
	}
	
	
////for web
	public void setUpWeb() throws Exception {
	    //driver = new SafariDriver();
	    driver = new FirefoxDriver();
	    //wait = new WebDriverWait(driver, 26);
	    driver.manage().window().setSize(new Dimension(900, 400));
	   // driver.manage().window().setSize(new Dimension(1180, 820));
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	  }

	
	
	public void  Get(String keys) throws Exception {
		driver.get(keys);
	  }
	
	public void  SendKeysID(String keys, String name) throws Exception {
	 driver.findElement(By.id(name)).sendKeys(keys);
	}
	
	public void ClickName(String name) throws Exception {
	driver.findElement(By.id(name)).click();

	}
	
	public void ClickclassName(String name) throws Exception {
	
	driver.findElement(By.className(name)).click();
	}
	
	
	public String GetTextWebXpath(String xpath) throws Exception {
		return driver.findElement(By.xpath(xpath)).getText();
	  }
	public String GetTextWebCssPath(String xpath) throws Exception {
	  return driver.findElement(By.cssSelector(xpath)).getText();
	}
	public String GetTextWebById(String name) throws Exception {
	return driver.findElement(By.id(name)).getText();
	}
	public void ClickcssSelector(String xpath) throws Exception {
		 driver.findElement(By.cssSelector(xpath)).click();
	  }
	
	public void  ClickXpath(String xpath) throws Exception {
	driver.findElement(By.xpath(xpath)).click();
	}
	public void  ClicklinkText(String keys) throws Exception {
	driver.findElement(By.linkText(keys)).click();
	}
	public void SwitchTo(String name) throws Exception {
	driver.switchTo().window(name);
	//driver.switchTo().window(driver.WindowHandles.Last());
		//driver.switchTo().window(lastHandle);
		System.out.println(driver.getTitle());
		driver.findElement(By.tagName("body")).click();
	}
	
	
	public void CkickSelfTarg(String xpath) throws Exception {
		
	//	((JavascriptExecutor)driver).executeScript("document.getElementByXPath('"+xpath+"').setAttribute('target', 'self');");
		//String parentHandle = driver.getWindowHandle(); // get the current window handle
		driver.findElement(By.xpath(xpath)).click(); // click some link that opens a new window

		for (String winHandle : driver.getWindowHandles()) {
			
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}

		//code to do something on new window
//
//		driver.close(); // close newly opened window when done with it
//		driver.switchTo().window(parentHandle); // switch back to the original window
	}
	
	public void  quit() throws Exception {
	driver.quit();
	}
	
	/// for mobile
	public void GetScreenShot(String file) throws Exception {
		try {
			// Get the screenshot
			File screenshot = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
			File testScreenShot = new File(file);
			//Copy the file to screenshot folder
			FileUtils.copyFile(screenshot, testScreenShot);
		} catch (Exception e1) {
		}  
	  }
	
	public String GetAttributeMobName(String name, String xpath) throws Exception {
		 return wd.findElement(By.name(xpath)).getAttribute(name);
	}
	public String GetAttributeMobXpath(String name, String xpath) throws Exception {
	 return wd.findElement(By.xpath(xpath)).getAttribute(name);
	}
	
	public String GetIDMobXpath(String xpath) throws Exception {
		 return wd.findElement(By.xpath(xpath)).getId();
		}
	
	public String GetTextMobXpath(String xpath) throws Exception {
		return wd.findElement(By.xpath(xpath)).getText();
	  }
	public void  TapXpath(String xpath) throws Exception {
		 wd.findElement(By.xpath(xpath)).click();
	  }
	public void TapName(String name) throws Exception {
		 wd.findElement(By.name(name)).click();


	}
	
	public void TapID(String name) throws Exception {
		 wd.findElement(By.id(name)).click();
	}

	public void ProgressBar() throws Exception {	
	try {
		int v = 0;
		String ProgressBar = null;
		do {
		 ProgressBar = wd.findElement(By.xpath("//*[@class='android.widget.ProgressBar']")).getText();
		System.out.print(ProgressBar + "_");
		v++;
		} while (!ProgressBar.equals(null)&&v<10000)	;
	} catch (Exception e) {
		System.out.println("|");
	}
	}
	
	
	public void WaitID(String name) throws Exception {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(name)));


	}
	
	public void WaitXpath(String xpath) throws Exception {
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	public void WaitName(String name) throws Exception {
	wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
	}
	public void SendKeysXpath(String  keys , String xpath) throws Exception {
		wd.findElement(By.xpath(xpath)).sendKeys(keys);
	}
	public void SendKeysName(String keys , String name) throws Exception {
		wd.findElement(By.name(name)).sendKeys(keys);
	}
	
	public void SendKeysMobID(String keys , String name) throws Exception {
		wd.findElement(By.id(name)).sendKeys(keys);
	}
	
	
	public void FPScheck() throws Exception {
	try {
		String fotball = wd.findElement(By.name("StreamFPS")).getAttribute("value");
		System.out.println(fotball);
	} catch (Exception e1) {}
	}
	
	public void Player_ActivityIndicator() throws Exception {
	String actval = null;	
	do { 
		try {
			actval = GetAttributeMobXpath("value","//UIAApplication[1]/UIAWindow[1]/UIAActivityIndicator[1]");
			System.out.print(actval);
		} catch (Exception e) { 
		}
	
	}
		while ( !actval.equals("0")			
		
				);System.out.println("_streaming_");
	}
	
	 public String GenerateCheckDigit(String[] args) {
		 long l = Long.valueOf("4" + RandomStringUtils.randomNumeric(15));
	       // long l = 123456789012345L;
	        int cd = generateCheckDigit(l);
	        String num = String.valueOf(l+cd);
	       // System.out.println("Valid card number="+num);
	       return num;
	    }
	 
	 
	    private int generateCheckDigit(long l) {
	        String str = Long.toString(l);
	        int[] ints = new int[str.length()];
	        for(int i = 0;i< str.length(); i++){
	            ints[i] = Integer.parseInt(str.substring(i, i+1));
	        }
	        for(int i = ints.length-2; i>=0; i=i-2){
	            int j = ints[i];
	            j = j*2;
	            if(j>9){
	                j = j%10 + 1;
	            }
	            ints[i]=j;
	        }
	        int sum=0;
	        for(int i = 0;i< ints.length; i++){
	            sum+=ints[i];
	        }
	        if(sum%10==0){
	            return 0;
	        }else return 10-(sum%10);
	    }
	 
	    public void Registration_Change_Restore_Pass() throws Exception {
		    
			Calendar calendar = Calendar.getInstance();
			 SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm");
			 String num = GenerateCheckDigit(null);
				Thread.sleep(3000);
			String mailID = new String("dpleamco+" + formater.format(calendar.getTime())+ "@icrealtech.com");
		try {
			TapID("com.icrealtime.allie:id/after_splash_login");
		} catch (Exception e) {
		}
		//wd.sendKeyEvent(AndroidKeyCode.BACK);
		WaitID("com.icrealtime.allie:id/auth_create_account");
		TapID("com.icrealtime.allie:id/auth_create_account");
	
		SendKeysMobID(mailID,
				"com.icrealtime.allie:id/auth_email");
		System.out.println(mailID);
		SendKeysMobID("dymon0101",
				"com.icrealtime.allie:id/auth_password");
		SendKeysMobID("dymon0101",
				"com.icrealtime.allie:id/auth_password2");
		wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 65); put("y", (double) 558); }});
		wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 95); put("y", (double) 802); }});
	wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 65); put("y", (double) 586); }});
//	Thread.sleep(80000);
	//	wd.findElement(By.id("com.icrealtime.allie:id/auth_checkbox")).click();
		try {
			wd.findElement(By.id("com.icrealtime.allie:id/auth_btn")).click();
		} catch (Exception e) {

		}
		
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

		Thread.sleep(8000);
		
		
		String mailIDf = GetTextWebXpath("//div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div[4]/div[1]/div/table/tbody/tr[1]/td[4]/div[2]/span");
		//System.out.println(mailIDf);
		//String mailIDw = GetTextWebXpath("//div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div[4]/div[1]/div/table/tbody/tr[1]/td[6]/div/div/div/span[1]/b");
		//System.out.println(mailIDw);
		//if (mailIDf.equals("ALLie Home"))
		//ClickXpath("//div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div[4]/div[1]/div/table/tbody/tr[1]/td[4]/div[2]/span");

	        int b = 1;
	        String p2 = null;
	        String xpath = null;
	        do {  
	        	xpath = "//div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div[4]/div[1]/div/table/tbody/tr["+ String.valueOf(b) +"]/td[6]/div/div/div/span[1]";
	        	String mailIDc = GetTextWebXpath(xpath);
	        	
	        	
	        	String[] parts = mailIDc.split(" ");
	    		String p1 = parts[0];
	    		p2 = parts[1];
	    	
	        	b++;
	        	
	        	
	        }
	       // dpleamco+18_03_2016_06_48@icrealtech.com
	        	while (!p2.equals(mailID+"!"));
	        ClickXpath(xpath);
			CkickSelfTarg("//div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[1]/div[2]/div[7]/div/a[2]");
		Thread.sleep(600);

		ClicklinkText("Start Using ALLie");
		
		
		ClickclassName("header__icon");
		//String mailIDs = GetTextWebXpath("//div[1]/div[1]/div[2]/ul/li[5]/span");
		//System.out.println(mailIDs);
			quit();
			

	//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]
		
		
			TapID("com.icrealtime.allie:id/after_splash_login");
		
			SendKeysMobID(mailID,
					"com.icrealtime.allie:id/auth_email");
			SendKeysMobID("dymon0101",
					"com.icrealtime.allie:id/auth_password");
			
			TapID("com.icrealtime.allie:id/auth_checkbox");
			
			TapID("com.icrealtime.allie:id/auth_btn");
		System.out.println("____LOGIN_Passed____");
		Thread.sleep(6000);
		WaitName("Open navigation drawer");
		TapXpath("//*[@class='android.widget.ImageButton' and @content-desc='Open navigation drawer']");
		
		Thread.sleep(2000);	
		TapXpath("//*[@class='android.widget.TextView' and @resource-id='com.icrealtime.allie:id/menu_item_title' and @text='Account']");
		
		TapID("com.icrealtime.allie:id/expand_collapse_icon");
		//TapXpath("//*[@class='android.widget.TextView' and @text='Change password']");
		
		SendKeysMobID("dymon0101","com.icrealtime.allie:id/edittext_item");
		
	String pass = RandomStringUtils.randomAlphanumeric(9);
		System.out.println(pass);
		Thread.sleep(200);
		SendKeysXpath(pass,"//*[@class='android.widget.LinearLayout' and @index='2']");
		SendKeysXpath(pass,"//*[@class='android.widget.LinearLayout' and @index='3']");
	
		
		//String mailIDck = GetAttributeMobXpath("name", "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");
		wd.sendKeyEvent(AndroidKeyCode.BACK);
		TapID("com.icrealtime.allie:id/account_change_pswd_btn");
		
		//Thread.sleep(6000);
		ProgressBar();
		TapID("com.icrealtime.allie:id/account_logout");
	
	   

		TapID("com.icrealtime.allie:id/after_splash_login");
	
		SendKeysMobID(mailID,
				"com.icrealtime.allie:id/auth_email");
		SendKeysMobID(pass,
				"com.icrealtime.allie:id/auth_password");
		
		TapID("com.icrealtime.allie:id/auth_checkbox");
		
		TapID("com.icrealtime.allie:id/auth_btn");
		System.out.println("____ChangePass_Passed____");
		
		Thread.sleep(6000);
	}
	    public void CheckSocialAcc(int r) throws Exception {
	    	
		wd.findElement(By.name("Side menu button")).click();
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]")).click();
		TapName("Social");
		Thread.sleep(950);
		String acc = GetAttributeMobXpath("value", "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIAStaticText[1]");
		//System.out.println(acc);
		if (!acc.equals("Youtube: dpleamco@icrealtech.cm"))
		{ if (r % 1==0) {
		wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 717); put("y", (double) 160); }});
			youtube_login();
		}else{System.out.println("round-"+r);}
		}
		
		TapName("Back button black");
		try {
			TapName("Back button black");
		} catch (Exception e) {
			System.out.println("already on account screen");
		}
		
		wd.findElement(By.name("Side menu button")).click();
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
}

	  
	    public void CamSettings() throws Exception {
	    	
	    	try {
				TapName("Back button black");
			} catch (Exception e1) {

			}
	    	
	    	try {
				String name = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]");
				String status = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[2]");
				System.out.println(name + " - " + status);
			} catch (Exception e) {

			}

			String cloud = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[3]");
			System.out.println("cloud - " + cloud);
			//wd.findElement(By.name("Available")).click();
	 TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[2]");
wd.findElement(By.name("Settings player button")).click();
	 wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]")).clear();
	 
	 wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]")).sendKeys("ALLie_"+RandomStringUtils.randomAlphabetic(Integer.valueOf(RandomStringUtils.randomNumeric(1))));
	 TapName("Information");
	 TapName("Information");
	// wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[10]")).click();
	 GetScreenShot("Screenshots/CamInfo.jpg");	
		TapName("Back button black");
		
		TapName("Day/Night");
		WaitName("Black arrow rotated");
		TapName("Black arrow rotated");
		try {
			TapName("Orange arrow rotated");
		} catch (Exception e) {
			TapName("Black arrow rotated");
			WaitName("Orange arrow rotated");
			TapName("Orange arrow rotated");
		}
		WaitName("Back button black");
		TapName("Back button black");
	    }
	    
	    public void youtube_login() throws Exception {
		WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]");
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")).click();
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")).sendKeys("dpleamco@icrealtech.com");
		
		
		try {
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")).click();
			WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]");
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")).click();
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")).sendKeys("Dymon0101");
		} catch (Exception e) {
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")).click();
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")).sendKeys("Dymon0101");
		
		}
		
		wd.findElement(By.name("Go")).click();
		
//wd.context("NATIVE_APP");
		Thread.sleep(9600);


//System.out.println(String.valueOf(wd.getPageSource()));
		
		
		
		org.openqa.selenium.Point loc = (wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")).getLocation());
		String locs = loc.toString();
		

		String[] parts = locs.split(",");
		String xp = parts[0];
		String yp = parts[1];
		xp = xp.replace("(", "").replace(" ", "");
		yp = yp.replace(")", "").replace(" ", "");


		int xpd = Integer.parseInt(xp);
		int ypd = Integer.parseInt(yp);
	//	System.out.println(xp + "  " + yp);
		//wd.context("NATIVE_APP");
		wd.tap(1, xpd, ypd, 1);
	
	    }

	    

	    
	    public void youtube_stream() throws Exception {
	    	Thread.sleep(23000);
	    	try {
				wait.until(ExpectedConditions.elementToBeClickable(By.name("Button stream")));
			} catch (Exception e) {
		
			
			System.out.println("Filed to connect ");
			Runtime.getRuntime().exec(new String[] {"/Users/dmitriy/Documents/workspace/Allie/resetBLE"});
			setUpWeb(); //WebDriver
			Thread.sleep(23000);
				Runtime.getRuntime().exec(new String[] {"/Users/dmitriy/Documents/workspace/Allie/startCameraApp"});
			
/*				Get("http://192.168.7.66:4000/index.html");
		    driver.findElement(By.xpath("//input[@value='Reboot device']")).click();
			Thread.sleep(8000);		quit();*/
				Runtime.getRuntime().exec(new String[] {"/Users/dmitriy/Documents/workspace/Allie/startCameraApp"});
	

		}
				GetScreenShot("Screenshots/Cam.jpg");
			
			wd.findElement(By.name("Button stream")).click();
			


			
	try {
		youtube_login();
		wd.findElement(By.name("Button stream")).click();
		
	} catch (Exception e3) {

	}

	Calendar calendar = Calendar.getInstance();
	 SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm");


	
//	WaitXpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextField[1]");
		
	GetScreenShot("Screenshots/Cam.jpg");
	//wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextField[1]")).sendKeys("Allie"+RandomStringUtils.randomNumeric(3));
	wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]")).sendKeys("Allie_Live_"+formater.format(calendar.getTime()));
	wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]")).sendKeys("Enter Description_" +RandomStringUtils.randomAlphabetic(3));
	wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]")).click();
wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 427); put("y", (double) 949); }});
//	wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]")).sendKeys("1280 × 720");
	
TapName("SUBMIT");
	//wd.findElement(By.name("Return")).click();
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
Thread.sleep(2800);//WaitXpath("//div[2]/div[4]/div/div[5]/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/h1/span");
String Name_stream = GetTextWebXpath("//div[2]/div[4]/div/div[5]/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/h1/span");
System.out.println(Name_stream);
String stream_st = GetTextWebXpath(
		"//div[2]/div[4]/div/div[4]/div[2]/div[2]/div/div[20]/div[2]/div[1]/div/button");
System.out.println(stream_st);

wd.findElement(By.name("Button pause stream")).click();
Thread.sleep(3000);
wd.findElement(By.name("Snapthot player button")).click();


String stream_st2 = GetTextWebXpath(
		"//div[2]/div[4]/div/div[4]/div[2]/div[2]/div/div[13]/div[2]/div/h1");
System.out.println(stream_st2);

		wd.findElement(By.name("Button resume stream")).click();
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

		String stream_st3 = GetTextWebXpath(
				"//div[2]/div[4]/div/div[4]/div[2]/div[2]/div/div[20]/div[2]/div[1]/div/button");
		System.out.println(stream_st3);
		
				TapName("Button stream stop");
				quit(); // web



	    }
	  
	    public void Snapshot_Gallery() throws Exception {
	    	try {
				WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");
				TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");
			} catch (Exception e2) {
				System.out.println("Already in player screen");
			}
	    	//WaitName("Back button black");
			WaitName("Snapthot player button");
			TapName("Snapthot player button");
			WaitName("Snapthot player button");
			TapName("Snapthot player button");
			WaitName("Snapthot player button");
			TapName("Snapthot player button");
			TapName("Gallery player button");
			WaitName("Back button black");
				//TapName("Back button black");
				Thread.sleep(2000);
				WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
			TapXpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
			TapName("Gallery remove video");
TapName("Cancel");
			//TapXpath("//UIAApplication[1]/UIAWindow[5]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]");
			TapName("Back button black");
			TapName("Edit");
			TapName("Edit_control");
			TapName("DELETE");
			//TapXpath("//UIAApplication[1]/UIAWindow[5]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]");
			TapName("Yes");
			TapName("Back button black");
			TapName("Back button black");
			WaitName("Button My ALLies Edit");
			TapName("Button My ALLies Edit");
		
			TapName("Button My ALLies Settings");
			try {
				TapName("Edit");
				TapName("Edit_control");
				TapName("DELETE");
				TapName("Yes");
			} catch (Exception e1) {

			}
			//GetScreenShot("Screenshots/Gallery.jpg");	
			try {
				String items = GetAttributeMobXpath("name", "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIAStaticText[2]");
				System.out.println(items);
			} catch (Exception e) {

			}

			TapName("Back button black");
			System.out.println("__Snapshot_Gallery_Pass__");
	    }
	    
	    public void AddCardinTrialPlan() throws Exception {
	    	Thread.sleep(4000);
			try {
				TapName("Record player button");
			} catch (Exception e2) {
				WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");
				TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");
				Player_ActivityIndicator();
				TapName("Record player button");
				
			}
			Thread.sleep(4000);
			try {
				TapName("OK");
				WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAPageIndicator[1]");
				TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAPageIndicator[1]");
				TapName("SELECT PLAN");
// add card
				AddCard();
				
			} catch (Exception e) {
			}
		
		Thread.sleep(12900);
		System.out.println("____CardAdded____");
	    }
	    
		public void AddCard() throws Exception {
		Thread.sleep(1000);
		WaitName("TextField Billing Card Number");
		TapName("TextField Billing Card Number");
		List<String> list = Files.readAllLines(new File("values/CardNum.txt").toPath(), Charset.defaultCharset() );
	  	String[] parts = (String.valueOf(list).replace("[", "").replace("]", "")).split(", ");
	    String Card = parts[Integer.valueOf(RandomStringUtils.randomNumeric(1))];
	    SendKeysName(Card, "TextField Billing Card Number");
	    TapName("TextField Billing Card Month");
		try {
			wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 393); put("y", (double) 983); }});

			SendKeysXpath("Apr","//UIAApplication[1]/UIAWindow[4]/UIAPicker[1]/UIAPickerWheel[1]");
		} catch (Exception e) {}
			try {
				SendKeysXpath("Apr","//UIAApplication[1]/UIAWindow[5]/UIAPicker[1]/UIAPickerWheel[1]");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
		
			}
			TapName("TextField Billing Card Year");
		try {
			wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 393); put("y", (double) 983); }});

			SendKeysXpath("2017","//UIAApplication[1]/UIAWindow[4]/UIAPicker[1]/UIAPickerWheel[1]");
		} catch (Exception e) {}
			try {
				SendKeysXpath("2017","//UIAApplication[1]/UIAWindow[5]/UIAPicker[1]/UIAPickerWheel[1]");
			} catch (Exception e) {
				
			}
			TapName("TextField Billing Card CVC");
			 SendKeysName("123", "TextField Billing Card CVC");
			 TapName("TextField Billing First Name");
		 SendKeysName("Dmitriy", "TextField Billing First Name");
		 TapName("TextField Billing Last Name");
		 SendKeysName("Pleamco", "TextField Billing Last Name");
		 TapName("TextField Billing Zip");
		 SendKeysName("32568", "TextField Billing Zip");
		TapName("SUBMIT");
		}
		
		
	    public void Sharing() throws Exception {
	    	try {
	    		ProgressBar();
				TapID("com.icrealtime.allie:id/player_rec_bottom");
			} catch (Exception e2) {
				TapID("com.icrealtime.allie:id/camera_availability_status");
			
			    //android.widget.ProgressBar
				ProgressBar();
				
				//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.ProgressBar[1]
				
				Thread.sleep(7900);
				TapID("com.icrealtime.allie:id/player_rec_bottom");
			}
	    	
	    	int p1 = 0;
	    	do {
	    	//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]
	    	Thread.sleep(17900);
	    	String timer = wd.findElement(By.xpath("//*[@class='android.widget.TextView' and @resource-id='com.icrealtime.allie:id/label_recording_duration_bottom']")).getText();
        	String[] parts = timer.split(":");
    		 p1 = Integer.valueOf(parts[2]);
    		System.out.print(p1);
	    	} while (p1 < 10);
	    	
		wd.rotate (ScreenOrientation.LANDSCAPE);
		GetScreenShot("Screenshots/TimeLine_Landscape.jpg");	
		wd.rotate (ScreenOrientation.PORTRAIT);
		TapID("com.icrealtime.allie:id/player_rec_bottom");
	
		Calendar calendar = Calendar.getInstance();	
		 SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm");
		 TapID("com.icrealtime.allie:id/player_gallery");

		 String time = wd.findElement(By.xpath("//*[@class='android.widget.TextView' and @resource-id='com.icrealtime.allie:id/gallery_item_duration']")).getText();
		 System.out.println(time);
		 WaitID("com.icrealtime.allie:id/gallery_item_is_record");
		 TapID("com.icrealtime.allie:id/gallery_item_is_record");
	
			Thread.sleep(5900);
	 try {
		TapID("com.icrealtime.allie:id/gallery_item_is_record");
	} catch (Exception e2) {

	}
				
		 TapXpath("//*[@class='android.widget.TextView' and @content-desc='Share']");
			String sharName = "Andr_sh_" +formater.format(calendar.getTime());
		SendKeysMobID(sharName,"com.icrealtime.allie:id/title_share");
		 System.out.println(sharName);
		SendKeysMobID(RandomStringUtils.randomAlphabetic(6),"com.icrealtime.allie:id/description_share");
		 TapID("com.icrealtime.allie:id/facebook");
		Thread.sleep(5900);
	try {
		//wd.findElement(By.name("Email address or phone number")).sendKeys("dmitriip@stelar.md");
			wd.findElement(By.xpath("//*[@class='android.widget.EditText' and @content-desc='Email address or phone number']")).sendKeys("dmitriip@stelar.md");
			SendKeysXpath("dymon01","//*[@class='android.widget.EditText' and @resource-id='u_0_1']");
		//	SendKeysMobID("dymon01","u_0_1");
			//TapID("u_0_5"); 
			wd.findElement(By.name("Log In ")).click();
			Thread.sleep(50900);
			wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 997); put("y", (double) 1685); }});

		} catch (Exception e1) {
			wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 997); put("y", (double) 1685); }});

		}

	TapID("com.icrealtime.allie:id/youtube");
	try {
		TapID("com.icrealtime.allie:id/youtube");
	} catch (Exception e1) {
	}
	String Acc = wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.CheckedTextView[3]")).getText();
	 System.out.println(Acc);
	wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.CheckedTextView[3]")).click();
	TapID("android:id/button2");
	TapID("com.icrealtime.allie:id/button_share");

	 String alertTitle =  null;
	 int v = 0;
	 do {
		  alertTitle = wd.findElement(By.id("android:id/alertTitle")).getText();
			 try {
				String progr = wd.findElement(By.id("android:id/progress_percent")).getText();
				 System.out.print(progr + "/");
			} catch (Exception e) {
			}
			 Thread.sleep(4000);
			 v++;
		 }while (!alertTitle.equals("Your videos were uploaded") && v < 120);
	 System.out.println(alertTitle);
	 
	 TapID("android:id/button1");
	 TapXpath("//*[@class='android.widget.ImageButton' and @content-desc='Navigate up']");
		//TapName("Navigate up");
	 wd.findElement(By.name("Open navigation drawer")).click();
	 TapID("com.icrealtime.allie:id/menu_container");
		//	xpath: //UIAApplication[1]/UIAWindow[1]/UIAProgressIndicator[1]
	 

		System.out.println("____Sharing_Done____");
	
	    }
	    
	    public void SharingCheckWeb() throws Exception {
		
		try {
			setUpWeb(); //WebDriver
			
			Get("https://www.facebook.com/login.php");
			driver.findElement(By.id("email")).sendKeys("100008481453656@facebook.com");

			driver.findElement(By.id("pass")).sendKeys("Dymon01");
			driver.findElement(By.id("loginbutton")).click();
			driver.findElement(By.id("userNavigationLabel")).click();
			driver.findElement(By.cssSelector("span._54nh > div.clearfix > div.lfloat._ohe")).click();
			String Name_streamF = GetTextWebXpath("//div[1]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div/div/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/div[2]/a/span");
System.out.println("FB_"+Name_streamF);
ClickXpath("//div[1]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div/div/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/div[2]/a/span");
Thread.sleep(14000);
Get("https://www.youtube.com/account");	

SendKeysID("dpleamco@icrealtech.com","Email");
ClickName("next");
SendKeysID("Dymon0101","Passwd");
ClickName("signIn");


Thread.sleep(2000);
Get("https://www.youtube.com/my_videos?o=U");
Thread.sleep(9000);
String Name_streamY = GetTextWebXpath("//div[2]/div[4]/div/div[5]/div/div[2]/div[9]/ol/li[1]/div/div/div[1]/div[2]/div[1]/div/a");
				System.out.println("YT_"+Name_streamY);
quit();
		} catch (Exception e) {
			System.out.println("CheckSaringFail");
		}
	    }
	    

	    
	    public void Restore() throws Exception {
	try {
		
		
		TapID("com.icrealtime.allie:id/camera_menu_btn");
		TapID("com.icrealtime.allie:id/camera_menu_settings");
		TapID("com.icrealtime.allie:id/settings_remove_allie");
		TapID("com.icrealtime.allie:id/remove_remove");

	} catch (Exception e) {
		
	}
	Thread.sleep(5200);
	TapXpath("//*[@class='android.widget.ImageButton' and @content-desc='Open navigation drawer']");
	WaitXpath("//*[@class='android.widget.TextView' and @resource-id='com.icrealtime.allie:id/menu_item_title' and @text='Account']");
	TapXpath("//*[@class='android.widget.TextView' and @resource-id='com.icrealtime.allie:id/menu_item_title' and @text='Account']");

	TapID("com.icrealtime.allie:id/account_logout");


}

 /////////////////////////////////
	    
	    public void RunLog() throws Exception {
	Runtime.getRuntime().exec(new String[] {"/Users/dmitriy/Documents/workspace/Allie/run_cam_log_c66"});
	Thread.sleep(9000);
	Runtime.getRuntime().exec(new String[] {"/Users/dmitriy/Documents/workspace/Allie/view_log_in_term"});
	
	//Runtime.getRuntime().exec(new String[] {"/Users/dmitriy/Downloads/android-sdk-macosx/platform-tools/adb","logcat", "-v" , "threadtime",">", "/Users/dmitriy/Documents/workspace/Allie/1.txt"});
//	StringBuffer output = new StringBuffer();
//
//	Process p;
//	try {
//		p = Runtime.getRuntime().exec(new String[] {"/Users/dmitriy/Downloads/android-sdk-macosx/platform-tools/adb","logcat",  "-v" , "threadtime",">", "1.txt"});
//		p.waitFor();
//		BufferedReader reader = 
//                        new BufferedReader(new InputStreamReader(p.getInputStream()));
//
//                    String line = "";			
//		while ((line = reader.readLine())!= null) {
//			output.append(line + "\n");
//			
//		}
//
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	System.out.println(output);
	
	
}

	    public void AddCamera() throws Exception {
	    	Thread.sleep(4600);
		WaitID("com.icrealtime.allie:id/add_add");
		TapID("com.icrealtime.allie:id/add_add");
		TapID("com.icrealtime.allie:id/welcome_btn");
		ProgressBar();
		WaitXpath("//*[@class='android.widget.TextView' and @resource-id='com.icrealtime.allie:id/found_camera_title' and @text='Allie-11155101833']");
		
	
		try {

			TapXpath("//*[@class='android.widget.TextView' and @resource-id='com.icrealtime.allie:id/found_camera_title' and @text='Allie-11155101833']");
			
		
			//TapName("Allie-16155203625");
		} catch (Exception e3) {
			System.out.println("Filed to connect wifi");
			
			
			Runtime.getRuntime().exec(new String[] {"/Users/dmitriy/Documents/workspace/Allie/startCameraApp"});
				Thread.sleep(8600);
			
			TapName("Back button black");
			TapName("FIND NEW ALLIE");
		
			WaitName("Select device");
			Thread.sleep(2800);
			//TapName("Allie-16155203625");
			TapName("Allie-16155100228");
		}
		try {//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextField[1]
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIASecureTextField[1]")).sendKeys("admin");
			TapXpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");
		} catch (Exception e) {
		}
		

			Thread.sleep(18000);
			try {
				WaitXpath("//*[@class='android.widget.TextView' and @resource-id='com.icrealtime.allie:id/wifi_network_title' and @text='1503-5G']");
				
				TapXpath("//*[@class='android.widget.TextView' and @resource-id='com.icrealtime.allie:id/wifi_network_title' and @text='1503-5G']");
				
			
				//TapName("1503");
			} catch (Exception e4) {
				
			}
			try {
				SendKeysMobID("splinex271813","com.icrealtime.allie:id/wifi_password_et");
				TapID("com.icrealtime.allie:id/wifi_password_set_btn");
			} catch (Exception e) {
			}
			
			ProgressBar();
				WaitID("android:id/customPanel");
			
				TapID("android:id/button1");
				WaitID("com.icrealtime.allie:id/camera_title");
				Thread.sleep(1800);
				TapID("com.icrealtime.allie:id/camera_availability_status");
			System.out.println("____CamAdded____");
}

}