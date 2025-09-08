package tests.day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T01ChromeOptionsConfigurationTest {

     /*
    Task: Create a test method that opens a browser with the following configurations:
    Maximize window on startup
    Disable extensions
    Run in incognito mode
    Disable infobars Navigate to "https://www.example.com" and verify the title contains "Example"
     */
    WebDriver driver;

    String url = "https://www.example.com";
    ChromeOptions options = new ChromeOptions();


    @Test
    void test01() {
        options.addArguments("--start-fullscreen");
        options.addArguments("--disable-extensions");
        options.addArguments("--incognito");
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.navigate().to(url);
        String expectedInTitle = "Example";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedInTitle)) {
            System.out.println("Title contains '" + expectedInTitle + "': Test Passed");
        } else {
            System.out.println("Title does not contain '" + expectedInTitle + "': Test Failed");
        }
    }

    @BeforeEach
    void setUp() {


    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


}
