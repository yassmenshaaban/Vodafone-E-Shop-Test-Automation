package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;

public class LoginPage extends BasePage{
    /*********** Elements Locators ***********/

    By mobileNumberField = By.xpath("//input[@tabindex='1']");
    By passwordField = By.xpath("//input[@tabindex='2']");
    By goToAccountBtn = By.xpath("//input[@id='submitBtn']");

    /*********** page Constructor**************/
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    /************** Page Functions ****************/
    public void login(String phone,String password){
        enterMobileNumber(phone);
        enterPassword(password);
        goToMyAccount();

    }
    public void enterMobileNumber(String number) {
        BrowserActions.sendKey(driver, mobileNumberField, number);
    }

    public void enterPassword(String pass) {
        BrowserActions.sendKey(driver, passwordField, pass);
    }

    public void goToMyAccount() {
        BrowserActions.clickButton(driver, goToAccountBtn);
    }
}
