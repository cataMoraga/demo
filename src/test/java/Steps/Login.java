package Steps;

import Pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class Login {
    String text = "You logged into a secure area!";

    LoginPage login = new LoginPage();

    @Given("I am on the login page")
    public void navigateToLoginPage() {
        login.navigateToLoginPage();
    }

    @When("I enter my username")
    public void enterUsername() {
        login.enterUsername("tomsmith");
    }

    @When("I enter my password")
    public void enterPassword() {
        login.enterPassword("SuperSecretPassword!");
    }

    @And("click on the login button")
    public void clickLoginButton() {
        login.clickLoginButton();
    }

    @Then("I enter to my account correctly")
    public void enterToAccount() {
        Assert.assertTrue("El mensaje no es el esperado", login.enterToAccount().contains(text));
    }

    @And("the logout button is visible")
    public void logoutButtonIsVisible() {
        Assert.assertTrue("El botón no es visible" ,login.logoutButtonIsVisible());
    }

}
