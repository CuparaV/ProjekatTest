package steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.LoginPage;
import utils.Constants;
import java.time.Duration;



public class CartSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private CartPage cartPage;

    @Before
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);

    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Given("I am on the product page")
    public void iAmOnTheProductPage() {
        loginPage.goToLoginPage();

    }

    @When("I add two products to the cart")
    public void iAddTwoProductsToTheCart() {
        cartPage.clickOnRandomProduct();

    }

    @And("I set the quantity of one product to {int}")
    public void iSetTheQuantityOfOneProductTo(int arg0) {

    }

    @Then("the cart should contain {int} products with the correct quantity")
    public void theCartShouldContainProductsWithTheCorrectQuantity(int arg0) {
    }

    @Given("I have added two products to the cart")
    public void iHaveAddedTwoProductsToTheCart() {
    }

    @When("I look at the cart icon")
    public void iLookAtTheCartIcon() {
    }

    @Then("the number of items in the cart should match the number in the red badge on the cart icon")
    public void theNumberOfItemsInTheCartShouldMatchTheNumberInTheRedBadgeOnTheCartIcon() {
    }

    @Given("I have added two products to the cart with correct quantities")
    public void iHaveAddedTwoProductsToTheCartWithCorrectQuantities() {
    }

    @When("I look at the total price of the cart")
    public void iLookAtTheTotalPriceOfTheCart() {
    }

    @Then("the total price should be the sum of the product prices multiplied by their quantities")
    public void theTotalPriceShouldBeTheSumOfTheProductPricesMultipliedByTheirQuantities() {
    }

    @Given("I have added products to the cart")
    public void iHaveAddedProductsToTheCart() {
    }

    @When("I proceed to checkout and complete the payment")
    public void iProceedToCheckoutAndCompleteThePayment() {
    }

    @Then("I should see a success message indicating the purchase was completed successfully")
    public void iShouldSeeASuccessMessageIndicatingThePurchaseWasCompletedSuccessfully() {
    }

}
