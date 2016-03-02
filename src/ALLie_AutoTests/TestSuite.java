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

public class TestSuite extends BaseTest {

//	
//	@Test
//	public void AASome() throws Exception {
//
//		SomeTests some = new SomeTests(file, xpath, name, keys, wd);
//		some.SomeTests1();
//
//	}
	
	@Test
	public void AccountScreen() throws Exception {
		
			 AccountScreen accountScreen = new AccountScreen(file, xpath, name, keys, wd, driver, num);
			 accountScreen.AccountCheck();

	}

	@Test
	public void Ride() throws Exception {

		// RideProcess rideProcess = new RideProcess(wd);
		// rideProcess.Process();

	}

	@Test
	public void Schedul_() throws Exception {

		// Filters_Wishlist_Schedul Filters_Wishlist_Schedul = new
		// Filters_Wishlist_Schedul(wd);
		// Filters_Wishlist_Schedul.Schedul();
		// wd.quit();
	}

}
