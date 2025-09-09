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

public class T02MultiSelectMenu {
    /*
        Launch browser
    Open https://demoqa.com/select-menu
    Select Standard Multi-Select using element id
    Verify element is multi-select
    Select 'Opel' using index, then deselect using index
    Select 'Saab' using value, then deselect using value
    Deselect all options
    Close browser
         */
    WebDriver driver;

    @Test
    void test(){
        WebElement multiSelectMenu = driver.findElement(By.id("cars"));

        Select multiSelect = new Select(multiSelectMenu);

        if (multiSelect.isMultiple()) {
            System.out.println("Element is a multi-select dropdown");
        } else {
            System.out.println("Element is NOT a multi-select dropdown");
        }

        multiSelect.selectByIndex(3);
        multiSelect.deselectByIndex(3);

        multiSelect.selectByValue("saab");
        multiSelect.deselectByValue("saab");

        multiSelect.deselectAll();


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
        driver.quit();
    }
}
