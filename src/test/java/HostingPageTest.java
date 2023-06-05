import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HostingPage;
import utils.DriverHandler;
import utils.PropsHandler;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
            assertFalse(hostingPage.modalContentIsShown());
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
            assertFalse(hostingPage.registrationFormIsShown());
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
            assertFalse(hostingPage.registrationFormIsShown());
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
            assertFalse(hostingPage.relocateFormIsShown());
            hostingPage.relocateProject();
            assertTrue(hostingPage.relocateFormIsShown());
            driver.quit();
        });
    }

}
