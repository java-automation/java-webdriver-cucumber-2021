package support;

import java.util.List;

public class Config {

    private String browser;
    private String runType;
    private boolean headless;
    private int browserWidth;
    private int browserHeight;
    private boolean logPerformance;
    private int pageLoadTimeout;
    private int implicitWait;
    private int explicitWait;
    private List<String> supportedOS;

    public String getBrowser() {
        return browser;
    }

    public String getRunType() {
        return runType;
    }

    public boolean isHeadless() {
        return headless;
    }

    public int getBrowserWidth() {
        return browserWidth;
    }

    public int getBrowserHeight() {
        return browserHeight;
    }

    public boolean isLogPerformance() {
        return logPerformance;
    }

    public int getPageLoadTimeout() {
        return pageLoadTimeout;
    }

    public int getImplicitWait() {
        return implicitWait;
    }

    public int getExplicitWait() {
        return explicitWait;
    }

    public List<String> getSupportedOS() {
        return supportedOS;
    }
}
