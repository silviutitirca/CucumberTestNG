package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Silviu_Titirca on 1/10/2022
 */
public class AdminPage {

    public WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "btnAdd")
    @CacheLookup
    WebElement addButton;

    @FindBy(id = "systemUser_employeeName_empName")
    @CacheLookup
    WebElement employeeName;

    @FindBy(id = "systemUser_userName")
    @CacheLookup
    WebElement username;

    @FindBy(id = "systemUser_password")
    @CacheLookup
    WebElement password;

    @FindBy(id = "systemUser_confirmPassword")
    @CacheLookup
    WebElement confirmPassword;

    @FindBy(id = "btnSave")
    @CacheLookup
    WebElement btnSave;

    public void clickOnAddNewUser(){
        addButton.click();
    }

    public void setEmployeeName(String emplName) {
        employeeName.sendKeys(emplName);
    }

    public void setUsername(String uname) {
        username.sendKeys(uname);
    }

    public void setPassword(String passw) {
        password.sendKeys(passw);
        confirmPassword.sendKeys(passw);
    }

    public void clickOnSave(){
        btnSave.click();
    }
}
