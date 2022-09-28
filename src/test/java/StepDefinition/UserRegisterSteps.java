package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.Given;
import java.io.IOException;

public class UserRegisterSteps extends BaseClass {

    @Given("User is on Home page")
    public void user_is_on_home_page() throws IOException {
        Setup();
    }
}
