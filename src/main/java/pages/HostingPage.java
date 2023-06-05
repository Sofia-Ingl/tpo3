package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HostingPage extends Page {

    @FindBy(xpath = "//div[contains(text(),'Все тарифы списком')]")
    WebElement allTariffsButton;

    @FindBy(xpath = "//table[contains(@class, 'tablet:table')]//div[contains(text(),'Year+')]/../button[contains(text(),'Заказать')]")
    WebElement orderButton;

    @FindBy(xpath = "//div[contains(@class,'ui-modal-content')]")
    List<WebElement> modalContentBackground;

    @FindBy(xpath = "//div[contains(text(),'Регистрация')]")
    List<WebElement> registrationFormTitle;

    @FindBy(xpath = "//div[contains(text(),'Перенести сайт')]")
    List<WebElement> relocateFormTitle;

    @FindBy(xpath = "//div[contains(text(),'Year+')]/../..//button")
    WebElement tryFreeButton;

    @FindBy(xpath = "//button[contains(text(),'Перенести проект')]")
    WebElement relocateButton;

    public HostingPage(WebDriver driver) {
        super(driver);
    }

    public void listAllTariffs() {
        allTariffsButton.click();
    }

    public void listAllTariffsAndTryOrder() {
        allTariffsButton.click();
        orderButton.click();
    }

    public boolean modalContentIsShown() {
        return modalContentBackground.size() != 0;
    }

    public boolean registrationFormIsShown() {
        if (!modalContentIsShown()) return false;
        return registrationFormTitle.size() != 0;
    }

    public boolean relocateFormIsShown() {
        if (!modalContentIsShown()) return false;
        return relocateFormTitle.size() != 0;
    }

    public void tryFreeTariff() {
        tryFreeButton.click();
    }

    public void relocateProject() {
        relocateButton.click();
    }

}
