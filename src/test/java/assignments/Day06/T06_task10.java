package assignments.Day06;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.utilities.TestBase;

import java.time.Duration;

public class T06_task10  {
        /*
        Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/

    Maximize the website
    Click on the second emoji
    Click on all second emoji items
    Return to the parent iframe
    Fill out the form and press the apply button */

    WebDriver driver;

    @Test
    public void test(){
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        driver.manage().window().maximize();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("emoojis")));

        By secondEmoji = By.xpath("//a[@href='#nature']//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect']");
        WebElement secondEmojiElemnt = wait.until(ExpectedConditions.elementToBeClickable(secondEmoji));
        secondEmojiElemnt.click();

        By allSecondEmojiItems = By.xpath("//div[@id='nature']//div//img");

        for (int i =0 ; i<driver.findElements(allSecondEmojiItems).size(); i++){
            driver.findElements(allSecondEmojiItems).get(i).click();
        }

        driver.switchTo().defaultContent();

        driver.findElement(By.id("text")).sendKeys("Hello");
        driver.findElement(By.id("smiles")).sendKeys("Smile");
        driver.findElement(By.id("nature")).sendKeys("Nature");
        driver.findElement(By.id("food")).sendKeys("Food");
        driver.findElement(By.id("activities")).sendKeys("Activities");
        driver.findElement(By.id("places")).sendKeys("Places");
        driver.findElement(By.id("objects")).sendKeys("Objects");
        driver.findElement(By.id("symbols")).sendKeys("symbols");
        driver.findElement(By.id("flags")).sendKeys("flags");


        driver.findElement(By.id("send")).click();

    }

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
           }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

}
