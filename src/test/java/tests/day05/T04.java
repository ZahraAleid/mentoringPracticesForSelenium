package tests.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

import java.util.List;

public class T04 extends TestBase {
   /* Go to https://claruswaysda.github.io/addDeleteStar.html
    Create a method to add given number of stars
    Create a method to delete given numbers of stars
    Create a method to verify the given number of stars deleted */

    @Test
    void test(){
        int numberOfStarsToAdd = 20;
        int numberOfStarsToDelete = 6;

        driver.get("https://claruswaysda.github.io/addDeleteStar.html");

        addStars(numberOfStarsToAdd);
        deleteStars(numberOfStarsToDelete);
        verifyStarsDeleted(numberOfStarsToAdd - numberOfStarsToDelete);
    }

    void addStars(int count) {
        for (int i = 0; i < count; i++) {
            driver.findElement(By.id("push-button")).click();
        }
    }

    void deleteStars(int count) {
        for (int i = 0; i < count; i++) {
            driver.findElement(By.id("delete-button")).click();
        }
    }

    void verifyStarsDeleted(int expectedCount) {
        int actualCount = driver.findElements(By.className("star")).size();
        Assertions.assertEquals(expectedCount, actualCount);

    }

}
