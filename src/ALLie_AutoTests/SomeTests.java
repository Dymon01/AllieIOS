package ALLie_AutoTests;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.primitives.Chars;

public class SomeTests extends Basemethods{

	private IOSDriver wd;
	private WebDriverWait wait;

	public SomeTests(String file, String xpath,String name, String  keys, IOSDriver wd, String num) {

		super(file, xpath, name, keys, wd, driver, num);	

		

		this.file = file;
		this.xpath = xpath;
		this.name = name;
		this.keys = keys;
		this.wd = wd;
		this.wait = new WebDriverWait(wd, 6);
		
	}

	public void SomeTests1() throws Exception {
		SomeTests();

	}

	public void SomeTests() throws Exception {
		Thread.sleep(3000);
		
		try {
			String main1 = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
						
			if (main1.equals("LOGIN")) { 
				TapName("LOGIN");
				TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
				SendKeysXpath("azapekin@splinex.com",
						"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
				TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]");
				SendKeysXpath("s13wasds13",
						"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]");
				TapName("LOGIN");
			}
			
		} catch (Exception e) {
		}
		WaitName("Camera settings");
		WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]");

		String name = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]");
		String status = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[2]");
		System.out.println(name + " - " + status);

		String cloud = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[3]");
		System.out.println("cloud - " + cloud);

		//GetScreenShot("Screenshots/4.jpg");

		TapName("Camera settings");
		
//		TapName("Camera open settings");
//		WaitName("WiFi");
//		WaitXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]");
//		
//		TapName("Back button black");
//		
//		TapName("Day/Night");
//		Thread.sleep(8000);
//		TapName("Back button black");
//		TapName("Side menu button");
//
//		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]");
//		TapName("Cloud");
//
//		String cl_text1 = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAImage[2]/UIAStaticText[1]");
//		String cl_text2 = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAImage[2]/UIAStaticText[2]");
//		String cl_text3 = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAImage[2]/UIAStaticText[3]");
//		String cl_text4 = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAImage[2]/UIAStaticText[4]");
//
//		System.out.println(cl_text1 + " " + cl_text2 + " " + cl_text3 + " "
//				+ cl_text4);

//		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]");
//		TapName("Cloud");
//		TapName("CHANGE");
//		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
//		SendKeysXpath("12",
//				"//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]");
//		TapName("Return");
//
////		String price = GetTextMobXpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[2]");
////		System.out.println(price);
//		TapName("SELECT PLAN");
//		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIATextField[1]");
//		SendKeysXpath(
//				"123",
//				"//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIATextField[1]");
//		TapName("Return");
//		//TapName("SUBMIT");
//
//		
//		
//		TapName("Back button black");
//		WaitName("SELECT PLAN");
//		TapName("Back button black");


		
		TapName("Side menu button");

		TapXpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]");

		int r = 0;
		do {

			TapName("Kudo");

			if (r % 2 == 0) {
				TapName("Camera vr");
			}
			Thread.sleep(42500);
			TapName("Back button black");
			WaitName("Venetian");
			TapName("Venetian");

			if (r % 2 == 0) {
				TapName("Camera vr");
			}
			Thread.sleep(42500);
			TapName("Back button black");
			WaitName("Everglades");
			TapName("Everglades");

			if (r % 2 == 0) {
				TapName("Camera vr");
			}
			Thread.sleep(42500);
			TapName("Back button black");
			WaitName("Baby");
			TapName("Baby");

			Thread.sleep(42500);
			if (r % 2 == 0) {
				TapName("Camera vr");
			}

			TapName("Back button black");
			WaitName("Kids playing");
			TapName("Kids playing");

			Thread.sleep(42500);
			if (r % 2 == 0) {
				TapName("Camera vr");
			}
			TapName("Back button black");
			WaitName("Kids fighting");
			TapName("Kids fighting");

			Thread.sleep(42500);
			if (r % 2 == 0) {
				TapName("Camera vr");
			}
			TapName("Back button black");
			WaitName("Helicopter");
			TapName("Helicopter");

			Thread.sleep(42500);
			if (r % 2 == 0) {
				TapName("Camera vr");
			}
			TapName("Back button black");
			// AccountScreen accountScreen = new AccountScreen(wd);
			// accountScreen.AccountCheck();
			r++;
			System.out.println(r);
		} while (r < 300);



		 wd.quit();

	}}
