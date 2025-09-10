package tests.day05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class T01 {
    /*
    Go to https://claruswaysda.github.io/ActionsForm.html
Fill the form
Generate Passcode
Use passcode to submit form
     */

    WebDriver driver;

    @Test
    void test01() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/ActionsForm.html");

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Zahra");
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("23");

        Select select = new   Select(driver.findElement(By.xpath("//select[@id='options']")));
        select.selectByValue("it");

        driver.findElement(By.xpath("//input[@value='coding']")).click();
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.xpath("//button[@type='button']")).click();

        String alertPassword = driver.switchTo().alert().getText();
        System.out.println("password = " + alertPassword);


        String password = alertPassword.substring(alertPassword.indexOf(":") + 1).trim();
        System.out.println("Extracted password = " + password);
        driver.switchTo().alert().accept();


        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys(password);
        prompt.accept();

        driver.switchTo().frame("iframeSubmit");
        driver.findElement(By.xpath("//button[@id='submitButton']")).click();


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
