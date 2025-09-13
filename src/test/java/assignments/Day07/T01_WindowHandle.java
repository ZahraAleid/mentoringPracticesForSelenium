package assignments.Day07;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T01_WindowHandle extends TestBase {

/*
    Go to https://claruswaysda.github.io/
    Click on Window Handle
    Click on 'Open Index Page'
    Verify the link 'https://claruswaysda.github.io/index.html'
*/

    @Test
    void windowHandleTest()  {


        driver.get("https://claruswaysda.github.io/");


        driver.findElement(By.linkText("Window Handle")).click();


        Set<String> wHandles = driver.getWindowHandles();
        List<String> windowHandles = new ArrayList<>(wHandles);
        driver.switchTo().window(windowHandles.get(1));

        driver.findElement(By.id("openIndex")).click();
        windowHandles = new ArrayList<>(driver.getWindowHandles());


        driver.switchTo().window(windowHandles.get(2));
        assertEquals("https://claruswaysda.github.io/index.html", driver.getCurrentUrl());

    }

}