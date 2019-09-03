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

public class TestGridIntegration {
	 WebDriver driver;
     String baseURL, nodeURL;

	@BeforeTest
     public void setUp() throws MalformedURLException {
		System.out.println("getClass "+this.getClass());  
		System.out.println("System.getProperty(testSuite) "+System.getProperty("testSuite")); 
		System.out.println("System.getProperty(testSuite) "+System.getProperty("surefire.suiteXmlFiles")); 

		 baseURL = "http://18.219.72.36:9999/eduapp/";
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
         System.out.println("driver.getTitle() "+driver.getTitle()); 
         System.out.println("driver.getTitle().contains(\"EduApp Registration Form\") "+driver.getTitle().contains("EduApp Registration Form")); 
         if (driver.getTitle().contains("EduApp Registration Form")) {
             AssertJUnit.assertTrue( "EduApp Registration Form", true);
         } else {
             AssertJUnit.assertTrue("Failed: EduApp Registration Form",false );
         }

     }

 }

