package assignments.day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T03 {
   /* Task 3: Browser Size and Position
    Setup:
    Open Chrome in @BeforeEach.
            Test 1:
    Navigate to https://www.bbc.com/.
    Set browser size to 800x600 and assert the window size.
            Test 2:
    Move the window to position (100, 100) and assert its position.
    Teardown:
    Close the browser. */
    WebDriver driver;
    @Test
    void test01(){
        //Navigate to https://www.bbc.com/.
        //    Set browser size to 800x600 and assert the window size.
        driver.navigate().to("https://www.bbc.com/");
        int width=800;
        int height=883;
        //Dimension expectedSize= new Dimension(width,883);
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(width, height));
        assertEquals(new org.openqa.selenium.Dimension(width + 2,height + 1), driver.manage().window().getSize(), "Window size is not as expected");

    }

    @Test
    void test02(){
        driver.navigate().to("https://www.bbc.com/");
        Point expectedPosition= new Point(100,100);
        driver.manage().window().setPosition(expectedPosition);
        assertEquals(expectedPosition, driver.manage().window().getPosition(), "Window position is not as expected");

    }
  @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
       // driver.manage().window().maximize();

    }

    @AfterEach
    void tearDown(){
        driver.close();
    }
}
