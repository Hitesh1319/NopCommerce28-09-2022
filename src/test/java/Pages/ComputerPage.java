package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class ComputerPage {
    WebDriver driver;
    WebDriverWait wait;

    public static String path;

    By computers = By.linkText("Computers");
    By notebooks = By.linkText("Notebooks");
    By asusNotebook = By.linkText("Asus N551JK-XO076H Laptop");
    By addToCartButton = By.xpath("//button[@type='button' and @id='add-to-cart-button-5']");
    By shoppingCart = By.linkText("Shopping cart");
    By checkout = By.xpath("//button[@id='checkout']");
    By radioInput = By.xpath("//input[@id='termsofservice']");
    By countryBilling = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    By countrySelect = By.xpath("//option[@value='133' and text()='India']");
    By cityInput = By.xpath("//input[@id='BillingNewAddress_City']");
    By address1 = By.xpath("//input[@id='BillingNewAddress_Address1']");
    By address2 = By.xpath("//input[@id='BillingNewAddress_Address2']");
    By postalCode = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    By phoneNumber = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
    By faxNumber = By.xpath("//input[@id='BillingNewAddress_FaxNumber']");
    By continueButton = By.xpath("//button[@onclick='Billing.save()']");
    By shippingMethodContinueButton = By.xpath("//button[@onclick='ShippingMethod.save()']");
    By paymentMethodContinueButton = By.xpath("//button[contains(@class,'payment-method-next-step-button')]");
    By confirmOrderContinueButton = By.xpath("//button[contains(@class,'payment-info-next-step-button')]");
    By checkoutConfirmButton = By.xpath("//button[contains(@class,'confirm-order-next-step-button')]");

    public ComputerPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void computerNotebook() {
        driver.findElement(computers).click();
        driver.findElement(notebooks).click();
        driver.findElement(asusNotebook).click();
        driver.findElement(addToCartButton).click();
        driver.findElement(shoppingCart).click();
    }

    public void checkout() {
        driver.findElement(radioInput).click();
        driver.findElement(checkout).click();
    }

    public void billingAddress() throws IOException {
        path = System.getProperty("user.dir") + "//src//test//java//TestData//Credential.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet2");
        driver.findElement(countryBilling).click();
        driver.findElement(countrySelect).click();
        String cityCell = sheet.getRow(1).getCell(0).getStringCellValue();
        String address1Cell = sheet.getRow(1).getCell(1).getStringCellValue();
        String address2Cell = sheet.getRow(1).getCell(2).getStringCellValue();
        driver.findElement(cityInput).sendKeys(cityCell);
        driver.findElement(address1).sendKeys(address1Cell);
        driver.findElement(address2).sendKeys(address2Cell);
        driver.findElement(postalCode).sendKeys("1234");
        driver.findElement(phoneNumber).sendKeys("0987654321");
        driver.findElement(faxNumber).sendKeys("12345");
        driver.findElement(continueButton).click();
    }

    public void shippingMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(shippingMethodContinueButton));
        driver.findElement(shippingMethodContinueButton).click();
    }

    public void paymentMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodContinueButton));
        driver.findElement(paymentMethodContinueButton).click();
    }

    public void confirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderContinueButton));
        driver.findElement(confirmOrderContinueButton).click();
    }

    public void checkoutConfirm() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutConfirmButton));
        driver.findElement(checkoutConfirmButton).click();
    }

    public void verifyOrderedProduct() {
        boolean isAdminDisplayed = driver.findElement(By.xpath(String.format("//h1", "Thank you"))).isDisplayed();
        Assert.isTrue(isAdminDisplayed, "Order is not verified yet");
    }
}
