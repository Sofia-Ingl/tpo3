package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverHandler;
import utils.PropsHandler;

import java.time.Duration;

public class UpperPane extends Page {

    @FindBy(xpath = "//span[contains(text(),'Оплата')]/..")
    WebElement payLink;

    @FindBy(xpath = "//div[contains(@class,'ui-dialog-old')]")
    WebElement payOptions;

    @FindBy(xpath = "//span[contains(text(),'Документация')]/..")
    WebElement docsLink;

    @FindBy(xpath = "//span[contains(text(),'Community')]/..")
    WebElement communityLink;

    @FindBy(xpath = "//span[contains(text(),'Вход')]/..")
    WebElement loginLink;

    @FindBy(xpath = "//div[contains(@class,'item')][1]/div[contains(@class,'link-wrapper')]")
    WebElement menuItem;

    @FindBy(xpath = "//div[contains(@class,'item')][1]/div[contains(@class,'link-wrapper')]/div")
    WebElement menuItemChildren;

    public UpperPane(WebDriver driver) {
        super(driver);
    }

    public void openPayOptions() {
        payLink.click();
    }

    public boolean payOptionsArePresent() {
        return payOptions != null;
    }

    public void openDocs() {
        String url = driver.getCurrentUrl();
        docsLink.click();
//        DriverHandler.waitUntilPageLoads(driver, 60);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));
    }

    public void openCommunity() {
        String url = driver.getCurrentUrl();
        communityLink.click();
//        DriverHandler.waitUntilPageLoads(driver, 60);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));
    }

    public void openHostingServiceLoginPageURL() {
        loginLink.click();
    }

    public void hoverDropdownMenuItem() {
        Actions actions = new Actions(driver);
        actions.moveToElement(menuItem).build().perform();
    }

    public boolean dropdownMenuItemChildrenAreHidden() {
        String classString = menuItemChildren.getAttribute("class");
        return classString.contains("hidden");
    }


}
