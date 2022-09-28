package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;

    private LoginPage loginPage;
    private RegisterPage registerPage;
    private SearchFunctionality searchFunctionality;
    private ComputerPage computerPage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public RegisterPage getRegisterPage() {
        if (registerPage == null) {
            registerPage = new RegisterPage(driver);
        }
        return registerPage;
    }

    public SearchFunctionality getSearchFunctionality() {
        if (searchFunctionality == null) {
            searchFunctionality = new SearchFunctionality(driver);
        }
        return searchFunctionality;
    }

    public ComputerPage getComputerPage() {
        if (computerPage == null) {
            computerPage = new ComputerPage(driver);
        }
        return computerPage;
    }
}
