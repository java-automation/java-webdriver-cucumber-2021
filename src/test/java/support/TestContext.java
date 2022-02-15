// Created by Viacheslav (Slava) Skryabin 04/01/2011
package support;

import com.fasterxml.jackson.core.type.TypeReference;
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

import java.io.*;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestContext {

    private static WebDriver driver;
    private static Map<String, Object> testData = new HashMap<>();
    private static String timestamp;

    public static void setTimestamp() {
//        timestamp = new SimpleDateFormat("+yyyy-MM-dd-hh-mm-ss").format(new Date());
        timestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss").format(LocalDateTime.now());
    }

    public String getTimestamp() {
        return timestamp;
    }

    public static void saveTestData(String key, Object data) {
        testData.put(key, data);
    }

    public static Integer readTestDataInteger(String key) {
        return (Integer) testData.get(key);
    }

    public static String readTestDataString(String key) {
        return (String) testData.get(key);
    }

    public static Map<String, Object> readTestDataMap(String key) {
        return (Map<String, Object>) testData.get(key);
    }

    // Example: (not used) readTestData(Integer.class, "lastCreatedPositionId")
    public static <T> T readTestData(Class<T> type, String key) {
        return (T) testData.get(key);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void initialize() {
        initialize(getConfig().getBrowser(), getConfig().getEnvironment(), getConfig().getHeadless());
    }

    public static void teardown() {
        driver.quit();
    }

    public static Shipment getShipment() {
        try {
            return new YAMLMapper().readValue(getStream("ups"), Shipment.class);
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    public static Config getConfig() {
//        return new Yaml().loadAs(getStream("config"), Config.class); //class SnakeYaml version
        try {
            return new YAMLMapper().readValue(getStream("config"), Config.class);
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    public static Map<String, String> getPositionDataWithFittings(String dataKey, String project) {
        Map<String, String> position = getData(dataKey, project);

        String originalDateOpen = position.get("dateOpen");
        if (originalDateOpen != null) {
//            String isoDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date(originalDateOpen));
            String isoDate = LocalDate.parse(originalDateOpen, DateTimeFormatter.ofPattern("MM/dd/yyyy"))
                                                                                .format(DateTimeFormatter.ISO_DATE);
            position.put("dateOpen", isoDate);
        }

        String originalTitle = position.get("title");
        if (originalTitle != null) {
            String newTitle = originalTitle + timestamp;
            position.put("title", newTitle);
        }
        return position;
    }

    private String addUniquePostfix(String email) {
        Matcher m = Pattern.compile("(.*)@(.*)").matcher(email);
        int rand = (int) (Math.random() * 1000000);
        if (m.find()) return m.group(1) + "-" + String.format("%06d",rand) + "@" + m.group(2);
        return email;
    }

    public static Map<String, String> getCandidateDataWithFittings(String dataKey, String project) {
        Map<String, String> candidate = getData(dataKey, project);
        String originalEmail = candidate.get("email");
        if (originalEmail != null) {
            String[] emailParts = originalEmail.split("@");
            String emailWithPostfix = emailParts[0] + timestamp + "@" + emailParts[1];
            candidate.put("email", emailWithPostfix);
        }
        return candidate;
    }

    public static InputStream getStream(String project) {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/data/" + project + ".yml";
        try {
            return new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new Error(e);
        }
    }

    public static Map<String, String> getData(String dataKey, String project) {
        InputStream stream = getStream(project);
        Map<String, Map<String, String>> mapOfMaps = new Yaml().load(stream);
        return mapOfMaps.get(dataKey);
    }

    public static Map<String, String> getData(String dataKey) {
        return getData(dataKey, "quote");
    }

    // Example(not used anymore): getData(ShipmentEndpoint[].class,"shipmentEndpoints", "ups")
    public static <T> List<T> getData(Class<T[]> type, String dataKey, String project) {
        YAMLMapper mapper = new YAMLMapper();
        List<T> list;
        try {
            list =  Arrays.asList(
                    mapper.convertValue(
                            mapper.readTree(getStream(project)).get(dataKey),
                            new TypeReference<T[]>(){
                                @Override
                                public Type getType() {
                                    return type;
                                }
                            })
            );
        } catch (IOException e) {
            throw new Error(e);
        }
        return list;
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
