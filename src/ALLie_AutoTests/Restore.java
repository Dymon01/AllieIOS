package ALLie_AutoTests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Restore extends BaseTest {


	
	@Test
	public void Default() throws Exception {
		try {
		wd.findElement(By.name("Button My ALLies Edit")).click();
wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", (double) 1); put("touchCount", (double) 1); put("duration", 0.5); put("x", (double) 440); put("y", (double) 187); }});
			wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[12]/UIAStaticText[1]")).click();
			wd.findElement(By.name("REMOVE")).click();
		} catch (Exception e) {
			
		}
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

}
