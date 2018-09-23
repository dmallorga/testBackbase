package pages;

import locators.ComputersLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddNewComputer extends BasePage {

  @FindBy(id = ComputersLocators.COMPUTER_NAME_FIELD_ID)
  private WebElement compName;

  @FindBy(id = ComputersLocators.INTRODUCED_DATE_FIELD_ID)
  private WebElement introducedDate;

  @FindBy(id = ComputersLocators.DISCONTINUED_DATE_FIELD_ID)
  private WebElement discontinuedDate;

  @FindBy(id = ComputersLocators.COMPANY_LIST_ID)
  private WebElement company;

  @FindBy(xpath = ComputersLocators.CREATE_THIS_COMPUTER_BTN_XPATH)
  private WebElement createBtn;

  @FindBy(xpath = ComputersLocators.CANCEL_BTN_XPATH)
  private WebElement cancelBtn;

  public AddNewComputer(WebDriver driver) {
    super(driver);
  }

  public boolean isAddNewComputerScreenDisplayed() {
    log.info("Verifying Add New Computer screen displays.");
    return driver.findElement(By.xpath(ComputersLocators.ADD_NEW_COMPUTER_SCREEN_TITLE_XPATH)).isDisplayed();
  }

  public void fillOutComputerNameField(String cName) {
    log.info("Filling out computer name field with " + cName);
    compName.sendKeys(cName);
  }

  public void fillOutIntroducedField(String intDate) {
    log.info("Filling out computer name field with " + intDate);
    introducedDate.sendKeys(intDate);
  }

  public void fillOutDiscontinuedField(String discDate) {
    log.info("Filling out computer name field with " + discDate);
    discontinuedDate.sendKeys(discDate);
  }

  public void selectCompanyFromList(String companyName){
    log.info("Select company " + companyName + " from the list.");
    Select companyDropDown = new Select(driver.findElement(By.id(ComputersLocators.COMPANY_LIST_ID)));
    companyDropDown.selectByVisibleText(companyName);
  }

  public void selectCreateThisComputerBtn() {
    log.info("Click on Create this computer button.");
    createBtn.click();
  }

  public void selectCancelBtn() {
    log.info("Click on Cancel button.");
    cancelBtn.click();
  }
}
