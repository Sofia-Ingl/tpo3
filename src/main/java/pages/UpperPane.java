package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.DriverHandler;

public class UpperPane extends Page {

    public UpperPane(WebDriver driver) {
        super(driver);
    }

    public void openPayOptions() {
        WebElement payLink = driver.findElement(By.xpath("//span[contains(text(),'Оплата')]/.."));
        payLink.click();
    }

    public boolean payOptionsArePresent() {
        WebElement payOptions;
        try {
            payOptions = driver.findElement(By.xpath("//div[contains(@class,'ui-dialog-old')]"));
        } catch (NoSuchElementException e) {
            payOptions = null;
        }
        return payOptions != null;
    }

    public void openDocs() {
        WebElement docsLink = driver.findElement(By.xpath("//span[contains(text(),'Документация')]/.."));
        docsLink.click();
        DriverHandler.waitUntilPageLoads(driver, 60);
    }

    public void openCommunity() {
        WebElement docsLink = driver.findElement(By.xpath("//span[contains(text(),'Community')]/.."));
        docsLink.click();
        DriverHandler.waitUntilPageLoads(driver, 60);
    }

    public String getHostingServiceLoginPageURL() {
        WebElement loginLink = driver.findElement(By.xpath("//span[contains(text(),'Вход')]/.."));
        return loginLink.getAttribute("href").split("[?]")[0];
    }

    public void hoverDropdownMenuItem() {
        WebElement menuItem = driver.findElement(By.xpath("//div[contains(@class,'item')][1]/div[contains(@class,'link-wrapper')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuItem).build().perform();
    }

    public boolean dropdownMenuItemChildrenAreHidden() {
        WebElement menuItemChildren = driver.findElement(By.xpath("//div[contains(@class,'item')][1]/div[contains(@class,'link-wrapper')]/div"));
        String classString = menuItemChildren.getAttribute("class");
        return classString.contains("hidden");
    }


}
