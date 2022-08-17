package Pages;

public class IncorrectUsernamePage extends BasePage {
    private String LoginButton = "//body/div[2]/div[1]/div[1]/form[1]/button[1]";
    private String Username = "//input[@id='username']";
    private String Password = "//input[@id='password']";
    private String confirmationMessage = "//div[@id='flash']";

    public IncorrectUsernamePage() {
        super(driver);
    }

    public void navigateTheLoginPage() {
        navigateTo("https://the-internet.herokuapp.com/login");
    }

    public void enterWrongUser(String criteria) {
        write(Username, criteria);
    }

    public void enterPasswrd(String criteria) {
        write(Password, criteria);
    }

    public void clickLoginBttn() {
        clickElement(LoginButton);
    }

    public String incorrectUsernameMessage(){
        return textFromElement(confirmationMessage);
    }

}
