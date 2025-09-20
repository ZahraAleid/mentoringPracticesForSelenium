package assignments.Week4Day08;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class T03_ExportTableToExcel extends TestBase {
        /*
    Go to https://claruswaysda.github.io/webTable.html
    Write the entire Table 1 to a new Excel sheet.
    */

    private static final Path RESOURCES = Path.of(System.getProperty("user.dir"),"resources");

    @Test
    void test(){
        driver.get("https://claruswaysda.github.io/webTable.html");

        Workbook workBook;

        Path filePath = RESOURCES.resolve("T03_ExportTable.xlsx");

        if (filePath.toFile().exists()) {
            try (FileInputStream fis = new FileInputStream(filePath.toFile())) {
                workBook = WorkbookFactory.create(fis);
            } catch (IOException e) {
                throw new RuntimeException("Failed to open existing Excel file", e);
            }
        } else {
            workBook = new XSSFWorkbook();
        }


        Sheet sheet = workBook.createSheet("New Sheet");


        List<WebElement> rowsList = driver.findElements(By.xpath("//table[1]//tr"));


        int rowCount =0;
        for (WebElement row: rowsList){
            List<WebElement> tdList =row.findElements(By.xpath(".//th | .//td"));

            Row ExcelRow = sheet.createRow(rowCount);

            int cellCount =0;
            for (WebElement data:tdList){
                ExcelRow.createCell(cellCount).setCellValue(data.getText());
                cellCount++;
            }
            rowCount++;
        }



        try (FileOutputStream fos = new FileOutputStream(filePath.toFile())) {
            workBook.write(fos);
            workBook.close(); // always close to free resources
            System.out.println("Excel file saved at: " + filePath.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to save Excel file", e);
        }

    }

}
