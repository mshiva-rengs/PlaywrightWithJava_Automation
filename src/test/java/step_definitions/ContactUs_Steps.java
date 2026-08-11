package step_definitions;

import browser.BrowserManager;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.*;
import net.datafaker.Faker;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class ContactUs_Steps {

    public BrowserManager browserManager;
    private final Faker faker = new Faker();
    private final String randomFirstName = faker.name().firstName();
    private final String randomLastName = faker.name().lastName();


    public ContactUs_Steps(BrowserManager browserManager) {

        this.browserManager = browserManager;


    }

    @And("I type a first name")
    public void i_type_a_first_name() {

        browserManager.page.getByPlaceholder("First Name").fill("Mpho");
    }

    @And("I type a last name")
    public void i_type_a_last_name() {

        browserManager.page.getByPlaceholder("Last Name").fill("Mogashwa");
    }

    @And("I enter an email address")
    public void i_enter_an_email_address() {
        browserManager.page.getByPlaceholder("Email Address").fill("mc.mogashwa@gmail.co.za");

    }

    @And("I type a comment")
    public void i_type_a_comment() {
        browserManager.page.getByPlaceholder("Comments").fill("mshiva-rengs has no activity yet for this period.");
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
        assertTrue(browserManager.page.getByText("Thank You for your Message!").isVisible());

    }


    // cucumber expressions

    @And("I type a specific first name {string}")
    public void i_type_a_specific_first_name(String firstName) {
        browserManager.page.getByPlaceholder("First Name").fill(firstName);

    }

    @And("I type a specific last name {string}")
    public void i_type_a_specific_last_name(String lastName) {
        browserManager.page.getByPlaceholder("Last Name").fill(lastName);
    }

    @And("I enter a specific email address {string}")
    public void i_enter_a_specific_email_address(String emailAddress) {
        browserManager.page.getByPlaceholder("Email Address").fill(emailAddress);

    }

    @And("I type a specific text {string} and a number within the comment input field")
    public void i_type_a_specific_text_and_a_number_within_the_comment_input_field(String Word) {
        browserManager.page.getByPlaceholder("Comments").fill(Word);
        System.out.println("Comment: " + Word);

    }

    //Random fakers
    @And("I type a random first name")
    public void i_type_a_random_first_name() {
        String randomFirstName = faker.name().firstName();
        browserManager.page.getByPlaceholder("First Name").fill(randomFirstName);
    }

    @And("I type a random last name")
    public void i_type_a_random_last_name() {
        String randomLastName = faker.name().lastName();
        browserManager.page.getByPlaceholder("Last Name").fill(randomLastName);

    }

    @And("I enter an random email address")
    public void i_enter_an_random_email_address() {
        String randomEmail = faker.internet().emailAddress();
        browserManager.page.getByPlaceholder("Email Address").fill(randomEmail);
        System.out.println("Random Email: " + randomEmail);
    }

    // Scenario outline structure

    @When("I type a first name {word} and a last name {word}")
    public void i_type_a_first_name_mingas_and_a_last_name_makola(String FirstName, String lastName) {
        browserManager.page.getByPlaceholder("First Name").fill(FirstName);
        browserManager.page.getByPlaceholder("Last Name").fill(lastName);
    }

    @When("I type an email address {string} and a comment {string}")
    public void i_type_an_email_address_and_a_comment(String emailAddress, String comment) {
        browserManager.page.getByPlaceholder("Email Address").fill(emailAddress);
        browserManager.page.getByPlaceholder("Comments").fill(comment);
    }


    @Then("I should be presented with a header text {string}")
    public void i_should_be_presented_with_a_header_text(String message) {
        assertTrue(browserManager.page.getByText(message).isVisible());
    }
}
