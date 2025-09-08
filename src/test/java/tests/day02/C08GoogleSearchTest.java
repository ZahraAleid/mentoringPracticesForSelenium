package tests.day02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C08GoogleSearchTest {

        static WebDriver driver;
        static  String url = "https://www.google.com";

    String[] movies = {"Green Mile", "Premonition", "The Curious Case of Benjamin Button"};

        @BeforeAll
        public static void setUp() {
        // TODO: Initialize static WebDriver
            driver = new ChromeDriver();
        // TODO: Navigate to Google
            driver.get(url);

        }

        @Test
        public void searchMovies() {



            for(String movie : movies) {

        // TODO: Find search box
        By searchBox = By.xpath("//textarea[@id='APjFqb']");


        // TODO: Clear and enter movie name
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(movie);

        // TODO: Submit search
                driver.findElement(searchBox).sendKeys(Keys.ENTER);

//          By submitButton = By.xpath("//*[contains(text(),'Google Search') or contains(text(),'results') or contains(text(), 'About')]");
//            driver.findElement(submitButton).click();

        // TODO: Get and print result count
              String resultStats = driver.findElement(By.id("result-stats")).getText();
              System.out.println("Results for " + movie + ": " + resultStats);
        // TODO: Clear search box for next iteration
                driver.findElement(searchBox).clear();

            }

        }

        @AfterAll
        public static void tearDown() {
    // TODO: Close driver
            driver.close();
        }
    }

