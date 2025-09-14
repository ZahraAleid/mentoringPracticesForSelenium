package tests.Week4.Day06;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class T02_Robot extends TestBase {
        /*
    Go to https://claruswaysda.github.io/downloadUpload.html
    Click on 'Upload'
    Close the opening page using 'CTRL+F4'
    */

@Test
    void T02_Robot() throws AWTException, InterruptedException {

    driver.get("https://claruswaysda.github.io/downloadUpload.html");

   driver.findElement(By.xpath("//label[normalize-space()='Upload']")).click();

//    Point location = button.getLocation();
//    int x = location.getX();
//    int y = location.getY();
//
//    Robot robot = new Robot();
//    robot.mouseMove(x, y);
//    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

    Robot robot = new Robot();

    robot.delay(3000);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_F4);
    robot.keyRelease(KeyEvent.VK_F4);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.delay(3000);



    }
}
