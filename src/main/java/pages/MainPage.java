package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropsHandler;

import java.time.Duration;

public class MainPage extends Page {

    @FindBy(xpath = "//div[contains(text(),'Виртуальный хостинг')]/../div[3]//button")
    WebElement hostingButton;

    @FindBy(xpath = "//div[contains(text(),'Аренда VDS и VPS')]/../div[3]//button")
    WebElement vdsButton;

    @FindBy(xpath = "//div[contains(text(),'Выделенные серверы')]/../div[3]//button")
    WebElement dedicatedServerButton;

    @FindBy(xpath = "//div[contains(text(),'Конструктор сайтов')]/../div[3]//button")
    WebElement constructorButton;

    @FindBy(xpath = "//div[contains(text(),'Регистрация доменов')]/../div[3]//input")
    WebElement domainFormInput;

    @FindBy(xpath = "//div[contains(text(),'Регистрация доменов')]/../div[3]//button")
    WebElement domainFormSubmitButton;

    @FindBy(xpath = "//span[@class='swiper-pagination-bullet'][1]")
    WebElement firstSwiperPaginationBullet;

    @FindBy(xpath = "//div[contains(@class,'swiper-slide')][not(contains(@class,'swiper-slide-duplicate'))][1]")
    WebElement firstComment;

    @FindBy(xpath = "//div[contains(text(),'Какие способы оплаты у вас есть?')]")
    WebElement question;

    @FindBy(xpath = "//div[contains(text(),'Какие способы оплаты у вас есть?')]/../../../div[2]")
    WebElement answer;

    @FindBy(xpath = "//button[contains(text(),'Заказать звонок эксперта')]")
    WebElement requestButton;

    @FindBy(xpath = "//div[contains(@class,'ui-modal-backdrop')]")
    WebElement callForm;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToHostingAdvertPage() {
        hostingButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(PropsHandler.get("base_url"))));
    }

    public void goToVdsAdvertPage() {
        vdsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(PropsHandler.get("base_url"))));
    }

    public void goToDedicatedServerAdvertPage() {
        dedicatedServerButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(PropsHandler.get("base_url"))));
    }

    public void goToConstructorAdvertPage() {
        constructorButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(PropsHandler.get("base_url"))));
    }

    public void tryCheckDomainForm() {
        domainFormInput.clear();
        domainFormInput.sendKeys(PropsHandler.get("domain_registration_form_sample_input"));
        domainFormSubmitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(PropsHandler.get("base_url"))));
        //https://timeweb.com/ru/services/domains/?d=itmo
    }

    public void trySwipe() {

        firstSwiperPaginationBullet.click();
        firstSwiperPaginationBullet.click();


    }

    public boolean checkFirstCommentIsActive() {
        String classString = firstComment.getAttribute("class");
        return classString.contains("swiper-slide-active");
    }

    public void questionOpen() {
        question.click();
    }

    public boolean answerIsPresent() {
        return answer != null;
    }

    public void requestCall() {
        requestButton.click();
    }

    public boolean callFormIsPresent() {
        return callForm != null;
    }

}
