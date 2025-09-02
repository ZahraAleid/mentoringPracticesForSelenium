package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02WindowsComments {
    public static void main(String[] args) throws InterruptedException {
        /* TC - 02

     Go to www.yahoo.com 
     Maximize Window 
     Go to www.amazon.com 
     Maximize Window 
     Navigate Back
     Navigate Forward
     Refresh The Page  */

        WebDriver driver = new ChromeDriver();


        // Go to www.yahoo.com 
        driver.navigate().to("https://www.LinkedIn.com");
        Thread.sleep(1000);

        // Maximize Window 
        driver.manage().window().maximize();
        Thread.sleep(1000);

        // Go to www.amazon.com 

        // Maximize Window 
        driver.navigate().to("https://www.LinkedIn.com");
        // Navigate Back
        driver.navigate().back();

        // Navigate Forward
        driver.navigate().forward();

        // Refresh The Page
        driver.navigate().refresh();

        driver.quit();


    }

}
