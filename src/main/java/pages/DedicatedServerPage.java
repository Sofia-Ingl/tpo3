package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropsHandler;

import java.time.Duration;

public class DedicatedServerPage extends Page {

    @FindBy(xpath = "//div[contains(text(), 'Дата-центр')]/..//div[contains(@class, 'select-option')]")
    WebElement locationOptions;

    @FindBy(xpath = "//div[contains(text(), 'Польша')]/..")
    WebElement polandOption;

    @FindBy(xpath = "//div[contains(text(), 'Бренд CPU')]/../..")
    WebElement cpuOptionsList;

    @FindBy(xpath = "//div[contains(text(), 'Бренд CPU')]/../../..//div[contains(text(), 'Amd')]/..")
    WebElement amdOption;

    @FindBy(xpath = "//div[contains(text(), 'Бренд CPU')]/../../..//div[contains(text(), 'Все')]/..")
    WebElement allCpuOption;

    @FindBy(xpath = "//div[contains(text(), 'Тип диска')]/../..")
    WebElement storageTypeOptionsList;

    @FindBy(xpath = "//div[contains(text(), 'Тип диска')]/../../..//div[contains(text(), 'NVMe')]/..")
    WebElement NVMeOption;

    @FindBy(xpath = "//div[contains(text(), 'Тип диска')]/../../..//div[contains(text(), 'Все')]/..")
    WebElement allStorageTypesOption;


    @FindBy(xpath = "//div[contains(@class, 'tw-dedic-servers-item')][1]/div[1]")
    WebElement firstDedicatedServerOfferedShortInfo;

    @FindBy(xpath = "//div[contains(@class, 'tw-dedic-servers-item')][1]//div[@class='cpu']/div[contains(@class, 'title')]")
    WebElement firstDedicatedServerOfferedCpu;

    @FindBy(xpath = "//div[contains(@class, 'tw-dedic-servers-item')][1]//div[contains(@class, 'disk')]/div")
    WebElement firstDedicatedServerOfferedStorage;

    @FindBy(xpath = "//div[contains(@class, 'tw-dedic-servers-item')][1]//button")
    WebElement firstDedicatedServerOfferedBuyButton;


    @FindBy(xpath = "//div[contains(text(), 'Распродажа')]/..//div[contains(@class, 'cursor-pointer')]")
    WebElement salesCursorPointer;

    @FindBy(xpath = "//div[contains(text(), 'Сбросить фильтры')]/..")
    WebElement resetButton;

    public DedicatedServerPage(WebDriver driver) {
        super(driver);
    }

    public void showCpuOptions() {
        cpuOptionsList.click();
    }

    public void filterByAMDCpu() {
        amdOption.click();
    }

    public void showAllCpu() {
        allCpuOption.click();
    }

    public boolean checkFirstItemCpuIsAMD() {
        return firstDedicatedServerOfferedCpu.getText().contains("AMD");
    }

    public void showStorageOptions() {
        storageTypeOptionsList.click();
    }

    public void filterByNVMeStorage() {
        NVMeOption.click();
    }

    public void showAllStorageTypes() {
        allStorageTypesOption.click();
    }

    public boolean checkFirstItemStorageIsNVMe() {
        return firstDedicatedServerOfferedStorage.getText().contains("NVMe");
    }

    public void choosePolandDataCenter() {
        locationOptions.click();
        polandOption.click();
    }

    public boolean polandIsChosen() {
        return locationOptions.getText().contains("Польша");
    }

    public void salesTurnOn() {
        salesCursorPointer.click();
    }

    public boolean checkFirstItemIsForSale() {
        return firstDedicatedServerOfferedShortInfo.getText().contains("РАСПРОДАЖА");
    }

    public void resetFilters() {
        resetButton.click();
    }

    public void tryBuyFirstItem() {
        firstDedicatedServerOfferedBuyButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(PropsHandler.get("dedicated_server_page_url"))));
    }


}
