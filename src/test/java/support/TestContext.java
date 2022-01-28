// Created by Viacheslav (Slava) Skryabin 04/01/2011
package support;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.function.Predicate;

public class TestContext {

    private static WebDriver driver;
    private static List<ShipmentEndpoint> shipments;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void initialize() {
        initialize(getConfig().getBrowser(), getConfig().getEnvironment(), getConfig().getHeadless());
    }

    public static void loadData() {
        YAMLMapper mapper = new YAMLMapper();
        try {
            shipments = Arrays.asList(
                    mapper.convertValue(
                            mapper.readTree(getStream("shipmentEndpoints")).get("shipmentEndpoints"),
                            ShipmentEndpoint[].class
                    )
            );
        } catch (IOException e) {
            // address1: "105 Tyler Blvd")
            // java.lang.Error: com.fasterxml.jackson.dataformat.yaml.snakeyaml.error.MarkedYAMLException: while parsing a block mapping
            throw new Error(e);
        }
    }

    public static void teardown() {
        driver.quit();
    }

    public static ShipmentEndpoint getShipment(Predicate<ShipmentEndpoint> condition) {
        return shipments.stream().filter(condition).findFirst().orElseThrow();
    }

    public static Config getConfig() {
//        return new Yaml().loadAs(getStream("config"), Config.class); //class SnakeYaml version
        try {
            return new YAMLMapper().readValue(getStream("config"), Config.class); //Jackson databind with dataformat-yaml
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    public static Map<String, String> getData(String fileName) {
        return new Yaml().load(getStream(fileName));
    }

    public static InputStream getStream(String fileName) {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/data/" + fileName + ".yml";
        try {
            return new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new Error(e);
        }
    }

    public static void initialize(String browser, String testEnv, boolean isHeadless) {
        Dimension size = new Dimension(getConfig().getBrowserWidth(),getConfig().getBrowserHeight());
        Point position = new Point(0, 0);
        if (testEnv.equals("local")) {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    Map<String, Object> chromePreferences = new HashMap<>();
                    chromePreferences.put("profile.default_content_settings.geolocation", 2);
                    chromePreferences.put("profile.default_content_settings.popups", 0);
                    chromePreferences.put("download.prompt_for_download", false);
                    chromePreferences.put("download.directory_upgrade", true);
                    chromePreferences.put("download.default_directory", System.getProperty("user.dir") + "/src/test/resources/downloads");
                    chromePreferences.put("safebrowsing.enabled", false);
                    chromePreferences.put("plugins.always_open_pdf_externally", true);
                    chromePreferences.put("plugins.plugins_disabled", new ArrayList<String>(){{ add("Chrome PDF Viewer"); }});
                    chromePreferences.put("credentials_enable_service", false);
                    chromePreferences.put("password_manager_enabled", false);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.setExperimentalOption("prefs", chromePreferences);
                    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                    if (isHeadless) {
                        chromeOptions.setHeadless(true);
                        chromeOptions.addArguments("--window-size=" + size.getWidth() + "," + size.getWidth());
                        chromeOptions.addArguments("--disable-gpu");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (isHeadless) {
                        FirefoxBinary firefoxBinary = new FirefoxBinary();
                        firefoxBinary.addCommandLineOptions("--headless");
                        firefoxOptions.setBinary(firefoxBinary);
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "safari":
                    driver = new SafariDriver();
                    driver.manage().window().setPosition(position);
                    driver.manage().window().setSize(size);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new RuntimeException("Driver is not implemented for: " + browser);
            }
        } else if (testEnv.equals("grid")){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setPlatform(Platform.ANY);
            try {
                URL hubUrl = new URL("http://localhost:4444/wd/hub");
                driver = new RemoteWebDriver(hubUrl, capabilities);
                ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new RuntimeException("Unsupported test environment: " + testEnv);
        }
    }
}
