package assignments.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T04MaximazeAndMinimize {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com/");

        driver.manage().window().maximize();


        System.out.println("Current Position: " + driver.manage().window().getPosition());
        System.out.println("Current Size =  = " + driver.manage().window().getSize());

        driver.manage().window().minimize();


        Thread.sleep(5000);
        driver.manage().window().maximize();

        System.out.println("Position after maximizing: " + driver.manage().window().getPosition());
        System.out.println("Current after maximizing =  = " + driver.manage().window().getSize());

        driver.manage().window().fullscreen();


        driver.close();


    }
}
