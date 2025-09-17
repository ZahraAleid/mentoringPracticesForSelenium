package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

  /*
        TestBase Class:
        We create this class to avoid repeating the same setup and teardown code
        in every test class. It uses Java’s OOP (Object-Oriented Programming) concept
        of inheritance.

        Key points:

        Reusability:
        Any class that extends TestBase automatically gets access to the driver,
        setup(), and teardown() methods.
        Child classes don’t need to write these methods again.

        Access Modifier:
        TestBase is usually placed in a separate package.
        To allow child classes to use the driver, it must be declared
        as public or protected.
        We choose "protected" since only child classes need it, not external classes.

        Abstract Class:
        We don’t want anyone to create objects of TestBase directly.
        To prevent this, we declare TestBase as abstract.
        Abstract classes can’t be instantiated; they can only be inherited.

        Usage:
        We will extend TestBase in our test classes.
        The driver variable and common methods are inherited,
        which keeps our code shorter, cleaner, and easier to maintain.
        */


public abstract class TestBase2 {

    protected WebDriver driver;
    protected ActionHelper actionHelper;
    protected Logger logger;
    @BeforeEach
    void setUp() {
        logger= LogManager.getLogger(TestBase2.class);
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Chrome browser is initialized...");
        driver.manage().window().maximize();
        actionHelper = new ActionHelper(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        logger.info("Chrome browser is closed ...");
    }
}