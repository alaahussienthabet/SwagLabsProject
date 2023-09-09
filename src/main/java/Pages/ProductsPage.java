package Pages;

import UI.UiActions;
import org.openqa.selenium.By;

/**
 * navigate to product page and check the items
 */

public class ProductsPage {
    UiActions action = new UiActions();

    private final By cartBtn = By.xpath("//div//a[@class='shopping_cart_link']");
    private final By pageTitle = By.xpath("//span[@class='title']");

    private final String product = "add-to-cart-%s";


    /**
     * select products to add them to cart
     */
    public void addProductsToCart(String productName) {

        By addProductBtn = By.id(String.format(product,productName));
         action.waitFunction(pageTitle, "waitVisibility");
         action.findElement(addProductBtn).actionOnElement("click");
    }
    /**
     * go to cart to see selected items and checkout
     */
    public void goToCart() {

        action.waitFunction(cartBtn, "waitVisibility");
        action.findElement(cartBtn).actionOnElement("click");
    }
    /**
     * get title of the page
     */
    public UiActions getPageTitle() {
        return action.findElement(pageTitle);
    }
}
