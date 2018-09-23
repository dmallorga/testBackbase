package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ResultsTests extends BaseTest {

  @Test(testName = "searchResultsRetrieveOneOrMoreResults")
  @Parameters("searchCriteria")
  public void searchResultsRetrieveOneOrMoreResults(String searchCriteria) {
    Results.fillOutFilterCriteria(searchCriteria);
    Results.selectFilterByNameBtn();
    Assert.assertTrue(Results.areResultsRetrievedMatchingWithCounterDisplayed());
    log.info("Results retrieved match correctly with results found counter, as well as pagination counter.");
  }

}
