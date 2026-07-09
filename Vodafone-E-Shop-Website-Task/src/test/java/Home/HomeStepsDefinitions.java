package Home;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

public class HomeStepsDefinitions {

    WebDriver driver;
    HomePage homePage;
    CheckOutPage checkOutPage;
    LoginPage loginPage;
    SoftAssert softAssert=new SoftAssert();

    @Given("navigate to website and login with phoneNumber {string} and password {string}")
    public void navigate_to_website_and_login(String phone,String password){
        driver=DriverSetup.setUp("chrome");
        homePage=new HomePage(driver);
        homePage.closeCookies();
        homePage.changeLanguage();
        homePage.goToLoginPage();
        loginPage=new LoginPage(driver);
        loginPage.login(phone,password);

    }

    @When("add item of Iphone brand to card and click checkOut button")
    public void addItemOfIphoneBrandToCardAndClickCheckOutButton() {
        homePage.clickOnAppleCategory();
        homePage.choiceWallCharger();
        homePage.addToCart();
        homePage.myCart();
        homePage.checkOutProcess();
        checkOutPage=new CheckOutPage(driver);
    }

    @And("add address detail and click Save")
    public void addAddressDetailAndClickSave() throws InterruptedException {
        checkOutPage.addAddress();
        checkOutPage.fillUserAddress();
    }

    @Then("Address added")
    public void addressAdded() {
        softAssert.assertEquals(checkOutPage.homeAddress(),"Home");
        softAssert.assertAll();
    }

    @And("add item to Cart")
    public void addItemToCart() {
        homePage.clickOnAppleCategory();
        homePage.choiceWallCharger();
        homePage.addToCart();
    }

    @When("go to cart page and click to remove item")
    public void goToCartPageAndClickToRemoveItem() {
        homePage.myCart();
        homePage.removeItem();
    }

    @Then("show message item is removed")
    public void showMessageItemIsRemoved() {
        softAssert.assertEquals(homePage.removeItemMessage(),"Item removed successfully");
    }
}
