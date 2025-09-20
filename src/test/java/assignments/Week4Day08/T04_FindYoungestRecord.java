package assignments.Week4Day08;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase2;


import java.util.List;

public class T04_FindYoungestRecord extends TestBase2 {

    /*
    Go to https://claruswaysda.github.io/addRecordWebTable.html
    Add 10 records using Faker.
    Find the name of the youngest record.
    */

    @Test
    void name() {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");


        // Add 10 records
        for (int i=0;i<10;i++){
            actionHelper.sendKeys(By.id("nameInput"), Faker.instance().name().firstName());
            actionHelper.sendKeys(By.id("ageInput"),Faker.instance().number().numberBetween(18,50)+"");
            Select select = new Select(actionHelper.findElement(By.id("countrySelect")));
            int idx = Faker.instance().number().numberBetween(1,5);
            try{
                select.selectByIndex(idx);

            }catch (Exception e){
                logger.error("Coulnd'T select by referance with idx :"+idx);
            }
            actionHelper.click(By.xpath("//button[.='Add Record']"));
        }


        //Store the name and age columns in separate arrays (not ArrayList).
        List<WebElement> namesList = driver.findElements(By.xpath("//table//td[1]"));

        String[] namesArr = new String[namesList.size()];
        for (int i=0;i< namesList.size();i++){
            namesArr[i] = namesList.get(i).getText();
        }


        List<WebElement> agesList = driver.findElements(By.xpath("//table//td[2]"));


        String[] agesArr = new String[namesList.size()];

        for (int i=0;i< agesList.size();i++){
            agesArr[i] = agesList.get(i).getText();
        }

        //to find the youngest record
        int min=Integer.parseInt(agesArr[0]);
        int youngestRecord=0;

        for (int i=0;i< agesList.size();i++){
            if (Integer.parseInt(agesArr[i]) < min){
                min = Integer.parseInt(agesArr[i]);
                youngestRecord = i;
            }
        }

        System.out.println("The youngest record's name is: "+ namesArr[youngestRecord] + " his/her age is: "+agesArr[youngestRecord]);





  }


}
