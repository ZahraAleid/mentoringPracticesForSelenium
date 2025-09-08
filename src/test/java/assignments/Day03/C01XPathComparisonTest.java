package assignments.Day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


import java.time.Duration;
public class C01XPathComparisonTest {


    // Navigate to: https://opensource-demo.orangehrmlive.com/
    // TODO: Locate username using absolute XPath
    String absoluteUsernameXPath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"; // Fill absolute path

    // TODO: Locate username using relative XPath
    String relativeUsernameXPath = "//input[@name='username']"; // Fill relative path

    // TODO: Locate password using both methods
    String absolutePasswordXPath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"; // Fill absolute path
    String relativePasswordXPath = "//input[@name='password']"; // Fill relative path

    // TODO: Locate login button using both methods
    String absoluteLoginButtonXPath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"; // Fill absolute path
    String relativeLoginButtonXPath = "//button[@type='submit']"; // Fill relative path

    // TODO: Test both approaches work



    WebDriver driver;

    @Test
    void relativeXpathTest() {

        // Wait for username field
        By relativeUsernameBy = By.xpath(relativeUsernameXPath);
        WebElement usernameField = driver.findElement(relativeUsernameBy);
        usernameField.sendKeys("Admin");
        usernameField.sendKeys(Keys.ENTER);

        // Wait for password field
        By relativePasswordBy = By.xpath(relativePasswordXPath);
        WebElement passwordField = driver.findElement(relativePasswordBy);
        passwordField.sendKeys("admin123");

        // Wait for login button and click
        By loginButtonBy = By.xpath(relativeLoginButtonXPath);
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();


    }

    @Test
    void absoluteXpathTest() {

        // Wait for username field
        By absoluteUsernameBy = By.xpath(absoluteUsernameXPath);
        WebElement usernameField = driver.findElement(absoluteUsernameBy);
        usernameField.sendKeys("Admin");
        usernameField.sendKeys(Keys.ENTER);

        // Wait for password field
        By absolutePasswordBy = By.xpath(absolutePasswordXPath);
        WebElement passwordField = driver.findElement(absolutePasswordBy);
        passwordField.sendKeys("admin123");

        // Wait for login button and click
        By loginButtonBy = By.xpath(absoluteLoginButtonXPath);
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();


    }

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterEach
     void tearDown(){
        driver.quit();
    }
}
