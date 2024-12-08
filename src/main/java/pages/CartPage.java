package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class CartPage extends BasePage {


    By cartItem = By.cssSelector(".card-title");
    By cartIcon = By.cssSelector(".cart-icon-selector");
    By redBalloon = By.cssSelector(".red-balloon-selector");
    By totalPrice = By.cssSelector(".total-price-selector");
    By checkoutButton = By.cssSelector(".checkout-button-selector");
    By successMessage = By.cssSelector(".success-message-selector");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartIconCount() {
        return Integer.parseInt(getElement(redBalloon).getText());
    }

    public double getTotalPrice() {
        return Double.parseDouble(getElement(totalPrice).getText().replace("$", ""));
    }

    public void proceedToCheckout() {
        clickOnElement(checkoutButton);
    }

    public boolean isPurchaseSuccessful() {
        return getElement(successMessage).isDisplayed();
    }


    public void clickOnRandomProduct() {

        List<WebElement> productCards = driver.findElements(By.cssSelector(".card-title"));
        if (!productCards.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(productCards.size());
            productCards.get(randomIndex).click();
        } else {
            System.out.println("No products found on the page.");
        }
    }





}



