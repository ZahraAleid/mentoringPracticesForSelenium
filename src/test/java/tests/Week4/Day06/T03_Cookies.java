package tests.Week4.Day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoAlertPresentException;
import tests.utilities.TestBase;

import java.util.Set;

public class T03_Cookies extends TestBase {

        /*
    Go to https://claruswaysda.github.io/CookiesWait.html
    Accept the alert if it is present
    Print the cookies
    Delete all cookies and assert
    */

    @Test
    void test() {
        driver.get("https://claruswaysda.github.io/CookiesWait.html");

        try {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            System.out.println("Alert accepted");
        } catch (NoAlertPresentException e) {
            System.out.println("No alert found");
        }

        System.out.println("------------- ALL COKIES ----------------");
        Set<Cookie> cookieSet = driver.manage().getCookies();
        cookieSet.forEach(System.out::println);

        driver.manage().deleteAllCookies();
        System.out.println("---------After all cookies are deleted ----------------");
        driver.manage().getCookies().forEach(System.out::println);
       // Set<Cookie> afterDelete = driver.manage().getCookies();

        Assertions.assertTrue(driver.manage().getCookies().isEmpty(),"Cookies were not deleted!");





    }


}
