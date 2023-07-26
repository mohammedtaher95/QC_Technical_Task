package pages;

import driverfactory.webdriver.WebDriver;
import org.openqa.selenium.By;
import pages.UserRegistrationPage;

public class WelcomePage{

	private final WebDriver driver;

	By createNewAccountButton = By.linkText("Create new account");

	public WelcomePage(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegistrationPage openCreateNewAccountPage()
	{
		driver.element().clickUsingJavaScript(createNewAccountButton);
		return new UserRegistrationPage(driver);
	}


}
