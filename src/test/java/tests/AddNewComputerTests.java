package tests;

import org.testng.annotations.Parameters;
import pages.AddNewComputer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewComputerTests extends BaseTest {

  @Test(testName = "addNewComputerScreenDisplays")
  public void addNewComputerScreenDisplays() {
    AddNewComputer addNewComputer = Results.addNewComputer();
    try{
      Assert.assertTrue(addNewComputer.isAddNewComputerScreenDisplayed());
      log.info("Add New Computer screen displays successfully after select 'Add New Computer' button");
    }
    finally {
      addNewComputer.selectCancelBtn();
    }
  }

  @Test(testName = "addNewComputerScreenDisplays")
  @Parameters("computerName")
  public void addNewComputerByOnlyEnteringRequiredFields(String computerName) {
    AddNewComputer addNewComputer = Results.addNewComputer();
    if(addNewComputer.isAddNewComputerScreenDisplayed()) {
      addNewComputer.fillOutComputerNameField(computerName);
      addNewComputer.selectCreateThisComputerBtn();
      Assert.assertTrue(Results.computerCreatedMsgDisplays(computerName));
      log.info("Computer " + computerName + " has been created successfully");
    }
    else {
      log.info("Add new computer screen does not display for any reason.");
      Assert.fail();
    }
  }

  @Test(testName = "cannotAddNewComputerWithoutEnteringRequiredField")
  @Parameters({"introducedDate", "discontinuedDate", "companyName"})
  public void cannotAddNewComputerWithoutEnteringRequiredField(String introducedDate, String discontinuedDate, String companyName) {
    AddNewComputer addNewComputer = Results.addNewComputer();
    if(addNewComputer.isAddNewComputerScreenDisplayed()) {
      addNewComputer.fillOutIntroducedField(introducedDate);
      addNewComputer.fillOutDiscontinuedField(discontinuedDate);
      addNewComputer.selectCompanyFromList(companyName);
      addNewComputer.selectCreateThisComputerBtn();
      Assert.assertTrue(addNewComputer.isAddNewComputerScreenDisplayed());
      log.info("Missing required field. User stays in Add New Computer screen.");
    }
    else {
      log.info("Add new computer screen does not display for any reason.");
      Assert.fail();
    }
  }

}
