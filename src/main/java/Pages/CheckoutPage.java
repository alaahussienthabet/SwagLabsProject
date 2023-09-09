package Pages;

import UI.UiActions;
import org.openqa.selenium.By;

/**
 * navigate to checkout page and checkout
 */
public class CheckoutPage {
    UiActions action = new UiActions();

    private final By checkoutBtn = By.id("checkout");
    private final By pageTitle = By.xpath("//span[@class='title']");
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueToCheckoutBtn = By.id("continue");
    private final By finishBtn = By.id("finish");
    private final By confirmationMessage = By.xpath("//h2[@class='complete-header']");

    /**
     * checkout with selected products
     */
    public void checkout() {

        action.waitFunction(pageTitle, "waitVisibility");
        action.findElement(checkoutBtn).actionOnElement("click");
    }

    /**
     * checkout With User Data and finish the checkout
     */
    public void checkoutWithUserData(String firstName, String lastName, String postalCode) {

        action.waitFunction(pageTitle, "waitVisibility");
        action.findElement(firstNameField).sendKeyToElement(firstName)
                .findElement(lastNameField).sendKeyToElement(lastName)
                .findElement(postalCodeField).sendKeyToElement(postalCode)
                .findElement(continueToCheckoutBtn).actionOnElement("click");
    }
    /**
     * finishing checkout after entering all user data
     */
    public void finishingCheckout() {

        action.waitFunction(pageTitle, "waitVisibility");
        action.findElement(finishBtn).actionOnElement("click");
    }
    /**
     * get confirmation message after user checkout successfully
     */
    public UiActions getConfirmationMessage() {

        action.waitFunction(pageTitle, "waitVisibility");
       return action.findElement(confirmationMessage);
    }
}
