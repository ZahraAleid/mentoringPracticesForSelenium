package tests.day02;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07Locators {


  static   WebDriver  driver;
  static String testEmail = "tester@test.com";
    static String testPassword = "Tester123?";

       static String url = "https://www.linkedin.com/login";
        @BeforeAll
         static void  setUp() {
// TODO: Initialize WebDriver
            driver = new ChromeDriver();
// TODO: Navigate to LinkedIn
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @Test
        public void testLoginElements() {
// TODO: Locate email field using By.id
            By emaoilFieldById = By.id("username");
// TODO: Locate password field using By.name
            By passWordFieldByName = By.name("session_password");
// TODO: Locate sign-in button using By.xpath
            By signInButtonByXpath = By.xpath("//button[@type='submit']");

// TODO: Enter test credentials
           WebElement emailField = driver.findElement(emaoilFieldById);
           emailField.sendKeys(testEmail);
           WebElement passField = driver.findElement(passWordFieldByName);
           passField.sendKeys(testEmail);

            WebElement signInButton = driver.findElement(signInButtonByXpath);
// TODO: Verify elements are displayed
        Assertions.assertTrue(emailField.isDisplayed());
        Assertions.assertTrue(passField.isDisplayed());
        Assertions.assertTrue(signInButton.isDisplayed());



            signInButton.click();
        }
        @AfterAll
       static public void tearDown() {
            driver.quit();
        }
// TODO: Close driver


        }




