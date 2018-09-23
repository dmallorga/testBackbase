package pages;

import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

  protected WebDriverWait wait;
  protected WebDriver driver;
  protected static Logger log = Logger.getLogger("BasePage Logger");

  public BasePage(WebDriver driver){
    this.driver = driver;
    wait = new WebDriverWait(driver, 10);
    PageFactory.initElements(driver, this);
  }

  public void waitSeconds(double timeToWaitInSec) {
    try {
      long timeToWaitInMilliSec = (long) timeToWaitInSec * 1000;
      Thread.sleep(timeToWaitInMilliSec);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void waitForPageToLoad() {
    JavascriptExecutor js=(JavascriptExecutor)driver;
    String state = (String)js.executeScript("return document.readyState");
    while(!state.equals("complete")){
      waitSeconds(1);
      state = (String)js.executeScript("return document.readyState");
    }
  }

  public WebElement waitForElementToExist(String locatorType, String locatorValue) {
    switch (locatorType) {
      case "id":
        WebElement elementById = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue)));
        return elementById;
      case "name":
        WebElement elementByName = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locatorValue)));
        return elementByName;
      case "class":
        WebElement elementByClass = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locatorValue)));
        return elementByClass;
      case "xpath":
        WebElement elementByXpath = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
        return elementByXpath;
      default:
        Assert.fail("waitForElementToExist(): Unexpected locator type: \"" + locatorType + "\"");
        return null;
    }
  }

  public void clickElement(String locatorType, String locatorValue) {
    WebElement element = waitForElementToExist(locatorType, locatorValue);
    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
  }

}


