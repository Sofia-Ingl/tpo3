import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HostingPage;
import utils.DriverHandler;
import utils.PropsHandler;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HostingPageTest {

    @BeforeAll
    public static void prepareDrivers() {
        DriverHandler.prepareSystemProps();
    }

    @Test
    void testTariffsListing() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            HostingPage hostingPage = new HostingPage(driver);
            hostingPage.loadSite(PropsHandler.get("hosting_page_url"));
            hostingPage.listAllTariffs();
            assertTrue(hostingPage.modalContentIsShown());
            driver.quit();
        });
    }

    @Test
    void testTariffsListingAndOrder() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            HostingPage hostingPage = new HostingPage(driver);
            hostingPage.loadSite(PropsHandler.get("hosting_page_url"));
            hostingPage.listAllTariffsAndTryOrder();
            assertTrue(hostingPage.registrationFormIsShown());
            driver.quit();
        });
    }

    @Test
    void testTryFreeButton() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            HostingPage hostingPage = new HostingPage(driver);
            hostingPage.loadSite(PropsHandler.get("hosting_page_url"));
            hostingPage.tryFreeTariff();
            assertTrue(hostingPage.registrationFormIsShown());
            driver.quit();
        });
    }

    @Test
    void testRelocationButton() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            HostingPage hostingPage = new HostingPage(driver);
            hostingPage.loadSite(PropsHandler.get("hosting_page_url"));
            hostingPage.relocateProject();
            assertTrue(hostingPage.relocateFormIsShown());
            driver.quit();
        });
    }

}
