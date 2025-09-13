package assignments.Day07;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.TestBase;

import java.util.ArrayList;

public class T02_Actions extends TestBase {
    /*
        Go to https://claruswaysda.github.io/submit-button.html
        Click on submit
        Verify link contains 'actionsClickDrag'
        Drag 'Drag me' to 'Drop here'
        Right-click on 'Right-click' me
        Double-click on 'Double-click me'
        Hover on 'Hover over me'
        Verify all actions' success messages.
    */

    @Test
    void actionsTest() {


        driver.get("https://claruswaysda.github.io/submit-button.html");


        driver.findElement(By.id("submitButton")).click();


        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));


        WebElement source = driver.findElement(By.id("drag1"));
        WebElement target = driver.findElement(By.id("drop1"));
        WebElement contextClick = driver.findElement(By.id("showSuccessButton"));
        WebElement doubleClick = driver.findElement(By.id("doubleClickButton"));
        WebElement hover = driver.findElement(By.id("hoverButton"));

        Actions actions = new Actions(driver);
        actions
                .dragAndDrop(source, target)
                .contextClick(contextClick)
                .doubleClick(doubleClick)
                .moveToElement(hover)
                .perform();

         Assertions.assertTrue(driver.findElement(By.xpath("//*[.='Item successfully dropped!']")).isDisplayed());
         Assertions.assertTrue(driver.findElement(By.xpath("//*[.='Button right-clicked!']")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[.='Button double-clicked!']")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[.='Button hovered!']")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.tagName("h2")).getText().contains("Selenium's Actions Class"));

    }

}


