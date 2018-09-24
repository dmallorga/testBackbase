package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ResultsTests extends BaseTest {

  @Test(testName = "searchResultsRetrieveOneOrMoreResults")
  @Parameters("searchCriteria")
  public void searchResultsRetrieveOneOrMoreResults(String searchCriteria) {
    try {
      Results.fillOutFilterCriteria(searchCriteria);
      Results.selectFilterByNameBtn();
      Assert.assertTrue(Results.areResultsRetrievedMatchingWithCounterDisplayed());
      log.info("Results retrieved match correctly with results found counter, as well as pagination counter.");
    }
    finally {
      Results.removeSearchCriteria();
    }
  }

  @Test(testName = "noComputersFoundMsgDisplaysWhenThereIsNoMatchingForEnteredSearchCriteria")
  @Parameters("noMatchingSearchCriteria")
  public void noComputersFoundMsgDisplaysWhenThereIsNoMatchingForEnteredSearchCriteria(String noMatchingSearchCriteria) {
    try {
      Results.fillOutFilterCriteria(noMatchingSearchCriteria);
      Results.selectFilterByNameBtn();
      Assert.assertTrue(Results.isNoComputerSFoundMsgDisplayed());
      log.info("No computers found message displays, since there are no matching for entered search criteria.");
    }
    finally {
      Results.removeSearchCriteria();
    }
  }

  @Test(testName = "nothingToDisplayMsgStatesInScreenWhenThereIsNoMatchForEnteredSearchCriteria")
  @Parameters("noMatchingSearchCriteria")
  public void nothingToDisplayMsgStatesInScreenWhenThereIsNoMatchForEnteredSearchCriteria(String noMatchingSearchCriteria) {
    try {
      Results.fillOutFilterCriteria(noMatchingSearchCriteria);
      Results.selectFilterByNameBtn();
      Assert.assertTrue(Results.isNothingToDisplayMsgPresent());
      log.info("Nothing to display message states in to results table, since there are no matching for entered search criteria.");
    }
    finally {
      Results.removeSearchCriteria();
    }
  }
}
