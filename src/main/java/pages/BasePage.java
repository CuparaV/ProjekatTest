package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static utils.Utils.dotEnv;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;

    private static final Logger log = LogManager.getLogger(BasePage.class.getName());
    private long waitTime = Long.parseLong(dotEnv().get("EXPLICIT_WAIT_TIME"));

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
    }

    protected WebElement getElement(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected BasePage typeIn(By locator, String text){
        WebElement element = getElement(locator);
        //element.clear();
        element.sendKeys(text);
        return this;
    }

    protected BasePage clickOnElement(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }catch (ElementClickInterceptedException cl){
            log.warn("ElementClickInterceptedException occurred when trying to click on element: " + locator.toString());
            cl.printStackTrace();
            wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
        }catch (TimeoutException t){
            log.warn("TimeoutException occurred");
            getElement(locator).click();
        }catch (Exception e){
            log.warn("Exception occurred");
            WebElement element = getElement(locator);
            js.executeScript("arguments[0].click();", element);
        }
        return this;
    }

    protected boolean matchesExpectedText(By locator, String expectedText){
        WebElement element = getElement(locator);
        //Assert.assertEquals(element.getText(), expectedText); ovo nikako
        if (element.getText().trim().equals(expectedText)){
            log.info("PASSED - Text found in element: " + element.getText() + " matches expected text: " + expectedText);
            return true;
        }else {
            log.error("FAILED - Text found in element: " + element.getText() + " is not matched with expected text: " + expectedText);
        }
        return false;
    }

    protected void clickOnRandomElement(By locator){
        List<WebElement> list = driver.findElements(locator);
        Random random = new Random();
        int randomElement = random.nextInt(list.size());
        list.get(randomElement).click();
    }

    protected void hover(By locator, long wait){
        WebElement element = getElement(locator);
        new Actions(driver)
                .moveToElement(element)
                .build()
                .perform();
    }


    protected void clickOnRandomElement(By locator, int times) {
        List<WebElement> list = driver.findElements(locator);
        Random random = new Random();
        int randomElementIndex = random.nextInt(list.size());

        WebElement randomElement = list.get(randomElementIndex);

        for (int i = 0; i < times; i++) {
            randomElement.click();
        }
    }


    protected void hoverAndClick(By locator, long wait){
        WebElement element = getElement(locator);
        new Actions(driver)
                .moveToElement(element)
                .pause(wait)
                .click()
                .build()
                .perform();
    }

}
