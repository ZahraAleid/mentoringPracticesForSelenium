package tests.day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T03RadioButtonSelection {

     /*
    Task: Navigate to "https://demoqa.com/radio-button"
        . Create a test that:

        Attempts to select each radio button (Yes, Impressive, No)
        Prints whether each option is enabled/disabled
        For enabled options, select them and verify selection
        Print confirmation message for each successful selection
    */

    WebDriver driver;

    //String url = "https://demoqa.com/radio-button";
    ChromeOptions options = new ChromeOptions();

    @Test
    void test1() {
        driver.get("http://test.rubywatir.com/radios.php");
         //Prints whether each option is enabled/disabled
        if (driver.findElement(By.xpath("//input[@value='Radio1']")).isEnabled()){
            System.out.println("radio1 radio button is enabled.");

            driver.findElement(By.xpath("//input[@value='Radio1']")).click();
            if (driver.findElement(By.xpath("//input[@value='Radio1']")).isSelected()){
                System.out.println("radio1 radio button is selected.");
            } else {
                System.out.println("radio1 radio button is not selected.");
            }


        } else {
            System.out.println("radio1  radio button is disabled.");
        }

        if (driver.findElement(By.xpath("//input[@value='Nope']")).isEnabled()){
            System.out.println("radio2 radio button is enabled.");
            driver.findElement(By.xpath("//input[@value='Nope']")).click();
            if (driver.findElement(By.xpath("//input[@value='Nope']")).isSelected()){
                System.out.println("radio 2 radio button is selected.");
            } else {
                System.out.println("radio 2 radio button is not selected.");
            }
        } else {
            System.out.println("radio 2 radio button is disabled.");
        }

        if (driver.findElement(By.xpath("//input[@id='radioId']")).isEnabled()){
            System.out.println("radio3 radio button is enabled.");
            driver.findElement(By.xpath("//input[@id='radioId']")).click();
            if (driver.findElement(By.xpath("//input[@id='radioId']")).isSelected()){
                System.out.println("radio3 radio button is selected.");
            } else {
                System.out.println("radio3 radio button is not selected.");
            }



        }

    }
        // Test steps will be implemented here
     @BeforeEach
     void setUp() {
         driver = new ChromeDriver();

     }

    @AfterEach
    void tearDown() {
       // driver.quit();
    }
}
