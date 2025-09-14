package tests.Week4.Day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

import java.util.List;

public class T01_JScriptExecutor extends TestBase {


    /*
        Go to https://claruswaysda.github.io/signIn.html
        enter username 'admin'
        enter password '123'
        Click on Sign In
        Assert the 'Employee Table' is visible
        Create a method to change border color and style of web elements.
        Use the method on each element you interact with.
    */

    @Test
    void test(){
        driver.get("https://claruswaysda.github.io/signIn.html");

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebElement table =driver.findElement(By.xpath("//table[@id='employeeTable']"));
        Assertions.assertTrue(table.isDisplayed());


        highlightElement(table, "3px dotted green");


        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='employeeTable']//tr"));
        for (WebElement row : rows) {
            flashElement(row);
        }

    }


    public void highlightElement(WebElement table, String borderStyle) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='" + borderStyle + "'", table);

    }


    public  void flashElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 1; i++) {
            js.executeScript("arguments[0].style.border='3px solid red'", element);
            try { Thread.sleep(200); } catch (InterruptedException e) {}
            js.executeScript("arguments[0].style.border=''", element);
            try { Thread.sleep(200); } catch (InterruptedException e) {}
        }
    }


}
