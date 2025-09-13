package assignments.Day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.TestBase;

public class T03_DragAndDrop extends TestBase {

    /*
Go to https://claruswaysda.github.io/dragAndDrop.html
Drag the items in their right places
Assert the success message
*/
    @Test
    void test() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/dragAndDrop.html");

        Actions actions = new Actions(driver);


        actions.dragAndDrop(driver.findElement(By.id("piece1")), driver.findElement(By.id("slot1"))).perform();
        Thread.sleep(2000);
        actions.dragAndDrop(driver.findElement(By.id("piece2")), driver.findElement(By.id("slot2"))).perform();
        Thread.sleep(2000);
        actions.dragAndDrop(driver.findElement(By.id("piece3")), driver.findElement(By.id("slot3"))).perform();
        Thread.sleep(2000);


        String expectedMessage = "Congratulations!";
        String actualMessage = driver.findElement(By.xpath("//div[@id='celebrate']")).getText();

        assert actualMessage.equals(expectedMessage) : "Test failed: expected '" + expectedMessage + "', but got '" + actualMessage + "'";
    }

}
