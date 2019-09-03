package com.eduapp.test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestGridRegression {
	 WebDriver driver;
     String baseURL, nodeURL;

	@BeforeTest
     public void setUp() throws MalformedURLException {
         baseURL = "http://yahoo.com";
         nodeURL = "http://3.17.73.82:4444/wd/hub";
         DesiredCapabilities capability = DesiredCapabilities.chrome();
         capability.setBrowserName("chrome");
         capability.setPlatform(Platform.LINUX);
         driver = new RemoteWebDriver(new URL(nodeURL), capability);
     }

     @AfterTest
     public void afterTest() {
         driver.quit();
     }
     @Test
     public void sampleTest() {
         driver.get(baseURL);
         

         if (driver.getPageSource().contains("MOBILE TESTING")) {
             AssertJUnit.assertTrue( "Mobile Testing Link Found", true);
         } else {
             AssertJUnit.assertTrue("Failed: Link not found",false );
         }

     }

 }

