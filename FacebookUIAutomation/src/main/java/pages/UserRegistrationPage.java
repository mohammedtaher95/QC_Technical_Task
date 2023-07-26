package pages;

import driverfactory.webdriver.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class UserRegistrationPage
{

	private final WebDriver driver;

	By header = By.cssSelector("div.mbs._52lq.fsl.fwb.fcb");
	By genderMaleRadioBtn = By.xpath("(//*[@class='_58mt'])[2]");
	By firstName = By.name("firstname");
	By lastName = By.name("lastname");
	By emailField = By.name("reg_email__");
	By confirmEmailField= By.name("reg_email_confirmation__");
	By passwordField = By.id("password_step_input");
	By birthdayDay = By.name("birthday_day");
	By birthdayMonth = By.name("birthday_month");
	By birthdayYear = By.name("birthday_year");
	By registerBtn = By.name("websubmit");
	By verificationCode = By.id("code_in_cliff");
	By successMessage = By.cssSelector("div.result");

	By continueBtn = By.cssSelector("a.button-1.register-continue-button");

	public UserRegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Then Sign up pop-up should be opened")
	public UserRegistrationPage validateThatUserOpenedSignUpPopUp(){
		driver.element().waitForVisibility(header);
		driver.assertThat().element(header).text().contains("Sign Up");
		return this;
	}

	@Step("When he fills Sign Up form")
	public UserRegistrationPage fillUserRegistrationForm(String firstname, String lastname, String email, String password) {
		driver.element().waitForVisibility(firstName);
		driver.element().fillField(firstName, firstname);
		driver.element().waitForVisibility(lastName);
		driver.element().fillField(lastName, lastname);
		driver.element().waitForVisibility(emailField);
		driver.element().fillField(emailField, email);
		driver.element().fillField(confirmEmailField, email);
		driver.element().waitForVisibility(passwordField);
		driver.element().fillField(passwordField, password);
		driver.element().selectItemByIndex(birthdayDay, 27);
		driver.element().selectItemByIndex(birthdayMonth, 7);
		driver.element().selectItemByText(birthdayYear,"1990");
		driver.element().click(genderMaleRadioBtn);
		return this;
	}

	@Step("And clicks on Sign Up Button")
	public UserRegistrationPage clickOnSignUpButton(){
		driver.element().waitForVisibility(registerBtn);
		driver.assertThat().element(registerBtn).isDisplayed();
		driver.element().click(registerBtn);
		return this;
	}

	@Step("Then Verification code field should be displayed")
	public UserRegistrationPage verificationCodeFieldShouldBeDisplayed(){
		driver.element().waitForVisibility(verificationCode);
		driver.assertThat().element(verificationCode).isDisplayed();
		return this;
	}

}
