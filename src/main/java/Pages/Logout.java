package Pages;

import UI.UiActions;
import org.openqa.selenium.By;

public class Logout {

    UiActions action = new UiActions();

    private final By sideMenu = By.id("react-burger-menu-btn");
    private final By logoutBtn = By.id("logout_sidebar_link");


    /**
     * logout
     */
    public void logout() {
      action.findElement(sideMenu).actionOnElement("click");
      action.findElement(logoutBtn).actionOnElement("click");

    }

}
