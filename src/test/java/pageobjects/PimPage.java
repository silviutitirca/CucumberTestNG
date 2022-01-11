package pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

/**
 * @author Silviu_Titirca on 1/11/2022
 */
public class PimPage {

    public WebDriver driver;

    public PimPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "btnAdd")
    @CacheLookup
    WebElement addButton;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "btnSave")
    WebElement btnSave;

    @FindBy(id = "empsearch_employee_name_empName")
    @CacheLookup
    WebElement tfSearch;

    @FindBy(id = "searchBtn")
    @CacheLookup
    WebElement btnSearch;

    @FindBy(id = "ohrmList_chkSelectAll")
    @CacheLookup
    WebElement chkUser;

    @FindBy(id = "btnDelete")
    @CacheLookup
    WebElement btnDelete;

    @FindBy(id = "dialogDeleteBtn")
    @CacheLookup
    WebElement dialogDeleteBtnOK;

    public void clickOnAddNewUser(){
        addButton.click();
    }

    public void clickOnSave(){ btnSave.click();}

    public void createNewEmployee(String fName, String lName){
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        btnSave.click();
    }

    public void searchForAnEmployee(String employeeName){
        tfSearch.clear();
        tfSearch.click();
        tfSearch.sendKeys(employeeName);
        btnSearch.click();
    }

    public void deleteAnEmployee(String employeeName){
        Wait fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        searchForAnEmployee(employeeName);
        fluentWait.until(ExpectedConditions.visibilityOfAllElements(chkUser));
        chkUser.click();
        fluentWait.until(ExpectedConditions.visibilityOfAllElements(btnDelete));
        btnDelete.click();
        fluentWait.until(ExpectedConditions.visibilityOfAllElements(dialogDeleteBtnOK));
        dialogDeleteBtnOK.click();
    }
}
