package assignments.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T02FirefoxYoutube {
    public static void main(String[] args) {


        WebDriver driver = new FirefoxDriver();


        driver.navigate().to("https://www.youtube.com/");


        String currentTitle = driver.getTitle();
        String expectedInTitle = "video";
        if (currentTitle.toLowerCase().contains(expectedInTitle.toLowerCase())){
            System.out.println("Title Test PASSED");
        } else {
            System.out.println("Title Test FAILED");
            System.out.println("Actual Title: " + currentTitle);
            System.out.println("Expected to contain: " + expectedInTitle);
        }


        driver.close();
    }
}
