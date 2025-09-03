package assignments.day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T02 {
    /*
        Task 2: Page Source Validation
    Setup:
    Use @BeforeEach to open Chrome and maximize.
    Test 1:
    Navigate to https://www.selenium.dev/.
    Verify that the page source contains the word "WebDriver".
    Test 2:
    Navigate to https://www.python.org/.
    Assert the page source contains "Python".
    Teardown:
    Close the browser with @AfterEach.
     */
    WebDriver driver;

    @Test
    void test01(){
        driver.navigate().to("https://www.selenium.dev/");
        Assertions.assertTrue(driver.getPageSource().contains("WebDriver"), "Page source does not contain 'WebDriver'");
    }

    @Test
    void test02(){
        driver.navigate().to("https://www.python.org/");
        Assertions.assertTrue(driver.getPageSource().contains("Python"), "Page source does not contain 'Python'");
    }

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterEach
    void tearDown(){
        driver.close();
    }
}
