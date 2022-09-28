package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class BuyNotebookSteps extends BaseClass {
    @Given("Home Page of NopCommerce")
    public void home_page_of_nopcommerce() throws IOException {
        Setup();
    }
    @When("Adding notebook in cart")
    public void adding_notebook_in_cart() {
        pageFactory.getComputerPage().computerNotebook();
    }

    @And("Checkout the product")
    public void user_click_on_notebook(){
        pageFactory.getComputerPage().checkout();
    }

    @And("Login with valid credential")
    public void login_with_valid_credential() throws IOException {
        pageFactory.getLoginPage().login();
    }

    @And("Checkout the product again")
    public void checkout_the_product_again(){
        pageFactory.getComputerPage().checkout();
    }

    @And("Billing address")
    public void billing_address() throws IOException {
        pageFactory.getComputerPage().billingAddress();
    }

    @And("Shipping method")
    public void shipping_method() {
        pageFactory.getComputerPage().shippingMethod();
    }

    @And("Payment method")
    public void payment_method() {
        pageFactory.getComputerPage().paymentMethod();
    }

    @And("Confirm Order")
    public void confirm_order() {
        pageFactory.getComputerPage().confirmOrder();
    }

    @And("Checkout Confirm")
    public void checkout_confirm() {
        pageFactory.getComputerPage().checkoutConfirm();
    }

    @Then("Verify product")
    public void verify_product() {
        pageFactory.getComputerPage().verifyOrderedProduct();
    }

    @And("Browser close")
    public void browser_close() {
        close();
    }
}
