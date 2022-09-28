package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class UserSearchSteps extends BaseClass {
    @Given("User is on Home page of nopcommerce")
    public void user_is_on_home_page() throws IOException {
        Setup();
    }

    @When("User enter data in search and searching the product")
    public void user_enter_data_in_search_and_searching_the_product()
    {
        pageFactory.getSearchFunctionality().searchingProduct();
    }

    @And("Click on Search button")
    public void click_on_search_button() {
        pageFactory.getSearchFunctionality().clickOnSearchButton();
    }

    @Then("User Verify the search product")
    public void user_verify_the_search_product() {
        pageFactory.getSearchFunctionality().verifySearchedProduct();
    }

    @And("Close browser")
    public void close_browser() {
        close();
    }
}
