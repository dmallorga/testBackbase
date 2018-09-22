package tests;

import pages.AddNewComputer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewComputerTests extends BaseTest {


  @Test(testName = "addNewComputerScreenDisplays")
  public void addNewComputerScreenDisplays() {
    AddNewComputer addNewComputer = Results.addNewComputer();
    Assert.assertTrue(addNewComputer.isAddNewComputerScreenDisplayed());
    System.out.println("Add New Computer screen displays successfully after select 'Add New Computer' button");
  }

}
