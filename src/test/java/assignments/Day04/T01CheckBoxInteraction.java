package assignments.Day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T01CheckBoxInteraction {


    /*
    Task: Go to "https://the-internet.herokuapp.com/checkboxes"
.   Write a method that:

    Checks the current state of both checkboxes
    Ensures both checkboxes are selected (click only if not already selected)
    Verify both checkboxes are checked after the operations
    Print the status of each checkbox to console */

    WebDriver driver;
    String url = "https://the-internet.herokuapp.com/checkboxes";

    @Test
    void test() {
        driver.get(url);

        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        System.out.println("Initial state:");
        System.out.println("Checkbox 1 selected? " + checkbox1.isSelected());
        System.out.println("Checkbox 2 selected? " + checkbox2.isSelected());


        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }


        Assertions.assertTrue(checkbox1.isSelected(), "Checkbox 1 should be selected");
        Assertions.assertTrue(checkbox2.isSelected(), "Checkbox 2 should be selected");


        System.out.println("Final state:");
        System.out.println("Checkbox 1 selected? " + checkbox1.isSelected());
        System.out.println("Checkbox 2 selected? " + checkbox2.isSelected());
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
