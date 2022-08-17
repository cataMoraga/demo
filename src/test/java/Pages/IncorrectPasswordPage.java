package Pages;

public class IncorrectPasswordPage extends BasePage {
    private String LoginButton = "//body/div[2]/div[1]/div[1]/form[1]/button[1]";
    private String Username = "//input[@id='username']";
    private String Password = "//input[@id='password']";
    private String confirmationMessage = "//div[@id='flash']";

    public IncorrectPasswordPage() {
        super(driver);
    }

    public void navigateLoginPage() {
        navigateTo("https://the-internet.herokuapp.com/login");
    }

    public void enterUser(String criteria) {
        write(Username, criteria);
    }

    public void enterPass(String criteria) {
        write(Password, criteria);
    }

    public void clickLoginBtton() {
        clickElement(LoginButton);
    }

    public String incorrectPasswordMessage(){
        return textFromElement(confirmationMessage);
    }

}
