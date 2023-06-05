package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DriverHandler;
import utils.PropsHandler;

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
        DriverHandler.waitUntilPageLoads(driver, 60);
    }

    public void goToVdsAdvertPage() {
        vdsButton.click();
        DriverHandler.waitUntilPageLoads(driver, 60);
    }

    public void goToDedicatedServerAdvertPage() {
        dedicatedServerButton.click();
        DriverHandler.waitUntilPageLoads(driver, 60);
    }

    public void goToConstructorAdvertPage() {
        constructorButton.click();
        DriverHandler.waitUntilPageLoads(driver, 60);
    }

    public void tryCheckDomainForm() {
        domainFormInput.clear();
        domainFormInput.sendKeys(PropsHandler.get("domain_registration_form_sample_input"));
        domainFormSubmitButton.click();
        DriverHandler.waitUntilPageLoads(driver, 60);
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

//public class MainPage extends Page {
//
//    public MainPage(WebDriver driver) {
//        super(driver);
//    }
//
//    public void goToHostingAdvertPage() {
//        WebElement hostingButton = driver.findElement(By.xpath("//div[contains(text(),'Виртуальный хостинг')]/../div[3]//button"));
//        hostingButton.click();
//        DriverHandler.waitUntilPageLoads(driver, 60);
//    }
//
//    public void goToVdsAdvertPage() {
//        WebElement vdsButton = driver.findElement(By.xpath("//div[contains(text(),'Аренда VDS и VPS')]/../div[3]//button"));
//        vdsButton.click();
//        DriverHandler.waitUntilPageLoads(driver, 60);
//    }
//
//    public void goToDedicatedServerAdvertPage() {
//        WebElement dedicatedServerButton = driver.findElement(By.xpath("//div[contains(text(),'Выделенные серверы')]/../div[3]//button"));
//        dedicatedServerButton.click();
//        DriverHandler.waitUntilPageLoads(driver, 60);
//    }
//
//    public void goToConstructorAdvertPage() {
//        WebElement constructorButton = driver.findElement(By.xpath("//div[contains(text(),'Конструктор сайтов')]/../div[3]//button"));
//        constructorButton.click();
//        DriverHandler.waitUntilPageLoads(driver, 60);
//    }
//
//    public void tryCheckDomainForm() {
//        WebElement domainFormInput = driver.findElement(By.xpath("//div[contains(text(),'Регистрация доменов')]/../div[3]//input"));
//        WebElement domainFormSubmitButton = driver.findElement(By.xpath("//div[contains(text(),'Регистрация доменов')]/../div[3]//button"));
//        domainFormInput.clear();
//        domainFormInput.sendKeys(PropsHandler.get("domain_registration_form_sample_input"));
//        domainFormSubmitButton.click();
//        DriverHandler.waitUntilPageLoads(driver, 60);
//        //https://timeweb.com/ru/services/domains/?d=itmo
//    }
//
//    public void trySwipe() {
//
//        WebElement firstSwiperPaginationBullet = driver.findElement(By.xpath("//span[@class='swiper-pagination-bullet'][1]"));
//        firstSwiperPaginationBullet.click();
//        firstSwiperPaginationBullet = driver.findElement(By.xpath("//span[@class='swiper-pagination-bullet'][1]"));
//        firstSwiperPaginationBullet.click();
//
//
//    }
//
//    public boolean checkCommentIsActiveBySequenceNumber(int number) {
//        WebElement comment = driver.findElement(By.xpath("//div[contains(@class,'swiper-slide')][not(contains(@class,'swiper-slide-duplicate'))]["+ number + "]"));
//        String classString = comment.getAttribute("class");
//        return classString.contains("swiper-slide-active");
//    }
//
//    public void questionOpen() {
//        WebElement question = driver.findElement(By.xpath("//div[contains(text(),'Какие способы оплаты у вас есть?')]"));
//        question.click();
//    }
//
//    public boolean answerIsPresent() {
//        WebElement answer;
//        try {
//            answer = driver.findElement(By.xpath("//div[contains(text(),'Какие способы оплаты у вас есть?')]/../../../div[2]"));
//        } catch (NoSuchElementException e) {
//            answer = null;
//        }
//        return answer != null;
//    }
//
//    public void requestCall() {
//        WebElement requestButton = driver.findElement(By.xpath("//button[contains(text(),'Заказать звонок эксперта')]"));
//        requestButton.click();
//    }
//
//    public boolean callFormIsPresent() {
//        WebElement callForm;
//        try {
//            callForm = driver.findElement(By.xpath("//div[contains(@class,'ui-modal-backdrop')]"));
//        } catch (NoSuchElementException e) {
//            callForm = null;
//        }
//        return callForm != null;
//    }
//
//}
