package assignments.Day05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class T01OldStyleMenu {
    /*
    Launch browser
Open https://demoqa.com/select-menu
Select Old Style Select Menu using element id
Print all dropdown options
Select 'Purple' using index
Select 'Magenta' using visible text
Select an option using value
Close browser
     */


    WebDriver driver;

    @Test
    void test(){
        WebElement oldStyleSelect = driver.findElement(By.id("oldSelectMenu"));
        System.out.println(" Available options = " + oldStyleSelect.getText());

        Select select = new Select(oldStyleSelect);

        select.selectByIndex(4);


        select.selectByVisibleText("Magenta");


        select.selectByValue("6");


    }
    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/select-menu");


    }

    @AfterEach
    void tearDown(){
        //driver.quit();
    }}

