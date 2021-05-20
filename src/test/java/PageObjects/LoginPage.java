package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#txtUsername")
    @CacheLookup
    private WebElement userField;

    @FindBy(css = "#txtPassword")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(id = "btnLogin")
    @CacheLookup
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='logInPanelHeading']")
    @CacheLookup
    private WebElement loginPanel;

    public void loginPanel() {

        WaitUntilElementVisible(loginPanel);
        loginPanel.isEnabled();

    }


    public void fillUserData(String email) {

        WaitUntilElementVisible(userField);
        userField.isEnabled();
        userField.clear();
        userField.sendKeys(email);
    }

    public void fillPasswordData(String password) {

        WaitUntilElementVisible(passwordField);
        passwordField.isEnabled();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {

        WaitUntilElementVisible(signInButton);
        signInButton.isEnabled();
        signInButton.click();
    }


    public boolean loginPageIsDisplayed() {

        WaitUntilElementVisible(userField);
        userField.isDisplayed();
        WaitUntilElementVisible(passwordField);
        passwordField.isDisplayed();
        WaitUntilElementVisible(signInButton);
        signInButton.isDisplayed();
        return true;
    }
}