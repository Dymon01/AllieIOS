package ALLie_AutoTests;

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

public class TestSuite extends BaseTest {

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
//	YTStrm_resolution accountScreen = new YTStrm_resolution(file, xpath, name, keys, wd, driver);
//	 accountScreen.ResCheck();
//	}

	@Test
	public void Ride() throws Exception {
		//wd.rotate (ScreenOrientation.LANDSCAPE);
		 AccountScreen accountScreen = new AccountScreen(file, xpath, name, keys, wd, driver, num);
		 accountScreen.AccountCheck();

	}


	@Test
	public void Schedul_() throws Exception {

	 AccountScreen accountScreen = new AccountScreen(file, xpath, name, keys, wd, driver, num);
		 accountScreen.AccountCheck();
		// wd.quit();
	}

	@Test
	public void Schedul_2() throws Exception {

	 AccountScreen accountScreen = new AccountScreen(file, xpath, name, keys, wd, driver, num);
		 accountScreen.AccountCheck();
		// wd.quit();
	}
	
}
