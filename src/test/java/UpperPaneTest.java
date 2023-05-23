import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.UpperPane;
import utils.DriverHandler;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UpperPaneTest {

    @BeforeAll
    public static void prepareDrivers() {
        DriverHandler.prepareSystemProps();
    }

    @Test
    void testPayOptionsLink() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            UpperPane upperPane = new UpperPane(driver);
            upperPane.loadSite();
            upperPane.openPayOptions();
            assertTrue(upperPane.payOptionsArePresent());
            driver.quit();
        });
    }

    @Test
    void testDocsLink() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            UpperPane upperPane = new UpperPane(driver);
            upperPane.loadSite();
            upperPane.openDocs();
            assertEquals("https://timeweb.com/ru/docs/", driver.getCurrentUrl());
            driver.quit();
        });
    }

    @Test
    void testCommunityLink() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            UpperPane upperPane = new UpperPane(driver);
            upperPane.loadSite();
            upperPane.openCommunity();
            assertEquals("https://timeweb.com/ru/community/", driver.getCurrentUrl());
            driver.quit();
        });
    }

    @Test
    void testLoginLink() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            UpperPane upperPane = new UpperPane(driver);
            upperPane.loadSite();
            upperPane.openHostingServiceLoginPageURL();
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            DriverHandler.waitUntilPageLoads(driver, 60);
            assertEquals("https://hosting.timeweb.ru/login", driver.getCurrentUrl());
            driver.quit();
        });
    }

    @Test
    void testDropdownMenu() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            UpperPane upperPane = new UpperPane(driver);
            upperPane.loadSite();
            upperPane.hoverDropdownMenuItem();
            assertFalse(upperPane.dropdownMenuItemChildrenAreHidden());
            driver.quit();
        });
    }

}
