package Pages;


import UI.UiActions;
import org.openqa.selenium.By;

/**
 * navigate to Swag Labs login page and login with username and password
 */
public class LoginPage {


    UiActions action = new UiActions();

    private final By userNameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginBtn = By.id("login-button");



    /**
     * login with username and password
     */
    public void login(String userName,String password) {

        action.waitFunction(userNameField, "waitVisibility");
        action.findElement(userNameField).sendKeyToElement(userName)
                .findElement(passwordField).sendKeyToElement(password)
                .findElement(loginBtn).actionOnElement("click");
    }

}
