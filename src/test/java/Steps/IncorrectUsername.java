package Steps;

import Pages.IncorrectUsernamePage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class IncorrectUsername {
    String text = "Your username is invalid!";

    IncorrectUsernamePage IULogin = new IncorrectUsernamePage();

    @Given("Im in the login page")
    public void navigateTheLoginPage() {
        IULogin.navigateTheLoginPage();
    }

    @When("I enter wrong my user")
    public void enterWrongUser() {
        IULogin.enterWrongUser("alfredo");
    }

    @When("I enter my pass")
    public void enterPasswrd() {
        IULogin.enterPasswrd("SuperSecretPassword!");
    }

    @And("click in the login button")
    public void clickLoginBttn() {
        IULogin.clickLoginBttn();
    }

    @Then("I can see an incorrect username message")
    public void incorrectUsernameMessage() {
        Assert.assertTrue("El mensaje no es el que se esperaba", IULogin.incorrectUsernameMessage().contains(text));
    }

}
