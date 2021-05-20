package StepDefinitions;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SystemUsers;
import Utilities.PropertiesReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;

    public LoginSteps() throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }


    @Given("user on login page")
    public void loginPage() {

        LoginPage login = new LoginPage(driver, wait);
        login.loginPageIsDisplayed();
    }

    @Given("Submit email using \"(.*)\" and password using \"(.*)\"")
    public void submitEmailPassword(String email, String password) {

        LoginPage login = new LoginPage(driver, wait);
        login.loginPageIsDisplayed();
        login.fillUserData(email);
        login.fillPasswordData(password);
        login.clickSignInButton();
    }

    @Given("Success login to home page")
    public void successLogin() {

        HomePage home = new HomePage(driver, wait);
        Assert.assertTrue(home.homePageIsDisplayed());
    }

    @When("A new user is created with (.*), (.*), (.*) (.*), and (.*)")
    public void newUserCreated(String userRole, String employee, String user, String statusActual, String pass) {

        HomePage home = new HomePage(driver, wait);
        home.clickAdminSection();

        SystemUsers newUser = new SystemUsers(driver, wait);
        newUser.clickAddUser();
        newUser.createdUser(userRole, employee, user, statusActual, pass);
    }

    @When("session closed")
    public void signOff(){
        SystemUsers newUser = new SystemUsers(driver, wait);
        newUser.signOff();
    }

    @Then("The user with the (.*) y (.*) can log in correctly")
    public void signOn(String user, String pass){
        LoginPage login = new LoginPage(driver, wait);
        login.fillUserData(user);
        login.fillPasswordData(pass);
        login.clickSignInButton();

        HomePage home = new HomePage(driver, wait);
        Assert.assertTrue(home.dashBoardIsDisplayed());
    }

}