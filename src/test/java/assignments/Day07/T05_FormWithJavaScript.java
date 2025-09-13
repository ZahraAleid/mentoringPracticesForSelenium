package assignments.Day07;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.JSUtils;
import tests.utilities.TestBase;

public class T05_FormWithJavaScript extends TestBase {
    /*
        Go to https://claruswaysda.github.io/form.html
        Create a method to flash the elements you are working on and use it.
        Register a user
        Login
        Celebrate the login!
    */

    @Test
    void javaScriptExecutorTest() {

        Faker faker = new Faker();

        driver.get("https://claruswaysda.github.io/form.html");


        WebElement ssn = driver.findElement(By.id("ssn"));
        JSUtils.flash(ssn,driver,"yellow");
        ssn.sendKeys(faker.idNumber().ssnValid());


        WebElement fName = driver.findElement(By.id("first-name"));
        JSUtils.flash(fName,driver,"yellow");
        fName.sendKeys(faker.name().firstName());

        WebElement lName = driver.findElement(By.id("last-name"));
        JSUtils.flash(lName,driver,"yellow");
        lName.sendKeys(faker.name().lastName());

        WebElement address = driver.findElement(By.id("address"));
        JSUtils.flash(address,driver,"yellow");
        address.sendKeys(faker.address().fullAddress());

        WebElement phoneNumber = driver.findElement(By.id("phone"));
        JSUtils.flash(phoneNumber,driver,"yellow");
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone());

        WebElement username = driver.findElement(By.id("username"));
        JSUtils.flash(username,driver,"yellow");
        username.sendKeys(faker.name().username());

        WebElement email = driver.findElement(By.id("email"));
        JSUtils.flash(email,driver,"yellow");
        email.sendKeys(faker.internet().emailAddress());

        WebElement pass = driver.findElement(By.id("password"));
        JSUtils.flash(pass,driver,"yellow");
       String password1 = faker.internet().password();
       pass.sendKeys(password1);

        WebElement repass = driver.findElement(By.id("confirm-password"));
        JSUtils.flash(repass,driver,"yellow");
        repass.sendKeys(password1);


        driver.findElement(By.xpath("//button[@type='submit']")).click();



    }
}