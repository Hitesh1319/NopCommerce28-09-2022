package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SearchFunctionality {
    WebDriver driver;
    WebDriverWait wait;

    By searchField = By.xpath("//input[@id='small-searchterms']");
    By searchSubmitButton = By.xpath("//button[@type='submit']");

    public SearchFunctionality(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchingProduct() {
        driver.findElement(searchField).sendKeys("Apple iCam");
    }

    public void clickOnSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchSubmitButton));
        driver.findElement(searchSubmitButton).click();
    }
    public void verifySearchedProduct() {
        boolean isAdminDisplayed = driver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", "Apple iCam"))).isDisplayed();
        Assert.isTrue(isAdminDisplayed, "Not showing relevant product");
    }
}
