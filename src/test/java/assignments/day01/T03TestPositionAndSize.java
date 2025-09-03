package assignments.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T03TestPositionAndSize {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.amazon.com/");



        System.out.println("Current Position: " + driver.manage().window().getPosition());
        System.out.println("Current Size =  = " + driver.manage().window().getSize());

        Point expectedPosition= new Point(120,40);
        Dimension expectedSize= new Dimension(800,600);
        driver.manage().window().setPosition(expectedPosition);
        driver.manage().window().setSize(expectedSize);



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

        driver.close();

    }
}
