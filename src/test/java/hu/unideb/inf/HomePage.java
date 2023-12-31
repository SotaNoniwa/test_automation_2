package hu.unideb.inf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class HomePage {
    private static final String PAGE_URL = "https://magento.softwaretestingboard.com/";

    private final WebDriver driver;

    @FindBy(css = "#checkout > div.opc-estimated-wrapper > div.estimated-block > span.estimated-price")
    private WebElement priceLabel;

    @FindBy(id = "email-error")
    private WebElement emailErrorMessage;

    @FindBy(id = "pass-error")
    private WebElement passwordErrorMessage;

    @FindBy(css = "#maincontent > div.page.messages > div:nth-child(2) > div > div > div")
    private WebElement loginErrorMessage;

    @FindBy(css = "#maincontent > div.page.messages > div:nth-child(2) > div > div > div")
    private WebElement addedItemMessage;

    private static final Map<String, By> textFields = Map.of(
            "Email Address", By.id("customer-email"),
            "First Name", By.id("H7JPN0M"),
            "Last Name", By.id("NGQLD4Y"),
            "Street Address", By.id("E1HS7LM"),
            "City", By.id("E1HS7LM"),
            "Zip Code", By.id("TGRQ8FM"),
            "Phone Number", By.id("OKD5J77"),
            // in login page
            "Email", By.id("email"),
            "Password", By.id("pass")
    );

    private static final Map<String, By> itemButtons = Map.ofEntries(
            Map.entry("Radiant Tee - XS", By.id("#option-label-size-143-item-166")),
            Map.entry("Radiant Tee - Blue", By.id("#option-label-color-93-item-50")),
            Map.entry("Radiant Tee - Add to Cart", By.cssSelector("#maincontent > div.columns > div > div.widget.block.block-static-block > div.block.widget.block-products-list.grid > div > div > ol > li:nth-child(1) > div > div > div.product-item-inner > div > div.actions-primary > form > button")),
            Map.entry("Breath-Easy Tank - S", By.id("#option-label-size-143-item-167")),
            Map.entry("Breath-Easy Tank - Purple", By.id("#option-label-color-93-item-57")), Map.entry("Breath-Easy Tank - Add to Cart", By.cssSelector("#maincontent > div.columns > div > div.widget.block.block-static-block > div.block.widget.block-products-list.grid > div > div > ol > li:nth-child(2) > div > div > div.product-item-inner > div > div.actions-primary > form > button")), Map.entry("Argus All-Weather Tank - M", By.id("#option-label-size-143-item-168")), Map.entry("Argus All-Weather Tank - Gray", By.id("#option-label-color-93-item-52")),
            Map.entry("Argus All-Weather Tank - Add to Cart", By.cssSelector("#maincontent > div.columns > div > div.widget.block.block-static-block > div.block.widget.block-products-list.grid > div > div > ol > li:nth-child(3) > div > div > div.product-item-inner > div > div.actions-primary > form > button")),
            Map.entry("Hero Hoodie - L", By.id("#option-label-size-143-item-169")),
            Map.entry("Hero Hoodie - Green", By.id("#option-label-color-93-item-53")),
            Map.entry("Hero Hoodie - Add to Cart", By.id("#maincontent > div.columns > div > div.widget.block.block-static-block > div.block.widget.block-products-list.grid > div > div > ol > li:nth-child(4) > div > div > div.product-item-inner > div > div.actions-primary > form > button"))
    );

    private static final Map<String, By> navigationButtons = Map.of(
            "SignIn", By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.authorization-link > a"),
            "Create an Account", By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li:nth-child(3) > a"),
            "Cart", By.cssSelector("body > div.page-wrapper > header > div.header.content > div.minicart-wrapper > a"),
            "Checkout", By.id("top-cart-btn-checkout"),
            "Side Bar", By.cssSelector("body > div.page-wrapper > header > div.header.content > span"),
            // login page
            "LogIn", By.id("send2"),
            // expand sign out option
            "Expand Sign Out Menu", By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.customer-welcome > span > button"),
            "Sign Out", By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.customer-welcome.active > div > ul > li.authorization-link > a")
    );

    private static final Map<String, By> navigationPanels = Map.of(
            "Yoga panel", By.cssSelector("#maincontent > div.columns > div > div.widget.block.block-static-block > div.blocks-promo > a > img"),
            "20% Off panel", By.cssSelector("#maincontent > div.columns > div > div.widget.block.block-static-block > div.blocks-promo > div > a.block-promo.home-pants > img"),
            "3 + 1 panel", By.cssSelector("#maincontent > div.columns > div > div.widget.block.block-static-block > div.blocks-promo > div > a.block-promo.home-t-shirts > img"),
            "Erin panel", By.cssSelector("#maincontent > div.columns > div > div.widget.block.block-static-block > div.blocks-promo > div > a.block-promo.home-erin > img"),
            "Science panel", By.cssSelector("#maincontent > div.columns > div > div.widget.block.block-static-block > div.blocks-promo > div > a.block-promo.home-performance > img"),
            "Eco-friendly panel", By.cssSelector("#maincontent > div.columns > div > div.widget.block.block-static-block > div.blocks-promo > div > a.block-promo.home-eco > img")
    );

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void closePage() {
        driver.quit();
    }

    public void fillOutField(String field, String text) {
        driver.findElement(textFields.get(field)).sendKeys(text);
    }

    public void clickButton(String button) {
        driver.findElement(navigationButtons.get(button)).click();
    }

    public void clickPanel(String panel) {
        By panelLocator = navigationPanels.get(panel);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement panelElement = wait.until(ExpectedConditions.elementToBeClickable(panelLocator));

        panelElement.click();
    }

    public void selectItem(String item) {
        driver.findElement(itemButtons.get(item)).click();
    }

    public String getTotal() {
        return priceLabel.getText();
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }

    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }

    public String getAddedItemMessage() {
        return addedItemMessage.getText();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

}