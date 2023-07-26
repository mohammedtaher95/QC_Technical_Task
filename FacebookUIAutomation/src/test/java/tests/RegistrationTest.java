package tests;

import driverfactory.webdriver.WebDriver;
import org.testng.annotations.*;
import pages.WelcomePage;
import utilities.UserFormData;


public class RegistrationTest{

    public static ThreadLocal<WebDriver> driver;

    UserFormData newUser = new UserFormData();


    @BeforeClass(description = "Setup Driver")
    public synchronized void setUp(){
        driver = new ThreadLocal<>();
        driver.set(new WebDriver());
    }

    @Test(priority = 1)
    public void UserCanRegisterSuccessfully()  {
        new WelcomePage(driver.get())
                .validateThatFacebookWelcomePageIsLoaded()
                .openCreateNewAccountPage()
                .validateThatUserOpenedSignUpPopUp()
                .fillUserRegistrationForm(newUser.getFirstName(),
                        newUser.getLastName(), newUser.getFirstName() + "@gmail.com", newUser.getOldPassword())
                .clickOnSignUpButton();
    }

    @AfterClass(description = "Tear down")
    public void tearDown(){
        driver.get().browser().deleteCookies();
        driver.get().quit();
        driver.remove();
    }
}
