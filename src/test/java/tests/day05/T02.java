package tests.day05;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.utilities.TestBase;

import java.time.Duration;

public class T02 {

    /*
Go to https://claruswaysda.github.io/iframe.html
Type your name in input
Click on 'Bold' button
Assert the alert message
*/

    WebDriver driver;
    Faker faker = new Faker();

    @Test
    void test(){

        driver.get("https://claruswaysda.github.io/iframe.html");
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.xpath("//input[@placeholder='Type here...']")).sendKeys(faker.name().fullName());



        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[.='Bold']")).click();


        Assertions.assertEquals("Bold button clicked", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

    }


    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
