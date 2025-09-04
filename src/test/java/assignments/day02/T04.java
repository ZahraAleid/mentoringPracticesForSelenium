package assignments.day02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T04 {

            /* Task 4: Multiple Navigation and Verification
        Setup:
        Launch Chrome and maximize in @BeforeEach.
        Test 1:
        Navigate Google → YouTube → LinkedIn.
        Assert titles contain "Google", "YouTube", "LinkedIn" respectively.
        Test 2:
        Navigate back twice and assert the URL of Google.
        Navigate forward twice and assert URL of LinkedIn.
        Teardown:
        Use @AfterAll to quit the browser. */

    static WebDriver driver;
    @Test
    void test01(){
        driver.navigate().to("https://www.google.com/");
        Assertions.assertTrue(driver.getTitle().contains("Google"), "Title does not contain 'Google'");
        driver.navigate().to("https://www.youtube.com/");
        Assertions.assertTrue(driver.getTitle().contains("YouTube"), "Title does not contain 'YouTube'");
        driver.navigate().to("https://www.linkedin.com/");
        Assertions.assertTrue(driver.getTitle().contains("LinkedIn"), "Title does not contain 'LinkedIn'");
    }

    @Test
    void test02(){
        driver.navigate().to("https://www.google.com/");
        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().to("https://www.linkedin.com/");
        driver.navigate().back();
        driver.navigate().back();
        Assertions.assertTrue(driver.getCurrentUrl().contains("google"), "URL does not contain 'google'");
        driver.navigate().forward();
        driver.navigate().forward();
        Assertions.assertTrue(driver.getCurrentUrl().contains("linkedin"), "URL does not contain 'linkedin'");
    }


    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

}
