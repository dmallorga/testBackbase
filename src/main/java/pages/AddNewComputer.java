package pages;

import interfaces.iAddNewComputer;
import org.openqa.selenium.WebDriver;

public class AddNewComputer extends BasePage implements iAddNewComputer {

  public AddNewComputer(WebDriver driver) {
    super(driver);
  }

  @Override
  public boolean isAddNewComputerScreenDisplayed() {
    return true;
  }
}
