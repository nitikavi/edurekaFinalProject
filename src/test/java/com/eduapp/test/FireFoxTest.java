package com.eduapp.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class FireFoxTest {
  @Test
  public void verifyTitle() {
	  
	  System.setProperty("webdriver.firefox.marionette","geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
  	
      String baseUrl = "http://demo.guru99.com/test/newtours/";
      String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = "";

      // launch Fire fox and direct it to the Base URL
      driver.get(baseUrl);

      // get the actual value of the title
      actualTitle = driver.getTitle();

      /*
       * compare the actual title of the page with the expected one and print
       * the result as "Passed" or "Failed"
       */
     assertEquals(actualTitle, expectedTitle);	
      
      if (actualTitle.contentEquals(expectedTitle)){
          System.out.println("Test Passed and cleared!");
      } else {
          System.out.println("Test Failed");
      }
     
      //close Fire fox
      driver.close();
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
