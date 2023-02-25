package com.cydeo.tests;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelSheetPractice {


    GoogleSearchPage googleSearchPage = new GoogleSearchPage();




    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
    }
    @After
    public void tearDown(){
        Driver.closeDriver();
    }


    @Test
    public void searchOnGoogle() throws IOException {


        String filePath="workbook.xlsx";

        FileInputStream in = new FileInputStream(filePath);

        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheet("search");

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            String input=sheet.getRow(i).getCell(0).toString();

            googleSearchPage.searchBox.sendKeys(input, Keys.ENTER);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
            wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//div[@id='result-stats']"))));

            String result = Driver.getDriver().findElement(By.xpath("//div[@id='result-stats']")).getText();


            XSSFCell resultCell = sheet.getRow(i).getCell(1);
            resultCell.setCellValue(result);
            googleSearchPage.searchBox.clear();

        }

        FileOutputStream out = new FileOutputStream(filePath);

        workbook.write(out);
        in.close();
        out.close();
        workbook.close();

    }


}
