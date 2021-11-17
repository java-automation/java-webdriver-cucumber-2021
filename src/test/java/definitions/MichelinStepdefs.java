package definitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static support.TestContext.getDriver;

public class MichelinStepdefs {

    public static final String XPATH_SEARCH_RESULTS = "//div[@id='search']//div[@class='g']//div[@class='tF2Cxc']//div[@class='yuRUbf']/a";
    public static final String XPATH_PEOPLE_ASK_SECTION = "//div[@jsname='Cpkphb']//div[@class='tF2Cxc']//div[@class='yuRUbf']/a";
    public static final String PART_OF_LOCATOR = "[@href]//h3";

    @And("I collect text from search results")
    public List<String> iCollectTextFromSearchingEntries() {
        List<WebElement> searchResults = getSearchResults(XPATH_SEARCH_RESULTS + PART_OF_LOCATOR, XPATH_PEOPLE_ASK_SECTION + PART_OF_LOCATOR);
        List<String> texts = new ArrayList<>();
        for (WebElement el : searchResults) {
            texts.add(el.getText());
        }
        return texts;
    }

    @And("I collect links from search results")
    public List<String> iCollectLinksFromSearchResults() {
        List<WebElement> searchResults = getSearchResults(XPATH_SEARCH_RESULTS, XPATH_PEOPLE_ASK_SECTION);
        List<String> links = new ArrayList<String>();
        List<String> associateText = new ArrayList<String>();

        for (WebElement webElement : searchResults) {
            links.add(webElement.getAttribute("href"));
        }
        return links;
    }


    @And("I create HashMap from search results")
    public void iCreateHashMapFromSearchResults() {
        List<String> searchTitle = iCollectTextFromSearchingEntries();
        List<String> links = iCollectLinksFromSearchResults();
        assertEquals(searchTitle.size(), links.size());
        HashMap<String, String> michelinTire = new HashMap<String, String>();
        for (int i = 0; i < links.size(); i++) {
            michelinTire.put(searchTitle.get(i), links.get(i));
        }
        out.println(michelinTire);
    }

    private List<WebElement> getSearchResults(String xpathSearchResults, String xpathPeopleAskSection) {
        List<WebElement> searchResults = new ArrayList<WebElement>();
        List<WebElement> peopleAskResultSection = new ArrayList<WebElement>();
        List<String> searchResultsLinks = new ArrayList<String>();
        searchResults = getDriver().findElements(By.xpath(xpathSearchResults));
        peopleAskResultSection = getDriver().findElements(By.xpath(xpathPeopleAskSection));
        for (WebElement webElement : peopleAskResultSection) {
            if (searchResults.contains(webElement)) {
                searchResults.remove(webElement);
            }
        }
        return searchResults;
    }
}
