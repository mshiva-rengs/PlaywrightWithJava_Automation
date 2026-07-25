package step_definitions;

import browser.BrowserManager;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.*;

import java.awt.*;

public class ContactUs_Steps {

public BrowserManager browserManager;

    public ContactUs_Steps(BrowserManager browserManager) {

        this.browserManager = browserManager;


    }
    @And("I type a first name")
    public void i_type_a_first_name() {

        browserManager.page.getByPlaceholder("First Name").fill("Mpho");
    }
    @And("I type a last name")
    public void i_type_a_last_name() {

        browserManager.page.getByPlaceholder("Last Name"). fill("Mogashwa");
    }
    @And("I enter an email address")
    public void i_enter_an_email_address() {
        browserManager.page.getByPlaceholder("Email Address"). fill("mc.mogashwa@gmail.co.za");

    }
    @And("I type a comment")
    public void i_type_a_comment() {
        browserManager.page.getByPlaceholder("Comments"). fill("mshiva-rengs has no activity yet for this period.");
    }
    @And("I click on the submit button")
    public void I_click_on_the_submit_button() {
        browserManager.page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("SUBMIT")
        ).click();
    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        assert browserManager.page.getByText("Thank You for your Message!").isVisible();


    }

    @Then("I should be presented with a unsuccessful contact us submission message")
    public void i_should_be_presented_with_a_unsuccessful_contact_us_submission_message() {
        assert browserManager.page.getByText("body").textContent().contains(" Error: all fields are required");


    }
}
