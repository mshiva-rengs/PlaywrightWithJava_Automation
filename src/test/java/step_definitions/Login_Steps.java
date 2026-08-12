package step_definitions;

import browser.BrowserManager;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Login_Steps {

    public BrowserManager browserManager;
    private String loginMessage;

    public Login_Steps(BrowserManager browserManager) {

        this.browserManager = browserManager;

    }

    @And("I click on the login portal button")
    public void i_click_on_the_login_portal_button() {

        Page loginPage = browserManager.context.waitForPage(() -> {
            browserManager.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("LOGIN PORTAL")).click();

        });
        browserManager.page = loginPage;
        System.out.println("login selected");
    }

    @When("I type a username")
    public void i_type_a_username() {
        browserManager.page.getByPlaceholder("Username").click();
        browserManager.page.getByPlaceholder("Username").fill("webdriver");
    }

    @And("I type a password")
    public void i_type_a_password() {
        browserManager.page.getByPlaceholder("Password").click();
        browserManager.page.getByPlaceholder("Password").fill("webdriver123");
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {

        browserManager.page.onceDialog(dialog -> {
            loginMessage = dialog.message();
            System.out.println("Login popup: " + loginMessage);
            dialog.accept();
        });
        browserManager.page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Login")
        ).click();
    }

    @Then("I should be presented with a successful login message")
    public void i_should_be_presented_with_a_successful_login_message() {
        assertTrue(
                "Expected login success message but received: " + loginMessage,
                "validation succeeded".equals(loginMessage)
        );
    }

    @When("I type an invalid username")
    public void i_type_an_invalid_username() {
        browserManager.page.getByPlaceholder("Username").click();
        browserManager.page.getByPlaceholder("Username").fill("webdrivers");
    }

    @Then("I should be presented with an error message")
    public void i_should_be_presented_with_an_error_message() {
        assertTrue(
                "Expected login failure message but received: " + loginMessage,
                "validation failed".equals(loginMessage)
        );
    }

    //scenario outline

    @When("I type a username {word}")
    public void i_type_a_username_webdriver(String username) {

        browserManager.page.getByPlaceholder("username").fill(username);
    }

    @And("I type a password {word}")
    public void i_type_a_password_webdriver123(String password) {
        browserManager.page.getByPlaceholder("password").fill(password);
    }

    @Then("I should be presented with a login message {string}")
    public void i_should_be_presented_with_a_login_message(String alertMessage) {

        assertEquals(
                alertMessage,
                loginMessage,
                "Expected login message: " + alertMessage +
                        " but received: " + loginMessage
        );
    }


}


