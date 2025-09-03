package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04GetAndAdjustScreenSize {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

     /*    TC - 04


     Go to the w3school URL : https://www.w3schools.com/ 
     Print the position and size of the page. 
     Adjust the position and size of the page as desired. 
     Test that the page is in the position and size you want. // Close the page.

     */




    // Go to the w3school URL : https://www.w3schools.com/ 
        driver.navigate().to("https://www.w3schools.com/");

    // Print the position and size of the page. 
        System.out.println("Position of the page: " + driver.manage().window().getPosition());
        System.out.println("Size of the page: " + driver.manage().window().getSize());

    // Adjust the position and size of the page as desired. 
        Point expectedPosition= new Point(100,50);
        Dimension expectedSize= new Dimension(800,600);

        driver.manage().window().setPosition(expectedPosition);
        driver.manage().window().setSize(expectedSize);

    // Test that the page is in the position and size you want. // Close the page.
        Point actualPosition = driver.manage().window().getPosition();
        Dimension actualSize = driver.manage().window().getSize();

        if (actualSize.equals(expectedSize)&& actualPosition.equals(expectedPosition)){
            System.out.println("Size and Position Test PASSED");
        } else {
            System.out.println("Size and Position Test FAILED");
            System.out.println("Actual Position: " + actualPosition);
            System.out.println("Expected Position: " + expectedPosition);
            System.out.println("Actual Size: " + actualSize);
            System.out.println("Expected Size: " + expectedSize);
        }


        driver.quit();


    }
}
