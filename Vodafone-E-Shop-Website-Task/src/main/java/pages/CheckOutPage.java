package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.BrowserActions;

public class CheckOutPage extends BasePage{

    /*********** Elements Locators ***********/
    By addAddresBtn = By.xpath("//p[text()='New Address']");

    By cityField = By.xpath("//select[@class='ng-pristine ng-invalid ng-touched']");

    By districtField = By.xpath("//select[@class='ng-untouched ng-pristine ng-invalid']");

    By streetField = By.xpath("//input[@formcontrolname='streetName']");

    By buildingNo = By.xpath("//input[@formcontrolname='buildingNo']");

    By floorNo = By.xpath("//input[@formcontrolname='floorNo']");
    By apartmentNo = By.xpath("//input[@formcontrolname='appartmentNo']");
    By saveAddress = By.xpath("//button[@class='btn-primary delievry--btn--checkout']");

    By homeAddress = By.xpath("//p[text()='Home']");

    /*********** page Constructor**************/
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    /************** Page Functions ****************/


    public void addAddress() {
        BrowserActions.clickButton(driver, addAddresBtn);
    }
    public void fillUserAddress() throws InterruptedException
    {
        //first must click on city field to run correctly
        fillCity();
        fillDistrict("Ain Shams");
        fillStreetName("S");
        fillBuildingNo("4");
        fillFloorNo("8");
        fillApartmentNo("11");
        saveAddress();
    }
    public void fillCity() throws InterruptedException {
        Thread.sleep(7000);
        wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(cityField,By.tagName("option")));
        Select se = new Select(driver.findElement(cityField));
        se.selectByIndex(6);
        //BrowserActions.sendKey(driver,cityField,txt);
    }

    public void fillDistrict(String txt) {
        BrowserActions.executeWait(driver, districtField);
        Select se = new Select(driver.findElement(districtField));
        se.selectByVisibleText(txt);
    }

    public void fillStreetName(String txt) {
        BrowserActions.sendKey(driver, streetField, txt);
    }

    public void fillBuildingNo(String txt) {
        BrowserActions.sendKey(driver, buildingNo, txt);
    }

    public void fillFloorNo(String txt) {
        BrowserActions.sendKey(driver, floorNo, txt);
    }

    public void fillApartmentNo(String txt) {
        BrowserActions.sendKey(driver, apartmentNo, txt);
    }

    public void saveAddress() {
        BrowserActions.clickButton(driver, saveAddress);
    }

    public String homeAddress() {
        return BrowserActions.getText(driver, homeAddress);
    }
}
