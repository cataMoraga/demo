package Steps;

import Pages.IncorrectPasswordPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class IncorrectPassword {
    String text = "Your password is invalid!";

    IncorrectPasswordPage NLogin = new IncorrectPasswordPage();

    @Given("Im on the login page")
    public void navigateLoginPage() {
        NLogin.navigateLoginPage();
    }

    @When("I enter my user")
    public void enterUser() {
        NLogin.enterUser("tomsmith");
    }

    @When("I enter wrong my password")
    public void enterPass() {
        NLogin.enterPass("password");
    }

    @And("click on login button")
    public void clickLoginBtton() {
        NLogin.clickLoginBtton();
    }

    @Then("I can see an incorrect password message")
    public void incorrectPasswordMessage() {
        Assert.assertTrue("El mensaje no es el que se esperaba", NLogin.incorrectPasswordMessage().contains(text));
    }

}
