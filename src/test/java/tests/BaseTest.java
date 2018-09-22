package tests;

import static driver.Browser.CHROME;

import driver.DriverFactory;
import pages.Results;
import util.Constants;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

  private WebDriver driver;
  public static Logger log = Logger.getLogger("TestingLog");
  protected Results Results;

  @BeforeSuite
  public void beforeSuite(){
    this.driver = DriverFactory.getDriver(CHROME);
  }

  @BeforeClass
  public void beforeClass(){
    navigateToHomePage();
  }

  @AfterSuite
  public void afterSuite(){
    driver.quit();
  }

  private void navigateToHomePage() {
    driver.get(Constants.APP_URL);
    Results = new Results(driver);
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod(ITestResult result) {
    try {
      if (result.getStatus() == ITestResult.SUCCESS) {
        log.info("Test : **** Passed ****");
      } else if (result.getStatus() == ITestResult.FAILURE) {
        log.info("Test : **** Failed ****");
      } else if (result.getStatus() == ITestResult.SKIP) {
        log.info("Test : **** Skipped ****");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


