package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SystemUsers extends BaseClass{

    public SystemUsers(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@id='btnAdd']")
    @CacheLookup
    private WebElement addUser;

    @FindBy(xpath = "//select[@id='systemUser_userType']")
    @CacheLookup
    private WebElement role;

    @FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
    @CacheLookup
    private WebElement employeeName;

    @FindBy(xpath = "//input[@id='systemUser_userName']")
    @CacheLookup
    private WebElement userName;

    @FindBy(xpath = "//select[@id='systemUser_status']")
    @CacheLookup
    private WebElement status;

    @FindBy(xpath = "//input[@id='systemUser_password']")
    @CacheLookup
    private WebElement password;

    @FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
    @CacheLookup
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='btnSave']")
    @CacheLookup
    private WebElement btnSave;

    @FindBy(xpath = "//a[@id='welcome']")
    @CacheLookup
    private WebElement welcome;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    @CacheLookup
    private WebElement logout;



    public void clickAddUser() {

        WaitUntilElementVisible(addUser);
        addUser.isEnabled();
        addUser.click();
    }

    public void createdUser(String userRole, String employee, String user, String statusActual, String pass){

        WaitUntilElementVisible(role);
        role.isEnabled();
        role.click();
        String text = role.getText();
        System.out.println("Texto: "+text);

        WaitUntilElementVisible(employeeName);
        employeeName.isEnabled();
        employeeName.clear();
        employeeName.sendKeys(employee, Keys.ARROW_DOWN, Keys.ENTER);

        WaitUntilElementVisible(userName);
        userName.isEnabled();
        userName.clear();
        userName.sendKeys(user);

        WaitUntilElementVisible(status);
        status.isEnabled();
        //status.clear();
        //status.sendKeys(statusActual);

        WaitUntilElementVisible(password);
        password.isEnabled();
        password.clear();
        password.sendKeys(pass);

        WaitUntilElementVisible(confirmPassword);
        confirmPassword.isEnabled();
        confirmPassword.clear();
        confirmPassword.sendKeys(pass);

        WaitUntilElementVisible(btnSave);
        btnSave.isEnabled();
        btnSave.click();
        System.out.println("Boton Save");

    }

    public void signOff() {

        WaitUntilElementVisible(welcome);
        welcome.isEnabled();
        welcome.click();

        WaitUntilElementVisible(logout);
        logout.isEnabled();
        logout.click();
    }
}
