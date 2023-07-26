package tests;

import driverfactory.webdriver.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.WelcomePage;
import utilities.JSONFileHandler;
import utilities.UserFormData;


public class LoginTest {

    public static ThreadLocal<WebDriver> driver;
    JSONFileHandler userData = new JSONFileHandler("simpleFile.json");

    @BeforeClass(description = "Setup Driver")
    public synchronized void setUp(){
        driver = new ThreadLocal<>();
        driver.set(new WebDriver());
    }

    @Test(priority = 1)
    public void UserCanLogin()  {
        new WelcomePage(driver.get())
                .validateThatFacebookWelcomePageIsLoaded()
                .userEntersLoginCredentials(userData.getData("user.email"),
                        userData.getData("user.password"))
                .clickOnLoginButton()
                .checkThatAccountDropDownMenuShouldBeDisplayed();
    }

    @AfterClass(description = "Tear down")
    public void tearDown(){
        driver.get().browser().deleteCookies();
        driver.get().quit();
        driver.remove();
    }
}
