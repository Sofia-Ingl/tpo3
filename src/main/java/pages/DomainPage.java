package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DomainPage extends Page{

    @FindBy(xpath = "//div[contains(@class, 'domains-block')]//form/input")
    WebElement formInput;

    @FindBy(xpath = "//a[contains(text(), 'Проверить домены')]/../../div[contains(@class, 'right')]")
    WebElement checkDomainsButton;

    @FindBy(xpath = "//div[contains(@class, 'domains-variants')]/div[@class='title']")
    List<WebElement> domainVariants;

    @FindBy(xpath = "//a[contains(text(), 'Региональные')]")
    WebElement regionDomainsPartition;

    @FindBy(xpath = "//strong[contains(text(), '.com.ru')]/../..//a")
    WebElement exampleDomainButton;

    @FindBy(xpath = "//a[@class='delete']")
    List<WebElement> cartClearButton;

//    @FindBy(xpath = "//a[contains(@class, 'full')]")
//    WebElement fullCart;


    public DomainPage(WebDriver driver) {
        super(driver);
    }

    public void sendWrongDomainName() {
        formInput.clear();
        formInput.sendKeys(".$55");
        checkDomainsButton.click();
    }

    public void sendCorrectDomainName() {
        formInput.clear();
        formInput.sendKeys("itmo");
        checkDomainsButton.click();
    }

    public boolean variantsAreDisplayed() {
        return domainVariants.size() != 0;
    }

    public void addDomainToCart() {

        formInput.clear();
        formInput.sendKeys("itmo");
        checkDomainsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        regionDomainsPartition.click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'done')]//strong[contains(text(), '.com.ru')]")));
        exampleDomainButton.click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class='delete']")));

    }

    public boolean checkCartIsNotEmpty() {
        return cartClearButton.size() != 0;
    }

//    public void openCart() {
//        fullCart.click();
//    }

}
