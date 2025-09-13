package assignments.Day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.TestBase;

public class T04_Drwaing extends TestBase {
        /*
    Go to https://claruswaysda.github.io/Draw.html
    Draw a triangle
    Reset
    */

    @Test
    void test01() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/Draw.html");
        Actions actions = new Actions(driver);

        actions
                .moveToElement(driver.findElement(By.xpath("//canvas[@id='myCanvas']")), -50, 50)
                .clickAndHold()
                .moveByOffset(100, 0)
                .moveByOffset(-50, -86)
                .moveByOffset(-50, 86)
                .release()
                .perform();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[.='Reset']")).click();
    }

}
