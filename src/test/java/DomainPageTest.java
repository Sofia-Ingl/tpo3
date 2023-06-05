import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import pages.DomainPage;
import utils.DriverHandler;
import utils.PropsHandler;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DomainPageTest {

    @BeforeAll
    public static void prepareDrivers() {
        DriverHandler.prepareSystemProps();
    }

    @Test
    void testDomainCheckFormInput() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            DomainPage domainPage = new DomainPage(driver);
            domainPage.loadSite(PropsHandler.get("domain_page_url"));

            domainPage.sendWrongDomainName();
            Alert alert = driver.switchTo().alert();
            assertEquals( "Введено некорректное значение", alert.getText());
            alert.accept();

            assertFalse(domainPage.variantsAreDisplayed());
            domainPage.sendCorrectDomainName();
            assertTrue(domainPage.variantsAreDisplayed());

            driver.quit();
        });
    }

    @Test
    void testAddDomainToCart() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            DomainPage domainPage = new DomainPage(driver);
            domainPage.loadSite(PropsHandler.get("domain_page_url"));

            assertFalse(domainPage.checkCartIsNotEmpty());
            domainPage.addDomainToCart();
            assertTrue(domainPage.checkCartIsNotEmpty());

            driver.quit();
        });
    }
}
