package hw6;

import hw6.components.HeaderMenu;
import hw6.components.LeftSideMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AbstractBasePage;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AbstractBasePage {

    private static final String URL = "https://epam.github.io/JDI/index.html";
    private HeaderMenu headerMenu;
    private LeftSideMenu leftSideMenu;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement usernameTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement usernameLabel;

    @FindBy(className = "benefits")
    private WebElement benefits;

    @FindBy(name = "main-title")
    private WebElement mainHeader;

    @FindBy(name = "jdi-text")
    private WebElement mainText;

    public HomePage(WebDriver driver) {
        super(driver);
        this.headerMenu = new HeaderMenu(driver);
        this.leftSideMenu = new LeftSideMenu(driver);
    }

    public void open() {
        driver.get(URL);
    }

    public void userIconClick() {
        userIcon.click();
    }

    public void setTextUsernameTextField(final String username) {
        usernameTextField.sendKeys(username);
    }

    public void setTextPasswordTextField(final String password) {
        passwordTextField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickHeaderMenuItem(String itemName) {
        headerMenu.headerMenuItemClick(itemName);
    }

    public void clickLeftSideMenuItem(String itemName) {
        leftSideMenu.leftSideMenuItemClick(itemName);
    }

    public void clickItemInService(String itemName) {
        headerMenu.clickItemInService(itemName);
    }

    public String getUsernameLabelText() {
        return usernameLabel.getText();
    }

    public ArrayList<String> getServiceHeaderItems() {
        return getHeaderMenu().getServiceHeaderItems();
    }

    public ArrayList<String> getServiceLeftSideItems() {
        return getLeftSideMenu().getServiceLeftSideItems();
    }

    public List<WebElement> getBenefitsSpans() {
        return benefits.findElements(By.className("icons-benefit"));
    }

    public List<WebElement> getBenefitsTextsElements() {
        return benefits.
                findElements(By.className("benefit-txt"));
    }

    public WebElement getMainHeader() {
        return mainHeader;
    }

    public WebElement getMainText() {
        return mainText;
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public LeftSideMenu getLeftSideMenu() {
        return leftSideMenu;
    }

}
