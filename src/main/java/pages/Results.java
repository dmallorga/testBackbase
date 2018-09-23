package pages;

import org.openqa.selenium.WebDriver;
import locators.ComputersLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Constants;

public class Results extends BasePage {

  @FindBy(xpath = ComputersLocators.INLINE_MSG_XPATH)
  WebElement inlineMsg;

  public Results(WebDriver driver) {
    super(driver);
  }

  public boolean computerCreatedMsgDisplays(String computerName) {
    log.info("Verifying successful inline message displays after create a new computer." );
    return inlineMsg.getText().equals(String.format(Constants.COMPUTER_CREATED_INLINE_MSG, computerName));
  }

  public AddNewComputer addNewComputer() {
    log.info("Click on Add a new computer button.");
    clickElement("id", ComputersLocators.CREATE_NEW_COMPUTER_BTN_ID);
    return new AddNewComputer(driver);
  }
}
