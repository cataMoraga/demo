package Pages;

public class LoginPage extends BasePage {
    private String LoginButton = "//body/div[2]/div[1]/div[1]/form[1]/button[1]";
    private String Username = "//input[@id='username']";
    private String Password = "//input[@id='password']";
    private String confirmationMessage = "//div[@id='flash']";
    private String LogoutButton = "//body/div[2]/div[1]/div[1]/a[1]";

    public LoginPage() {
        super(driver);
    }

    public void navigateToLoginPage() {
        navigateTo("https://the-internet.herokuapp.com/login");
    }

    public void enterUsername(String criteria) {
        write(Username, criteria);
    }

    public void enterPassword(String criteria) {
        write(Password, criteria);
    }

    public void clickLoginButton() {
        clickElement(LoginButton);
    }

    public String enterToAccount(){
        return textFromElement(confirmationMessage);
    }

    public boolean logoutButtonIsVisible() {
        return  elementIsDisplayed(LogoutButton);
    }

}
