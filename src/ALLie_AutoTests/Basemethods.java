package ALLie_AutoTests;
import java.awt.Point;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;



public class Basemethods extends BaseTest {
	protected String name;
	protected String xpath;
	protected String keys;
	protected String file;
	protected String num;
	protected static WebDriver driver;
	  protected  WebDriverWait wait;
	public Basemethods(String file, String xpath,String name, String  keys, IOSDriver wd, WebDriver driver, String num ) {
	super();	
		this.file = file;
		this.xpath = xpath;
		this.name = name;
		this.keys = keys;
		this.wd = wd;
		this.wait = new WebDriverWait(wd, 10);
		this.num = num;
		
	}
	
	
////for web
	public void setUpWeb() throws Exception {
	    //driver = new SafariDriver();
	    driver = new FirefoxDriver();
	    //wait = new WebDriverWait(driver, 26);
	    driver.manage().window().setSize(new Dimension(1180, 820));
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
	
	public String GetAttributeMobXpath(String name, String xpath) throws Exception {
	 return wd.findElement(By.xpath(xpath)).getAttribute(name);
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
	String alert = GetTextMobXpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[2]");
	System.out.println(alert);
	
	ClicklinkText("Start Using ALLie");
	
	
	ClickclassName("header__icon");
	String mailIDs = GetTextWebXpath("//div[1]/div[1]/div[2]/ul/li[5]/span");
	//System.out.println(mailIDs);
		quit();
		
TapName("Ok");
//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]
	
	
	//TapName("LOGIN");
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
	WaitName("Side menu button");
	wd.findElement(By.name("Side menu button")).click();
	wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]")).click();
	TapName("Change password");
	TapName("TextField Account Settings Current Password");
	SendKeysName("dymon0101","TextField Account Settings Current Password");
	
TapName("TextField Account Settings New Password");
	String pass = RandomStringUtils.randomAlphanumeric(9);
	System.out.println(pass);
	String mailIDck = GetAttributeMobXpath("name", "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");
	SendKeysName(pass,"TextField Account Settings New Password");
	TapName("TextField Account Settings Confirm Password");
	SendKeysName(pass,"TextField Account Settings Confirm Password");
   wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 395); put("y", (double) 440); }});
   TapName("LOG OUT");
   
   TapName("LOGIN");
	TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
	SendKeysXpath(mailIDck,
			"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
	TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]");
	SendKeysXpath(pass,
			"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]");
	TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]");
	TapName("LOGIN");
	System.out.println("____ChangePass_Passed____");
	
}
	
	    public void CheckSocialAcc() throws Exception {
		wd.findElement(By.name("Side menu button")).click();
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]")).click();
		TapName("Social");
		Thread.sleep(950);
		String acc = GetAttributeMobXpath("value", "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIAStaticText[1]");
		System.out.println(acc);
		if (!acc.equals("Youtube: dpleamco@icrealtech.cm"))
		{
		wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 717); put("y", (double) 160); }});
		//(JavascriptExecutor)wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1); put("touchCount", 1); put("duration", 0.5); put("x", 360); put("y", 318); }});
		
//			TapName("Unlink");
//
//			Thread.sleep(9500);
//			wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 724); put("y", (double) 174); }});

		
			youtube_login();
		}
		
		TapName("Back button black");

		
		wd.findElement(By.name("Side menu button")).click();
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
}

	 
   
	    public void CamSettings() throws Exception {
	    	String name = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]");
			String status = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[2]");
			System.out.println(name + " - " + status);

			String cloud = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[3]");
			System.out.println("cloud - " + cloud);

	 TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[2]");
	 wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]")).clear();
	 
	 wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]")).sendKeys("ALLie_"+RandomStringUtils.randomAlphabetic(3));
	 TapName("Information");
	// wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[10]")).click();
	 GetScreenShot("Screenshots/CamInfo.jpg");	
		TapName("Back button black");
		
		TapName("Day/Night");
		TapName("Black arrow rotated");
		TapName("Orange arrow rotated");
		
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
				System.out.println("Filed to connect wifi");
				Runtime.getRuntime().exec(new String[] {"/Users/dmitriy/Documents/workspace/Allie/resetBLE"});
				Thread.sleep(18000);
//				setUpWeb(); //WebDriver
//				Get("http://192.168.7.66:4000/index.html");
//			    driver.findElement(By.xpath("//input[@value='Reboot device']")).click();
//				Thread.sleep(8000);
//				quit();
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


	 Player_ActivityIndicator();
	
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
	    	WaitName("Back button black");
			WaitName("Snapthot player button");
			TapName("Snapthot player button");
			TapName("Gallery player button");
			WaitName("Back button black");
				//TapName("Back button black");
				Thread.sleep(2500);
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

	    }
	    
	    public void AddCardinTrialPlan() throws Exception {


			try {
				WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");
				TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");
			} catch (Exception e1) {
			}
	    	//Player_ActivityIndicator();
	    	
			TapName("Record player button");
			
			try {
				WaitName("OK");
				TapName("OK");
				Thread.sleep(1700);
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
try {
				wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 393); put("y", (double) 983); }});

				SendKeysXpath("Apr","//UIAApplication[1]/UIAWindow[4]/UIAPicker[1]/UIAPickerWheel[1]");
} catch (Exception e) {}
				try {
					SendKeysXpath("Apr","//UIAApplication[1]/UIAWindow[5]/UIAPicker[1]/UIAPickerWheel[1]");
				} catch (Exception e1) {
					// TODO Auto-generated catch block

				}


TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[4]");
try {
				wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 393); put("y", (double) 983); }});

				SendKeysXpath("2017","//UIAApplication[1]/UIAWindow[4]/UIAPicker[1]/UIAPickerWheel[1]");
} catch (Exception e) {}
				try {
					SendKeysXpath("2017","//UIAApplication[1]/UIAWindow[5]/UIAPicker[1]/UIAPickerWheel[1]");
				} catch (Exception e) {
					
				}

TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[3]");
SendKeysXpath("123","//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[3]");

TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[1]");
SendKeysXpath("Dmitriy","//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[1]");
TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[2]");
SendKeysXpath("Pleamco","//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[2]");
TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[3]");
SendKeysXpath("32568","//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[3]");
TapName("SUBMIT");

Thread.sleep(12900);
System.out.println("____CardAdded____");
			} catch (Exception e) {
				try {
					TapName("Back button black");
				} catch (Exception e1) {
			
				}
				System.out.println("???CardNotAdded???");
			}

	    }
	    
	    public void Sharing() throws Exception {
	    	Thread.sleep(7900);
		try {
			wd.findElement(By.name("Record player button")).click();
		} catch (Exception e2) {
		
		}
		Thread.sleep(9900);
		//GetScreenShot("Screenshots/CamRec.jpg");
		wd.findElement(By.name("Stop player button")).click();
		wd.findElement(By.name("Gallery player button")).click();
		wd.findElement(By.name("Video_play_button")).click();
		wd.findElement(By.name("Share player button")).click();
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
		
		Calendar calendar = Calendar.getInstance();	
		 SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm");

		SendKeysXpath("_sh_" +formater.format(calendar.getTime()),"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]");
		SendKeysXpath("Comment___" +(calendar.getTime()),"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]");
	
	wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]")).click();
	wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[1]")).click();
	wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 720); put("y", (double) 513); }});
	Thread.sleep(5900);
	try {
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[8]")).click();
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")).click();
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")).sendKeys("dmitriip@stelar.md");
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")).click();
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")).sendKeys("dymon01");
//	wd.findElement(By.name("Перейти")).click();
			wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 375); put("y", (double) 410); }});
			wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 371); put("y", (double) 864); }});
			wd.findElement(By.name("OK")).click();
		} catch (Exception e1) {

		}
	
		wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 405); put("y", (double) 987); }});
		wd.findElement(By.name("SHARE")).click();
		//xpath: //UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]
		//	xpath: //UIAApplication[1]/UIAWindow[1]/UIAProgressIndicator[1]
		String elval = null;
		
		do { 
			try {
				elval = GetAttributeMobXpath("value","//UIAApplication[1]/UIAWindow[1]/UIAProgressIndicator[1]");
				System.out.print("_"+elval);
			} catch (Exception e) { 
			}
			try {
				elval = GetAttributeMobXpath("value","//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]");
				System.out.print("_"+elval);
			} catch (Exception e) { 
			}
			try {
				TapName("Ok");//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]
				wd.findElement(By.name("SHARE")).click();
			} catch (Exception e) { 
			}
			
		}
			while ( !elval.equals("SUCCESS!")			
			
					);
		

		Thread.sleep(19900);
		WaitName("SUCCESS!");
		
		WaitName("Back button black");
		
		TapName("SEND TO FRIEND");
		Thread.sleep(1200);
		//wd.switchTo().alert().accept();
		try {
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[7]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")).click();
		} catch (Exception e) {
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[6]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")).click();
		}
		
		wd.findElement(By.name("toField")).sendKeys("dpleamco@icrealtech.com");
		String links = GetAttributeMobXpath("value", "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextView[2]");
		System.out.println(links);
		Thread.sleep(19900);
		
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[3]")).click();
		TapName("Back button black");
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
			driver.findElement(By.cssSelector("span._54nh > div.clearfix")).click();
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
		
		
//		setUpWeb(); //WebDriver
//		Get("http://192.168.7.66:4000/index.html");
//		String wifi = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[1]/fieldset[2]/table/tbody/tr/td[2]/fieldset/table/tbody/tr[1]/td[2]")).getText();
//		
//		System.out.println(wifi);
		

	
	wd.findElement(By.name("Button My ALLies Edit")).click();
wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 440); put("y", (double) 187); }});
		
try {
	wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[5]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")).click();
	Thread.sleep(5200);
	wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIASecureTextField[1]")).sendKeys("splinex271813");
	TapXpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");
} catch (Exception e) {
}
wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[12]/UIAStaticText[1]")).click();
		wd.findElement(By.name("REMOVE")).click();
		TapName("Ok");
	} catch (Exception e) {
		
	}
	Thread.sleep(5200);
	WaitName("Side menu button");
	wd.findElement(By.name("Side menu button")).click();
	wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]")).click();
	try {
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIAStaticText[1]")).click();
		wd.findElement(By.name("REMOVE PLAN")).click();
		TapName("Yes");
		//wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")).click();
	} catch (Exception e) {
		wd.findElement(By.name("Back button black")).click();
	}
	
	wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[5]/UIAButton[1]")).click();
	
}

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
		WaitName("Buy new allie");
		TapName("Add new allie small");
		TapName("FIND NEW ALLIE");
		
		WaitName("Select device");
		try {

			
			TapName("Allie-16155100228");
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
		
//		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");
//			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[4]")).click();
			Thread.sleep(18000);
			try {
				WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]");
				TapName("1503-5G");
				//TapName("1503");
			} catch (Exception e4) {
				try {
					wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIASecureTextField[1]")).sendKeys("splinex271813");
					TapXpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");
					TapName("1503-5G");
				} catch (Exception e) {
				}
				System.out.println("Filed to connect wifi");
				Runtime.getRuntime().exec(new String[] {"/Users/dmitriy/Documents/workspace/Allie/resetBLE"});
				Thread.sleep(18000);
//				setUpWeb(); //WebDriver
//				Get("http://192.168.7.92:4000/index.html");
//			    driver.findElement(By.xpath("//input[@value='Reboot device']")).click();
//				Thread.sleep(8000);
//				quit();

				Runtime.getRuntime().exec(new String[] {"/Users/dmitriy/Documents/workspace/Allie/startCameraApp"});
		
				wd.resetApp();
				wd.findElement(By.name("Side menu button")).click();
				wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]")).click();
				wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[5]")).click();
			
				
			}
			try {
				wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIASecureTextField[1]")).sendKeys("splinex271813");
				TapXpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]");
			} catch (Exception e) {
			}
			Thread.sleep(18600);
			try {
				WaitName("SUCCESS!");
			} catch (Exception e2) {
				System.out.println("Filed to connect wifi");
				Runtime.getRuntime().exec(new String[] {"/Users/dmitriy/Documents/workspace/Allie/resetBLE"});
			}
			TapName("Side menu button");
			TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]");
			System.out.println("____CamAdded____");
}

}