package pages;

import driverfactory.webdriver.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FeedPage{

	private final WebDriver driver;

	By dropDownMenu = By.xpath("//*[@aria-label='More options']");

	public FeedPage(WebDriver driver) {
		this.driver = driver;
	}


	@Step("Then News Feed Page should be displayed successfully")
	public FeedPage checkThatAccountDropDownMenuShouldBeDisplayed()
	{
		driver.element().waitForVisibility(dropDownMenu);
		driver.assertThat().element(dropDownMenu).isDisplayed();
		return this;
	}

}
