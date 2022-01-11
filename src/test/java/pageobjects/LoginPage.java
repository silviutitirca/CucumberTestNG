package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Silviu_Titirca on 1/10/2022
 */
public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "txtUsername")
    @CacheLookup
    WebElement username;

    @FindBy(id = "txtPassword")
    @CacheLookup
    WebElement password;

    @FindBy(id = "btnLogin")
    @CacheLookup
    WebElement btnLogin;

    WebElement linkLogout;

    public void setUserName(String uname){
        username.clear();
        username.sendKeys(uname);
    }

    public void setPassword(String passw){
        password.clear();
        password.sendKeys(passw);
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public void logout(){
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/logout");
    }

    public void login(String username, String password){
        setUserName(username);
        setPassword(password);
        clickLogin();
    }
}
