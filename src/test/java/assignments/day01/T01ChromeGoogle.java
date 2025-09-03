package assignments.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T01ChromeGoogle {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com");

        String title = driver.getTitle();
        System.out.println("title = " + title);

        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        driver.close();
        driver.quit();
    }
}
