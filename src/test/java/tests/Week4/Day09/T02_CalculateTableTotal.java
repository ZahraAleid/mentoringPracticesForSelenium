package tests.Week4.Day09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase2;

import java.util.List;

public class T02_CalculateTableTotal extends TestBase2 {
    /*
Go to https://claruswaysda.github.io/webTable.html
Calculate and assert the total price in Table 2.
*/

    @Test
    void test() {
        driver.get("https://claruswaysda.github.io/webTable.html");

        List<WebElement> prices = driver.findElements(By.xpath("//table[2]//tr/td[3]"));
        int total = 0;
        for (WebElement t : prices) {
            total += Integer.parseInt(t.getText().substring(1));
        }
        System.out.println("Total: " + total);
        Assertions.assertEquals(2275, total);

    }


}
