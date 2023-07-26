package pages;

import driverfactory.webdriver.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class WelcomePage{

	private final WebDriver driver;

	By createNewAccountButton = By.linkText("Create new account");
	By emailField = By.id("email");
	By passwordField = By.id("pass");
	By loginBtn = By.name("login");

	public WelcomePage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Given Facebook Welcome Page is Loaded")
	public WelcomePage validateThatFacebookWelcomePageIsLoaded(){
		driver.element().waitForVisibility(emailField);
		driver.assertThat().element(emailField).isDisplayed();
		return this;
	}
	@Step("When user clicks on Sign Up button")
	public UserRegistrationPage openCreateNewAccountPage()
	{
		driver.element().clickUsingJavaScript(createNewAccountButton);
		return new UserRegistrationPage(driver);
	}

	@Step("When user enters Login Credentials")
	public WelcomePage userEntersLoginCredentials(String email, String password)
	{
		driver.element().fillField(emailField, email);
		driver.element().fillField(passwordField, password);
		return this;
	}

	@Step("And Clicks on Login button")
	public FeedPage clickOnLoginButton()
	{
		driver.element().click(loginBtn);
		return new FeedPage(driver);
	}


}
