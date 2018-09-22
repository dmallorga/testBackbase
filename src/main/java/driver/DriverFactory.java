package driver;

import util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

  public static WebDriver getDriver(Browser browser){
    switch (browser) {
      case CHROME:
        System.setProperty("webdriver.chrome.driver",
            System.getProperty("user.dir") + Constants.CHROME_DRIVER_PATH);
        return new ChromeDriver();
    }
    return null;
  }

}

