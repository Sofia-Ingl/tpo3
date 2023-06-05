import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.DedicatedServerPage;
import utils.DriverHandler;
import utils.PropsHandler;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DedicatedServerPageTest {

    @BeforeAll
    public static void prepareDrivers() {
        DriverHandler.prepareSystemProps();
    }

    @Test
    void testFilterByStorage() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            DedicatedServerPage dedicatedServerPage = new DedicatedServerPage(driver);
            dedicatedServerPage.loadSite(PropsHandler.get("dedicated_server_page_url"));

            assertFalse(dedicatedServerPage.checkFirstItemStorageIsNVMe());
            dedicatedServerPage.showStorageOptions();
            dedicatedServerPage.filterByNVMeStorage();
            assertTrue(dedicatedServerPage.checkFirstItemStorageIsNVMe());
            dedicatedServerPage.showAllStorageTypes();
            assertFalse(dedicatedServerPage.checkFirstItemStorageIsNVMe());

            driver.quit();
        });
    }


    @Test
    void testFilterByCpu() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            DedicatedServerPage dedicatedServerPage = new DedicatedServerPage(driver);
            dedicatedServerPage.loadSite(PropsHandler.get("dedicated_server_page_url"));

            assertFalse(dedicatedServerPage.checkFirstItemCpuIsAMD());
            dedicatedServerPage.showCpuOptions();
            dedicatedServerPage.filterByAMDCpu();
            assertTrue(dedicatedServerPage.checkFirstItemCpuIsAMD());
            dedicatedServerPage.showAllCpu();
            assertFalse(dedicatedServerPage.checkFirstItemCpuIsAMD());

            driver.quit();
        });
    }


    @Test
    void testChangeLocation() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            DedicatedServerPage dedicatedServerPage = new DedicatedServerPage(driver);
            dedicatedServerPage.loadSite(PropsHandler.get("dedicated_server_page_url"));

            assertFalse(dedicatedServerPage.polandIsChosen());
            dedicatedServerPage.choosePolandDataCenter();
            assertTrue(dedicatedServerPage.polandIsChosen());

            driver.quit();
        });
    }

    @Test
    void testSales() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            DedicatedServerPage dedicatedServerPage = new DedicatedServerPage(driver);
            dedicatedServerPage.loadSite(PropsHandler.get("dedicated_server_page_url"));

            assertFalse(dedicatedServerPage.checkFirstItemIsForSale());
            dedicatedServerPage.salesTurnOn();
            assertTrue(dedicatedServerPage.checkFirstItemIsForSale());

            driver.quit();
        });
    }

    @Test
    void testReset() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            DedicatedServerPage dedicatedServerPage = new DedicatedServerPage(driver);
            dedicatedServerPage.loadSite(PropsHandler.get("dedicated_server_page_url"));

            assertFalse(dedicatedServerPage.checkFirstItemIsForSale());
            assertFalse(dedicatedServerPage.checkFirstItemStorageIsNVMe());
            assertFalse(dedicatedServerPage.checkFirstItemCpuIsAMD());

            dedicatedServerPage.salesTurnOn();
            assertTrue(dedicatedServerPage.checkFirstItemIsForSale());
            dedicatedServerPage.resetFilters();
            assertFalse(dedicatedServerPage.checkFirstItemIsForSale());

            dedicatedServerPage.showCpuOptions();
            dedicatedServerPage.filterByAMDCpu();
            assertTrue(dedicatedServerPage.checkFirstItemCpuIsAMD());
            dedicatedServerPage.resetFilters();
            assertFalse(dedicatedServerPage.checkFirstItemCpuIsAMD());

            dedicatedServerPage.showStorageOptions();
            dedicatedServerPage.filterByNVMeStorage();
            assertTrue(dedicatedServerPage.checkFirstItemStorageIsNVMe());
            dedicatedServerPage.resetFilters();
            assertFalse(dedicatedServerPage.checkFirstItemStorageIsNVMe());

            driver.quit();
        });
    }

    @Test
    void testBuy() {
        List<WebDriver> drivers = DriverHandler.getDrivers();
        drivers.parallelStream().forEach(driver -> {
            DedicatedServerPage dedicatedServerPage = new DedicatedServerPage(driver);
            dedicatedServerPage.loadSite(PropsHandler.get("dedicated_server_page_url"));
            dedicatedServerPage.tryBuyFirstItem();
            assertEquals(driver.getCurrentUrl().split("[?]")[0], "https://timeweb.com/ru/order/");

            driver.quit();
        });
    }

}
