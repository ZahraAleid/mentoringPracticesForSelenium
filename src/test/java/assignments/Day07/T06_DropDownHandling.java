package assignments.Day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tests.utilities.TestBase;

public class T06_DropDownHandling extends TestBase {
       /*
Go to https://claruswaysda.github.io/Dropdowns.html
In 1. Traditional Dropdown select 'Ford'
In 2. Multi-Select Dropdown select 'Mercedes'
In 3. Custom Dropdown (Bootstrap-like) select 'BMW'
In 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
In 5. Dynamic Auto-Suggest Dropdown select 'Toyota'
*/

    @Test
    void test() {
        driver.get("https://claruswaysda.github.io/Dropdowns.html");

        //In 1. Traditional Dropdown select 'Ford'
        Select traditionalDropdown = new Select(driver.findElement(By.xpath("//select[@id='carSelect']")));
        traditionalDropdown.selectByValue("Ford");

        //In 2. Multi-Select Dropdown select 'Mercedes'
        Select multiSelectDropdown = new Select(driver.findElement(By.xpath("//select[@id='multiCarSelect']")));
        multiSelectDropdown.selectByVisibleText("Mercedes");

        //In 3. Custom Dropdown (Bootstrap-like) select 'BMW'
        WebElement customDropdown = driver.findElement(By.xpath("//div[@id='customDropdown']"));
        customDropdown.click();
        driver.findElement(By.xpath("//div[@id='customList']//div[.='BMW']")).click();

        //In 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
        WebElement staticAutoSuggest = driver.findElement(By.xpath("//input[@id='staticInput']"));
        staticAutoSuggest.sendKeys("Tesla Model 3");
        driver.findElement(By.xpath("//div[@id='staticSuggestions']//div[.='Tesla Model 3']")).click();

        //In 5. Dynamic Auto-Suggest Dropdown select 'Toyota'
        WebElement dynamicAutoSuggest = driver.findElement(By.xpath("//input[@id='dynamicInput']"));
        dynamicAutoSuggest.sendKeys("Toyota");
        driver.findElement(By.xpath("//div[@id='dynamicSuggestions']//div[.='Toyota']")).click();




    }

}