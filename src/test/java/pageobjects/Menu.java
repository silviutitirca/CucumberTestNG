package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Silviu_Titirca on 1/10/2022
 */
public class Menu {
    public WebDriver driver;

    public Menu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Admin")
    @CacheLookup
    WebElement admin;

    @FindBy(linkText = "PIM")
    @CacheLookup
    WebElement pim;

    @FindBy(linkText = "Leave")
    @CacheLookup
    WebElement leave;

    @FindBy(linkText = "Time")
    @CacheLookup
    WebElement time;

    @FindBy(linkText = "My Info")
    @CacheLookup
    WebElement myinfo;

    public void clickAdmin(){
        admin.click();
    }

    public void clickPIM(){ pim.click();
    }
}
