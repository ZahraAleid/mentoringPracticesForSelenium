package tests.day05;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.utilities.TestBase;

import java.time.Duration;

public class T03 extends TestBase {

    /*
Go to https://claruswaysda.github.io/deleteChars.html
Enter your full name
Delete the letters
Verify the message 'Deleted'
*/

    @Test
    void test()   {

        Faker faker = new Faker();

        driver.get("https://claruswaysda.github.io/deleteChars.html");
        driver.findElement(By.xpath("//input[@id='inputText']")).sendKeys(faker.name().fullName());
        driver.findElement(By.xpath("//button[@id='enterButton']")).click();

        By deletebtn = By.xpath("//button[@id='deleteButton']");
        By displayText = By.xpath("//div[@id='displayText']");
        By deleteText = By.xpath("//div[@id='deletedMessage']");


        while (!driver.findElement(deleteText).isDisplayed()) {
            driver.findElement(deletebtn).click();

        }

        Assertions.assertEquals("Deleted", driver.findElement(By.xpath("//div[@id='deletedMessage']")).getText());


    }



    }

