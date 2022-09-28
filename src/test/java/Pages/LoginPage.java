package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    public static String path;

    By login = By.linkText("Log in");
    By email = By.xpath("//input[@class='email']");
    By password = By.xpath("//input[@class='password']");
    By submit = By.xpath("//button[@type='submit' and text()='Log in']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() throws IOException {
        path = System.getProperty("user.dir") + "//src//test//java//TestData//Credential.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String emailCell = sheet.getRow(1).getCell(4).getStringCellValue();
        String passwordCell = sheet.getRow(1).getCell(6).getStringCellValue();
        driver.findElement(email).sendKeys("3"+emailCell);
        driver.findElement(password).sendKeys(passwordCell);
        driver.findElement(submit).click();
    }
}
