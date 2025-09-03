package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06JunitTest02 {

    // Go to google homepage
// Do the following tasks by creating 3 different test methods.
// Print "Tests are starting to run" before each test() method
// Print "Tests have finished running" after each test() method
// Test if the title is the same when the page window is maximize and minimize
// Test if the title does not contain "Video" when the page window is fullscreen
// Test if the URL contains "google"

    WebDriver driver;
    String url = "https://www.google.com";

    @Test
    void test01(){
        String titleMaximized;
        String titleMinimized;

        driver.manage().window().maximize();
        titleMaximized =driver.getTitle();
        System.out.println("titleMaximized = " + titleMaximized);

        driver.manage().window().minimize();
        titleMinimized = driver.getTitle();
        System.out.println("titleMinimized = " + titleMinimized);

        Assertions.assertEquals(titleMaximized, titleMinimized,"Titles are not the same") ;



    }

    @Test
    void test02(){
        driver.manage().window().fullscreen();

        String title = driver.getTitle();
        System.out.println("title = " + title);

        Assertions.assertFalse(title.contains("Video"),"Title contains 'Video'");
    }

    @Test
    void test03(){
        Assertions.assertTrue(driver.getCurrentUrl().contains("google"),"URL does not contain 'google'");
    }


    @BeforeEach
    void setUp(){
        System.out.println("new test is executed");
        driver = new ChromeDriver();
        driver.get(url);

    }

    @AfterEach
    void tearDown(){
        System.out.println("Test finished");
        driver.quit();
    }

}
