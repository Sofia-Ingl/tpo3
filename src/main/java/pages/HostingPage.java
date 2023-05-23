package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HostingPage extends Page {

    public HostingPage(WebDriver driver) {
        super(driver);
    }

    public void listAllTariffs() {
        WebElement allTariffsButton = driver.findElement(By.xpath("//div[contains(text(),'Все тарифы списком')]"));
        allTariffsButton.click();
    }

    public void listAllTariffsAndTryOrder() {
        WebElement allTariffsButton = driver.findElement(By.xpath("//div[contains(text(),'Все тарифы списком')]"));
        allTariffsButton.click();
        WebElement orderButton = driver.findElement(By.xpath("//table[contains(@class, 'tablet:table')]//div[contains(text(),'Year+')]/../button[contains(text(),'Заказать')]"));
        orderButton.click();
    }

    public boolean modalContentIsShown() {
        WebElement modalContentBackground;
        try {
            modalContentBackground = driver.findElement(By.xpath("//div[contains(@class,'ui-modal-content')]"));
        } catch (NoSuchElementException e) {
            modalContentBackground = null;
        }
        return modalContentBackground != null;
    }

    public boolean registrationFormIsShown() {
        if (!modalContentIsShown()) return false;
        WebElement registrationFormTitle;
        try {
            registrationFormTitle = driver.findElement(By.xpath("//div[contains(text(),'Регистрация')]"));
        } catch (NoSuchElementException e) {
            registrationFormTitle = null;
        }
        return registrationFormTitle != null;
    }

    public boolean relocateFormIsShown() {
        if (!modalContentIsShown()) return false;
        WebElement relocateFormTitle;
        try {
            relocateFormTitle = driver.findElement(By.xpath("//div[contains(text(),'Перенести сайт')]"));
        } catch (NoSuchElementException e) {
            relocateFormTitle = null;
        }
        return relocateFormTitle != null;
    }

    public void tryFreeTariff() {
        WebElement tryFreeButton = driver.findElement(By.xpath("//div[contains(text(),'Year+')]/../..//button"));
        tryFreeButton.click();
    }

    public void relocateProject() {
        WebElement relocateButton = driver.findElement(By.xpath("//button[contains(text(),'Перенести проект')]"));
        relocateButton.click();
    }

}
