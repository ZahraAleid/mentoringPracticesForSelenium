package assignments.day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class T01 {

    /*

    Task 1: Browser History Exploration
Setup:
Use @BeforeEach to launch Chrome and maximize.
Test 1:
Navigate to https://www.wikipedia.org/.
Navigate to https://www.google.com/.
Navigate back and forward multiple times, asserting the correct title at each step.
Test 2:
Use driver.navigate().refresh() on Google and assert the title still contains "Google".
Teardown:
Use @AfterEach to close the browser.
     */
    WebDriver driver;

    @Test
    void test01(){
        driver.navigate().to("https://www.wikipedia.org/");
        Assertions.assertEquals("Wikipedia", driver.getTitle(), "Title is not as expected for Wikipedia");
        driver.navigate().to("https://www.google.com/");
        Assertions.assertEquals("Google", driver.getTitle(), "Title is not as expected for Wikipedia");
        driver.navigate().back();
        Assertions.assertEquals("Wikipedia", driver.getTitle(), "Title is not as expected for Wikipedia");
        driver.navigate().forward();
        Assertions.assertEquals("Google", driver.getTitle(), "Title is not as expected for Wikipedia");
        driver.navigate().back();
        Assertions.assertEquals("Wikipedia", driver.getTitle(), "Title is not as expected for Wikipedia");
        driver.navigate().forward();
        Assertions.assertEquals("Google", driver.getTitle(), "Title is not as expected for Wikipedia");
    }

    @Test
    void test02(){
        driver.navigate().to("https://www.google.com/");
        driver.navigate().refresh();
        Assertions.assertTrue(driver.getTitle().contains("Google"), "Title does not contain 'Google' after refresh");
    }
    @BeforeEach
    void setUp(){
        System.out.println("Tests are starting to run");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown(){
        System.out.println("Tests have finished running");
        driver.close();
    }
}
