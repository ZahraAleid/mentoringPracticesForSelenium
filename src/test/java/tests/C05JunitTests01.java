package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05JunitTests01 {

       /* // Go to YouTube homepage
    // Do the following tasks by creating 4 different test methods. 
    *- Print "Test is running" before each test() method
    *- Print "Test finished" after each test() method
    // Test if the currentURL contains "youtube" 
    // Test if the title does not contain "Video". 
    // Test if the URL contains "youtube". 
    // Test if the sourcePage contains "youtube".*/

    static WebDriver driver;

    @Test
    void urlTest01(){
        System.out.println("CurrentURL contains \"youtube\" test is executed");
        String currentURL = driver.getCurrentUrl();
        Assertions.assertTrue(currentURL.contains("youtube"));
    }

    @Test
    void urlTest02(){
        System.out.println("title doesn't contains \"video\" test is executed");
        String url = driver.getCurrentUrl();
        Assertions.assertFalse(url.contains("Video"));
        //
    }

    @Test
    void titleTest01() {
        System.out.println("title doesn't contains \"video\" test is executed");
        String title = driver.getTitle();
        Assertions.assertFalse(title.contains("Video"));
    }

    @Test
    void pageSourceTest01() {
        System.out.println("Page source contains \"youtube\" test is executed");
        String pageSource = driver.getPageSource();
        Assertions.assertTrue(driver.getPageSource().contains("youtube"));
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Test is running");

    }

    @AfterEach
    void afterEach(){
        System.out.println("Test finished");
    }

    @BeforeAll
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

}
