package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.BrowserActions;

public class HomePage extends BasePage{

    /*********** Elements Locators ***********/

    By languageBtn = By.cssSelector("button.language");

    By cookiesClose = By.xpath("//button[@class='onetrust-close-btn-handler banner-close-button ot-close-icon']");

    By loginLink = By.xpath("//div[@id='userProfileMenu']//button");
    By appleLink = By.xpath("//h5[text()=' Apple']");
    By wallCharger = By.xpath("(//img)[17]");


    By addToCartBtn = By.xpath("//button[@class='add-to-cart']");

    By myCartBtn = By.cssSelector("button.cart-btn");
    By checkOutBtn = By.xpath("//div[@class='order-actions']//button[@class='checkout-btn']");

    By homePageBtn=By.cssSelector("p.logo-text");
    By removeItemBtn=By.xpath("(//div[@class='cartCard-details']//p)[2]");
    By removeItemMessage=By.xpath("//p[text()='Item removed successfully']");
    /*********** page Constructor**************/
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /************** Page Functions ****************/

    public void changeLanguage() {
        BrowserActions.clickButton(driver, languageBtn);
    }

    public void closeCookies() {
        BrowserActions.clickButton(driver, cookiesClose);
    }

    public void goToLoginPage() {
        BrowserActions.clickButton(driver, loginLink);
    }

    public void clickOnAppleCategory() {
        BrowserActions.clickButton(driver, appleLink);
    }

    public void choiceWallCharger() {
        BrowserActions.clickButton(driver, wallCharger);
    }

    public void addToCart() {
        BrowserActions.clickButton(driver, addToCartBtn);
    }

    public void myCart() {
        BrowserActions.clickButton(driver, myCartBtn);
    }

    public void checkOutProcess() {
        BrowserActions.clickButton(driver, checkOutBtn);
    }


    public void goToHomePage() {
        BrowserActions.clickButton(driver, homePageBtn);
    }
    public void removeItem() {
        BrowserActions.clickButton(driver, removeItemBtn);
    }
    public String removeItemMessage() {
        return BrowserActions.getText(driver, removeItemMessage);
    }

}
