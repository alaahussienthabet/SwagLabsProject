package SwagLabsTest;

import Pages.CheckoutPage;
import Pages.LoginPage;

import Pages.Logout;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * test scenario to validate  the purchasing flow
 */
public class TestScenario extends BaseClass {

    LoginPage loginPage = new LoginPage(); //Instantiation of loginPage object
    ProductsPage productsPage = new ProductsPage(); //Instantiation of productsPage object
    CheckoutPage checkoutPage = new CheckoutPage(); //Instantiation of checkoutPage object
    Logout logout = new Logout(); //Instantiation of logout page object

    /**
     * <p> Test Scenario </p>
     * <p> Step.1) Open Url </p>
     * <p> Step.2) login </p>
     * <p> Step.3) select product </p>
     * <p> Step.4) checkout </p>
     * <p> Step.5) enter user data to checkout </p>
     * <p> Step.6) validate the confirmation message </p>
     * <p> Step.7) logout </p>
     */
    @Test
    public void validateThatUserCanPurchaseSuccessfully() {
        loginPage.login("standard_user","secret_sauce");
        String productPageTitle = productsPage.getPageTitle().getTextOfElement();
        Assert.assertEquals(productPageTitle, "Products", "can't find Products page");

        productsPage.addProductsToCart("sauce-labs-backpack");
        productsPage.goToCart();
        String checkoutPageTitle = productsPage.getPageTitle().getTextOfElement();
        Assert.assertEquals(checkoutPageTitle, "Your Cart", "can't find Your Cart page");

        checkoutPage.checkout();
        String userInfoPageTitle = productsPage.getPageTitle().getTextOfElement();
        Assert.assertEquals(userInfoPageTitle, "Checkout: Your Information", "can't find checkout page");

        checkoutPage.checkoutWithUserData("Alaa","Hussein","123456");
        String overviewPageTitle = productsPage.getPageTitle().getTextOfElement();
        Assert.assertEquals(overviewPageTitle, "Checkout: Overview", "can't find checkout page");

        checkoutPage.finishingCheckout();

        String confirmationMessage = checkoutPage.getConfirmationMessage().getTextOfElement();
        Assert.assertEquals(confirmationMessage, "Thank you for your order!", "can't compete the checkout");

        logout.logout();
    }

}


