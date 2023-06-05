import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import utils.DriverHandler;
import utils.PropsHandler;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {

    @BeforeAll
    public static void prepareDrivers() {
        DriverHandler.prepareSystemProps();
    }

    @Test
    void testHostingButton() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            MainPage mainPage = new MainPage(driver);
            mainPage.loadSite();
            mainPage.goToHostingAdvertPage();
            assertEquals(driver.getCurrentUrl(), "https://timeweb.com/ru/services/hosting/#hosting-optimo");
            driver.quit();
        });
    }

    @Test
    void testVdsButton() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            MainPage mainPage = new MainPage(driver);
            mainPage.loadSite();
            mainPage.goToVdsAdvertPage();
            assertEquals(driver.getCurrentUrl(), "https://timeweb.com/ru/services/vds/#tariffs");
            driver.quit();
        });
    }

    @Test
    void testDedicatedServerButton() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            MainPage mainPage = new MainPage(driver);
            mainPage.loadSite();
            mainPage.goToDedicatedServerAdvertPage();
            assertEquals(driver.getCurrentUrl(), "https://timeweb.com/ru/services/dedicated-server/");
            driver.quit();
        });
    }

    @Test
    void testConstructorButton() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            MainPage mainPage = new MainPage(driver);
            mainPage.loadSite();
            mainPage.goToConstructorAdvertPage();
            assertEquals(driver.getCurrentUrl(), "https://timeweb.com/ru/services/constructor/");
            driver.quit();
        });
    }

    @Test
    void testDomainRegistrationForm() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            MainPage mainPage = new MainPage(driver);
            mainPage.loadSite();
            mainPage.tryCheckDomainForm();
            assertEquals(driver.getCurrentUrl(), PropsHandler.get("base_url")
                    + "services/domains/?d="
                    + PropsHandler.get("domain_registration_form_sample_input"));
            driver.quit();
        });
    }

    @Test
    void testCommentSwiperPagination() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            MainPage mainPage = new MainPage(driver);
            mainPage.loadSite();
            assertTrue(mainPage.checkFirstCommentIsActive());
            mainPage.trySwipe();
            assertTrue(mainPage.checkFirstCommentIsActive());
            driver.quit();
        });
    }

    @Test
    void testFAQSection() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            MainPage mainPage = new MainPage(driver);
            mainPage.loadSite();
            mainPage.questionOpen();
            assertTrue(mainPage.answerIsPresent());
            driver.quit();
        });
    }

    @Test
    void testCallRequestSection() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            MainPage mainPage = new MainPage(driver);
            mainPage.loadSite();
            mainPage.requestCall();
            assertTrue(mainPage.callFormIsPresent());
            driver.quit();
        });
    }


}
