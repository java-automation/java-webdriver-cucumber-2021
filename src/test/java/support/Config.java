package support;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Config {

    private String browser;
    private String environment;
    private Boolean headless;
    @JsonProperty("browserWidth") // can have different key name in config.yml
    private Integer browserWidth;
    @JsonProperty("browserHeight")
    private Integer browserHeight;
    private Integer pageLoadTimeOut;
    private Integer implicitTimeOut;
    private Integer explicitTimeOut;

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public Boolean getHeadless() {
        return headless;
    }

    public void setHeadless(Boolean headless) {
        this.headless = headless;
    }

    public Integer getBrowserWidth() {
        return browserWidth;
    }

    public void setBrowserWidth(Integer browserWidth) {
        this.browserWidth = browserWidth;
    }

    public Integer getBrowserHeight() {
        return browserHeight;
    }

    public void setBrowserHeight(Integer browserHeight) {
        this.browserHeight = browserHeight;
    }

    public Integer getPageLoadTimeOut() {
        return pageLoadTimeOut;
    }

    public void setPageLoadTimeOut(Integer pageLoadTimeOut) {
        this.pageLoadTimeOut = pageLoadTimeOut;
    }

    public Integer getImplicitTimeOut() {
        return implicitTimeOut;
    }

    public void setImplicitTimeOut(Integer implicitTimeOut) {
        this.implicitTimeOut = implicitTimeOut;
    }

    public Integer getExplicitTimeOut() {
        return explicitTimeOut;
    }

    public void setExplicitTimeOut(Integer explicitTimeOut) {
        this.explicitTimeOut = explicitTimeOut;
    }

}
