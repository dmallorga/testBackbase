package pages;

import interfaces.iResults;
import org.openqa.selenium.WebDriver;
import locators.ComputersLocators;

public class Results extends BasePage implements iResults {

  public Results(WebDriver driver) {
    super(driver);
  }

  @Override
  public AddNewComputer addNewComputer() {
    clickElement("id", ComputersLocators.CREATE_NEW_COMPUTER_BTN_ID,"");
    return new AddNewComputer(driver);
  }
}
