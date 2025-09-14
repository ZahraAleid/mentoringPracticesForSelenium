package assignments.W3Day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class T04_RobotWithNavigationAndFofm extends TestBase {

    /*
     * Open a demo login page (e.g. https://the-internet.herokuapp.com/login).
     * Click into the username field.
     * Type the username using sendKeys.
     * Use the Robot class to:
     * Press Tab → go to password field.
     * Type the password using sendKeys.
     * Press Enter → submit the form.
     * Verify login success or error message.
     */

    @Test
    void test() throws AWTException {

        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.xpath("//label[normalize-space()='Username']/following::input[1]")).sendKeys("tomsmith");


        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        driver.findElement(By.xpath("//label[normalize-space()='Password']/following::input[1]")).sendKeys("SuperSecretPassword!");

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


        //to assert the login was successful
        Assertions.assertTrue(driver.findElement(By.xpath("//a[@href='/logout']")).isDisplayed(), "Login wasn't successful");

    }
}
