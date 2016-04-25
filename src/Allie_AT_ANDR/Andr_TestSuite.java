package Allie_AT_ANDR;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Andr_TestSuite extends ANDR_BaseTest {

//	
//	@Test
//	public void AASome() throws Exception {
//
//		SomeTests some = new SomeTests(file, xpath, name, keys, wd);
//		some.SomeTests1();
//
//	}
	
//	@Test
//	public void AccountScreen() throws Exception {	
//
//	YTStrm_resolution accountScreen = new YTStrm_resolution(file, xpath, name, keys, wd, driver);
//	 accountScreen.ResCheck();
//	
//	}

//	@Test
//	public void Ride() throws Exception {
//		int r = 0;
//		do {
//		SecurityMode checksecurity = new SecurityMode(file, xpath, name, keys, wd, driver); checksecurity.SecMode();
//		r++;	System.out.println("Round-"+ r);
//		
//	} while (r < 1);
//		 Andr_AccountScreen accountScreen = new Andr_AccountScreen(file, xpath, name, keys, wd, driver);
//		 accountScreen.AccountCheck();
//
//	}


	@Test
	public void Schedul_() throws Exception {

	 Andr_AccountScreen accountScreen = new Andr_AccountScreen(file, xpath, name, keys, wd, driver);
		 accountScreen.AccountCheck();
		// wd.quit();
	}

	@Test
	public void Schedul_2() throws Exception {

	 Andr_AccountScreen accountScreen = new Andr_AccountScreen(file, xpath, name, keys, wd, driver);
		 accountScreen.AccountCheck();
		// wd.quit();
	}
	
}
