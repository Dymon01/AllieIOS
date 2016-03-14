package ALLie_AutoTests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;



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
	 
	
	
	
	



	
public void Restore() throws Exception {
	try {
	wd.findElement(By.name("Button My ALLies Edit")).click();
wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 440); put("y", (double) 187); }});
		
try {
	wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")).click();
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
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")).click();
	} catch (Exception e) {
		wd.findElement(By.name("Back button black")).click();
	}
	
	wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[5]/UIAButton[1]")).click();
	
}

public void RunLog() throws Exception {
	Runtime.getRuntime().exec(new String[] {"/Users/dmitriy/Documents/workspace/Allie/run_cam_log"});
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


}