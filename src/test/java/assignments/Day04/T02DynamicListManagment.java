package assignments.Day04;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;



public class T02DynamicListManagment {
    /*
    Task:  Go to "http://webdriveruniversity.com/To-Do-List/index.html" and create a test that:

            Uses Faker to generate 5 random task names
            Adds all tasks to the todo list
            Marks every other task as completed (strikethrough)
            Deletes all completed tasks
            Verifies only incomplete tasks remain
    */

    WebDriver driver;
    Faker faker;


    @Test
    void testToDoList()  {

        // Generate and add 5 random tasks
        for (int i = 0; i < 5; i++) {
            //Uses Faker to generate 5 random task names
            String task = faker.lorem().sentence(3);    // Random task name

            // Adds all tasks to the todo list
            WebElement inputBox = driver.findElement(By.xpath("//input[@placeholder='Add new todo']"));
            inputBox.sendKeys(task + Keys.ENTER);
        }

        // Get all tasks
        List<WebElement> tasks = driver.findElements(By.cssSelector("ul li"));




        // Mark every other task as completed
        for (int i = 0; i < tasks.size(); i+=2) {
            tasks.get(i).click();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Delete all completed tasks (strike-through)
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("ul li span i"));
        for (int i = 0; i < tasks.size(); i++) {
            WebElement task = tasks.get(i);
            boolean isCompleted = task.getAttribute("class").contains("completed");
            if (isCompleted) {
                deleteButtons.get(i).click();

                wait.until(ExpectedConditions.stalenessOf(task));
            }
        }


        // Get remaining tasks
        List<WebElement> remainingTasks = driver.findElements(By.cssSelector("ul li"));

        // Verify only incomplete tasks remain
        for (WebElement task : remainingTasks) {
            Assertions.assertFalse(task.getAttribute("class").contains("completed"),
                    "No completed tasks should remain");
        }

    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        faker = new Faker();
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
            driver.quit();
    }

}
