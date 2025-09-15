package tests.Week4.Day07;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class T02_FileUpload extends TestBase {
        /*
    Go to https://claruswaysda.github.io/downloadUpload.html
    Upload a PDF using single upload button
    Verify that 'Files uploaded successfully!'


    Do negative test (No file or other than PDF)
    Verify that 'Please upload at least one PDF file. Only PDF files are allowed!'
    Test multiple PDFs as well
    */

    @Test
    void test() throws InterruptedException {

        driver.get("https://claruswaysda.github.io/downloadUpload.html");


        Path path1 = Path.of(System.getProperty("user.home"),"Downloads", "sample.pdf");
        Path path2 = Path.of(System.getProperty("user.home"),"Downloads", "prestige.pdf");


        driver.findElement(By.className("upload-btn")).click();

        driver.findElement(By.id("uploadInput")).sendKeys(path1.toString());
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assertions.assertTrue(driver.findElement(By.id("successBox")).isDisplayed());
        Thread.sleep(3000);

        // Negative test
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assertions.assertTrue(driver.findElement(By.id("alertBox")).isDisplayed());
        Thread.sleep(3000);

        // Multiple files
        driver.findElement(By.id("multiUploadInput")).sendKeys(path1.toString() + "\n" + path2.toString());
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assertions.assertTrue(driver.findElement(By.id("successBox")).isDisplayed());
        Thread.sleep(3000);




    }



}
