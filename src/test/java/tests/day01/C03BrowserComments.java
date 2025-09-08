package tests.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03BrowserComments {
    public static void main(String[] args) {
            // TC – 03

    // Expected Title 
        String expectedTitle = "LinkedIn";
    // Set Path of the Chrome driver 

    // Launch Chrome browser 
        WebDriver driver = new ChromeDriver();

    // Open URL of Website 
        driver.navigate().to("https://www.LinkedIn.com");
    // Maximize Window 
        driver.manage().window().maximize();

    // Get Title of current Page 
        String actualTitle = driver.getTitle();

    // Validate/Compare Page Title 

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title Test PASSED");
        } else {
            System.out.println("Title Test FAILED");
            System.out.println("Actual Title: " + actualTitle);
            System.out.println("Expected Title: " + expectedTitle);
        }
    // Close Browser
        driver.quit();
    }
}
