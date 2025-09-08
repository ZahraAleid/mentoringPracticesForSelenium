package assignments.Day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02SecondAssignment {
    // Url = “https://testpages.herokuapp.com/styled/index.html“
// TODO: Navigate to test pages
// TODO: Click on "Locators - Find By Playground Test Page"
// TODO: Print current URL
// TODO: Navigate back
// TODO: Print URL after going back
// TODO: Click on "WebDriver Example Page"
// TODO: Print current URL
// TODO: Enter value 20 in number input
// TODO: Verify 'two, zero' message appears

    WebDriver driver;

    @Test
    void test(){

        driver.findElement(By.xpath("//a[@id='findbytest']")).click();

        System.out.println("Current URL: " + driver.getCurrentUrl());

        driver.navigate().back();

        System.out.println("URL after going back: " + driver.getCurrentUrl());

        driver.findElement(By.xpath("//a[@id='webdriverexamplepage']")).click();

        System.out.println("Current URL: " + driver.getCurrentUrl());

        driver.findElement(By.xpath("//input[@id='numentry']")).sendKeys("20");

        driver.findElement(By.xpath("//input[@id='submit-to-server']")).click();


        // TODO: Verify 'two, zero' message appears
        WebElement messg = driver.findElement(By.xpath("//p[@id='message']"));
        String actualText = messg.getText();

        Assertions.assertTrue(actualText.contains("two, zero"), "Expected message to contain 'two, zero' but got: " + actualText);
    }
    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");


    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
