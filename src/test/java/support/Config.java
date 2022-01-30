package support;

import java.util.List;

public class Config {

    private String browser;
    private String runType;
    private boolean headless;
    private int browserWidth;
    private int browserHeight;
    private boolean useChroPath;
    private boolean enableLogs;
    private boolean enablePerformanceLogs;
    private int pageLoadTimeout;
    private int implicitTimeout;
    private int explicitTimeout;
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

    public boolean isEnableLogs() {
        return enableLogs;
    }

    public boolean isEnablePerformanceLogs() {
        return enablePerformanceLogs;
    }

    public boolean isUseChroPath() {
        return useChroPath;
    }

    public int getPageLoadTimeout() {
        return pageLoadTimeout;
    }

    public int getImplicitTimeout() {
        return implicitTimeout;
    }

    public int getExplicitTimeout() {
        return explicitTimeout;
    }

    public List<String> getSupportedOS() {
        return supportedOS;
    }
}
