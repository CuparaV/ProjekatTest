package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Constants;

public class LoginPage extends BasePage {
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector(".radius");
    private By welcomeMessage = By.cssSelector(".flash.success");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        driver.get(Constants.URL);
    }

    public void loginUser(String username, String password) {
        typeIn(usernameField, username);
        typeIn(passwordField, password);
        clickOnElement(loginButton);
    }

    public boolean isWelcomeMessageDisplayed() {
        return getElement(welcomeMessage).isDisplayed();
    }
}
