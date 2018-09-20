package tests;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class BaseTestClass {


  BaseTestClass(){}

  @BeforeSuite
  public void setUp() { }


  @AfterMethod(alwaysRun = true)
  public void afterMethod(ITestResult result) {
    //try {
      /*if (result.getStatus() == ITestResult.SUCCESS) {
        log.info("Test : **** Passed ****");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test : **** Passed ****");
      } else if (result.getStatus() == ITestResult.FAILURE) {
        log.info("Test : **** Failed ****");
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test : **** Failed ****");
        captureMobileScreenShot(result);
      } else if (result.getStatus() == ITestResult.SKIP) {
        log.info("Test : **** Skipped ****");
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test : **** Skipped ****");
      }
      //End Test With Log
      ExtentTestManager.endTest();
    } catch (Exception e) {
      e.printStackTrace();
    }*/
  }

  @AfterTest(alwaysRun = true)
  public void tearDown() {
      //quitDriver();
    }

}


