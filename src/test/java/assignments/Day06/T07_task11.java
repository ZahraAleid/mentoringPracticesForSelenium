package assignments.Day06;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T07_task11 {
        /*
        Go to URL: http://demo.guru99.com/test/guru99home/
    Find the number of iframes on the page
    Switch to the third iframe (JMeter Made Easy)
    Click the link (https://www.guru99.com/live-selenium-project.html)
    Exit the iframe and return to the main page

     */


    WebDriver driver;

    @Test
    void test(){
        driver.get("http://demo.guru99.com/test/guru99home/");

        // Find the number of iframes on the page
        int iframeCount = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iframes on the page: " + iframeCount);

        // Switch to the second iframe
        driver.switchTo().frame(1);

        // Click the link inside the iframe
        driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']")).click();

        // Exit the iframe and return to the main page
        driver.switchTo().defaultContent();
    }
    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
