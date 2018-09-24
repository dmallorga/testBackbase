package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import locators.ComputersLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Constants;

public class Results extends BasePage {

  @FindBy(xpath = ComputersLocators.INLINE_MSG_XPATH)
  WebElement inlineMsg;

  @FindBy(id = ComputersLocators.SEARCH_FIELD_ID)
  WebElement searchBox;

  @FindBy(id = ComputersLocators.FILTER_BY_NAME_BTN_ID)
  WebElement filterBtn;

  public Results(WebDriver driver) {
    super(driver);
  }

  public boolean computerCreatedMsgDisplays(String computerName) {
    log.info("Verifying successful inline message displays after create a new computer.");
    return inlineMsg.getText()
        .equals(String.format(Constants.COMPUTER_CREATED_INLINE_MSG, computerName));
  }

  public AddNewComputer addNewComputer() {
    log.info("Click on Add a new computer button.");
    clickElement("id", ComputersLocators.CREATE_NEW_COMPUTER_BTN_ID);
    return new AddNewComputer(driver);
  }

  public void fillOutFilterCriteria(String filterCriteria) {
    log.info("Filling out computer name filter field with " + filterCriteria);
    searchBox.sendKeys(filterCriteria);
  }

  public void selectFilterByNameBtn() {
    log.info("Click on Filter by name button.");
    filterBtn.click();
  }

  public boolean areResultsRetrievedMatchingWithCounterDisplayed() {
    int rowCount = driver.findElements(By.xpath(ComputersLocators.RESULTS_TABLE_ROWS_XPATH)).size();
    String resultsFound = driver.findElement(By.xpath(ComputersLocators.RESULTS_FOUND_TEXT_XPATH))
        .getText();
    String paginationResults = driver
        .findElement(By.xpath(ComputersLocators.PAGINATION_RESULTS__TEXT_XPATH)).getText();
    return rowCount == Integer.parseInt(resultsFound.split(" ")[0]) && rowCount == Integer
        .parseInt(paginationResults.split("of ")[1]);
  }

  public boolean isNoComputerSFoundMsgDisplayed(){
    return isTextPresent(Constants.NO_COMPUTERS_FOUND_MSG);
  }

  public void removeSearchCriteria() {
    searchBox.clear();
  }

  public boolean isNothingToDisplayMsgPresent() {
    return isTextPresent(Constants.NOTHING_TO_DISPLAY_MSG);
  }
}
