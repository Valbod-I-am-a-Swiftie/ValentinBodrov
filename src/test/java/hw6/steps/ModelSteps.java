package hw6.steps;

import cucumber.api.java.en.Given;
import hw6.DifferentElementsPage;
import hw6.HomePage;
import hw6.UserTablePage;
import hw6.utils.UserPropertiesSingleton;
import hw6.utils.WebDriverSingleton;

import static org.testng.Assert.assertEquals;

public class ModelSteps extends AbstractSteps {

    @Given("^I open EPAM JDI Site$")
    public void iOpenEpamJdiSite() {
        homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());

        homePage.open();
    }

    @Given("^I am on \"Home Page\"$")
    public void iAmOnHomePage() {
        homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());

        homePage.open();
    }

    @Given("^I login as user '([^\"]+)'$")
    public void iLoginAsUser(String expectedUsername) {
        homePage.userIconClick();
        homePage.setTextUsernameTextField(UserPropertiesSingleton.
                INSTANCE.getUserProperties().getProperty("username"));
        homePage.setTextPasswordTextField(UserPropertiesSingleton.
                INSTANCE.getUserProperties().getProperty("password"));
        homePage.clickLoginButton();
        assertEquals(homePage.getUsernameLabelText(), expectedUsername.toUpperCase());
    }

}
