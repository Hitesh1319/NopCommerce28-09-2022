package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class UserRegisterSteps extends BaseClass {

    @Given("User is on Home page")
    public void user_is_on_home_page() throws IOException {
        Setup();
    }

    @When("User click on Register link")
    public void user_click_on_register_link() {
        pageFactory.getRegisterPage().clickOnRegister();
    }

    @And("User enter data on fields")
    public void user_enter_data_on_fields() throws IOException {
        pageFactory.getRegisterPage().registeringUser();
    }

    @And("User click on the register button")
    public void user_click_on_the_register_button() {
        pageFactory.getRegisterPage().clickOnRegisterButton();
    }

    @Then("Verify the registration")
    public void verify_the_registration() {
        pageFactory.getRegisterPage().verifiRegisterUser();
    }

    @And("Close the Browser")
    public void close_the_browser() {
        close();
    }
}