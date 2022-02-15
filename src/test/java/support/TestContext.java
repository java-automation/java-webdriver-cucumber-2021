package support;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class TestContext {

    private static WebDriver driver;
    private static Config config;
    private static Map<String, Object> testData = new HashMap<>();
    private static String timeStamp;

    public static void setTimestamp() {
        timeStamp = new SimpleDateFormat("+yyyy-MM-dd-hh-mm-ss").format(new Date());
    }

    public static String getTimeStamp() {
        return timeStamp;
    }

    public static void saveTestData(String key, Object data) {
        testData.put(key, data);
    }

    public static Integer readTestDataAsInteger(String key) {
        return (Integer) testData.get(key);
    }

    public static String readTestDataAsString(String key) {
        return (String) testData.get(key);
    }

    public static Map<String, Object> readTestDataAsMap(String key) {
        return (Map<String, Object>) testData.get(key);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static JavascriptExecutor getExecutor() {
        return (JavascriptExecutor) driver;
    }

    public static Actions getActions() {
        return new Actions(driver);
    }

    public static Config getConfig() {
        return config;
    }

    public static Map<String, String> getPositionDataFromFile(String key, String project) {
        Map<String, String> position = getData(key, project);
        String originalTitle = position.get("title");
        if (originalTitle != null) {
            String newTitle = originalTitle + " " + timeStamp;
            position.put("title", newTitle);
        }
        return position;
    }

    public static Map<String, String> getCandidateDataFromFile(String key, String project) {
        Map<String, String> candidateProfile = getData(key, project);
        String originalName = candidateProfile.get("firstName");
        if (originalName != null) {
            String newName = originalName + " " + timeStamp;
            candidateProfile.put("firstName", newName);
        }

        Map<String, String> candidateCredentials = getData(key, "secrets/" + project);
        if (candidateCredentials != null) { //if updating profile only - no _updated record in secrets
            String originalLogin = candidateCredentials.get("email");
            if (originalLogin != null) {
                int atSignIndex = originalLogin.indexOf("@");
                String newLogin = originalLogin.substring(0, atSignIndex) + timeStamp + originalLogin.substring(atSignIndex);
                candidateCredentials.put("email", newLogin);
                candidateProfile.putAll(candidateCredentials);
            }
        }
        return candidateProfile;
    }

    public static Map<String, String> getData(String recordKey, String project) {
        Map<String, Map<String, String>> map = new Yaml().load(getStream(project));
        return map.get(recordKey);
    }

    private static InputStream getStream(String project) {
        try {
            return new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/data/" + project + ".yml");
        } catch (FileNotFoundException e) {
            throw new Error("Couldn't stream project data for: " + project + ". Error: " + e);
        }
    }

    private static void setConfig() {
        try {
            config = new YAMLMapper().readValue(getStream("config"), Config.class);
        } catch (IOException e) {
            throw new Error("Couldn't process test config data! Error: " + e);
        }
        //config = new Yaml().loadAs(getStream("config"), Config.class);
    }

    public static void initialize() {
        setConfig();
        String browser = config.getBrowser();
        String testEnv = config.getRunType();
        boolean isHeadless = config.isHeadless();
        Dimension size = new Dimension(config.getBrowserWidth(), config.getBrowserHeight());
        Point position = new Point(0, 0);

        if (testEnv.equals("local")) {
            switch (browser) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();

                    //verified for Chrome v97
                    Map<String, Object> chromePreferences = new HashMap<>();
                    //ask where to save each file before downloading - off
                    chromePreferences.put("download.prompt_for_download", false);
                    //What does it actually do? Present on fresh Chrome profile with 'true' value. Saw a comment saying it's not needed from v97.
                    chromePreferences.put("download.directory_upgrade", true);
                    //prefs JSON file has it as 'savefile.default_directory', but that version doesn't work
                    chromePreferences.put("download.default_directory", System.getProperty("user.dir") + "/src/test/resources/downloads");
                    //download .pdf instead of opening
                    chromePreferences.put("plugins.always_open_pdf_externally", true);
                    //protection service - off, it checks against the list of harmful websites/extensions
                    chromePreferences.put("safebrowsing.enabled", false);
                    /*
                    Offer to save passwords - off, even though seems to be auto-blocked by driver.
                    Prompt doesn't show up even if slider is in 'on' position after passing true value.
                    In manual mode setting works as intended.
                    Prefs JSON file has it as 'chrome.credentials_enable_service', but that version doesn't work.
                     */
                    chromePreferences.put("credentials_enable_service", false);
                    //don't allow sites to see your location
                    chromePreferences.put("profile.default_content_setting_values.geolocation", 2);
                    //sites can send pop-ups and use redirects
                    chromePreferences.put("profile.default_content_setting_values.popups", 1);
                    /*
                    This one may be needed in Europe, since they have a consent popup with status stored in cookies.
                    If you block them - google allows you to auto-proceed.
                    chromePreferences.put("profile.default_content_setting_values.cookies", 2);
                     */

                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setExperimentalOption("prefs", chromePreferences);

                    //adding ChroPath if needed
                    if (config.isUseChroPath()) {
                        File chroPathFile = new File(System.getProperty("user.dir") + "/src/test/resources/data/ChroPath.crx");
                        chromeOptions.addExtensions(chroPathFile);
                    }

                    if (config.isEnableLogs()) {
                        //performance logging that is not enabled by default
                        if (config.isEnablePerformanceLogs()) {
                            LoggingPreferences logPrefs = new LoggingPreferences();
                            logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
                            chromeOptions.setCapability("goog:loggingPrefs", logPrefs);
                        }
                        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, System.getProperty("user.dir") + "/target/chromedriver.log");
                        System.setProperty(ChromeDriverService.CHROME_DRIVER_VERBOSE_LOG_PROPERTY, "true");
                    } else {
                        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                    }

                    if (isHeadless) {
                        chromeOptions.setHeadless(true);
                        chromeOptions.addArguments("--window-size=" + size.getWidth() + "," + size.getWidth());
                        chromeOptions.addArguments("--disable-gpu");
                    }
                    driver = new ChromeDriver(chromeOptions);
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();

                    FirefoxOptions firefoxOptions = new FirefoxOptions()
                            .addPreference("browser.download.useDownloadDir", true)
                            .addPreference("browser.download.lastDir", System.getProperty("user.dir") + "/src/test/resources/downloads");
                    /*
                    This one may be needed in Europe, since they have a consent popup with status stored in cookies.
                    If you block them - google allows you to auto-proceed.
                            .addPreference("network.cookie.cookieBehavior", 2);
                     */

                    if (config.isEnableLogs()) {
                        //performance logging that is not enabled by default
                        if (config.isEnablePerformanceLogs()) {
                            LoggingPreferences logPrefs = new LoggingPreferences();
                            logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
                            firefoxOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
                        }
                        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, System.getProperty("user.dir") + "/target/firefoxdriver.log");
                        firefoxOptions.setLogLevel(FirefoxDriverLogLevel.TRACE);
                    } else {
                        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                    }

                    if (isHeadless) {
                        FirefoxBinary firefoxBinary = new FirefoxBinary();
                        firefoxBinary.addCommandLineOptions("--headless");
                        firefoxOptions.setBinary(firefoxBinary);
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                }
                case "safari" -> driver = new SafariDriver();
                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
                case "ie" -> {
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                }
                default -> throw new RuntimeException("Driver is not implemented for: " + browser);
            }
        } else if (testEnv.equals("grid")) {
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
        driver.manage().window().setPosition(position);
        driver.manage().window().setSize(size);
    }

    public static void teardown() {
        driver.quit();
    }
}
