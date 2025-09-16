package tests.Week4.Day08;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class T01_WebTableIntegration extends TestBase {
    List<String> namesArray =  new ArrayList<>();
    List<String> agesArray =  new ArrayList<>();
    List<String> countryArray =  new ArrayList<>();

    @Test
    void tesst() throws IOException {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        FileInputStream fis = new FileInputStream((Path.of(".","resources","Task01.xlsx").toString()));

        Workbook workbook = WorkbookFactory.create(fis);
        fis.close();

        Sheet sheet = workbook.getSheetAt(0);
        int indexOfLastRow = sheet.getLastRowNum();


        for (int i =1 ; i< indexOfLastRow ; i++){
            namesArray.add(sheet.getRow(i).getCell(0).toString());
            agesArray.add(sheet.getRow(i).getCell(1).toString());
            countryArray.add(sheet.getRow(i).getCell(2).toString());

            driver.findElement(By.id("nameInput")).sendKeys(namesArray.get(i));
            driver.findElement(By.id("ageInput")).sendKeys(agesArray.get(i));
            Select select = new Select(driver.findElement(By.id("countrySelect")));
            //select.selectByVisibleText(countryArray.trim());

            driver.findElement(By.xpath("//button[.='Add Record']")).click();


            //Check the code in the comments it should work


            /*
            package mentoring.week03.day3;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class T01WebTableIntegration extends TestBase {

    /*
     Go to
https://claruswaysda.github.io/addRecordWebTable.html and add 10 records to the
 table by taking data (Name, Age, Country) from Excel.
     */
            /*

            Path path = Path.of("./", "resources", "Task01.xlsx");

            @Test
            void test() throws IOException {
                driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
                //locate elements
                WebElement inputName = driver.findElement(By.id("nameInput"));
                WebElement inputAge = driver.findElement(By.id("ageInput"));
                WebElement countrySelect = driver.findElement(By.id("countrySelect"));
                WebElement addButton = driver.findElement(By.xpath("//button[normalize-space()='Add Record']"));
                Select countries = new Select(countrySelect);

                //read excel file
                FileInputStream fis = new FileInputStream(path.toFile());
                Workbook workbook = WorkbookFactory.create(fis);
                Sheet sheet = workbook.getSheet("Sheet1");

                //loop through the rows and get data, then add to the web table
                for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

                    String name = sheet.getRow(i).getCell(0).toString();
                    String age = sheet.getRow(i).getCell(1).toString();
                    String country = sheet.getRow(i).getCell(2).toString();

                    inputName.sendKeys(name);
                    inputAge.sendKeys(age);
                    countries.selectByValue(country);
                    addButton.click();
                }


            }
        }
             */


        }


//        for (int i =0 ; i< indexOfLastRow ; i++){
//            agesArray.add(sheet.getRow(i).getCell(1).toString());
//
//        }
//
//        for (int i =0 ; i< indexOfLastRow ; i++){
//
//        }

        System.out.println("NamesArray = " + namesArray);
        System.out.println("agesArray = " + agesArray);
        System.out.println("countryArray = " + countryArray);

//        for (String s : namesArray) {
//            driver.findElement(By.id("nameInput")).sendKeys(s);
//        }
//
//        for (String s : agesArray) {
//            driver.findElement(By.id("ageInput")).sendKeys(s);
//        }
//
//        Select select = new Select(driver.findElement(By.id("nameInput")));
//        for (String s : countryArray) {
//            select.selectByValue(s);
//        }

        //driver.findElement(By.xpath("//button[.='Add Record']")).click();



    }


}
